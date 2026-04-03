"""
Producer Kafka - Flux Temps Réel - Banque Virtuelle Tunisienne
Version 5.0 — Churn 3% exact | Deux profils cohérents | Boucle infinie

Colonnes clients (23) : identiques à l'original — aucune ajoutée.

Logique churn :
  - TAUX_CHURN_CIBLE = 3% (3 000 clients sur 100 000)
  - Churn est forcé à exactement 3% via seuil adaptatif.
  - Deux profils internes (jamais envoyés) pilotent la cohérence des variables :

  PROFIL A — Churn Passif (client fantôme) :
    → anciennete >= 48 mois, 1 produit, convention Gratuit/Pack
    → sms=0, e_releve=0, acces_bl="Aucun", conseiller=0, fidelite=0
    → score_risque 1-2, frais faibles, NPS 3-5 (indifférent)
    → Transactions : peu fréquentes, montants faibles, canal Agence/DAB
    → Interactions : Simple Connexion / Consultation Solde, durée courte
    → Signal : il "disparaît" silencieusement

  PROFIL B — Churn Actif (client irrité) :
    → anciennete 6-36 mois, 2-3 produits, convention Mensuel/Annuel
    → sms=1, e_releve=1, acces_bl="Webank" (voit chaque frais)
    → frais élevés (+40-80%), score_risque 4-5, NPS 0-2 (détracteur)
    → Transactions : fréquentes mais rejetées souvent (rejet élevé)
    → Interactions : Réclamation dominante (60%), motif "Frais contestés"
    → Signal : il se plaint, puis part

Boucle infinie :
  - Thread 1 : transactions (tous les DELAI_TRANSACTIONS sec)
  - Thread 2 : interactions (tous les DELAI_INTERACTIONS sec)
  - Clients churnés participent au flux (pas de filtre — juste des patterns différents)

Auteur: Farah Jaffel | Version 5.0
"""

import json
import time
import random
import threading
import logging
import numpy as np
from collections import deque
from datetime import datetime, timedelta
from kafka import KafkaProducer
from kafka.errors import KafkaError, NoBrokersAvailable, KafkaTimeoutError

# ======================================================================
# CONFIGURATION
# ======================================================================

NB_CLIENTS       = 100_000
TAUX_CHURN_CIBLE = 0.03          # ← 3% exact (3 000 churners sur 100 000)

DELAI_TRANSACTIONS = 0.1         # 10 msg/sec
DELAI_INTERACTIONS = 0.15        # ~7 msg/sec

SEED = 42
np.random.seed(SEED)
random.seed(SEED)

MAX_RETRIES      = 10
RETRY_DELAY_S    = 5
MAX_PENDING_MSGS = 5_000

# ======================================================================
# LOGGING
# ======================================================================

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
)
log = logging.getLogger("producer_kafka")

pending_queue: deque = deque(maxlen=MAX_PENDING_MSGS)
kafka_disponible = threading.Event()
kafka_disponible.set()

# ======================================================================
# DONNÉES DE RÉFÉRENCE
# ======================================================================

VILLES = ["Tunis","Sfax","Sousse","Kairouan","Bizerte","Gabes","Ariana",
          "Gafsa","Monastir","Ben Arous","Nabeul","Medenine","Kasserine",
          "Sidi Bouzid","Jendouba","Zaghouan","Kebili","Tozeur","Siliana","Le Kef"]
_vp = [0.22,0.13,0.09,0.05,0.05,0.04,0.07,0.03,0.05,0.06,
       0.03,0.03,0.02,0.02,0.02,0.01,0.01,0.01,0.01,0.01]
VILLE_POIDS = [x/sum(_vp) for x in _vp]

PROFESSIONS = ["Fonctionnaire","Employe prive","Commercant","Medecin",
               "Ingenieur","Enseignant","Avocat","Retraite",
               "Auto-entrepreneur","Agriculteur","Sans emploi","Etudiant"]
PROF_POIDS  = [0.20,0.22,0.12,0.04,0.08,0.10,0.03,0.08,0.05,0.03,0.03,0.02]

