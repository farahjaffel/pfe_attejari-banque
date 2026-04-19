@echo off
title AUTOMATISATION KAFKA ATTIJARI
echo ==============================================
echo   DEMARRAGE DU FLUX DE DONNEES TEMPS REEL
echo ==============================================

:: 1. Lancement de Zookeeper (Chemin complet)
echo [1/4] Lancement de Zookeeper...
start "ZOOKEEPER" cmd /k "G: & cd G:\kafka\kafka_2.13-3.7.0 & G:\kafka\kafka_2.13-3.7.0\bin\windows\zookeeper-server-start.bat G:\kafka\kafka_2.13-3.7.0\config\zookeeper.properties"

:: Attente de 20 secondes
timeout /t 20

:: 2. Lancement de Kafka Server (Chemin complet)
echo [2/4] Lancement de Kafka Server...
start "KAFKA_SERVER" cmd /k "G: & cd G:\kafka\kafka_2.13-3.7.0 & G:\kafka\kafka_2.13-3.7.0\bin\windows\kafka-server-start.bat G:\kafka\kafka_2.13-3.7.0\config\server.properties"

:: Attente de 20 secondes
timeout /t 20

:: 3. Lancement du Consumer
echo [3/4] Lancement du Consumer...
start "PYTHON_CONSUMER" cmd /k "G: & cd "G:\KAIROS_PFE_ATTIJARI\ingestion\consumer_kafka.py" & python consumer_kafka.py"

:: 4. Lancement du Producer
echo [4/4] Lancement du Producer...
start "PYTHON_PRODUCER" cmd /k "G: & cd "G:\KAIROS_PFE_ATTIJARI\ingestion\producer_kafka_final.py" & python producer_kafka_final.py"

echo.
echo ----------------------------------------------
echo TOUTES LES FENETRES SONT OUVERTES.
echo ----------------------------------------------
pause