from pathlib import Path

# Racine du projet
ROOT_DIR = Path(__file__).resolve().parent.parent

# Chemins des sous-dossiers
DATA_DIR    = ROOT_DIR / "data"
MODEL_DIR   = ROOT_DIR / "models"
ETL_SQL_DIR = ROOT_DIR / "etl" / "vues_sql"
LOGS_DIR    = ROOT_DIR / "logs"

# Créer les dossiers s'ils n'existent pas
for d in [DATA_DIR, MODEL_DIR, LOGS_DIR, DATA_DIR/"raw", DATA_DIR/"processed"]:
    d.mkdir(parents=True, exist_ok=True)