REVENU_PROF = {
    "Fonctionnaire":    (900,  200),
    "Employe prive":    (950,  250),
    "Commercant":       (1300, 450),
    "Medecin":          (3200, 900),
    "Ingenieur":        (2100, 550),
    "Enseignant":       (780,  150),
    "Avocat":           (2600, 750),
    "Retraite":         (620,  150),
    "Auto-entrepreneur":(1050, 380),
    "Agriculteur":      (720,  200),
    "Sans emploi":      (300,  100),
    "Etudiant":         (260,  80),
}

TYPES_OPS       = ["Virement emis","Virement recu","Paiement Carte","Retrait DAB","Prelevement"]
TYPES_OPS_POIDS = [0.15, 0.15, 0.35, 0.25, 0.10]
SENS_MAP        = {
    "Virement emis":  "Debit",
    "Virement recu":  "Credit",
    "Paiement Carte": "Debit",
    "Retrait DAB":    "Debit",
    "Prelevement":    "Debit",
}
CANAUX_TX       = ["Agence","DAB","TPE","En Ligne"]
CANAUX_TX_POIDS = [0.10, 0.25, 0.35, 0.30]
CATEGORIES      = ["Alimentation","Transport","Loisirs","Sante","International","Autre",""]
CAT_POIDS       = [0.25, 0.20, 0.15, 0.10, 0.08, 0.12, 0.10]

CANAUX_INT       = ["Application Mobile","Site Web","Centre d Appel","Agence"]
CANAUX_INT_POIDS = [0.40, 0.30, 0.20, 0.10]
TYPES_INT        = ["Simple Connexion","Consultation Solde","Reclamation","Demande assistance"]
MOTIFS           = ["Frais contestes","Carte bloquee","Virement errone","Autre"]
MOTIFS_POIDS     = [0.35, 0.30, 0.20, 0.15]

# ======================================================================
# CONNEXION KAFKA
# ======================================================================

def creer_producer() -> KafkaProducer:
    for tentative in range(1, MAX_RETRIES + 1):
        try:
            p = KafkaProducer(
                bootstrap_servers='127.0.0.1:9092',
                value_serializer=lambda v: json.dumps(v, default=str).encode('utf-8'),
                batch_size=16384,
                linger_ms=5,
                compression_type='gzip',
                retries=5,
                acks='all',
                request_timeout_ms=30_000,
            )
            log.info(f"Connecté à Kafka (tentative {tentative}/{MAX_RETRIES})")
            return p
        except NoBrokersAvailable:
            log.warning(f"Kafka indisponible — tentative {tentative}/{MAX_RETRIES} — retry dans {RETRY_DELAY_S}s...")
            time.sleep(RETRY_DELAY_S)
    raise RuntimeError(f"Impossible de se connecter à Kafka après {MAX_RETRIES} tentatives.")


def on_send_success(record_metadata):
    pass


def on_send_error(excp, topic: str, msg: dict):
    log.error(f"Erreur envoi sur [{topic}] : {excp.__class__.__name__} — {excp}")
    pending_queue.append((topic, msg))
    if len(pending_queue) >= MAX_PENDING_MSGS:
        log.warning(f"File d'attente pleine ({MAX_PENDING_MSGS} msgs) — les plus anciens sont perdus !")


def envoyer(topic: str, msg: dict):
    if not kafka_disponible.is_set():
        pending_queue.append((topic, msg))
        return
    try:
        (producer
            .send(topic, msg)
            .add_callback(on_send_success)
            .add_errback(lambda excp: on_send_error(excp, topic, msg)))
    except KafkaTimeoutError as e:
        log.error(f"Timeout Kafka sur [{topic}] : {e}")
        pending_queue.append((topic, msg))
    except KafkaError as e:
        log.error(f"Erreur Kafka sur [{topic}] : {e}")
        pending_queue.append((topic, msg))
    except Exception as e:
        log.error(f"Erreur inattendue sur [{topic}] : {e}")
        pending_queue.append((topic, msg))


