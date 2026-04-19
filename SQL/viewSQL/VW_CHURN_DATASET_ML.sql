

-- 1. Créer la vue matérialisée
CREATE MATERIALIZED VIEW "DWH_ATTEJARI"."VW_CHURN_DATASET_ML" AS
SELECT 
    f.id_client,
    f.nb_transactions, 
    f.solde_moy, 
    f.nb_rejet, 
    f.nb_reclamations,
    f.nb_interactions,
    f.monte_mensuel,
    f.delai_resolution_moyen,
    f.duree_inact_connexion_sec,
    f.nb_produits_actifs,
    f.score_risque_interne,
    f.revenu_mensuel,
    c.sexe,
    EXTRACT(YEAR FROM AGE(CURRENT_DATE, c.date_naissance)) AS age,
    c.anciennete_mois,
    p.situation_matrimoniale,
    p.enfants_a_charge,
    p.profession,
    p.ville_region,
    p.est_senior,
    d.service_sms_banking,
    d.acces_banque_en_ligne,
    d.alerte_securite_active,
    d.e_releve_active,
    fin.methode_paiement_fav,
    fin.frais_bancaires_mensuels,
    fin.total_frais_cumules,
    prod.conseiller_dedie,
    prod.programme_fidelite,
    prod.assurance_moyen_paiement,
    f.churn
FROM "DWH_ATTEJARI"."CHURN_CLIENT" f
JOIN "DWH_ATTEJARI"."DIM_CLIENT" c ON f.id_client = c.id_client
LEFT JOIN "DWH_ATTEJARI"."DIM_PROFIL" p ON c.id_profil_fk = p.id_profil_sk
LEFT JOIN "DWH_ATTEJARI"."DIM_DIGITAL" d ON c.id_digital_fk = d.id_digital_sk
LEFT JOIN "DWH_ATTEJARI"."DIM_FINANCIER" fin ON c.id_financier_fk = fin.id_financier_sk
LEFT JOIN "DWH_ATTEJARI"."DIM_PRODUIT" prod ON c.id_produit_fk = prod.id_produit_sk;

-- 3. AJOUTER UN INDEX (Indispensable pour la performance)
CREATE UNIQUE INDEX idx_vw_churn_client ON "DWH_ATTEJARI"."VW_CHURN_DATASET_ML" (id_client);