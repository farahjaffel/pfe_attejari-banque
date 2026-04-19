from airflow import DAG
from airflow.operators.python import PythonOperator
from airflow.operators.bash import BashOperator
from airflow.providers.postgres.operators.postgres import PostgresOperator # Plus propre pour le SQL
from datetime import datetime, timedelta
import psycopg2

# 1. CONFIGURATION
# Note : Pour bien faire, ces params devraient être dans "Airflow Connections" sur l'UI
DB_PARAMS = {
    "dbname": "BD_ATTEJARI",
    "user": "postgres",
    "password": "farah",
    "host": "postgres-attejari",
    "port": "5432"
}

TALEND_PATH = "/opt/airflow/kairos/Talend_Export/J_Master_ETL_0.1/J_Master_ETL"

def check_staging_data():
    conn = None
    try:
        conn = psycopg2.connect(**DB_PARAMS)
        cur = conn.cursor()
        # On garde les guillemets et les majuscules tels qu'ils apparaissent dans pgAdmin
        cur.execute('SELECT COUNT(*) FROM "staging"."stg_clients";')
        count = cur.fetchone()[0]
        print(f"✅ SUCCES : {count} lignes trouvées en Staging.")
        cur.close()
        conn.close()
        if count == 0:
            raise ValueError("Staging vide, arrêt du workflow.")
    except Exception as e:
        if conn: conn.close()
        print(f"❌ ERREUR : Vérification Staging échouée.")
        raise e

# 3. DEFINITION DU DAG
with DAG(
    'KAIROS_ATT_ORCHESTRATION_V4',
    default_args={
        'owner': 'Farah_Jaffel',
        'depends_on_past': False,
        'start_date': datetime(2024, 1, 1), # Gardez une date passée
        'retries': 1,
        'retry_delay': timedelta(minutes=5),
    },
    # MODIFICATION ICI : '0 0 * * *' signifie "Tous les jours à 00:00"
    schedule_interval='0 0 * * *', 
    catchup=False, # Très important pour ne pas exécuter tous les jours manqués depuis 2024
    tags=['Attijari', 'KAIROS', 'DWH']
) as dag:

    # Tâche 1 : Vérification
    t1 = PythonOperator(
        task_id='verifier_donnees_staging',
        python_callable=check_staging_data
    )

    # Tâche 2 : Talend
    t2 = BashOperator(
        task_id='execution_talend_etl',
        bash_command=f'cd {TALEND_PATH} && bash ./J_Master_ETL_run.sh --context=Docker'
    )

    # Tâche 3 : Refresh de la vue ML (Version SQL pure)
    # Note : Assurez-vous d'avoir créé une connexion "postgres_default" dans l'UI Airflow
    # Sinon, on peut garder votre version PythonOperator ci-dessous
    t3 = PostgresOperator(
        task_id='rafraichir_vue_materialisee_ml',
        postgres_conn_id='postgres-attejari-conn', # Nom de la connexion à créer dans Airflow UI
        sql='REFRESH MATERIALIZED VIEW CONCURRENTLY "DWH_ATTEJARI"."VW_CHURN_DATASET_ML";'
    )

    t1 >> t2 >> t3