@echo off
title KAIROS - BANQUE VIRTUELLE TUNISIENNE
color 0A

set KAIROS_ROOT=G:\KAIROS_PFE_ATTIJARI
set KAFKA_HOME=G:\kafka\kafka_2.13-3.7.0

echo.
echo ==============================================================
echo   KAIROS - SOLUTION COMPLETE - ATTIJARI BANK
echo ==============================================================
echo.

:: ---------------------------------------------------------------
:: [1/5] ZOOKEEPER
:: ---------------------------------------------------------------
echo [1/5] Demarrage Zookeeper...
start "ZOOKEEPER" cmd /k "cd /d %KAFKA_HOME% && .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties"
echo      Attente demarrage Zookeeper (15s)...
timeout /t 15 /nobreak > nul

:: ---------------------------------------------------------------
:: [2/5] KAFKA SERVER
:: ---------------------------------------------------------------
echo [2/5] Demarrage Kafka Server...
start "KAFKA_SERVER" cmd /k "cd /d %KAFKA_HOME% && .\bin\windows\kafka-server-start.bat .\config\server.properties"
echo      Attente demarrage Kafka (30s)...
timeout /t 30 /nobreak > nul

:: Verifier que Kafka ecoute sur 9092 avant de continuer
echo      Verification port 9092...
:WAIT_KAFKA
netstat -ano | findstr "9092" | findstr "LISTENING" > nul
if errorlevel 1 (
    echo      Kafka pas encore pret, nouvelle tentative dans 5s...
    timeout /t 5 /nobreak > nul
    goto WAIT_KAFKA
)
echo      Kafka OK - port 9092 actif !
echo.

:: ---------------------------------------------------------------
:: [3/5] AIRFLOW (Docker)
:: ---------------------------------------------------------------
echo [3/5] Demarrage Airflow (Docker)...
cd /d %KAIROS_ROOT%\airflow_attijari
docker-compose up -d
if errorlevel 1 (
    echo      AVERTISSEMENT : Docker a retourne une erreur.
    echo      Verifiez que Docker Desktop est lance.
)
echo      Attente initialisation Airflow (20s)...
timeout /t 20 /nobreak > nul

:: ---------------------------------------------------------------
:: [4/5] CONSUMER KAFKA
:: ---------------------------------------------------------------
echo [4/5] Lancement Consumer Kafka...
start "CONSUMER_KAFKA" cmd /k "cd /d %KAIROS_ROOT% && python -m ingestion.consumer_kafka"
timeout /t 5 /nobreak > nul

:: ---------------------------------------------------------------
:: [5/5] PRODUCER KAFKA
:: ---------------------------------------------------------------
echo [5/5] Lancement Producer (100k clients, 3%% churn)...
start "PRODUCER_KAFKA" cmd /k "cd /d %KAIROS_ROOT% && python -m ingestion.producer_kafka_final"

:: ---------------------------------------------------------------
:: OUVERTURE AIRFLOW UI
:: ---------------------------------------------------------------
echo      Ouverture Airflow dans le navigateur (10s)...
timeout /t 10 /nobreak > nul
start http://localhost:8085

:: ---------------------------------------------------------------
:: RESUME FINAL
:: ---------------------------------------------------------------
echo.
echo ==============================================================
echo   KAIROS DEPLOYE AVEC SUCCES !
echo ==============================================================
echo   Airflow UI  : http://localhost:8085
echo   Login       : airflow / airflow
echo   PostgreSQL  : localhost:5433  (BD_ATTEJARI)
echo   Kafka       : localhost:9092
echo   Zookeeper   : localhost:2181
echo ==============================================================
echo.
echo   Fenetres ouvertes :
echo     - ZOOKEEPER
echo     - KAFKA_SERVER
echo     - CONSUMER_KAFKA
echo     - PRODUCER_KAFKA
echo     - Airflow (Docker)
echo ==============================================================
echo.
pause