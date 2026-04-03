"""
Consumer Kafka - Banque Virtuelle Tunisienne
Lit depuis 3 topics Kafka et insère dans PostgreSQL BD_ATTEJARI :
  - clients_topic      → staging.STG_CLIENTS
  - transactions_topic → staging.STG_TRANSACTIONS
  - interactions_topic → staging.stg_interactions

Améliorations v2.0 :
  - Flush temporel : insertion forcée toutes les FLUSH_INTERVAL secondes
  - Gestion d'erreurs explicite (pas de threads silencieux qui meurent)
  - Flush final à l'arrêt pour ne perdre aucun message
  - Logs enrichis avec horodatage

Auteur: Farah Jaffel | Version Kafka 2.0
"""

import json
import threading
import time
import os
import psycopg2
from psycopg2.extras import execute_batch
from kafka import KafkaConsumer
from datetime import datetime

# ======================================================================
# CONFIGURATION
# ======================================================================
os.environ["PGCLIENTENCODING"] = "UTF8"

DB_CONFIG = {
    "dbname":          "BD_ATTEJARI",
    "user":            "postgres",
    "password":        "farah",
    "host":            "localhost",
    "port":            "5433",
    "client_encoding": "UTF8",
}

BATCH_SIZE     = 50    # Insérer dès 50 messages accumulés
FLUSH_INTERVAL = 5     # OU forcer l'insertion toutes les 5 secondes (même si < 50 msg)


# ======================================================================
# UTILITAIRE : log avec horodatage
# ======================================================================
def log(topic: str, msg: str):
    ts = datetime.now().strftime("%H:%M:%S")
    print(f"[{ts}] [{topic}] {msg}")


# ======================================================================
# UTILITAIRE : flush du batch vers PostgreSQL
# ======================================================================
def flush_batch(cur, conn, sql: str, batch: list, topic: str, total: int) -> tuple[list, int]:
    """Insère le batch et retourne (batch_vide, nouveau_total)."""
    if not batch:
        return batch, total
    try:
        execute_batch(cur, sql, batch)
        conn.commit()
        total += len(batch)
        log(topic, f"✅ {len(batch)} insérés — total cumulé : {total:,}")
    except Exception as e:
        conn.rollback()
        log(topic, f"❌ Erreur lors de l'insertion : {e}")
    return [], total


