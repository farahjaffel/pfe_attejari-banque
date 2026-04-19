from config import get_connection

try:
    conn = get_connection()
    cur = conn.cursor()
    cur.execute("SELECT version();")
    record = cur.fetchone()
    print("\n✅ CONNEXION RÉUSSIE !")
    print(f"Version de PostgreSQL : {record}\n")
    cur.close()
    conn.close()
except Exception as e:
    print("\n❌ ERREUR DE CONNEXION :")
    print(e)