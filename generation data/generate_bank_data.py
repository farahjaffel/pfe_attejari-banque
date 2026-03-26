"""
Génération de Données Synthétiques - Banque Virtuelle Tunisienne
Seed=42 | 100K clients | 5M transactions | 2M interactions
Auteur: Farah Jaffel | Encadrant: M. Nabil Zidi | Version 2.0
"""
import os, json, time, warnings
import numpy as np
import pandas as pd
from datetime import datetime, timedelta
from scipy import stats
import random

warnings.filterwarnings("ignore")

SEED             = 42
NB_CLIENTS       = 100_000
NB_TRANSACTIONS  = 5_000_000
NB_INTERACTIONS  = 2_000_000
TAUX_CHURN_CIBLE = 0.25
DATE_FIN         = datetime(2024, 12, 31)
DATE_DEBUT       = datetime(2023, 1, 1)
OUTPUT_DIR       = "/home/claude/output_data"
CHUNK_TX         = 500_000
CHUNK_INT        = 400_000

np.random.seed(SEED)
random.seed(SEED)
os.makedirs(OUTPUT_DIR, exist_ok=True)

VILLES = ["Tunis","Sfax","Sousse","Kairouan","Bizerte","Gabes","Ariana",
          "Gafsa","Monastir","Ben Arous","Nabeul","Medenine","Kasserine",
          "Sidi Bouzid","Jendouba","Zaghouan","Kebili","Tozeur","Siliana","Le Kef"]
vp = [0.22,0.13,0.09,0.05,0.05,0.04,0.07,0.03,0.05,0.06,
      0.03,0.03,0.02,0.02,0.02,0.01,0.01,0.01,0.01,0.01]
VILLE_POIDS = [x/sum(vp) for x in vp]

PROFESSIONS = ["Fonctionnaire","Employe prive","Commercant","Medecin",
               "Ingenieur","Enseignant","Avocat","Retraite",
               "Auto-entrepreneur","Agriculteur","Sans emploi","Etudiant"]
PROF_POIDS  = [0.20,0.22,0.12,0.04,0.08,0.10,0.03,0.08,0.05,0.03,0.03,0.02]

REVENU_PROF = {
    "Fonctionnaire":(900,200),"Employe prive":(950,250),"Commercant":(1300,450),
    "Medecin":(3200,900),"Ingenieur":(2100,550),"Enseignant":(780,150),
    "Avocat":(2600,750),"Retraite":(620,150),"Auto-entrepreneur":(1050,380),
    "Agriculteur":(720,200),"Sans emploi":(300,100),"Etudiant":(260,80),
}

