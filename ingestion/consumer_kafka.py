"""
Consumer Kafka - Banque Virtuelle Tunisienne
Version 2.4 - FIX : Consumer clients ne lit pas les messages
"""

import json
import threading
import time
import os
import sys
import psycopg2
from psycopg2.extras import execute_batch
from kafka import KafkaConsumer
from datetime import datetime
import traceback

# Importation de la configuration
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from config import get_connection, KAFKA_SERVER

# Paramètres
BATCH_SIZE     = 50    
FLUSH_INTERVAL = 5

def log(topic: str, msg: str):
    ts = datetime.now().strftime("%H:%M:%S")
    print(f"[{ts}] [{topic}] {msg}", flush=True)

def flush_batch(cur, sql: str, batch: list, topic: str, total: int) -> tuple[list, int]:
    if not batch:
        return batch, total
    try:
        execute_batch(cur, sql, batch)
        total += len(batch)
        log(topic, f"✅ {len(batch)} insérés — total cumulé : {total:,}")
    except Exception as e:
        log(topic, f"❌ Erreur insertion : {e}")
        # Afficher la première ligne qui pose problème
        if batch:
            log(topic, f"📝 Première ligne du batch : {batch[0]}")
        traceback.print_exc()
    return [], total

# ======================================================================
# CONSUMER CLIENTS - VERSION CORRIGÉE
# ======================================================================
def consumer_clients():
    topic = "CLIENTS"
    log(topic, "🚀 Démarrage du consumer...")

    # 1. VÉRIFIER LA CONNEXION POSTGRES
    try:
        conn = get_connection()
        log(topic, f"🔍 CONNECTÉ À : {conn.info.dbname} sur {conn.info.host}:{conn.info.port}")
        conn.autocommit = True
        cur = conn.cursor()
        
        # Tester que la table existe
        cur.execute("SELECT COUNT(*) FROM staging.stg_clients;")
        existing = cur.fetchone()[0]
        log(topic, f"📊 Table staging.stg_clients existe : {existing} lignes actuelles")
        
    except Exception as e:
        log(topic, f"❌ ERREUR CONNEXION POSTGRES : {e}")
        traceback.print_exc()
        return

    # 2. CRÉER LE CONSUMER KAFKA
    try:
        log(topic, f"📡 Connexion à Kafka : {KAFKA_SERVER}")
        log(topic, f"📋 Group ID : group_clients_v7 (nouveau pour forcer la lecture)")
        
        consumer = KafkaConsumer(
            "clients_topic",
            bootstrap_servers=KAFKA_SERVER,
            auto_offset_reset="earliest",  # Lire depuis le début
            group_id="group_clients_v7",   # NOUVEAU GROUP ID pour forcer la relecture
            value_deserializer=lambda x: json.loads(x.decode("utf-8")),
            consumer_timeout_ms=FLUSH_INTERVAL * 1000,
            enable_auto_commit=True,
            max_poll_records=500,  # Lire plus de messages à la fois
        )
        
        # Vérifier les partitions assignées
        partitions = consumer.assignment()
        log(topic, f"📌 Partitions assignées : {partitions}")
        
        # Vérifier la position actuelle
        consumer.poll(timeout_ms=1000)
        for partition in consumer.assignment():
            position = consumer.position(partition)
            log(topic, f"📍 Position actuelle sur {partition} : {position}")
        
    except Exception as e:
        log(topic, f"❌ ERREUR CRÉATION CONSUMER KAFKA : {e}")
        traceback.print_exc()
        return

    # 3. SQL D'INSERTION
    SQL = """
        INSERT INTO staging.stg_clients
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

    # 4. BOUCLE DE CONSOMMATION
    batch = []
    total = 0
    msg_count = 0
    last_log_time = time.time()
    
    log(topic, "🔄 Début de la lecture des messages...")
    
    try:
        while True:
            try:
                # Poll avec timeout explicite
                messages = consumer.poll(timeout_ms=5000, max_records=500)
                
                if not messages:
                    # Pas de nouveaux messages
                    if batch:
                        log(topic, f"⏱ Timeout - Flush du batch restant ({len(batch)} messages)")
                        batch, total = flush_batch(cur, SQL, batch, topic, total)
                    continue
                
                # Traiter tous les messages reçus
                for topic_partition, records in messages.items():
                    log(topic, f"📥 Reçu {len(records)} messages de {topic_partition}")
                    
                    for msg in records:
                        msg_count += 1
                        c = msg.value
                        
                        # Vérifier que le message contient bien les données
                        if not c.get("id_client"):
                            log(topic, f"⚠️ Message sans id_client : {c}")
                            continue
                        
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
                        
                        # Flush si batch plein
                        if len(batch) >= BATCH_SIZE:
                            batch, total = flush_batch(cur, SQL, batch, topic, total)
                
                # Log de progression toutes les 5 secondes
                if time.time() - last_log_time > 5:
                    log(topic, f"📊 Progression : {msg_count} messages lus, {total} insérés en DB")
                    last_log_time = time.time()
                
            except Exception as e:
                log(topic, f"❌ ERREUR dans la boucle de lecture : {e}")
                traceback.print_exc()
                time.sleep(2)
    
    except KeyboardInterrupt:
        log(topic, "⛔ Arrêt demandé")
    
    finally:
        # Flush final
        if batch:
            log(topic, f"🔚 Flush final de {len(batch)} messages")
            flush_batch(cur, SQL, batch, topic, total)
        
        log(topic, f"✅ TERMINÉ : {msg_count} messages lus, {total} clients insérés")
        cur.close()
        conn.close()
        consumer.close()


# ======================================================================
# CONSUMER TRANSACTIONS - INCHANGÉ
# ======================================================================
def consumer_transactions():
    topic = "TRANSACTIONS"
    log(topic, "Démarrage...")

    try:
        conn = get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        log(topic, "✅ Connexion PostgreSQL OK")
    except Exception as e:
        log(topic, f"❌ Connexion échouée : {e}")
        traceback.print_exc()
        return

    consumer = KafkaConsumer(
        "transactions_topic",
        bootstrap_servers=KAFKA_SERVER,
        auto_offset_reset="earliest",
        group_id="group_transactions",
        value_deserializer=lambda x: json.loads(x.decode("utf-8")),
        consumer_timeout_ms=FLUSH_INTERVAL * 1000,
    )

    SQL = """
        INSERT INTO staging.stg_transactions
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
                        batch, total = flush_batch(cur, SQL, batch, topic, total)
                if batch:
                    batch, total = flush_batch(cur, SQL, batch, topic, total)
            except Exception as e:
                log(topic, f"❌ Erreur boucle : {e}")
                traceback.print_exc()
                time.sleep(2)
    except KeyboardInterrupt:
        log(topic, "⛔ Arrêt demandé")
    finally:
        if batch:
            flush_batch(cur, SQL, batch, topic, total)
        cur.close()
        conn.close()


