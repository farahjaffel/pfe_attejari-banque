"""
Producer Kafka - Flux Temps Réel - Banque Virtuelle Tunisienne
Génère et envoie les données EN TEMPS RÉEL vers 3 topics Kafka :
  - clients_topic       (envoyés au démarrage, table de référence)
  - transactions_topic  (flux continu infini)
  - interactions_topic  (flux continu infini)

Auteur: Farah Jaffel | Version Temps Réel 3.0

Logique :
  1. Au démarrage → génère et envoie 100K clients (une seule fois)
  2. Ensuite      → 2 threads tournent en boucle infinie :
       - Thread 1 : génère une transaction toutes les DELAI_TRANSACTIONS secondes
       - Thread 2 : génère une interaction toutes les DELAI_INTERACTIONS secondes
  3. Gestion d'erreurs Kafka :
       - Callback on_error sur chaque message
       - Reconnexion automatique si Kafka tombe (max MAX_RETRIES tentatives)
       - Messages en attente mis en file locale pendant la panne
       - Log horodaté de toutes les erreurs
  4. Ctrl+C → arrêt propre
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
TAUX_CHURN_CIBLE = 0.25

# Délais entre chaque message (en secondes)
# 0.0  → vitesse max
# 0.01 → 100 msg/sec
# 0.1  → 10 msg/sec  ← recommandé pour démo visible
# 1.0  → 1 msg/sec   ← pour voir chaque message clairement
DELAI_TRANSACTIONS = 0.1
DELAI_INTERACTIONS = 0.15

SEED = 42
np.random.seed(SEED)
random.seed(SEED)

# Gestion d'erreurs Kafka
MAX_RETRIES      = 10     # tentatives de reconnexion max
RETRY_DELAY_S    = 5      # secondes entre chaque tentative
MAX_PENDING_MSGS = 5_000  # messages mis en attente max pendant une panne

# ======================================================================
# LOGGING
# ======================================================================

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
)
log = logging.getLogger("producer_kafka")

# File d'attente partagée : stocke les messages si Kafka est indisponible
# Structure : deque de tuples (topic, message_dict)
pending_queue: deque = deque(maxlen=MAX_PENDING_MSGS)
kafka_disponible = threading.Event()
kafka_disponible.set()  # True au démarrage

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
# INITIALISATION KAFKA
# ======================================================================

# ======================================================================
# CONNEXION KAFKA — avec retry automatique
# ======================================================================

def creer_producer() -> KafkaProducer:
    """
    Crée un KafkaProducer. Réessaie jusqu'à MAX_RETRIES fois
    si Kafka n'est pas encore disponible.
    """
    for tentative in range(1, MAX_RETRIES + 1):
        try:
            p = KafkaProducer(
                bootstrap_servers='localhost:9092',
                value_serializer=lambda v: json.dumps(v, default=str).encode('utf-8'),
                batch_size=16384,
                linger_ms=5,
                compression_type='gzip',
                retries=5,                    # retry interne Kafka
                acks='all',                   # attendre confirmation broker
                request_timeout_ms=30_000,    # timeout 30s par requête
            )
            log.info(f"Connecté à Kafka (tentative {tentative}/{MAX_RETRIES})")
            return p
        except NoBrokersAvailable:
            log.warning(f"Kafka indisponible — tentative {tentative}/{MAX_RETRIES} — retry dans {RETRY_DELAY_S}s...")
            time.sleep(RETRY_DELAY_S)

    raise RuntimeError(f"Impossible de se connecter à Kafka après {MAX_RETRIES} tentatives.")


def on_send_success(record_metadata):
    """Callback appelé quand Kafka confirme la réception d'un message."""
    pass  # succès silencieux — les logs de volume sont dans les threads


def on_send_error(excp, topic: str, msg: dict):
    """
    Callback appelé si Kafka rejette un message.
    → Log l'erreur et met le message en file d'attente locale.
    """
    log.error(f"Erreur envoi sur [{topic}] : {excp.__class__.__name__} — {excp}")
    pending_queue.append((topic, msg))
    if len(pending_queue) >= MAX_PENDING_MSGS:
        log.warning(f"File d'attente pleine ({MAX_PENDING_MSGS} msgs) — les plus anciens sont perdus !")