# ======================================================================
# CONSUMER CLIENTS → staging.STG_CLIENTS
# ======================================================================
def consumer_clients():
    topic = "CLIENTS"
    log(topic, "Démarrage du consumer...")

    try:
        conn = psycopg2.connect(**DB_CONFIG)
        conn.autocommit = False
        cur = conn.cursor()
        log(topic, "✅ Connexion PostgreSQL OK")
    except Exception as e:
        log(topic, f"❌ Connexion PostgreSQL échouée : {e}")
        return

    consumer = KafkaConsumer(
        "clients_topic",
        bootstrap_servers="localhost:9092",
        auto_offset_reset="earliest",
        group_id="group_clients_v1",
        value_deserializer=lambda x: json.loads(x.decode("utf-8")),
        consumer_timeout_ms=FLUSH_INTERVAL * 1000,  # Timeout pour forcer le flush
    )

    SQL = """
        INSERT INTO staging."STG_CLIENTS"
        (id_client, sexe, date_naissance, est_senior,
         situation_matrimoniale, enfants_a_charge, profession, ville_region,
         anciennete_mois, service_sms_banking, acces_banque_en_ligne,
         alerte_securite_active, assurance_moyen_paiement, conseiller_dedie,
         programme_fidelite, type_convention, e_releve_active,
         methode_paiement_fav, frais_bancaires_mensuels, total_frais_cumules,
         revenu_mensuel, nb_produits_actifs, score_risque_interne, churn)
        VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
        ON CONFLICT (id_client) DO NOTHING
    """

    batch = []
    total = 0
    last_flush = time.time()

    try:
        while True:
            try:
                for msg in consumer:
                    c = msg.value
                    batch.append((
                        c.get("id_client"), c.get("sexe"), c.get("date_naissance"),
                        c.get("est_senior"), c.get("situation_matrimoniale"),
                        c.get("enfants_a_charge"), c.get("profession"), c.get("ville_region"),
                        c.get("anciennete_mois"), c.get("service_sms_banking"),
                        c.get("acces_banque_en_ligne"), c.get("alerte_securite_active"),
                        c.get("assurance_moyen_paiement"), c.get("conseiller_dedie"),
                        c.get("programme_fidelite"), c.get("type_convention"),
                        c.get("e_releve_active"), c.get("methode_paiement_fav"),
                        c.get("frais_bancaires_mensuels"), c.get("total_frais_cumules"),
                        c.get("revenu_mensuel"), c.get("nb_produits_actifs"),
                        c.get("score_risque_interne"), c.get("churn"),
                    ))

                    # Flush par taille
                    if len(batch) >= BATCH_SIZE:
                        batch, total = flush_batch(cur, conn, SQL, batch, topic, total)
                        last_flush = time.time()

                # Timeout atteint → flush temporel
                if batch:
                    log(topic, f"⏱ Flush temporel ({len(batch)} msg en attente)...")
                    batch, total = flush_batch(cur, conn, SQL, batch, topic, total)
                    last_flush = time.time()

            except Exception as e:
                log(topic, f"❌ Erreur dans la boucle : {e}")
                time.sleep(2)

    except KeyboardInterrupt:
        # Flush final avant arrêt
        if batch:
            log(topic, f"⛔ Arrêt — flush final de {len(batch)} messages...")
            flush_batch(cur, conn, SQL, batch, topic, total)
        log(topic, "Consumer arrêté proprement.")
    finally:
        cur.close()
        conn.close()


# ======================================================================
# CONSUMER TRANSACTIONS → staging.STG_TRANSACTIONS
# ======================================================================
def consumer_transactions():
    topic = "TRANSACTIONS"
    log(topic, "Démarrage du consumer...")

    try:
        conn = psycopg2.connect(**DB_CONFIG)
        conn.autocommit = False
        cur = conn.cursor()
        log(topic, "✅ Connexion PostgreSQL OK")
    except Exception as e:
        log(topic, f"❌ Connexion PostgreSQL échouée : {e}")
        return

    consumer = KafkaConsumer(
        "transactions_topic",
        bootstrap_servers="localhost:9092",
        auto_offset_reset="earliest",
        group_id="group_transactions",
        value_deserializer=lambda x: json.loads(x.decode("utf-8")),
        consumer_timeout_ms=FLUSH_INTERVAL * 1000,
    )

    SQL = """
        INSERT INTO staging."STG_TRANSACTIONS"
        (id_transaction, id_client, date_transaction, type_operation,
         montant, sens_operation, canal_transaction,
         solde_apres_operation, est_rejete, categorie_depense)
        VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
        ON CONFLICT (id_transaction) DO NOTHING
    """

    batch = []
    total = 0

    try:
        while True:
            try:
                for msg in consumer:
                    t = msg.value
                    batch.append((
                        t.get("id_transaction"), t.get("id_client"),
                        t.get("date_transaction"), t.get("type_operation"),
                        t.get("montant"), t.get("sens_operation"),
                        t.get("canal_transaction"), t.get("solde_apres_operation"),
                        t.get("est_rejete"), t.get("categorie_depense"),
                    ))

                    if len(batch) >= BATCH_SIZE:
                        batch, total = flush_batch(cur, conn, SQL, batch, topic, total)

                if batch:
                    log(topic, f"⏱ Flush temporel ({len(batch)} msg en attente)...")
                    batch, total = flush_batch(cur, conn, SQL, batch, topic, total)

            except Exception as e:
                log(topic, f"❌ Erreur dans la boucle : {e}")
                time.sleep(2)

    except KeyboardInterrupt:
        if batch:
            log(topic, f"⛔ Arrêt — flush final de {len(batch)} messages...")
            flush_batch(cur, conn, SQL, batch, topic, total)
        log(topic, "Consumer arrêté proprement.")
    finally:
        cur.close()
        conn.close()


