import os
from dotenv import load_dotenv
from pathlib import Path

# Charger le .env depuis la racine
env_path = Path(__file__).resolve().parent.parent / ".env"
load_dotenv(dotenv_path=env_path)

DB_CONFIG = {
    "dbname":   os.getenv("DB_NAME", "BD_ATTEJARI"),
    "user":     os.getenv("DB_USER", "postgres"),
    "password": os.getenv("DB_PASSWORD", "farah"),
    "host":     os.getenv("DB_HOST", "localhost"), # 'postgres-attejari' sera injecté par Docker
    "port":     os.getenv("DB_PORT", "5432"),      # '5432' sera injecté par Docker
}

# Pour Kafka
KAFKA_SERVER = os.getenv("KAFKA_SERVER", "localhost:9092")