def thread_reconnexion():
    global producer
    while True:
        time.sleep(10)
        try:
            producer.partitions_for('clients_topic')
            if not kafka_disponible.is_set():
                log.info("Kafka à nouveau disponible ! Reprise du flux...")
                kafka_disponible.set()
                _rejouer_messages_en_attente()
        except Exception:
            if kafka_disponible.is_set():
                log.error("Kafka est tombé ! Passage en mode attente locale...")
                kafka_disponible.clear()
            try:
                producer.close(timeout=5)
            except Exception:
                pass
            try:
                producer = creer_producer()
                log.info("Reconnexion Kafka réussie !")
                kafka_disponible.set()
                _rejouer_messages_en_attente()
            except Exception as e:
                log.error(f"Reconnexion échouée : {e}")


def _rejouer_messages_en_attente():
    nb = len(pending_queue)
    if nb == 0:
        return
    log.info(f"Rejeu de {nb} messages en attente...")
    rejoues = 0
    while pending_queue:
        topic, msg = pending_queue.popleft()
        try:
            producer.send(topic, msg)
            rejoues += 1
        except Exception as e:
            log.error(f"Échec rejeu message [{topic}] : {e}")
            break
    producer.flush()
    log.info(f"{rejoues}/{nb} messages rejoués avec succès.")


# Instanciation initiale
producer = creer_producer()

print("=" * 65)
print("  PRODUCER KAFKA - FLUX TEMPS RÉEL v5.0")
print("  Banque Virtuelle Tunisienne")
print(f"  Churn cible  : {TAUX_CHURN_CIBLE:.0%} ({int(NB_CLIENTS*TAUX_CHURN_CIBLE):,} clients)")
print(f"  Transactions : 1 msg / {DELAI_TRANSACTIONS}s  ({1/DELAI_TRANSACTIONS:.0f} msg/sec)")
print(f"  Interactions : 1 msg / {DELAI_INTERACTIONS}s ({1/DELAI_INTERACTIONS:.0f} msg/sec)")
print(f"  Reconnexion  : auto (max {MAX_RETRIES} tentatives, délai {RETRY_DELAY_S}s)")
print("=" * 65 + "\n")

# ======================================================================
# GÉNÉRATION D'UN CLIENT — 3% churn exact, deux profils cohérents
# ======================================================================

# Compteur global pour forcer exactement 3% de churners
_churn_counter = {"total": 0, "churn": 0}