# ======================================================================
# TABLE CLIENTS
# ======================================================================
def generer_clients():
    print("  [1/3] Generation des clients ...")
    t0 = time.time(); n = NB_CLIENTS

    sexe       = np.random.choice(["M","F"], size=n, p=[0.54,0.46])
    age        = np.clip(np.random.normal(38,13,n).astype(int), 18, 80)
    est_senior = (age >= 60).astype(int)
    date_naissance = [(DATE_FIN - timedelta(days=int(a)*365+random.randint(0,364))).strftime("%Y-%m-%d") for a in age]
    situation  = np.random.choice(["Marie","Celibataire","Divorce","Veuf"], size=n, p=[0.52,0.33,0.10,0.05])
    enfants    = (((situation=="Marie")&(np.random.rand(n)<0.65))|((situation!="Marie")&(np.random.rand(n)<0.10))).astype(int)
    profession = np.random.choice(PROFESSIONS, size=n, p=PROF_POIDS)
    ville      = np.random.choice(VILLES,      size=n, p=VILLE_POIDS)
    anciennete = np.clip(np.random.exponential(40, n).astype(int), 1, 240)
    revenu     = np.array([max(200, np.random.normal(*REVENU_PROF[p])) for p in profession]).round(3)

    acces_bl   = np.random.choice(["Standard","Webank","Aucun"], size=n, p=[0.40,0.45,0.15])
    sms        = (np.random.rand(n)<0.68).astype(int)
    alerte     = (np.random.rand(n)<0.55).astype(int)
    assurance  = (np.random.rand(n)<0.42).astype(int)
    conseiller = (np.random.rand(n)<0.30).astype(int)
    fidelite   = (np.random.rand(n)<0.38).astype(int)
    ereleve    = (np.random.rand(n)<0.60).astype(int)
    convention = np.random.choice(["Mensuel","Annuel","Gratuit","Pack"], size=n, p=[0.25,0.30,0.20,0.25])
    paiement   = np.random.choice(["Prelevement auto","Carte","Cheque"], size=n, p=[0.45,0.40,0.15])
    frais_m    = np.where(convention=="Gratuit", 0.0, np.clip(np.random.normal(12,5,n),0,50)).round(3)
    frais_tot  = (frais_m * anciennete * np.random.uniform(0.8,1.1,n)).round(3)
    nb_prod    = np.clip(np.random.poisson(2.2, n), 1, 6)
    score_r    = np.random.choice([1,2,3,4,5], size=n, p=[0.10,0.25,0.35,0.20,0.10])

    # Score churn avec correlations metier
    cs = (  0.20*(1/np.sqrt(anciennete+1)) + 0.15*(score_r/5)
          - 0.12*(nb_prod/6) + 0.10*(frais_m/50)
          - 0.08*conseiller  - 0.07*fidelite
          + 0.06*(acces_bl=="Aucun").astype(float) - 0.05*sms
          + 0.05*(age>65).astype(float) + np.random.uniform(-0.08,0.08,n))
    prob  = 1/(1+np.exp(-10*(cs-cs.mean())))
    seuil = np.percentile(prob, (1-TAUX_CHURN_CIBLE)*100)
    churn = (prob>=seuil).astype(int)

    df = pd.DataFrame({
        "id_client":id_cli(n), "sexe":sexe, "date_naissance":date_naissance,
        "est_senior":est_senior, "situation_matrimoniale":situation,
        "enfants_a_charge":enfants, "profession":profession, "ville_region":ville,
        "anciennete_mois":anciennete, "service_sms_banking":sms,
        "acces_banque_en_ligne":acces_bl, "alerte_securite_active":alerte,
        "assurance_moyen_paiement":assurance, "conseiller_dedie":conseiller,
        "programme_fidelite":fidelite, "type_convention":convention,
        "e_releve_active":ereleve, "methode_paiement_fav":paiement,
        "frais_bancaires_mensuels":frais_m, "total_frais_cumules":frais_tot,
        "revenu_mensuel":revenu, "nb_produits_actifs":nb_prod,
        "score_risque_interne":score_r, "churn":churn,
    })
    print(f"     OK {n:,} clients | Churn : {churn.mean():.2%} | {time.time()-t0:.1f}s")
    return df

def id_cli(n): return [f"CLI-{i:06d}" for i in range(1,n+1)]