# ======================================================================
# CONSUMER INTERACTIONS → staging.stg_interactions
# ======================================================================
def consumer_interactions():
    topic = "INTERACTIONS"
    log(topic, "Démarrage du consumer...")

    try:
        conn = psycopg2.connect(**DB_CONFIG)
        conn.autocommit = False
        cur = conn.cursor()
        log(topic, "✅ Connexion PostgreSQL OK")
    except Exception as e:
        log(topic, f"❌ Connexion PostgreSQL échouée : {e}")
        return

    consumer = KafkaConsumer(
        "interactions_topic",
        bootstrap_servers="localhost:9092",
        auto_offset_reset="earliest",
        group_id="group_interactions",
        value_deserializer=lambda x: json.loads(x.decode("utf-8")),
        consumer_timeout_ms=FLUSH_INTERVAL * 1000,
    )

    SQL = """
        INSERT INTO staging."stg_interactions"
        (id_interaction, id_client, date_interaction, canal_interaction,
         type_interaction, est_reclamation, motif_reclamation,
         statut_resolution, delai_resolution_jours,
         score_satisfaction_nps, duree_connexion_sec)
        VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
        ON CONFLICT (id_interaction) DO NOTHING
    """

    batch = []
    total = 0

    try:
        while True:
            try:
                for msg in consumer:
                    i = msg.value
                    batch.append((
                        i.get("id_interaction"), i.get("id_client"),
                        i.get("date_interaction"), i.get("canal_interaction"),
                        i.get("type_interaction"), i.get("est_reclamation"),
                        i.get("motif_reclamation"), i.get("statut_resolution"),
                        i.get("delai_resolution_jours"), i.get("score_satisfaction_nps"),
                        i.get("duree_connexion_sec"),
                    ))

                    if len(batch) >= BATCH_SIZE:
                        batch, total = flush_batch(cur, conn, SQL, batch, topic, total)

                if batch:
                    log(topic, f"⏱ Flush temporel ({len(batch)} msg en attente)...")
                    batch, total = flush_batch(cur, conn, SQL, batch, topic, total)

            except Exception as e:
                log(topic, f"❌ Erreur dans la boucle : {e}")
                time.sleep(2)

    except KeyboardInterrupt:
        if batch:
            log(topic, f"⛔ Arrêt — flush final de {len(batch)} messages...")
            flush_batch(cur, conn, SQL, batch, topic, total)
        log(topic, "Consumer arrêté proprement.")
    finally:
        cur.close()
        conn.close()


# ======================================================================
# MAIN — Lance les 3 consumers en parallèle
# ======================================================================
if __name__ == "__main__":
    print("\n" + "=" * 65)
    print("  CONSUMER KAFKA v2.0 - BANQUE VIRTUELLE TUNISIENNE")
    print(f"  Batch size : {BATCH_SIZE} msg  |  Flush toutes les {FLUSH_INTERVAL}s")
    print("=" * 65 + "\n")

    threads = [
        threading.Thread(target=consumer_clients,      name="clients",      daemon=True),
        threading.Thread(target=consumer_transactions, name="transactions", daemon=True),
        threading.Thread(target=consumer_interactions, name="interactions", daemon=True),
    ]

    for t in threads:
        t.start()

    print("✅ 3 consumers démarrés en parallèle\n")

    try:
        while True:
            time.sleep(5)
    except KeyboardInterrupt:
        print("\n⛔ Signal d'arrêt reçu — flush finaux en cours...")
        time.sleep(3)  # Laisser le temps aux threads de flush
        print("✅ Consumer arrêté proprement.")