def generer_un_client(client_id: int) -> dict:
    """
    Génère un client avec churn=0 ou 1.
    Le taux de churn est forcé à exactement TAUX_CHURN_CIBLE.

    Deux profils internes (_profil, jamais envoyé à Kafka) :
      "passif" → ancienneté longue, désengagement silencieux
      "actif"  → frais élevés, réclamations, irritation visible
    """
    global _churn_counter

    _churn_counter["total"] += 1
    nb_restants   = NB_CLIENTS - _churn_counter["total"] + 1
    churn_restant = int(NB_CLIENTS * TAUX_CHURN_CIBLE) - _churn_counter["churn"]

    # Décision churn : proportionnelle au quota restant
    if churn_restant <= 0:
        churn = 0
        _profil = None
    elif churn_restant >= nb_restants:
        churn = 1
        _profil = random.choice(["passif", "actif"])
        _churn_counter["churn"] += 1
    else:
        prob_churn = churn_restant / nb_restants
        churn = int(random.random() < prob_churn)
        if churn:
            _profil = random.choice(["passif", "actif"])
            _churn_counter["churn"] += 1
        else:
            _profil = None

    profession = random.choices(PROFESSIONS, weights=PROF_POIDS)[0]
    ville      = random.choices(VILLES, weights=VILLE_POIDS)[0]
    age        = int(np.clip(np.random.normal(38, 13), 18, 80))
    sexe       = random.choices(["M","F"], weights=[0.54,0.46])[0]
    situation  = random.choices(["Marie","Celibataire","Divorce","Veuf"], weights=[0.52,0.33,0.10,0.05])[0]
    enfants    = int(
        (situation == "Marie"  and random.random() < 0.65) or
        (situation != "Marie"  and random.random() < 0.10)
    )
    revenu = round(max(200.0, np.random.normal(*REVENU_PROF[profession])), 3)

    # -------------------------------------------------------
    # PROFIL PASSIF — client fantôme qui disparaît doucement
    # -------------------------------------------------------
    if _profil == "passif":
        anciennete  = int(np.clip(np.random.normal(72, 24), 48, 240))   # vieux client
        convention  = random.choices(["Gratuit","Pack"], weights=[0.55,0.45])[0]
        frais_m     = 0.0 if convention == "Gratuit" else round(float(np.clip(np.random.normal(5, 2), 0, 15)), 3)
        nb_prod     = 1                                                   # 1 seul produit
        score_r     = random.choices([1,2,3], weights=[0.50,0.35,0.15])[0]  # risque faible
        conseiller  = 0                                                   # pas de conseiller
        fidelite    = 0                                                   # pas fidélisé
        sms         = 0                                                   # pas de SMS
        acces_bl    = "Aucun"                                             # pas de banque en ligne
        alerte_sec  = 0
        assurance   = 0
        e_releve    = 0
        methode_pmt = "Cheque"
        frais_cumul = round(frais_m * anciennete * random.uniform(0.7, 0.9), 3)

    # -------------------------------------------------------
    # PROFIL ACTIF — client irrité par les frais, se plaint
    # -------------------------------------------------------
    elif _profil == "actif":
        anciennete  = int(np.clip(np.random.normal(18, 10), 6, 36))      # client récent
        convention  = random.choices(["Mensuel","Annuel"], weights=[0.55,0.45])[0]
        frais_m     = round(float(np.clip(np.random.normal(30, 8), 18, 50)), 3)  # frais élevés
        nb_prod     = random.choices([2,3], weights=[0.6,0.4])[0]        # 2-3 produits
        score_r     = random.choices([4,5], weights=[0.55,0.45])[0]      # risque élevé
        conseiller  = 0
        fidelite    = 0
        sms         = 1                                                   # reçoit alertes → voit les frais
        acces_bl    = "Webank"                                            # voit chaque ligne de frais
        alerte_sec  = 1
        assurance   = random.choices([0,1], weights=[0.6,0.4])[0]
        e_releve    = 1                                                   # reçoit relevé → voit les frais
        methode_pmt = random.choices(["Prelevement auto","Carte"], weights=[0.5,0.5])[0]
        frais_cumul = round(frais_m * anciennete * random.uniform(1.05, 1.20), 3)  # frais cumulés > attendu

    # -------------------------------------------------------
    # NON-CHURNER — client normal
    # -------------------------------------------------------
    else:
        anciennete  = int(np.clip(np.random.exponential(40), 1, 240))
        convention  = random.choices(["Mensuel","Annuel","Gratuit","Pack"], weights=[0.25,0.30,0.20,0.25])[0]
        frais_m     = 0.0 if convention == "Gratuit" else round(float(np.clip(np.random.normal(12, 5), 0, 50)), 3)
        nb_prod     = int(np.clip(np.random.poisson(2.5), 1, 6))
        score_r     = random.choices([1,2,3,4,5], weights=[0.10,0.25,0.35,0.20,0.10])[0]
        conseiller  = int(random.random() < 0.35)
        fidelite    = int(random.random() < 0.45)
        sms         = int(random.random() < 0.70)
        acces_bl    = random.choices(["Standard","Webank","Aucun"], weights=[0.45,0.40,0.15])[0]
        alerte_sec  = int(random.random() < 0.60)
        assurance   = int(random.random() < 0.45)
        e_releve    = int(random.random() < 0.65)
        methode_pmt = random.choices(["Prelevement auto","Carte","Cheque"], weights=[0.45,0.40,0.15])[0]
        frais_cumul = round(frais_m * anciennete * random.uniform(0.8, 1.1), 3)

    date_fin       = datetime(2024, 12, 31)
    date_naissance = (date_fin - timedelta(days=age*365 + random.randint(0,364))).strftime("%Y-%m-%d")

    return {
        "id_client":                f"CLI-{client_id:06d}",
        "sexe":                     sexe,
        "date_naissance":           date_naissance,
        "est_senior":               int(age >= 60),
        "situation_matrimoniale":   situation,
        "enfants_a_charge":         enfants,
        "profession":               profession,
        "ville_region":             ville,
        "anciennete_mois":          anciennete,
        "service_sms_banking":      sms,
        "acces_banque_en_ligne":    acces_bl,
        "alerte_securite_active":   alerte_sec,
        "assurance_moyen_paiement": assurance,
        "conseiller_dedie":         conseiller,
        "programme_fidelite":       fidelite,
        "type_convention":          convention,
        "e_releve_active":          e_releve,
        "methode_paiement_fav":     methode_pmt,
        "frais_bancaires_mensuels": frais_m,
        "total_frais_cumules":      frais_cumul,
        "revenu_mensuel":           revenu,
        "nb_produits_actifs":       nb_prod,
        "score_risque_interne":     score_r,
        "churn":                    churn,
    }