# ======================================================================
# TABLE TRANSACTIONS (par chunks)
# ======================================================================
def generer_transactions(df_c):
    print(f"  [2/3] Generation transactions ({NB_TRANSACTIONS//1e6:.0f}M par chunks) ...")
    t0 = time.time()
    ids    = df_c["id_client"].values
    churns = df_c["churn"].values
    revenus= df_c["revenu_mensuel"].values

    pw = np.where(churns==1, 0.6, 1.0); pw /= pw.sum()
    delta = (DATE_FIN-DATE_DEBUT).days

    types_ops = ["Virement emis","Virement recu","Paiement Carte","Retrait DAB","Prelevement"]
    sens_map  = {"Virement emis":"Debit","Virement recu":"Credit",
                 "Paiement Carte":"Debit","Retrait DAB":"Debit","Prelevement":"Debit"}
    canaux_tx = ["Agence","DAB","TPE","En Ligne"]
    categories= ["Alimentation","Transport","Loisirs","Sante","International","Autre",""]

    path = f"{OUTPUT_DIR}/transactions.csv"
    total_rej = 0; written = 0
    for chunk_i, start in enumerate(range(0, NB_TRANSACTIONS, CHUNK_TX)):
        n = min(CHUNK_TX, NB_TRANSACTIONS - start)
        idx    = np.random.choice(len(ids), size=n, p=pw)
        type_op= np.random.choice(types_ops, size=n, p=[0.15,0.15,0.35,0.25,0.10])
        sens   = np.array([sens_map[t] for t in type_op])
        canal  = np.random.choice(canaux_tx, size=n, p=[0.10,0.25,0.35,0.30])
        rev    = revenus[idx]

        mt = np.where(type_op=="Retrait DAB",   np.clip(np.random.normal(150,80,n),20,800),
             np.where(type_op=="Paiement Carte", np.clip(np.random.normal(80,60,n),5,500),
             np.where(type_op=="Virement emis",  np.clip(np.random.normal(rev*0.3,rev*0.15+1),50,5000),
             np.where(type_op=="Virement recu",  np.clip(np.random.normal(rev*0.8,rev*0.2+1),100,8000),
                                                 np.clip(np.random.normal(200,100,n),30,1000))))).round(3)

        jr = np.random.randint(0,delta,n); hr=np.random.randint(7,22,n); mn=np.random.randint(0,60,n)
        dates = [(DATE_DEBUT+timedelta(days=int(j),hours=int(h),minutes=int(m))).strftime("%Y-%m-%d %H:%M:%S")
                 for j,h,m in zip(jr,hr,mn)]

        sb = np.clip(np.random.normal(3000,2000,n),0,50000)
        mk = churns[idx]==1
        sb[mk] *= np.random.uniform(0.3,0.7,mk.sum())
        sa = np.where(sens=="Debit", np.clip(sb-mt,0,100000), sb+mt).round(3)

        pr = np.where(churns[idx]==1, 0.08, 0.02)
        pr = np.where(sa<100, pr+0.10, pr)
        rej= (np.random.rand(n)<pr).astype(int)
        total_rej += rej.sum()

        cat_raw = np.random.choice(categories, size=n, p=[0.25,0.20,0.15,0.10,0.08,0.12,0.10])
        cat     = np.where(sens=="Credit","",cat_raw)

        df_chunk = pd.DataFrame({
            "id_transaction":       [f"TRX-{start+i+1:09d}" for i in range(n)],
            "id_client":            ids[idx],
            "date_transaction":     dates,
            "type_operation":       type_op,
            "montant":              mt,
            "sens_operation":       sens,
            "canal_transaction":    canal,
            "solde_apres_operation":sa,
            "est_rejete":           rej,
            "categorie_depense":    cat,
        })
        written += n
        df_chunk.to_csv(path, mode="w" if chunk_i==0 else "a",
                        header=(chunk_i==0), index=False, encoding="utf-8-sig")
        print(f"     chunk {chunk_i+1}/{NB_TRANSACTIONS//CHUNK_TX} -> {written:,} lignes")
        del df_chunk

    sz = os.path.getsize(path)/1e6
    print(f"     OK {NB_TRANSACTIONS:,} transactions | Taux rejet : {total_rej/NB_TRANSACTIONS:.2%} | {sz:.0f}MB | {time.time()-t0:.1f}s")
    return total_rej/NB_TRANSACTIONS

