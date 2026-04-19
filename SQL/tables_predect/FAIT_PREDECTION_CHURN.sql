CREATE TABLE "DWH_ATTEJARI"."FAIT_PREDICTION_CHURN" (
    id_prediction_sk SERIAL PRIMARY KEY,
    id_client VARCHAR(10),
    date_prediction TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    score_churn DOUBLE PRECISION,      -- Probabilité (0.0 à 1.0)
    risque_label VARCHAR(20),          -- 'Critique', 'Élevé', etc.
    motif_principal VARCHAR(255),      -- Variable SHAP n°1
    motif_secondaire VARCHAR(255),     -- Variable SHAP n°2
    recommandation TEXT,            -- Ce que le conseiller doit faire
    etat_action VARCHAR(50) DEFAULT 'En attente'
);
CREATE INDEX idx_pred_client ON "DWH_ATTEJARI"."FAIT_PREDICTION_CHURN" (id_client);