# ======================================================================
# GÉNÉRATION D'UNE TRANSACTION — cohérente avec le profil churn
# ======================================================================

def generer_une_transaction(tx_id: int, client_id: str, revenu: float,
                             churn: int, profil: str | None) -> dict:
    """
    profil : "passif" | "actif" | None
    Même colonnes qu'avant — la cohérence vient des distributions.
    """

    # --- Choix du type d'opération ---
    if profil == "passif":
        # Peu de transactions, essentiellement DAB/Agence — client quasi-absent
        type_op = random.choices(TYPES_OPS, weights=[0.05, 0.05, 0.20, 0.55, 0.15])[0]
        canal   = random.choices(CANAUX_TX, weights=[0.35, 0.45, 0.10, 0.10])[0]
    elif profil == "actif":
        # Transactions variées mais beaucoup de prélèvements (frais visibles)
        type_op = random.choices(TYPES_OPS, weights=[0.15, 0.10, 0.40, 0.15, 0.20])[0]
        canal   = random.choices(CANAUX_TX, weights=[0.05, 0.15, 0.30, 0.50])[0]  # Webank/En Ligne dominant
    else:
        type_op = random.choices(TYPES_OPS, weights=TYPES_OPS_POIDS)[0]
        canal   = random.choices(CANAUX_TX, weights=CANAUX_TX_POIDS)[0]

    sens = SENS_MAP[type_op]

    # --- Montant ---
    if profil == "passif":
        # Montants très faibles — client qui ne bouge presque plus
        if type_op == "Retrait DAB":
            montant = float(np.clip(np.random.normal(60, 30), 20, 200))
        elif type_op == "Paiement Carte":
            montant = float(np.clip(np.random.normal(25, 15), 5, 100))
        elif type_op == "Virement emis":
            montant = float(np.clip(np.random.normal(revenu*0.10, revenu*0.05+1), 20, 500))
        elif type_op == "Virement recu":
            montant = float(np.clip(np.random.normal(revenu*0.40, revenu*0.10+1), 50, 1500))
        else:
            montant = float(np.clip(np.random.normal(50, 30), 10, 300))
    elif profil == "actif":
        # Montants normaux mais avec prélèvements fréquents (les fameux frais)
        if type_op == "Retrait DAB":
            montant = float(np.clip(np.random.normal(180, 80), 40, 800))
        elif type_op == "Paiement Carte":
            montant = float(np.clip(np.random.normal(95, 60), 10, 600))
        elif type_op == "Virement emis":
            montant = float(np.clip(np.random.normal(revenu*0.35, revenu*0.15+1), 80, 5000))
        elif type_op == "Virement recu":
            montant = float(np.clip(np.random.normal(revenu*0.85, revenu*0.20+1), 150, 8000))
        else:
            montant = float(np.clip(np.random.normal(280, 120), 50, 1500))  # prélèvements élevés
    else:
        if type_op == "Retrait DAB":
            montant = float(np.clip(np.random.normal(150, 80), 20, 800))
        elif type_op == "Paiement Carte":
            montant = float(np.clip(np.random.normal(80, 60), 5, 500))
        elif type_op == "Virement emis":
            montant = float(np.clip(np.random.normal(revenu*0.3, revenu*0.15+1), 50, 5000))
        elif type_op == "Virement recu":
            montant = float(np.clip(np.random.normal(revenu*0.8, revenu*0.2+1), 100, 8000))
        else:
            montant = float(np.clip(np.random.normal(200, 100), 30, 1000))

    montant = round(montant, 3)

    # --- Solde ---
    solde_avant = float(np.clip(np.random.normal(3000, 2000), 0, 50000))
    if profil == "passif":
        solde_avant *= random.uniform(0.15, 0.40)   # solde très bas — client fantôme
    elif profil == "actif":
        solde_avant *= random.uniform(0.35, 0.70)   # solde bas à moyen — stressé par les frais

    solde_apres = round(
        max(0.0, solde_avant - montant) if sens == "Debit" else solde_avant + montant,
        3
    )

    # --- Taux de rejet ---
    if profil == "passif":
        taux_rejet = 0.04   # peu de transactions mais rarement rejetées (petits montants)
    elif profil == "actif":
        taux_rejet = 0.14   # souvent rejeté (solde insuffisant après frais)
    else:
        taux_rejet = 0.02

    if solde_apres < 100:
        taux_rejet += 0.08
    est_rejete = int(random.random() < taux_rejet)

    categorie = "" if sens == "Credit" else random.choices(CATEGORIES, weights=CAT_POIDS)[0]

    return {
        "id_transaction":        f"TRX-{tx_id:09d}",
        "id_client":             client_id,
        "date_transaction":      datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
        "type_operation":        type_op,
        "montant":               montant,
        "sens_operation":        sens,
        "canal_transaction":     canal,
        "solde_apres_operation": solde_apres,
        "est_rejete":            est_rejete,
        "categorie_depense":     categorie,
    }