def envoyer(topic: str, msg: dict):
    """
    Envoie un message vers Kafka avec callbacks success/error.
    Si Kafka est indisponible, met le message en file d'attente.
    """
    if not kafka_disponible.is_set():
        # Kafka est en panne — mise en attente locale
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
    """
    Thread de surveillance : détecte si Kafka tombe et
    tente de se reconnecter, puis rejoue les messages en attente.
    """
    global producer
    while True:
        time.sleep(10)  # vérifie toutes les 10 secondes
        try:
            # Test : envoyer un message vide pour vérifier la connexion
            producer.partitions_for('clients_topic')
            if not kafka_disponible.is_set():
                log.info("Kafka à nouveau disponible ! Reprise du flux...")
                kafka_disponible.set()
                _rejouer_messages_en_attente()
        except Exception:
            if kafka_disponible.is_set():
                log.error("Kafka est tombé ! Passage en mode attente locale...")
                kafka_disponible.clear()
            # Tentative de reconnexion
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
    """Renvoie tous les messages mis en attente pendant la panne."""
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
print("  PRODUCER KAFKA - FLUX TEMPS RÉEL v3.0")
print("  Banque Virtuelle Tunisienne")
print(f"  Transactions : 1 msg / {DELAI_TRANSACTIONS}s  ({1/DELAI_TRANSACTIONS:.0f} msg/sec)")
print(f"  Interactions : 1 msg / {DELAI_INTERACTIONS}s ({1/DELAI_INTERACTIONS:.0f} msg/sec)")
print(f"  Reconnexion  : auto (max {MAX_RETRIES} tentatives, délai {RETRY_DELAY_S}s)")
print(f"  File attente : max {MAX_PENDING_MSGS} msgs pendant panne Kafka")
print("=" * 65 + "\n")

# ======================================================================
# GÉNÉRATION D'UN CLIENT
# ======================================================================

def generer_un_client(client_id: int) -> dict:
    profession = random.choices(PROFESSIONS, weights=PROF_POIDS)[0]
    ville      = random.choices(VILLES, weights=VILLE_POIDS)[0]
    age        = int(np.clip(np.random.normal(38, 13), 18, 80))
    anciennete = int(np.clip(np.random.exponential(40), 1, 240))
    revenu     = round(max(200.0, np.random.normal(*REVENU_PROF[profession])), 3)
    convention = random.choices(["Mensuel","Annuel","Gratuit","Pack"], weights=[0.25,0.30,0.20,0.25])[0]
    frais_m    = 0.0 if convention == "Gratuit" else round(float(np.clip(np.random.normal(12, 5), 0, 50)), 3)
    nb_prod    = int(np.clip(np.random.poisson(2.2), 1, 6))
    score_r    = random.choices([1,2,3,4,5], weights=[0.10,0.25,0.35,0.20,0.10])[0]
    conseiller = int(random.random() < 0.30)
    fidelite   = int(random.random() < 0.38)
    sms        = int(random.random() < 0.68)
    acces_bl   = random.choices(["Standard","Webank","Aucun"], weights=[0.40,0.45,0.15])[0]
    situation  = random.choices(["Marie","Celibataire","Divorce","Veuf"], weights=[0.52,0.33,0.10,0.05])[0]
    sexe       = random.choices(["M","F"], weights=[0.54,0.46])[0]

    # Score churn (même logique que l'original)
    cs = (  0.20*(1/np.sqrt(anciennete+1))
          + 0.15*(score_r/5)
          - 0.12*(nb_prod/6)
          + 0.10*(frais_m/50)
          - 0.08*conseiller
          - 0.07*fidelite
          + 0.06*(1 if acces_bl=="Aucun" else 0)
          - 0.05*sms
          + 0.05*(1 if age > 65 else 0)
          + random.uniform(-0.08, 0.08))
    prob  = 1 / (1 + np.exp(-10 * (cs - 0.15)))
    churn = int(prob >= 0.5)

    date_fin       = datetime(2024, 12, 31)
    date_naissance = (date_fin - timedelta(days=age*365 + random.randint(0,364))).strftime("%Y-%m-%d")
    enfants        = int(
        (situation == "Marie"  and random.random() < 0.65) or
        (situation != "Marie"  and random.random() < 0.10)
    )

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
        "alerte_securite_active":   int(random.random() < 0.55),
        "assurance_moyen_paiement": int(random.random() < 0.42),
        "conseiller_dedie":         conseiller,
        "programme_fidelite":       fidelite,
        "type_convention":          convention,
        "e_releve_active":          int(random.random() < 0.60),
        "methode_paiement_fav":     random.choices(["Prelevement auto","Carte","Cheque"], weights=[0.45,0.40,0.15])[0],
        "frais_bancaires_mensuels": frais_m,
        "total_frais_cumules":      round(frais_m * anciennete * random.uniform(0.8, 1.1), 3),
        "revenu_mensuel":           revenu,
        "nb_produits_actifs":       nb_prod,
        "score_risque_interne":     score_r,
        "churn":                    churn,
    }

# ======================================================================
# GÉNÉRATION D'UNE TRANSACTION
# ======================================================================

