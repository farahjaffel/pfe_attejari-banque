import psycopg2
from .settings import DB_CONFIG

def get_connection():
    """Retourne une connexion PostgreSQL."""
    conn = psycopg2.connect(**DB_CONFIG)
    conn.autocommit = True
    return conn