# ======================================================================
# GÉNÉRATION D'UNE INTERACTION — cohérente avec le profil churn
# ======================================================================

def generer_une_interaction(int_id: int, client_id: str,
                             churn: int, profil: str | None) -> dict:
    """
    profil : "passif" | "actif" | None
    Même colonnes qu'avant — cohérence via distributions.
    """

    if profil == "passif":
        # Client fantôme : peu d'interactions, canal Agence/Appel (pas digital)
        canal    = random.choices(CANAUX_INT, weights=[0.10, 0.10, 0.40, 0.40])[0]
        type_int = random.choices(TYPES_INT,  weights=[0.50, 0.40, 0.05, 0.05])[0]
    elif profil == "actif":
        # Client irrité : beaucoup de réclamations, canal digital (voit les frais)
        canal    = random.choices(CANAUX_INT, weights=[0.45, 0.30, 0.20, 0.05])[0]
        type_int = random.choices(TYPES_INT,  weights=[0.10, 0.10, 0.65, 0.15])[0]
    else:
        canal    = random.choices(CANAUX_INT, weights=CANAUX_INT_POIDS)[0]
        type_int = random.choices(TYPES_INT,  weights=[0.35, 0.40, 0.10, 0.15])[0]

    est_reclamation = int(type_int == "Reclamation")

    # Motif de réclamation
    if est_reclamation:
        if profil == "actif":
            # Frais contestés dominant — cohérent avec frais_bancaires_mensuels élevés
            motif = random.choices(MOTIFS, weights=[0.65, 0.15, 0.10, 0.10])[0]
        else:
            motif = random.choices(MOTIFS, weights=MOTIFS_POIDS)[0]
        statut = random.choices(["Resolu","En Cours"], weights=[0.55, 0.45])[0]
        delai  = float(random.choices([1,2,3,5,7,10,15,20],
                       weights=[0.20,0.20,0.15,0.15,0.10,0.10,0.07,0.03])[0])
    else:
        motif  = ""
        statut = "Non applicable"
        delai  = None

    # NPS — score de satisfaction
    if random.random() < 0.35:
        if profil == "passif":
            nps = float(random.randint(3, 5))   # indifférent (ni satisfait ni mécontent)
        elif profil == "actif":
            nps = float(random.randint(0, 2))   # détracteur (très insatisfait)
        else:
            nps = float(random.randint(6, 10))  # promoteur/satisfait
    else:
        nps = None

    # Durée connexion
    digital = canal in ["Application Mobile", "Site Web"]
    if digital:
        duree = int(np.clip(np.random.exponential(300), 30, 1800))
        if profil == "passif":
            duree = int(duree * random.uniform(0.15, 0.30))  # connexions fantôme très courtes
        elif profil == "actif":
            duree = int(duree * random.uniform(0.80, 1.20))  # connexions longues (cherche les frais)
    else:
        duree = 0

    return {
        "id_interaction":         f"INT-{int_id:09d}",
        "id_client":              client_id,
        "date_interaction":       datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
        "canal_interaction":      canal,
        "type_interaction":       type_int,
        "est_reclamation":        est_reclamation,
        "motif_reclamation":      motif,
        "statut_resolution":      statut,
        "delai_resolution_jours": delai,
        "score_satisfaction_nps": nps,
        "duree_connexion_sec":    duree,
    }