def generer_une_transaction(tx_id: int, client_id: str, revenu: float, is_churn: int) -> dict:
    type_op = random.choices(TYPES_OPS, weights=TYPES_OPS_POIDS)[0]
    sens    = SENS_MAP[type_op]
    canal   = random.choices(CANAUX_TX, weights=CANAUX_TX_POIDS)[0]

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

    solde_avant = float(np.clip(np.random.normal(3000, 2000), 0, 50000))
    if is_churn:
        solde_avant *= random.uniform(0.3, 0.7)
    solde_apres = round(
        max(0.0, solde_avant - montant) if sens == "Debit" else solde_avant + montant,
        3
    )

    taux_rejet = 0.08 if is_churn else 0.02
    if solde_apres < 100:
        taux_rejet += 0.10
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
# GÉNÉRATION D'UNE INTERACTION
# ======================================================================

def generer_une_interaction(int_id: int, client_id: str, is_churn: int) -> dict:
    canal = random.choices(CANAUX_INT, weights=CANAUX_INT_POIDS)[0]

    if is_churn:
        type_int = random.choices(TYPES_INT, weights=[0.20, 0.30, 0.35, 0.15])[0]
    else:
        type_int = random.choices(TYPES_INT, weights=[0.35, 0.40, 0.10, 0.15])[0]

    est_reclamation = int(type_int == "Reclamation")
    motif  = random.choices(MOTIFS, weights=MOTIFS_POIDS)[0] if est_reclamation else ""
    statut = random.choices(["Resolu","En Cours"], weights=[0.65,0.35])[0] if est_reclamation else "Non applicable"
    delai  = float(random.choices([1,2,3,5,7,10,15,20],
                   weights=[0.20,0.20,0.15,0.15,0.10,0.10,0.07,0.03])[0]) if est_reclamation else None

    nps = None
    if random.random() < 0.30:
        nps = float(random.randint(0, 5)) if is_churn else float(random.randint(5, 10))

    digital = canal in ["Application Mobile", "Site Web"]
    if digital:
        duree = int(np.clip(np.random.exponential(300), 30, 1800))
        if is_churn:
            duree = int(duree * random.uniform(0.4, 0.7))
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
    print(f"[1/3] Génération et envoi de {NB_CLIENTS:,} clients...")
    t0 = time.time()
    clients_info = {}

    for i in range(1, NB_CLIENTS + 1):
        client = generer_un_client(i)
        envoyer('clients_topic', client)
        clients_info[client["id_client"]] = {
            "revenu": client["revenu_mensuel"],
            "churn":  client["churn"],
        }
        if i % 10_000 == 0:
            producer.flush()
            print(f"   → {i:,} / {NB_CLIENTS:,} clients envoyés")

    producer.flush()
    nb_churn = sum(1 for v in clients_info.values() if v["churn"] == 1)
    print(f"✅ {NB_CLIENTS:,} clients envoyés | Churn: {nb_churn/NB_CLIENTS:.2%} | {time.time()-t0:.1f}s\n")
    return clients_info

# ======================================================================
# [2/3] FLUX TRANSACTIONS — Boucle infinie
# ======================================================================

def flux_transactions(clients_info: dict):
    print("[2/3] Flux TRANSACTIONS démarré (Ctrl+C pour arrêter)...")
    client_ids = list(clients_info.keys())
    tx_id = 1
    total = 0
    t_log = time.time()

    while True:
        client_id = random.choice(client_ids)
        info = clients_info[client_id]

        # Les churners font moins de transactions
        if info["churn"] == 1 and random.random() > 0.6:
            continue

        tx = generer_une_transaction(tx_id, client_id, info["revenu"], info["churn"])
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
    print("[3/3] Flux INTERACTIONS démarré (Ctrl+C pour arrêter)...")
    client_ids = list(clients_info.keys())
    int_id = 1
    total = 0
    t_log = time.time()

    while True:
        client_id = random.choice(client_ids)
        info = clients_info[client_id]

        # Les churners interagissent plus
        if info["churn"] == 0 and random.random() > 0.9:
            continue

        interaction = generer_une_interaction(int_id, client_id, info["churn"])
        envoyer('interactions_topic', interaction)
        int_id += 1
        total += 1

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

    # Étape 1 : envoyer les clients (synchrone — doit finir avant les flux)
    clients_info = envoyer_clients()

    print("=" * 65)
    print("  FLUX TEMPS RÉEL ACTIF — Ctrl+C pour arrêter")
    print("=" * 65 + "\n")

    # Thread de surveillance Kafka (reconnexion automatique)
    t_watch = threading.Thread(target=thread_reconnexion, name="watchdog", daemon=True)
    t_watch.start()

    # Étapes 2 & 3 : deux threads en parallèle, en boucle infinie
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
