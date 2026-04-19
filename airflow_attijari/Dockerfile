FROM apache/airflow:2.7.1

USER root
# Installation de JAVA (Obligatoire pour vos scripts Talend !)
RUN apt-get update && apt-get install -y openjdk-17-jre-headless gcc libpq-dev && apt-get clean

USER airflow
# Installation des librairies Python pour vos scripts ML et DAG
COPY requirements.txt /requirements_airflow.txt
RUN pip install --no-cache-dir -r /requirements_airflow.txt