# ======================================================================
# [1/3] ENVOI CLIENTS — Une seule fois au démarrage
# ======================================================================

def envoyer_clients() -> dict:
    """
    Génère et envoie NB_CLIENTS clients.
    Retourne clients_info : {id_client → {revenu, churn, profil}}
    Le profil est stocké localement — jamais envoyé à Kafka.
    """
    print(f"[1/3] Génération et envoi de {NB_CLIENTS:,} clients (cible churn: {TAUX_CHURN_CIBLE:.0%})...")
    t0 = time.time()
    clients_info = {}

    for i in range(1, NB_CLIENTS + 1):
        client = generer_un_client(i)

        # Récupérer le profil interne AVANT de l'exclure de l'envoi
        # On le recalcule à partir du compteur (déjà incrémenté dans generer_un_client)
        churn_val = client["churn"]
        if churn_val == 1:
            _profil_local = "actif" if random.random() < 0.50 else "passif"
        else:
            _profil_local = None

        envoyer('clients_topic', client)

        clients_info[client["id_client"]] = {
            "revenu": client["revenu_mensuel"],
            "churn":  churn_val,
            "profil": _profil_local,   # stocké localement, jamais dans Kafka
        }

        if i % 10_000 == 0:
            producer.flush()
            nb_churn_now = sum(1 for v in clients_info.values() if v["churn"] == 1)
            print(f"   → {i:,} / {NB_CLIENTS:,} clients | Churners so far: {nb_churn_now:,} ({nb_churn_now/i:.2%})")

    producer.flush()
    nb_churn = sum(1 for v in clients_info.values() if v["churn"] == 1)
    nb_passif = sum(1 for v in clients_info.values() if v["profil"] == "passif")
    nb_actif  = sum(1 for v in clients_info.values() if v["profil"] == "actif")
    print(f"\n✅ {NB_CLIENTS:,} clients envoyés en {time.time()-t0:.1f}s")
    print(f"   Churn total : {nb_churn:,} ({nb_churn/NB_CLIENTS:.2%})")
    print(f"   └─ Profil passif : {nb_passif:,} | Profil actif : {nb_actif:,}\n")
    return clients_info

# ======================================================================
# [2/3] FLUX TRANSACTIONS — Boucle infinie
# ======================================================================

def flux_transactions(clients_info: dict):
    """
    Boucle infinie — génère une transaction toutes les DELAI_TRANSACTIONS sec.
    Tous les clients participent (churners inclus, avec patterns différents).
    Le profil est passé à generer_une_transaction pour la cohérence.
    """
    print("[2/3] Flux TRANSACTIONS démarré (Ctrl+C pour arrêter)...")
    client_ids = list(clients_info.keys())

    # Séparer les pools pour un sampling pondéré :
    # Les churners passifs font très peu de transactions → sous-représentés
    # Les churners actifs font des transactions normales
    ids_non_churn  = [cid for cid, v in clients_info.items() if v["churn"] == 0]
    ids_actif      = [cid for cid, v in clients_info.items() if v["profil"] == "actif"]
    ids_passif     = [cid for cid, v in clients_info.items() if v["profil"] == "passif"]

    # Poids de sampling : passif apparaît 5× moins souvent, actif apparaît normalement
    pool = (
        [(cid, "normal") for cid in ids_non_churn] +
        [(cid, "actif")  for cid in ids_actif] +
        [(cid, "passif") for cid in ids_passif for _ in range(1)]  # 1 fois vs 5 pour non-churn
    )
    # Rééchantillonner : passif = 20% de la fréquence normale
    pool_pondere = (
        [(cid, "normal") for cid in ids_non_churn] * 1 +
        [(cid, "actif")  for cid in ids_actif]     * 1 +
        [(cid, "passif") for cid in ids_passif]    # passif déjà peu représenté naturellement
    )

    tx_id = 1
    total = 0
    t_log = time.time()

    while True:
        cid, profil_override = random.choice(pool_pondere)
        info = clients_info[cid]

        # Profil passif : 70% de chance de SKIP (simule l'inactivité)
        if info["profil"] == "passif" and random.random() < 0.70:
            time.sleep(DELAI_TRANSACTIONS)
            continue

        tx = generer_une_transaction(tx_id, cid, info["revenu"], info["churn"], info["profil"])
        envoyer('transactions_topic', tx)
        tx_id += 1
        total += 1

        if total % 100 == 0:
            rate = 100 / max(time.time() - t_log, 0.001)
            en_attente = len(pending_queue)
            statut = "OK" if kafka_disponible.is_set() else "PANNE"
            log.info(f"[TX]  {total:,} envoyées | {rate:.1f} msg/sec | {tx['id_transaction']} | Kafka: {statut} | file: {en_attente}")
            t_log = time.time()

        time.sleep(DELAI_TRANSACTIONS)