# ======================================================================
# CONSUMER INTERACTIONS - INCHANGÉ
# ======================================================================
def consumer_interactions():
    topic = "INTERACTIONS"
    log(topic, "Démarrage...")

    try:
        conn = get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        log(topic, "✅ Connexion PostgreSQL OK")
    except Exception as e:
        log(topic, f"❌ Connexion échouée : {e}")
        traceback.print_exc()
        return

    consumer = KafkaConsumer(
        "interactions_topic",
        bootstrap_servers=KAFKA_SERVER,
        auto_offset_reset="earliest",
        group_id="group_interactions",
        value_deserializer=lambda x: json.loads(x.decode("utf-8")),
        consumer_timeout_ms=FLUSH_INTERVAL * 1000,
    )

    SQL = """
        INSERT INTO staging.stg_interactions
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
                        batch, total = flush_batch(cur, SQL, batch, topic, total)
                if batch:
                    batch, total = flush_batch(cur, SQL, batch, topic, total)
            except Exception as e:
                log(topic, f"❌ Erreur boucle : {e}")
                traceback.print_exc()
                time.sleep(2)
    except KeyboardInterrupt:
        log(topic, "⛔ Arrêt demandé")
    finally:
        if batch:
            flush_batch(cur, SQL, batch, topic, total)
        cur.close()
        conn.close()


# ======================================================================
# MAIN - THREADS NON-DAEMON pour voir les erreurs
# ======================================================================
if __name__ == "__main__":
    print("\n" + "=" * 70)
    print("  CONSUMER KAFKA v2.4 - FIX CONSUMER CLIENTS")
    print("  Changements:")
    print("    - Nouveau group_id pour forcer la relecture")
    print("    - Logs détaillés pour debug")
    print("    - Threads NON-daemon pour voir les erreurs")
    print("    - Traceback complet en cas d'erreur")
    print("=" * 70 + "\n")

    # THREADS NON-DAEMON pour voir les crash
    threads = [
        threading.Thread(target=consumer_clients,      name="clients",      daemon=False),
        threading.Thread(target=consumer_transactions, name="transactions", daemon=False),
        threading.Thread(target=consumer_interactions, name="interactions", daemon=False),
    ]

    for t in threads:
        t.start()
        log("MAIN", f"✅ Thread {t.name} démarré")

    log("MAIN", "🎯 3 consumers actifs - Appuyez sur Ctrl+C pour arrêter")

    try:
        while True:
            time.sleep(5)
            # Vérifier si les threads sont toujours vivants
            for t in threads:
                if not t.is_alive():
                    log("MAIN", f"⚠️ Thread {t.name} est mort !")
    except KeyboardInterrupt:
        print("\n⛔ Arrêt demandé - Attente de fermeture des threads...")
        time.sleep(3)
        print("✅ Arrêt complet")