# ======================================================================
# TABLE INTERACTIONS (par chunks)
# ======================================================================
def generer_interactions(df_c):
    print(f"  [3/3] Generation interactions ({NB_INTERACTIONS//1e6:.0f}M par chunks) ...")
    t0 = time.time()
    ids    = df_c["id_client"].values
    churns = df_c["churn"].values

    pw = np.where(churns==1, 1.3, 0.9); pw /= pw.sum()
    delta = (DATE_FIN-DATE_DEBUT).days

    canaux = ["Application Mobile","Site Web","Centre d Appel","Agence"]
    types  = ["Simple Connexion","Consultation Solde","Reclamation","Demande assistance"]
    motifs = ["Frais contestes","Carte bloquee","Virement errone","Autre"]

    path = f"{OUTPUT_DIR}/interactions.csv"
    total_recl = 0; written = 0
    for chunk_i, start in enumerate(range(0, NB_INTERACTIONS, CHUNK_INT)):
        n   = min(CHUNK_INT, NB_INTERACTIONS - start)
        idx = np.random.choice(len(ids), size=n, p=pw)
        cf  = churns[idx]

        canal = np.random.choice(canaux, size=n, p=[0.40,0.30,0.20,0.10])
        tc = np.where(cf==1,
             np.random.choice(types, size=n, p=[0.20,0.30,0.35,0.15]),
             np.random.choice(types, size=n, p=[0.35,0.40,0.10,0.15]))

        recl = (tc=="Reclamation").astype(int)
        total_recl += recl.sum()

        motif_raw = np.random.choice(motifs, size=n, p=[0.35,0.30,0.20,0.15])
        motif     = np.where(recl==1, motif_raw, "")

        statut_raw = np.random.choice(["Resolu","En Cours"], size=n, p=[0.65,0.35])
        statut     = np.where(recl==1, statut_raw, "Non applicable")

        delai_raw = np.random.choice([1,2,3,5,7,10,15,20],size=n,p=[0.20,0.20,0.15,0.15,0.10,0.10,0.07,0.03]).astype(float)
        delai     = np.where(recl==1, delai_raw, np.nan)

        nps_envoye = np.random.rand(n)<0.30
        nps_v = np.where(cf==1, np.random.randint(0,6,n).astype(float), np.random.randint(5,11,n).astype(float))
        nps   = np.where(nps_envoye, nps_v, np.nan)

        digital = np.isin(canal,["Application Mobile","Site Web"])
        duree   = np.where(digital, np.clip(np.random.exponential(300,n),30,1800).astype(int), 0)
        duree   = np.where((cf==1)&digital, (duree*np.random.uniform(0.4,0.7,n)).astype(int), duree)

        jr=np.random.randint(0,delta,n); hr=np.random.randint(7,23,n); mn=np.random.randint(0,60,n)
        dates=[(DATE_DEBUT+timedelta(days=int(j),hours=int(h),minutes=int(m))).strftime("%Y-%m-%d %H:%M:%S")
               for j,h,m in zip(jr,hr,mn)]

        df_chunk = pd.DataFrame({
            "id_interaction":          [f"INT-{start+i+1:09d}" for i in range(n)],
            "id_client":               ids[idx],
            "date_interaction":        dates,
            "canal_interaction":       canal,
            "type_interaction":        tc,
            "est_reclamation":         recl,
            "motif_reclamation":       motif,
            "statut_resolution":       statut,
            "delai_resolution_jours":  delai,
            "score_satisfaction_nps":  nps,
            "duree_connexion_sec":     duree,
        })
        written += n
        df_chunk.to_csv(path, mode="w" if chunk_i==0 else "a",
                        header=(chunk_i==0), index=False, encoding="utf-8-sig")
        print(f"     chunk {chunk_i+1}/{NB_INTERACTIONS//CHUNK_INT} -> {written:,} lignes")
        del df_chunk

    sz = os.path.getsize(path)/1e6
    print(f"     OK {NB_INTERACTIONS:,} interactions | Taux recl. : {total_recl/NB_INTERACTIONS:.2%} | {sz:.0f}MB | {time.time()-t0:.1f}s")
    return total_recl/NB_INTERACTIONS