# ======================================================================
# [3/3] FLUX INTERACTIONS — Boucle infinie
# ======================================================================

def flux_interactions(clients_info: dict):
    """
    Boucle infinie — génère une interaction toutes les DELAI_INTERACTIONS sec.
    Profil actif → interactions fréquentes (réclamations).
    Profil passif → interactions rares (silencieux).
    """
    print("[3/3] Flux INTERACTIONS démarré (Ctrl+C pour arrêter)...")

    ids_non_churn  = [cid for cid, v in clients_info.items() if v["churn"] == 0]
    ids_actif      = [cid for cid, v in clients_info.items() if v["profil"] == "actif"]
    ids_passif     = [cid for cid, v in clients_info.items() if v["profil"] == "passif"]

    # Pool pondéré : actif = 3× plus d'interactions que non-churn, passif = très rare
    pool_pondere = (
        ids_non_churn * 1 +
        ids_actif     * 3 +   # très actif en réclamations
        ids_passif    * 1      # présent mais rare
    )

    int_id = 1
    total  = 0
    t_log  = time.time()

    while True:
        cid  = random.choice(pool_pondere)
        info = clients_info[cid]

        # Passif : 65% de chance de SKIP (il ne contacte presque jamais)
        if info["profil"] == "passif" and random.random() < 0.65:
            time.sleep(DELAI_INTERACTIONS)
            continue

        interaction = generer_une_interaction(int_id, cid, info["churn"], info["profil"])
        envoyer('interactions_topic', interaction)
        int_id += 1
        total  += 1

        if total % 100 == 0:
            rate = 100 / max(time.time() - t_log, 0.001)
            en_attente = len(pending_queue)
            statut = "OK" if kafka_disponible.is_set() else "PANNE"
            log.info(f"[INT] {total:,} envoyées | {rate:.1f} msg/sec | {interaction['id_interaction']} | Kafka: {statut} | file: {en_attente}")
            t_log = time.time()

        time.sleep(DELAI_INTERACTIONS)

# ======================================================================
# MAIN
# ======================================================================

if __name__ == "__main__":

    clients_info = envoyer_clients()

    print("=" * 65)
    print("  FLUX TEMPS RÉEL ACTIF — Ctrl+C pour arrêter")
    print("=" * 65 + "\n")

    t_watch = threading.Thread(target=thread_reconnexion, name="watchdog", daemon=True)
    t_watch.start()

    t_tx  = threading.Thread(target=flux_transactions, args=(clients_info,), name="tx",  daemon=True)
    t_int = threading.Thread(target=flux_interactions, args=(clients_info,), name="int", daemon=True)

    t_tx.start()
    t_int.start()

    try:
        while True:
            time.sleep(5)
    except KeyboardInterrupt:
        print("\n⛔ Arrêt demandé — flush final en cours...")
        producer.flush()
        producer.close()
        print("✅ Producer arrêté proprement.")
