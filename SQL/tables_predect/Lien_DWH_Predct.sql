-- Liaison physique avec la table des clients
ALTER TABLE "DWH_ATTEJARI"."FAIT_PREDICTION_CHURN"
ADD CONSTRAINT fk_prediction_client
FOREIGN KEY (id_client) 
REFERENCES "DWH_ATTEJARI"."DIM_CLIENT" (id_client);