# ======================================================================
# METRIQUES DE VALIDATION
# ======================================================================
def valider(df_c, taux_rejet, taux_recl):
    print("  [Validation] Calcul des metriques ...")
    m = {}

    # Churn
    tr = df_c["churn"].mean()
    m["churn"] = {"reel":round(tr,4), "cible":TAUX_CHURN_CIBLE,
                  "ecart":round(abs(tr-TAUX_CHURN_CIBLE),4), "ok":abs(tr-TAUX_CHURN_CIBLE)<0.02}

    # KS-Test anciennete
    ks_s, ks_p = stats.kstest(df_c["anciennete_mois"]/df_c["anciennete_mois"].max(),"expon")
    m["ks_anciennete"] = {"stat":round(ks_s,4),"pval":round(ks_p,4)}

    # IV
    def calc_iv(df, col, cible="churn", bins=10):
        try:
            if df[col].dtype==object:
                g = df.groupby(col)[cible].agg(["sum","count"])
            else:
                df2 = df.copy(); df2["_b"] = pd.cut(df2[col],bins=bins,duplicates="drop")
                g = df2.groupby("_b")[cible].agg(["sum","count"])
            g.columns=["e","t"]; g["ne"]=g["t"]-g["e"]
            te=g["e"].sum(); tne=g["ne"].sum()
            if te==0 or tne==0: return 0.0
            g["pe"]=g["e"]/te; g["pne"]=g["ne"]/tne
            g=g[(g["pe"]>0)&(g["pne"]>0)]
            g["woe"]=np.log(g["pe"]/g["pne"]); g["iv"]=(g["pe"]-g["pne"])*g["woe"]
            return round(g["iv"].sum(),4)
        except: return None

    feats_iv = ["anciennete_mois","nb_produits_actifs","score_risque_interne",
                "frais_bancaires_mensuels","revenu_mensuel","conseiller_dedie",
                "programme_fidelite","acces_banque_en_ligne","est_senior"]
    iv_vals = {f: calc_iv(df_c,f) for f in feats_iv}
    def iv_label(v):
        if v is None: return "N/A"
        if v<0.02: return "Non predictive (<0.02)"
        if v<0.10: return "Faible (0.02-0.10)"
        if v<0.30: return "Moyen (0.10-0.30)"
        if v<0.50: return "Fort (0.30-0.50)"
        return "Tres fort (>0.50)"
    m["information_value"] = {f:{"iv":iv_vals[f],"label":iv_label(iv_vals[f])} for f in feats_iv}

    # PSI
    def calc_psi(a, b, bins=10):
        try:
            bp=np.percentile(a,np.linspace(0,100,bins+1)); bp[0]-=0.001; bp[-1]+=0.001
            pa=np.histogram(a,bins=bp)[0]/len(a); pb=np.histogram(b,bins=bp)[0]/len(b)
            pa=np.where(pa==0,0.0001,pa); pb=np.where(pb==0,0.0001,pb)
            return round(float(np.sum((pb-pa)*np.log(pb/pa))),4)
        except: return None
    mid = len(df_c)//2
    psi_feats = ["anciennete_mois","revenu_mensuel","score_risque_interne","nb_produits_actifs"]
    psi_vals  = {f: calc_psi(df_c[f][:mid].values, df_c[f][mid:].values) for f in psi_feats}
    def psi_label(v):
        if v is None: return "N/A"
        if v<0.10: return "Stable (<0.10)"
        if v<0.25: return "Legere derive (0.10-0.25)"
        return "Derive significative (>0.25)"
    m["psi"] = {f:{"psi":psi_vals[f],"interpretation":psi_label(psi_vals[f])} for f in psi_feats}

    # Stats globales
    m["stats_globales"] = {
        "nb_clients":NB_CLIENTS, "nb_transactions":NB_TRANSACTIONS, "nb_interactions":NB_INTERACTIONS,
        "revenu_moyen_dt":round(df_c["revenu_mensuel"].mean(),2),
        "anciennete_moy_mois":round(df_c["anciennete_mois"].mean(),1),
        "pct_senior":round(df_c["est_senior"].mean(),4),
        "pct_webank":round((df_c["acces_banque_en_ligne"]=="Webank").mean(),4),
        "taux_rejet_transactions":round(taux_rejet,4),
        "taux_reclamations":round(taux_recl,4),
        "tx_par_client_moy":round(NB_TRANSACTIONS/NB_CLIENTS,1),
        "int_par_client_moy":round(NB_INTERACTIONS/NB_CLIENTS,1),
    }

    # Tailles fichiers
    m["fichiers_csv_mb"] = {
        "clients":      round(os.path.getsize(f"{OUTPUT_DIR}/clients.csv")/1e6,1),
        "transactions": round(os.path.getsize(f"{OUTPUT_DIR}/transactions.csv")/1e6,1),
        "interactions": round(os.path.getsize(f"{OUTPUT_DIR}/interactions.csv")/1e6,1),
    }
    m["fichiers_csv_mb"]["total"] = round(sum(m["fichiers_csv_mb"].values()),1)

    print(f"     OK Metriques calculees")
    return m

# ======================================================================
# MAIN
# ======================================================================
def main():
    print("\n" + "="*65)
    print("  GENERATION BIG DATA - BANQUE VIRTUELLE TUNISIENNE")
    print("  Seed=42 | 100K clients | 5M transactions | 2M interactions")
    print("="*65+"\n")
    t0 = time.time()

    df_c        = generer_clients()
    df_c.to_csv(f"{OUTPUT_DIR}/clients.csv", index=False, encoding="utf-8-sig")

    taux_rejet  = generer_transactions(df_c)
    taux_recl   = generer_interactions(df_c)
    m           = valider(df_c, taux_rejet, taux_recl)

    with open(f"{OUTPUT_DIR}/metrics.json","w",encoding="utf-8") as f:
        json.dump(m, f, ensure_ascii=False, indent=2)

    dur = time.time()-t0
    print(f"\n{'='*65}")
    print(f"  TERMINE en {dur:.0f}s ({dur/60:.1f} min) | {m['fichiers_csv_mb']['total']} MB total")
    print(f"{'='*65}\n")
    return df_c, m

if __name__=="__main__":
    df_c, metrics = main()
