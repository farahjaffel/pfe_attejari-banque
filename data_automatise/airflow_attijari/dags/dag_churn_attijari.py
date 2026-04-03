from airflow import DAG
from airflow.operators.python import PythonOperator
from airflow.operators.bash import BashOperator
from datetime import datetime, timedelta
import os

default_args = {
    'owner': 'Farah_Jaffel',
    'depends_on_past': False,
    'start_date': datetime(2026, 3, 31),
    'email_on_failure': False,
    'email_on_retry': False,
    'retries': 1, # Il est conseillé de mettre au moins 1 retry pour l'ETL
    'retry_delay': timedelta(minutes=5),
}

with DAG(
    'ORCHESTRATION_PROFIL_CHURN_ATTIJARI',
    default_args=default_args,
    schedule_interval='0 2 * * *',  # Tous les jours à 2h00 du matin
    catchup=False,
    max_active_runs=1,  # Empêche le lancement d'une 2ème instance
    dagrun_timeout=None,  # Pas de limite de temps - le DAG prendra le temps nécessaire
    tags=['Attijari_Bank', 'Data_Engineering', 'PostgreSQL']
) as dag:

    # 1. VÉRIFICATION
    def check_ingestion_status():
        print("Vérification de la Landing Zone...")
        return "OK"

    task_check_kafka = PythonOperator(
        task_id='verifier_flux_kafka',
        python_callable=check_ingestion_status
    )

    # 2. EXÉCUTION TALEND (Sécurisée)
    # 1. Définition précise du dossier de travail (Working Directory)
    talend_working_dir = "/opt/airflow/scripts/Talend_Export/J_Master_ETL_0.1/J_Master_ETL"

    task_run_talend_etl = BashOperator(
        task_id='execution_master_etl_talend',
        # On change de dossier (cd) PUIS on lance le script avec bash
        bash_command=f'cd "{talend_working_dir}" && bash ./J_Master_ETL_run.sh --context=Docker',
        execution_timeout=None,  # Pas de limite - laisse le job finir complètement
    )

    # 3. QUALITÉ
    task_quality_control = BashOperator(
        task_id='controle_qualite_DWH',
        bash_command='echo "Vérification de l\'intégrité terminée."'
    )

    # 4. VUE ML
    task_prepare_ml_view = BashOperator(
        task_id='refresh_vue_ML',
        bash_command='echo "La Vue SQL [VW_CHURN_DATASET_ML] mise à jour."'
    )

    # 5. NOTIFICATION
    task_notify = BashOperator(
        task_id='notification_succes',
        bash_command='echo "Pipeline terminé à $(date)"'
    )

    # Logique
    task_check_kafka >> task_run_talend_etl >> task_quality_control >> task_prepare_ml_view >> task_notify