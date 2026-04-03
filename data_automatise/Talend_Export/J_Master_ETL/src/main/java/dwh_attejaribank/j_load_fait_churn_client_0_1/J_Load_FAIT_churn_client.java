// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package dwh_attejaribank.j_load_fait_churn_client_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: J_Load_FAIT_churn_client Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class J_Load_FAIT_churn_client implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(host != null){
				
					this.setProperty("host", host.toString());
				
			}
			
			if(port != null){
				
					this.setProperty("port", port.toString());
				
			}
			
			if(schema != null){
				
					this.setProperty("schema", schema.toString());
				
			}
			
			if(database != null){
				
					this.setProperty("database", database.toString());
				
			}
			
			if(password != null){
				
					this.setProperty("password", password.toString());
				
			}
			
			if(params != null){
				
					this.setProperty("params", params.toString());
				
			}
			
			if(username != null){
				
					this.setProperty("username", username.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public String host;
public String getHost(){
	return this.host;
}
public BigDecimal port;
public BigDecimal getPort(){
	return this.port;
}
public String schema;
public String getSchema(){
	return this.schema;
}
public String database;
public String getDatabase(){
	return this.database;
}
public String password;
public String getPassword(){
	return this.password;
}
public String params;
public String getParams(){
	return this.params;
}
public String username;
public String getUsername(){
	return this.username;
}
	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "J_Load_FAIT_churn_client";
	private final String projectName = "DWH_ATTEJARIBANK";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				J_Load_FAIT_churn_client.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(J_Load_FAIT_churn_client.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row10_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAggregateRow_1_AGGOUT_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tAggregateRow_1_AGGIN_error(exception, errorComponent, globalMap);
						
						}
					
			public void tAggregateRow_1_AGGIN_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAggregateRow_2_AGGOUT_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tAggregateRow_2_AGGIN_error(exception, errorComponent, globalMap);
						
						}
					
			public void tAggregateRow_2_AGGIN_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_7_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_8_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class row11Struct implements routines.system.IPersistableRow<row11Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_fact_churn_sk;

				public int getId_fact_churn_sk () {
					return this.id_fact_churn_sk;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public String id_transaction_pk;

				public String getId_transaction_pk () {
					return this.id_transaction_pk;
				}
				
			    public String id_interaction_pk;

				public String getId_interaction_pk () {
					return this.id_interaction_pk;
				}
				
			    public String id_reclamation_pk;

				public String getId_reclamation_pk () {
					return this.id_reclamation_pk;
				}
				
			    public Integer id_date_fk;

				public Integer getId_date_fk () {
					return this.id_date_fk;
				}
				
			    public Long anciennete_mois;

				public Long getAnciennete_mois () {
					return this.anciennete_mois;
				}
				
			    public Long score_risque_interne;

				public Long getScore_risque_interne () {
					return this.score_risque_interne;
				}
				
			    public Long nb_produits_actifs;

				public Long getNb_produits_actifs () {
					return this.nb_produits_actifs;
				}
				
			    public Double revenu_mensuel;

				public Double getRevenu_mensuel () {
					return this.revenu_mensuel;
				}
				
			    public Double solde_moy;

				public Double getSolde_moy () {
					return this.solde_moy;
				}
				
			    public Double monte_mensuel;

				public Double getMonte_mensuel () {
					return this.monte_mensuel;
				}
				
			    public Long nb_rejet;

				public Long getNb_rejet () {
					return this.nb_rejet;
				}
				
			    public Long nb_transactions;

				public Long getNb_transactions () {
					return this.nb_transactions;
				}
				
			    public Long nb_reclamations;

				public Long getNb_reclamations () {
					return this.nb_reclamations;
				}
				
			    public Long nb_interactions;

				public Long getNb_interactions () {
					return this.nb_interactions;
				}
				
			    public Double delai_resolution_moyen;

				public Double getDelai_resolution_moyen () {
					return this.delai_resolution_moyen;
				}
				
			    public Double duree_inact_connexion_sec;

				public Double getDuree_inact_connexion_sec () {
					return this.duree_inact_connexion_sec;
				}
				
			    public Long churn;

				public Long getChurn () {
					return this.churn;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
						result = prime * result + ((this.id_date_fk == null) ? 0 : this.id_date_fk.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row11Struct other = (row11Struct) obj;
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					
						if (this.id_date_fk == null) {
							if (other.id_date_fk != null)
								return false;
						
						} else if (!this.id_date_fk.equals(other.id_date_fk))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row11Struct other) {

		other.id_fact_churn_sk = this.id_fact_churn_sk;
	            other.id_client = this.id_client;
	            other.id_transaction_pk = this.id_transaction_pk;
	            other.id_interaction_pk = this.id_interaction_pk;
	            other.id_reclamation_pk = this.id_reclamation_pk;
	            other.id_date_fk = this.id_date_fk;
	            other.anciennete_mois = this.anciennete_mois;
	            other.score_risque_interne = this.score_risque_interne;
	            other.nb_produits_actifs = this.nb_produits_actifs;
	            other.revenu_mensuel = this.revenu_mensuel;
	            other.solde_moy = this.solde_moy;
	            other.monte_mensuel = this.monte_mensuel;
	            other.nb_rejet = this.nb_rejet;
	            other.nb_transactions = this.nb_transactions;
	            other.nb_reclamations = this.nb_reclamations;
	            other.nb_interactions = this.nb_interactions;
	            other.delai_resolution_moyen = this.delai_resolution_moyen;
	            other.duree_inact_connexion_sec = this.duree_inact_connexion_sec;
	            other.churn = this.churn;
	            
	}

	public void copyKeysDataTo(row11Struct other) {

		other.id_client = this.id_client;
	            	other.id_date_fk = this.id_date_fk;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
			        this.id_fact_churn_sk = dis.readInt();
					
					this.id_client = readString(dis);
					
					this.id_transaction_pk = readString(dis);
					
					this.id_interaction_pk = readString(dis);
					
					this.id_reclamation_pk = readString(dis);
					
						this.id_date_fk = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_produits_actifs = null;
           				} else {
           			    	this.nb_produits_actifs = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.revenu_mensuel = null;
           				} else {
           			    	this.revenu_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_moy = null;
           				} else {
           			    	this.solde_moy = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.monte_mensuel = null;
           				} else {
           			    	this.monte_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_rejet = null;
           				} else {
           			    	this.nb_rejet = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_transactions = null;
           				} else {
           			    	this.nb_transactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_reclamations = null;
           				} else {
           			    	this.nb_reclamations = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_interactions = null;
           				} else {
           			    	this.nb_interactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_moyen = null;
           				} else {
           			    	this.delai_resolution_moyen = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_inact_connexion_sec = null;
           				} else {
           			    	this.duree_inact_connexion_sec = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.churn = null;
           				} else {
           			    	this.churn = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
			        this.id_fact_churn_sk = dis.readInt();
					
					this.id_client = readString(dis);
					
					this.id_transaction_pk = readString(dis);
					
					this.id_interaction_pk = readString(dis);
					
					this.id_reclamation_pk = readString(dis);
					
						this.id_date_fk = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_produits_actifs = null;
           				} else {
           			    	this.nb_produits_actifs = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.revenu_mensuel = null;
           				} else {
           			    	this.revenu_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_moy = null;
           				} else {
           			    	this.solde_moy = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.monte_mensuel = null;
           				} else {
           			    	this.monte_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_rejet = null;
           				} else {
           			    	this.nb_rejet = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_transactions = null;
           				} else {
           			    	this.nb_transactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_reclamations = null;
           				} else {
           			    	this.nb_reclamations = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_interactions = null;
           				} else {
           			    	this.nb_interactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_moyen = null;
           				} else {
           			    	this.delai_resolution_moyen = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_inact_connexion_sec = null;
           				} else {
           			    	this.duree_inact_connexion_sec = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.churn = null;
           				} else {
           			    	this.churn = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fact_churn_sk);
					
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.id_transaction_pk,dos);
					
					// String
				
						writeString(this.id_interaction_pk,dos);
					
					// String
				
						writeString(this.id_reclamation_pk,dos);
					
					// Integer
				
						writeInteger(this.id_date_fk,dos);
					
					// Long
				
						if(this.anciennete_mois == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.anciennete_mois);
		            	}
					
					// Long
				
						if(this.score_risque_interne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.score_risque_interne);
		            	}
					
					// Long
				
						if(this.nb_produits_actifs == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_produits_actifs);
		            	}
					
					// Double
				
						if(this.revenu_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.revenu_mensuel);
		            	}
					
					// Double
				
						if(this.solde_moy == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_moy);
		            	}
					
					// Double
				
						if(this.monte_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.monte_mensuel);
		            	}
					
					// Long
				
						if(this.nb_rejet == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_rejet);
		            	}
					
					// Long
				
						if(this.nb_transactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_transactions);
		            	}
					
					// Long
				
						if(this.nb_reclamations == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_reclamations);
		            	}
					
					// Long
				
						if(this.nb_interactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_interactions);
		            	}
					
					// Double
				
						if(this.delai_resolution_moyen == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_moyen);
		            	}
					
					// Double
				
						if(this.duree_inact_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.duree_inact_connexion_sec);
		            	}
					
					// Long
				
						if(this.churn == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.churn);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fact_churn_sk);
					
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.id_transaction_pk,dos);
					
					// String
				
						writeString(this.id_interaction_pk,dos);
					
					// String
				
						writeString(this.id_reclamation_pk,dos);
					
					// Integer
				
						writeInteger(this.id_date_fk,dos);
					
					// Long
				
						if(this.anciennete_mois == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.anciennete_mois);
		            	}
					
					// Long
				
						if(this.score_risque_interne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.score_risque_interne);
		            	}
					
					// Long
				
						if(this.nb_produits_actifs == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_produits_actifs);
		            	}
					
					// Double
				
						if(this.revenu_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.revenu_mensuel);
		            	}
					
					// Double
				
						if(this.solde_moy == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_moy);
		            	}
					
					// Double
				
						if(this.monte_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.monte_mensuel);
		            	}
					
					// Long
				
						if(this.nb_rejet == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_rejet);
		            	}
					
					// Long
				
						if(this.nb_transactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_transactions);
		            	}
					
					// Long
				
						if(this.nb_reclamations == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_reclamations);
		            	}
					
					// Long
				
						if(this.nb_interactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_interactions);
		            	}
					
					// Double
				
						if(this.delai_resolution_moyen == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_moyen);
		            	}
					
					// Double
				
						if(this.duree_inact_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.duree_inact_connexion_sec);
		            	}
					
					// Long
				
						if(this.churn == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.churn);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_fact_churn_sk="+String.valueOf(id_fact_churn_sk));
		sb.append(",id_client="+id_client);
		sb.append(",id_transaction_pk="+id_transaction_pk);
		sb.append(",id_interaction_pk="+id_interaction_pk);
		sb.append(",id_reclamation_pk="+id_reclamation_pk);
		sb.append(",id_date_fk="+String.valueOf(id_date_fk));
		sb.append(",anciennete_mois="+String.valueOf(anciennete_mois));
		sb.append(",score_risque_interne="+String.valueOf(score_risque_interne));
		sb.append(",nb_produits_actifs="+String.valueOf(nb_produits_actifs));
		sb.append(",revenu_mensuel="+String.valueOf(revenu_mensuel));
		sb.append(",solde_moy="+String.valueOf(solde_moy));
		sb.append(",monte_mensuel="+String.valueOf(monte_mensuel));
		sb.append(",nb_rejet="+String.valueOf(nb_rejet));
		sb.append(",nb_transactions="+String.valueOf(nb_transactions));
		sb.append(",nb_reclamations="+String.valueOf(nb_reclamations));
		sb.append(",nb_interactions="+String.valueOf(nb_interactions));
		sb.append(",delai_resolution_moyen="+String.valueOf(delai_resolution_moyen));
		sb.append(",duree_inact_connexion_sec="+String.valueOf(duree_inact_connexion_sec));
		sb.append(",churn="+String.valueOf(churn));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row11Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.id_date_fk, other.id_date_fk);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class factStruct implements routines.system.IPersistableRow<factStruct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_fact_churn_sk;

				public int getId_fact_churn_sk () {
					return this.id_fact_churn_sk;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public String id_transaction_pk;

				public String getId_transaction_pk () {
					return this.id_transaction_pk;
				}
				
			    public String id_interaction_pk;

				public String getId_interaction_pk () {
					return this.id_interaction_pk;
				}
				
			    public String id_reclamation_pk;

				public String getId_reclamation_pk () {
					return this.id_reclamation_pk;
				}
				
			    public Integer id_date_fk;

				public Integer getId_date_fk () {
					return this.id_date_fk;
				}
				
			    public Long anciennete_mois;

				public Long getAnciennete_mois () {
					return this.anciennete_mois;
				}
				
			    public Long score_risque_interne;

				public Long getScore_risque_interne () {
					return this.score_risque_interne;
				}
				
			    public Long nb_produits_actifs;

				public Long getNb_produits_actifs () {
					return this.nb_produits_actifs;
				}
				
			    public Double revenu_mensuel;

				public Double getRevenu_mensuel () {
					return this.revenu_mensuel;
				}
				
			    public Double solde_moy;

				public Double getSolde_moy () {
					return this.solde_moy;
				}
				
			    public Double monte_mensuel;

				public Double getMonte_mensuel () {
					return this.monte_mensuel;
				}
				
			    public Long nb_rejet;

				public Long getNb_rejet () {
					return this.nb_rejet;
				}
				
			    public Long nb_transactions;

				public Long getNb_transactions () {
					return this.nb_transactions;
				}
				
			    public Long nb_reclamations;

				public Long getNb_reclamations () {
					return this.nb_reclamations;
				}
				
			    public Long nb_interactions;

				public Long getNb_interactions () {
					return this.nb_interactions;
				}
				
			    public Double delai_resolution_moyen;

				public Double getDelai_resolution_moyen () {
					return this.delai_resolution_moyen;
				}
				
			    public Double duree_inact_connexion_sec;

				public Double getDuree_inact_connexion_sec () {
					return this.duree_inact_connexion_sec;
				}
				
			    public Long churn;

				public Long getChurn () {
					return this.churn;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
						result = prime * result + ((this.id_date_fk == null) ? 0 : this.id_date_fk.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final factStruct other = (factStruct) obj;
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					
						if (this.id_date_fk == null) {
							if (other.id_date_fk != null)
								return false;
						
						} else if (!this.id_date_fk.equals(other.id_date_fk))
						
							return false;
					

		return true;
    }

	public void copyDataTo(factStruct other) {

		other.id_fact_churn_sk = this.id_fact_churn_sk;
	            other.id_client = this.id_client;
	            other.id_transaction_pk = this.id_transaction_pk;
	            other.id_interaction_pk = this.id_interaction_pk;
	            other.id_reclamation_pk = this.id_reclamation_pk;
	            other.id_date_fk = this.id_date_fk;
	            other.anciennete_mois = this.anciennete_mois;
	            other.score_risque_interne = this.score_risque_interne;
	            other.nb_produits_actifs = this.nb_produits_actifs;
	            other.revenu_mensuel = this.revenu_mensuel;
	            other.solde_moy = this.solde_moy;
	            other.monte_mensuel = this.monte_mensuel;
	            other.nb_rejet = this.nb_rejet;
	            other.nb_transactions = this.nb_transactions;
	            other.nb_reclamations = this.nb_reclamations;
	            other.nb_interactions = this.nb_interactions;
	            other.delai_resolution_moyen = this.delai_resolution_moyen;
	            other.duree_inact_connexion_sec = this.duree_inact_connexion_sec;
	            other.churn = this.churn;
	            
	}

	public void copyKeysDataTo(factStruct other) {

		other.id_client = this.id_client;
	            	other.id_date_fk = this.id_date_fk;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
			        this.id_fact_churn_sk = dis.readInt();
					
					this.id_client = readString(dis);
					
					this.id_transaction_pk = readString(dis);
					
					this.id_interaction_pk = readString(dis);
					
					this.id_reclamation_pk = readString(dis);
					
						this.id_date_fk = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_produits_actifs = null;
           				} else {
           			    	this.nb_produits_actifs = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.revenu_mensuel = null;
           				} else {
           			    	this.revenu_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_moy = null;
           				} else {
           			    	this.solde_moy = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.monte_mensuel = null;
           				} else {
           			    	this.monte_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_rejet = null;
           				} else {
           			    	this.nb_rejet = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_transactions = null;
           				} else {
           			    	this.nb_transactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_reclamations = null;
           				} else {
           			    	this.nb_reclamations = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_interactions = null;
           				} else {
           			    	this.nb_interactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_moyen = null;
           				} else {
           			    	this.delai_resolution_moyen = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_inact_connexion_sec = null;
           				} else {
           			    	this.duree_inact_connexion_sec = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.churn = null;
           				} else {
           			    	this.churn = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
			        this.id_fact_churn_sk = dis.readInt();
					
					this.id_client = readString(dis);
					
					this.id_transaction_pk = readString(dis);
					
					this.id_interaction_pk = readString(dis);
					
					this.id_reclamation_pk = readString(dis);
					
						this.id_date_fk = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_produits_actifs = null;
           				} else {
           			    	this.nb_produits_actifs = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.revenu_mensuel = null;
           				} else {
           			    	this.revenu_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_moy = null;
           				} else {
           			    	this.solde_moy = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.monte_mensuel = null;
           				} else {
           			    	this.monte_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_rejet = null;
           				} else {
           			    	this.nb_rejet = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_transactions = null;
           				} else {
           			    	this.nb_transactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_reclamations = null;
           				} else {
           			    	this.nb_reclamations = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_interactions = null;
           				} else {
           			    	this.nb_interactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_moyen = null;
           				} else {
           			    	this.delai_resolution_moyen = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_inact_connexion_sec = null;
           				} else {
           			    	this.duree_inact_connexion_sec = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.churn = null;
           				} else {
           			    	this.churn = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fact_churn_sk);
					
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.id_transaction_pk,dos);
					
					// String
				
						writeString(this.id_interaction_pk,dos);
					
					// String
				
						writeString(this.id_reclamation_pk,dos);
					
					// Integer
				
						writeInteger(this.id_date_fk,dos);
					
					// Long
				
						if(this.anciennete_mois == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.anciennete_mois);
		            	}
					
					// Long
				
						if(this.score_risque_interne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.score_risque_interne);
		            	}
					
					// Long
				
						if(this.nb_produits_actifs == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_produits_actifs);
		            	}
					
					// Double
				
						if(this.revenu_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.revenu_mensuel);
		            	}
					
					// Double
				
						if(this.solde_moy == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_moy);
		            	}
					
					// Double
				
						if(this.monte_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.monte_mensuel);
		            	}
					
					// Long
				
						if(this.nb_rejet == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_rejet);
		            	}
					
					// Long
				
						if(this.nb_transactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_transactions);
		            	}
					
					// Long
				
						if(this.nb_reclamations == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_reclamations);
		            	}
					
					// Long
				
						if(this.nb_interactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_interactions);
		            	}
					
					// Double
				
						if(this.delai_resolution_moyen == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_moyen);
		            	}
					
					// Double
				
						if(this.duree_inact_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.duree_inact_connexion_sec);
		            	}
					
					// Long
				
						if(this.churn == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.churn);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_fact_churn_sk);
					
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.id_transaction_pk,dos);
					
					// String
				
						writeString(this.id_interaction_pk,dos);
					
					// String
				
						writeString(this.id_reclamation_pk,dos);
					
					// Integer
				
						writeInteger(this.id_date_fk,dos);
					
					// Long
				
						if(this.anciennete_mois == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.anciennete_mois);
		            	}
					
					// Long
				
						if(this.score_risque_interne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.score_risque_interne);
		            	}
					
					// Long
				
						if(this.nb_produits_actifs == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_produits_actifs);
		            	}
					
					// Double
				
						if(this.revenu_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.revenu_mensuel);
		            	}
					
					// Double
				
						if(this.solde_moy == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_moy);
		            	}
					
					// Double
				
						if(this.monte_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.monte_mensuel);
		            	}
					
					// Long
				
						if(this.nb_rejet == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_rejet);
		            	}
					
					// Long
				
						if(this.nb_transactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_transactions);
		            	}
					
					// Long
				
						if(this.nb_reclamations == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_reclamations);
		            	}
					
					// Long
				
						if(this.nb_interactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_interactions);
		            	}
					
					// Double
				
						if(this.delai_resolution_moyen == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_moyen);
		            	}
					
					// Double
				
						if(this.duree_inact_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.duree_inact_connexion_sec);
		            	}
					
					// Long
				
						if(this.churn == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.churn);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_fact_churn_sk="+String.valueOf(id_fact_churn_sk));
		sb.append(",id_client="+id_client);
		sb.append(",id_transaction_pk="+id_transaction_pk);
		sb.append(",id_interaction_pk="+id_interaction_pk);
		sb.append(",id_reclamation_pk="+id_reclamation_pk);
		sb.append(",id_date_fk="+String.valueOf(id_date_fk));
		sb.append(",anciennete_mois="+String.valueOf(anciennete_mois));
		sb.append(",score_risque_interne="+String.valueOf(score_risque_interne));
		sb.append(",nb_produits_actifs="+String.valueOf(nb_produits_actifs));
		sb.append(",revenu_mensuel="+String.valueOf(revenu_mensuel));
		sb.append(",solde_moy="+String.valueOf(solde_moy));
		sb.append(",monte_mensuel="+String.valueOf(monte_mensuel));
		sb.append(",nb_rejet="+String.valueOf(nb_rejet));
		sb.append(",nb_transactions="+String.valueOf(nb_transactions));
		sb.append(",nb_reclamations="+String.valueOf(nb_reclamations));
		sb.append(",nb_interactions="+String.valueOf(nb_interactions));
		sb.append(",delai_resolution_moyen="+String.valueOf(delai_resolution_moyen));
		sb.append(",duree_inact_connexion_sec="+String.valueOf(duree_inact_connexion_sec));
		sb.append(",churn="+String.valueOf(churn));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(factStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.id_date_fk, other.id_date_fk);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];

	
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public String sexe;

				public String getSexe () {
					return this.sexe;
				}
				
			    public java.util.Date date_naissance;

				public java.util.Date getDate_naissance () {
					return this.date_naissance;
				}
				
			    public Long est_senior;

				public Long getEst_senior () {
					return this.est_senior;
				}
				
			    public String situation_matrimoniale;

				public String getSituation_matrimoniale () {
					return this.situation_matrimoniale;
				}
				
			    public Long enfants_a_charge;

				public Long getEnfants_a_charge () {
					return this.enfants_a_charge;
				}
				
			    public String profession;

				public String getProfession () {
					return this.profession;
				}
				
			    public String ville_region;

				public String getVille_region () {
					return this.ville_region;
				}
				
			    public Long anciennete_mois;

				public Long getAnciennete_mois () {
					return this.anciennete_mois;
				}
				
			    public Long service_sms_banking;

				public Long getService_sms_banking () {
					return this.service_sms_banking;
				}
				
			    public String acces_banque_en_ligne;

				public String getAcces_banque_en_ligne () {
					return this.acces_banque_en_ligne;
				}
				
			    public Long alerte_securite_active;

				public Long getAlerte_securite_active () {
					return this.alerte_securite_active;
				}
				
			    public Long assurance_moyen_paiement;

				public Long getAssurance_moyen_paiement () {
					return this.assurance_moyen_paiement;
				}
				
			    public Long conseiller_dedie;

				public Long getConseiller_dedie () {
					return this.conseiller_dedie;
				}
				
			    public Long programme_fidelite;

				public Long getProgramme_fidelite () {
					return this.programme_fidelite;
				}
				
			    public String type_convention;

				public String getType_convention () {
					return this.type_convention;
				}
				
			    public Long e_releve_active;

				public Long getE_releve_active () {
					return this.e_releve_active;
				}
				
			    public String methode_paiement_fav;

				public String getMethode_paiement_fav () {
					return this.methode_paiement_fav;
				}
				
			    public Double frais_bancaires_mensuels;

				public Double getFrais_bancaires_mensuels () {
					return this.frais_bancaires_mensuels;
				}
				
			    public Double total_frais_cumules;

				public Double getTotal_frais_cumules () {
					return this.total_frais_cumules;
				}
				
			    public Double revenu_mensuel;

				public Double getRevenu_mensuel () {
					return this.revenu_mensuel;
				}
				
			    public Long nb_produits_actifs;

				public Long getNb_produits_actifs () {
					return this.nb_produits_actifs;
				}
				
			    public Long score_risque_interne;

				public Long getScore_risque_interne () {
					return this.score_risque_interne;
				}
				
			    public Long churn;

				public Long getChurn () {
					return this.churn;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
					this.sexe = readString(dis);
					
					this.date_naissance = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_senior = null;
           				} else {
           			    	this.est_senior = dis.readLong();
           				}
					
					this.situation_matrimoniale = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.enfants_a_charge = null;
           				} else {
           			    	this.enfants_a_charge = dis.readLong();
           				}
					
					this.profession = readString(dis);
					
					this.ville_region = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.service_sms_banking = null;
           				} else {
           			    	this.service_sms_banking = dis.readLong();
           				}
					
					this.acces_banque_en_ligne = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.alerte_securite_active = null;
           				} else {
           			    	this.alerte_securite_active = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.assurance_moyen_paiement = null;
           				} else {
           			    	this.assurance_moyen_paiement = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.conseiller_dedie = null;
           				} else {
           			    	this.conseiller_dedie = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.programme_fidelite = null;
           				} else {
           			    	this.programme_fidelite = dis.readLong();
           				}
					
					this.type_convention = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.e_releve_active = null;
           				} else {
           			    	this.e_releve_active = dis.readLong();
           				}
					
					this.methode_paiement_fav = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.frais_bancaires_mensuels = null;
           				} else {
           			    	this.frais_bancaires_mensuels = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.total_frais_cumules = null;
           				} else {
           			    	this.total_frais_cumules = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.revenu_mensuel = null;
           				} else {
           			    	this.revenu_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_produits_actifs = null;
           				} else {
           			    	this.nb_produits_actifs = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.churn = null;
           				} else {
           			    	this.churn = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
					this.sexe = readString(dis);
					
					this.date_naissance = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_senior = null;
           				} else {
           			    	this.est_senior = dis.readLong();
           				}
					
					this.situation_matrimoniale = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.enfants_a_charge = null;
           				} else {
           			    	this.enfants_a_charge = dis.readLong();
           				}
					
					this.profession = readString(dis);
					
					this.ville_region = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.service_sms_banking = null;
           				} else {
           			    	this.service_sms_banking = dis.readLong();
           				}
					
					this.acces_banque_en_ligne = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.alerte_securite_active = null;
           				} else {
           			    	this.alerte_securite_active = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.assurance_moyen_paiement = null;
           				} else {
           			    	this.assurance_moyen_paiement = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.conseiller_dedie = null;
           				} else {
           			    	this.conseiller_dedie = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.programme_fidelite = null;
           				} else {
           			    	this.programme_fidelite = dis.readLong();
           				}
					
					this.type_convention = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.e_releve_active = null;
           				} else {
           			    	this.e_releve_active = dis.readLong();
           				}
					
					this.methode_paiement_fav = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.frais_bancaires_mensuels = null;
           				} else {
           			    	this.frais_bancaires_mensuels = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.total_frais_cumules = null;
           				} else {
           			    	this.total_frais_cumules = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.revenu_mensuel = null;
           				} else {
           			    	this.revenu_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_produits_actifs = null;
           				} else {
           			    	this.nb_produits_actifs = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.churn = null;
           				} else {
           			    	this.churn = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.sexe,dos);
					
					// java.util.Date
				
						writeDate(this.date_naissance,dos);
					
					// Long
				
						if(this.est_senior == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_senior);
		            	}
					
					// String
				
						writeString(this.situation_matrimoniale,dos);
					
					// Long
				
						if(this.enfants_a_charge == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.enfants_a_charge);
		            	}
					
					// String
				
						writeString(this.profession,dos);
					
					// String
				
						writeString(this.ville_region,dos);
					
					// Long
				
						if(this.anciennete_mois == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.anciennete_mois);
		            	}
					
					// Long
				
						if(this.service_sms_banking == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.service_sms_banking);
		            	}
					
					// String
				
						writeString(this.acces_banque_en_ligne,dos);
					
					// Long
				
						if(this.alerte_securite_active == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.alerte_securite_active);
		            	}
					
					// Long
				
						if(this.assurance_moyen_paiement == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.assurance_moyen_paiement);
		            	}
					
					// Long
				
						if(this.conseiller_dedie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.conseiller_dedie);
		            	}
					
					// Long
				
						if(this.programme_fidelite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.programme_fidelite);
		            	}
					
					// String
				
						writeString(this.type_convention,dos);
					
					// Long
				
						if(this.e_releve_active == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.e_releve_active);
		            	}
					
					// String
				
						writeString(this.methode_paiement_fav,dos);
					
					// Double
				
						if(this.frais_bancaires_mensuels == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.frais_bancaires_mensuels);
		            	}
					
					// Double
				
						if(this.total_frais_cumules == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.total_frais_cumules);
		            	}
					
					// Double
				
						if(this.revenu_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.revenu_mensuel);
		            	}
					
					// Long
				
						if(this.nb_produits_actifs == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_produits_actifs);
		            	}
					
					// Long
				
						if(this.score_risque_interne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.score_risque_interne);
		            	}
					
					// Long
				
						if(this.churn == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.churn);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.sexe,dos);
					
					// java.util.Date
				
						writeDate(this.date_naissance,dos);
					
					// Long
				
						if(this.est_senior == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_senior);
		            	}
					
					// String
				
						writeString(this.situation_matrimoniale,dos);
					
					// Long
				
						if(this.enfants_a_charge == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.enfants_a_charge);
		            	}
					
					// String
				
						writeString(this.profession,dos);
					
					// String
				
						writeString(this.ville_region,dos);
					
					// Long
				
						if(this.anciennete_mois == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.anciennete_mois);
		            	}
					
					// Long
				
						if(this.service_sms_banking == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.service_sms_banking);
		            	}
					
					// String
				
						writeString(this.acces_banque_en_ligne,dos);
					
					// Long
				
						if(this.alerte_securite_active == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.alerte_securite_active);
		            	}
					
					// Long
				
						if(this.assurance_moyen_paiement == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.assurance_moyen_paiement);
		            	}
					
					// Long
				
						if(this.conseiller_dedie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.conseiller_dedie);
		            	}
					
					// Long
				
						if(this.programme_fidelite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.programme_fidelite);
		            	}
					
					// String
				
						writeString(this.type_convention,dos);
					
					// Long
				
						if(this.e_releve_active == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.e_releve_active);
		            	}
					
					// String
				
						writeString(this.methode_paiement_fav,dos);
					
					// Double
				
						if(this.frais_bancaires_mensuels == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.frais_bancaires_mensuels);
		            	}
					
					// Double
				
						if(this.total_frais_cumules == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.total_frais_cumules);
		            	}
					
					// Double
				
						if(this.revenu_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.revenu_mensuel);
		            	}
					
					// Long
				
						if(this.nb_produits_actifs == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_produits_actifs);
		            	}
					
					// Long
				
						if(this.score_risque_interne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.score_risque_interne);
		            	}
					
					// Long
				
						if(this.churn == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.churn);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_client="+id_client);
		sb.append(",sexe="+sexe);
		sb.append(",date_naissance="+String.valueOf(date_naissance));
		sb.append(",est_senior="+String.valueOf(est_senior));
		sb.append(",situation_matrimoniale="+situation_matrimoniale);
		sb.append(",enfants_a_charge="+String.valueOf(enfants_a_charge));
		sb.append(",profession="+profession);
		sb.append(",ville_region="+ville_region);
		sb.append(",anciennete_mois="+String.valueOf(anciennete_mois));
		sb.append(",service_sms_banking="+String.valueOf(service_sms_banking));
		sb.append(",acces_banque_en_ligne="+acces_banque_en_ligne);
		sb.append(",alerte_securite_active="+String.valueOf(alerte_securite_active));
		sb.append(",assurance_moyen_paiement="+String.valueOf(assurance_moyen_paiement));
		sb.append(",conseiller_dedie="+String.valueOf(conseiller_dedie));
		sb.append(",programme_fidelite="+String.valueOf(programme_fidelite));
		sb.append(",type_convention="+type_convention);
		sb.append(",e_releve_active="+String.valueOf(e_releve_active));
		sb.append(",methode_paiement_fav="+methode_paiement_fav);
		sb.append(",frais_bancaires_mensuels="+String.valueOf(frais_bancaires_mensuels));
		sb.append(",total_frais_cumules="+String.valueOf(total_frais_cumules));
		sb.append(",revenu_mensuel="+String.valueOf(revenu_mensuel));
		sb.append(",nb_produits_actifs="+String.valueOf(nb_produits_actifs));
		sb.append(",score_risque_interne="+String.valueOf(score_risque_interne));
		sb.append(",churn="+String.valueOf(churn));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public String sexe;

				public String getSexe () {
					return this.sexe;
				}
				
			    public java.util.Date date_naissance;

				public java.util.Date getDate_naissance () {
					return this.date_naissance;
				}
				
			    public Long est_senior;

				public Long getEst_senior () {
					return this.est_senior;
				}
				
			    public String situation_matrimoniale;

				public String getSituation_matrimoniale () {
					return this.situation_matrimoniale;
				}
				
			    public Long enfants_a_charge;

				public Long getEnfants_a_charge () {
					return this.enfants_a_charge;
				}
				
			    public String profession;

				public String getProfession () {
					return this.profession;
				}
				
			    public String ville_region;

				public String getVille_region () {
					return this.ville_region;
				}
				
			    public Long anciennete_mois;

				public Long getAnciennete_mois () {
					return this.anciennete_mois;
				}
				
			    public Long service_sms_banking;

				public Long getService_sms_banking () {
					return this.service_sms_banking;
				}
				
			    public String acces_banque_en_ligne;

				public String getAcces_banque_en_ligne () {
					return this.acces_banque_en_ligne;
				}
				
			    public Long alerte_securite_active;

				public Long getAlerte_securite_active () {
					return this.alerte_securite_active;
				}
				
			    public Long assurance_moyen_paiement;

				public Long getAssurance_moyen_paiement () {
					return this.assurance_moyen_paiement;
				}
				
			    public Long conseiller_dedie;

				public Long getConseiller_dedie () {
					return this.conseiller_dedie;
				}
				
			    public Long programme_fidelite;

				public Long getProgramme_fidelite () {
					return this.programme_fidelite;
				}
				
			    public String type_convention;

				public String getType_convention () {
					return this.type_convention;
				}
				
			    public Long e_releve_active;

				public Long getE_releve_active () {
					return this.e_releve_active;
				}
				
			    public String methode_paiement_fav;

				public String getMethode_paiement_fav () {
					return this.methode_paiement_fav;
				}
				
			    public Double frais_bancaires_mensuels;

				public Double getFrais_bancaires_mensuels () {
					return this.frais_bancaires_mensuels;
				}
				
			    public Double total_frais_cumules;

				public Double getTotal_frais_cumules () {
					return this.total_frais_cumules;
				}
				
			    public Double revenu_mensuel;

				public Double getRevenu_mensuel () {
					return this.revenu_mensuel;
				}
				
			    public Long nb_produits_actifs;

				public Long getNb_produits_actifs () {
					return this.nb_produits_actifs;
				}
				
			    public Long score_risque_interne;

				public Long getScore_risque_interne () {
					return this.score_risque_interne;
				}
				
			    public Long churn;

				public Long getChurn () {
					return this.churn;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_1Struct other) {

		other.id_client = this.id_client;
	            other.sexe = this.sexe;
	            other.date_naissance = this.date_naissance;
	            other.est_senior = this.est_senior;
	            other.situation_matrimoniale = this.situation_matrimoniale;
	            other.enfants_a_charge = this.enfants_a_charge;
	            other.profession = this.profession;
	            other.ville_region = this.ville_region;
	            other.anciennete_mois = this.anciennete_mois;
	            other.service_sms_banking = this.service_sms_banking;
	            other.acces_banque_en_ligne = this.acces_banque_en_ligne;
	            other.alerte_securite_active = this.alerte_securite_active;
	            other.assurance_moyen_paiement = this.assurance_moyen_paiement;
	            other.conseiller_dedie = this.conseiller_dedie;
	            other.programme_fidelite = this.programme_fidelite;
	            other.type_convention = this.type_convention;
	            other.e_releve_active = this.e_releve_active;
	            other.methode_paiement_fav = this.methode_paiement_fav;
	            other.frais_bancaires_mensuels = this.frais_bancaires_mensuels;
	            other.total_frais_cumules = this.total_frais_cumules;
	            other.revenu_mensuel = this.revenu_mensuel;
	            other.nb_produits_actifs = this.nb_produits_actifs;
	            other.score_risque_interne = this.score_risque_interne;
	            other.churn = this.churn;
	            
	}

	public void copyKeysDataTo(after_tDBInput_1Struct other) {

		other.id_client = this.id_client;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
					this.sexe = readString(dis);
					
					this.date_naissance = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_senior = null;
           				} else {
           			    	this.est_senior = dis.readLong();
           				}
					
					this.situation_matrimoniale = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.enfants_a_charge = null;
           				} else {
           			    	this.enfants_a_charge = dis.readLong();
           				}
					
					this.profession = readString(dis);
					
					this.ville_region = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.service_sms_banking = null;
           				} else {
           			    	this.service_sms_banking = dis.readLong();
           				}
					
					this.acces_banque_en_ligne = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.alerte_securite_active = null;
           				} else {
           			    	this.alerte_securite_active = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.assurance_moyen_paiement = null;
           				} else {
           			    	this.assurance_moyen_paiement = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.conseiller_dedie = null;
           				} else {
           			    	this.conseiller_dedie = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.programme_fidelite = null;
           				} else {
           			    	this.programme_fidelite = dis.readLong();
           				}
					
					this.type_convention = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.e_releve_active = null;
           				} else {
           			    	this.e_releve_active = dis.readLong();
           				}
					
					this.methode_paiement_fav = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.frais_bancaires_mensuels = null;
           				} else {
           			    	this.frais_bancaires_mensuels = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.total_frais_cumules = null;
           				} else {
           			    	this.total_frais_cumules = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.revenu_mensuel = null;
           				} else {
           			    	this.revenu_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_produits_actifs = null;
           				} else {
           			    	this.nb_produits_actifs = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.churn = null;
           				} else {
           			    	this.churn = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
					this.sexe = readString(dis);
					
					this.date_naissance = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_senior = null;
           				} else {
           			    	this.est_senior = dis.readLong();
           				}
					
					this.situation_matrimoniale = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.enfants_a_charge = null;
           				} else {
           			    	this.enfants_a_charge = dis.readLong();
           				}
					
					this.profession = readString(dis);
					
					this.ville_region = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.service_sms_banking = null;
           				} else {
           			    	this.service_sms_banking = dis.readLong();
           				}
					
					this.acces_banque_en_ligne = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.alerte_securite_active = null;
           				} else {
           			    	this.alerte_securite_active = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.assurance_moyen_paiement = null;
           				} else {
           			    	this.assurance_moyen_paiement = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.conseiller_dedie = null;
           				} else {
           			    	this.conseiller_dedie = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.programme_fidelite = null;
           				} else {
           			    	this.programme_fidelite = dis.readLong();
           				}
					
					this.type_convention = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.e_releve_active = null;
           				} else {
           			    	this.e_releve_active = dis.readLong();
           				}
					
					this.methode_paiement_fav = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.frais_bancaires_mensuels = null;
           				} else {
           			    	this.frais_bancaires_mensuels = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.total_frais_cumules = null;
           				} else {
           			    	this.total_frais_cumules = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.revenu_mensuel = null;
           				} else {
           			    	this.revenu_mensuel = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_produits_actifs = null;
           				} else {
           			    	this.nb_produits_actifs = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.churn = null;
           				} else {
           			    	this.churn = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.sexe,dos);
					
					// java.util.Date
				
						writeDate(this.date_naissance,dos);
					
					// Long
				
						if(this.est_senior == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_senior);
		            	}
					
					// String
				
						writeString(this.situation_matrimoniale,dos);
					
					// Long
				
						if(this.enfants_a_charge == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.enfants_a_charge);
		            	}
					
					// String
				
						writeString(this.profession,dos);
					
					// String
				
						writeString(this.ville_region,dos);
					
					// Long
				
						if(this.anciennete_mois == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.anciennete_mois);
		            	}
					
					// Long
				
						if(this.service_sms_banking == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.service_sms_banking);
		            	}
					
					// String
				
						writeString(this.acces_banque_en_ligne,dos);
					
					// Long
				
						if(this.alerte_securite_active == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.alerte_securite_active);
		            	}
					
					// Long
				
						if(this.assurance_moyen_paiement == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.assurance_moyen_paiement);
		            	}
					
					// Long
				
						if(this.conseiller_dedie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.conseiller_dedie);
		            	}
					
					// Long
				
						if(this.programme_fidelite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.programme_fidelite);
		            	}
					
					// String
				
						writeString(this.type_convention,dos);
					
					// Long
				
						if(this.e_releve_active == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.e_releve_active);
		            	}
					
					// String
				
						writeString(this.methode_paiement_fav,dos);
					
					// Double
				
						if(this.frais_bancaires_mensuels == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.frais_bancaires_mensuels);
		            	}
					
					// Double
				
						if(this.total_frais_cumules == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.total_frais_cumules);
		            	}
					
					// Double
				
						if(this.revenu_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.revenu_mensuel);
		            	}
					
					// Long
				
						if(this.nb_produits_actifs == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_produits_actifs);
		            	}
					
					// Long
				
						if(this.score_risque_interne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.score_risque_interne);
		            	}
					
					// Long
				
						if(this.churn == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.churn);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.sexe,dos);
					
					// java.util.Date
				
						writeDate(this.date_naissance,dos);
					
					// Long
				
						if(this.est_senior == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_senior);
		            	}
					
					// String
				
						writeString(this.situation_matrimoniale,dos);
					
					// Long
				
						if(this.enfants_a_charge == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.enfants_a_charge);
		            	}
					
					// String
				
						writeString(this.profession,dos);
					
					// String
				
						writeString(this.ville_region,dos);
					
					// Long
				
						if(this.anciennete_mois == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.anciennete_mois);
		            	}
					
					// Long
				
						if(this.service_sms_banking == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.service_sms_banking);
		            	}
					
					// String
				
						writeString(this.acces_banque_en_ligne,dos);
					
					// Long
				
						if(this.alerte_securite_active == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.alerte_securite_active);
		            	}
					
					// Long
				
						if(this.assurance_moyen_paiement == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.assurance_moyen_paiement);
		            	}
					
					// Long
				
						if(this.conseiller_dedie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.conseiller_dedie);
		            	}
					
					// Long
				
						if(this.programme_fidelite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.programme_fidelite);
		            	}
					
					// String
				
						writeString(this.type_convention,dos);
					
					// Long
				
						if(this.e_releve_active == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.e_releve_active);
		            	}
					
					// String
				
						writeString(this.methode_paiement_fav,dos);
					
					// Double
				
						if(this.frais_bancaires_mensuels == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.frais_bancaires_mensuels);
		            	}
					
					// Double
				
						if(this.total_frais_cumules == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.total_frais_cumules);
		            	}
					
					// Double
				
						if(this.revenu_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.revenu_mensuel);
		            	}
					
					// Long
				
						if(this.nb_produits_actifs == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_produits_actifs);
		            	}
					
					// Long
				
						if(this.score_risque_interne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.score_risque_interne);
		            	}
					
					// Long
				
						if(this.churn == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.churn);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_client="+id_client);
		sb.append(",sexe="+sexe);
		sb.append(",date_naissance="+String.valueOf(date_naissance));
		sb.append(",est_senior="+String.valueOf(est_senior));
		sb.append(",situation_matrimoniale="+situation_matrimoniale);
		sb.append(",enfants_a_charge="+String.valueOf(enfants_a_charge));
		sb.append(",profession="+profession);
		sb.append(",ville_region="+ville_region);
		sb.append(",anciennete_mois="+String.valueOf(anciennete_mois));
		sb.append(",service_sms_banking="+String.valueOf(service_sms_banking));
		sb.append(",acces_banque_en_ligne="+acces_banque_en_ligne);
		sb.append(",alerte_securite_active="+String.valueOf(alerte_securite_active));
		sb.append(",assurance_moyen_paiement="+String.valueOf(assurance_moyen_paiement));
		sb.append(",conseiller_dedie="+String.valueOf(conseiller_dedie));
		sb.append(",programme_fidelite="+String.valueOf(programme_fidelite));
		sb.append(",type_convention="+type_convention);
		sb.append(",e_releve_active="+String.valueOf(e_releve_active));
		sb.append(",methode_paiement_fav="+methode_paiement_fav);
		sb.append(",frais_bancaires_mensuels="+String.valueOf(frais_bancaires_mensuels));
		sb.append(",total_frais_cumules="+String.valueOf(total_frais_cumules));
		sb.append(",revenu_mensuel="+String.valueOf(revenu_mensuel));
		sb.append(",nb_produits_actifs="+String.valueOf(nb_produits_actifs));
		sb.append(",score_risque_interne="+String.valueOf(score_risque_interne));
		sb.append(",churn="+String.valueOf(churn));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_3Process(globalMap);
		tDBInput_4Process(globalMap);
		tDBInput_5Process(globalMap);
		tDBInput_6Process(globalMap);
		tDBInput_7Process(globalMap);
		tDBInput_8Process(globalMap);
		tDBInput_2Process(globalMap);

		row1Struct row1 = new row1Struct();
factStruct fact = new factStruct();
factStruct row11 = fact;






	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row11");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = context.schema;
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = ("CHURN_CLIENT");
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("CHURN_CLIENT");
}

        int updateKeyCount_tDBOutput_1 = 2;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 19 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

boolean whetherReject_tDBOutput_1 = false;

java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_1 = "jdbc:postgresql://"+context.host+":"+context.port+"/"+context.database + "?" + context.params;
    dbUser_tDBOutput_1 = context.username;

	final String decryptedPassword_tDBOutput_1 = context.password; 

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;

    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;



int count_tDBOutput_1=0;
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM \"" + tableName_tDBOutput_1 + "\" WHERE \"id_client\" = ? AND \"id_date_fk\" = ?");
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    String insert_tDBOutput_1 = "INSERT INTO \"" + tableName_tDBOutput_1 + "\" (\"id_client\",\"id_transaction_pk\",\"id_interaction_pk\",\"id_reclamation_pk\",\"id_date_fk\",\"anciennete_mois\",\"score_risque_interne\",\"nb_produits_actifs\",\"revenu_mensuel\",\"solde_moy\",\"monte_mensuel\",\"nb_rejet\",\"nb_transactions\",\"nb_reclamations\",\"nb_interactions\",\"delai_resolution_moyen\",\"duree_inact_connexion_sec\",\"churn\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
	    String update_tDBOutput_1 = "UPDATE \"" + tableName_tDBOutput_1 + "\" SET \"id_client\" = ?,\"id_transaction_pk\" = ?,\"id_interaction_pk\" = ?,\"id_reclamation_pk\" = ?,\"anciennete_mois\" = ?,\"score_risque_interne\" = ?,\"nb_produits_actifs\" = ?,\"revenu_mensuel\" = ?,\"solde_moy\" = ?,\"monte_mensuel\" = ?,\"nb_rejet\" = ?,\"nb_transactions\" = ?,\"nb_reclamations\" = ?,\"nb_interactions\" = ?,\"delai_resolution_moyen\" = ?,\"duree_inact_connexion_sec\" = ?,\"churn\" = ? WHERE \"id_client\" = ? AND \"id_date_fk\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
	    resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fact");
					}
				
		int tos_count_tLogRow_1 = 0;
		

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
		java.io.PrintStream consoleOut_tLogRow_1 = null;	

 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) 
					globalMap.get( "tHash_Lookup_row8" ))
					;					
					
	

row8Struct row8HashKey = new row8Struct();
row8Struct row8Default = new row8Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) 
					globalMap.get( "tHash_Lookup_row7" ))
					;					
					
	

row7Struct row7HashKey = new row7Struct();
row7Struct row7Default = new row7Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) 
					globalMap.get( "tHash_Lookup_row9" ))
					;					
					
	

row9Struct row9HashKey = new row9Struct();
row9Struct row9Default = new row9Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
					globalMap.get( "tHash_Lookup_row4" ))
					;					
					
	

row4Struct row4HashKey = new row4Struct();
row4Struct row4Default = new row4Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row10Struct> tHash_Lookup_row10 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row10Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row10Struct>) 
					globalMap.get( "tHash_Lookup_row10" ))
					;					
					
	

row10Struct row10HashKey = new row10Struct();
row10Struct row10Default = new row10Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) 
					globalMap.get( "tHash_Lookup_row5" ))
					;					
					
	

row5Struct row5HashKey = new row5Struct();
row5Struct row5Default = new row5Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
factStruct fact_tmp = new factStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
    
	
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = context.username;
				
				
	final String decryptedPassword_tDBInput_1 = context.password; 
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
				String url_tDBInput_1 = "jdbc:postgresql://" + context.host + ":" + context.port + "/" + context.database + "?" + context.params;
				
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
		        
				conn_tDBInput_1.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT \n  \"staging\".\"STG_CLIENTS\".\"id_client\", \n  \"staging\".\"STG_CLIENTS\".\"sexe\", \n  \"staging\".\"STG_CLIE"
+"NTS\".\"date_naissance\", \n  \"staging\".\"STG_CLIENTS\".\"est_senior\", \n  \"staging\".\"STG_CLIENTS\".\"situation_matr"
+"imoniale\", \n  \"staging\".\"STG_CLIENTS\".\"enfants_a_charge\", \n  \"staging\".\"STG_CLIENTS\".\"profession\", \n  \"sta"
+"ging\".\"STG_CLIENTS\".\"ville_region\", \n  \"staging\".\"STG_CLIENTS\".\"anciennete_mois\", \n  \"staging\".\"STG_CLIENT"
+"S\".\"service_sms_banking\", \n  \"staging\".\"STG_CLIENTS\".\"acces_banque_en_ligne\", \n  \"staging\".\"STG_CLIENTS\".\""
+"alerte_securite_active\", \n  \"staging\".\"STG_CLIENTS\".\"assurance_moyen_paiement\", \n  \"staging\".\"STG_CLIENTS\".\""
+"conseiller_dedie\", \n  \"staging\".\"STG_CLIENTS\".\"programme_fidelite\", \n  \"staging\".\"STG_CLIENTS\".\"type_convent"
+"ion\", \n  \"staging\".\"STG_CLIENTS\".\"e_releve_active\", \n  \"staging\".\"STG_CLIENTS\".\"methode_paiement_fav\", \n  "
+"\"staging\".\"STG_CLIENTS\".\"frais_bancaires_mensuels\", \n  \"staging\".\"STG_CLIENTS\".\"total_frais_cumules\", \n  \"s"
+"taging\".\"STG_CLIENTS\".\"revenu_mensuel\", \n  \"staging\".\"STG_CLIENTS\".\"nb_produits_actifs\", \n  \"staging\".\"STG"
+"_CLIENTS\".\"score_risque_interne\", \n  \"staging\".\"STG_CLIENTS\".\"churn\"\nFROM \"staging\".\"STG_CLIENTS\"";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.id_client = null;
							} else {
	                         		
        	row1.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.sexe = null;
							} else {
	                         		
        	row1.sexe = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.date_naissance = null;
							} else {
										
			row1.date_naissance = routines.system.JDBCUtil.getDate(rs_tDBInput_1, 3);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.est_senior = null;
							} else {
		                          
            row1.est_senior = rs_tDBInput_1.getLong(4);
            if(rs_tDBInput_1.wasNull()){
                    row1.est_senior = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.situation_matrimoniale = null;
							} else {
	                         		
        	row1.situation_matrimoniale = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.enfants_a_charge = null;
							} else {
		                          
            row1.enfants_a_charge = rs_tDBInput_1.getLong(6);
            if(rs_tDBInput_1.wasNull()){
                    row1.enfants_a_charge = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.profession = null;
							} else {
	                         		
        	row1.profession = routines.system.JDBCUtil.getString(rs_tDBInput_1, 7, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.ville_region = null;
							} else {
	                         		
        	row1.ville_region = routines.system.JDBCUtil.getString(rs_tDBInput_1, 8, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.anciennete_mois = null;
							} else {
		                          
            row1.anciennete_mois = rs_tDBInput_1.getLong(9);
            if(rs_tDBInput_1.wasNull()){
                    row1.anciennete_mois = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.service_sms_banking = null;
							} else {
		                          
            row1.service_sms_banking = rs_tDBInput_1.getLong(10);
            if(rs_tDBInput_1.wasNull()){
                    row1.service_sms_banking = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.acces_banque_en_ligne = null;
							} else {
	                         		
        	row1.acces_banque_en_ligne = routines.system.JDBCUtil.getString(rs_tDBInput_1, 11, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.alerte_securite_active = null;
							} else {
		                          
            row1.alerte_securite_active = rs_tDBInput_1.getLong(12);
            if(rs_tDBInput_1.wasNull()){
                    row1.alerte_securite_active = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.assurance_moyen_paiement = null;
							} else {
		                          
            row1.assurance_moyen_paiement = rs_tDBInput_1.getLong(13);
            if(rs_tDBInput_1.wasNull()){
                    row1.assurance_moyen_paiement = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.conseiller_dedie = null;
							} else {
		                          
            row1.conseiller_dedie = rs_tDBInput_1.getLong(14);
            if(rs_tDBInput_1.wasNull()){
                    row1.conseiller_dedie = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.programme_fidelite = null;
							} else {
		                          
            row1.programme_fidelite = rs_tDBInput_1.getLong(15);
            if(rs_tDBInput_1.wasNull()){
                    row1.programme_fidelite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.type_convention = null;
							} else {
	                         		
        	row1.type_convention = routines.system.JDBCUtil.getString(rs_tDBInput_1, 16, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.e_releve_active = null;
							} else {
		                          
            row1.e_releve_active = rs_tDBInput_1.getLong(17);
            if(rs_tDBInput_1.wasNull()){
                    row1.e_releve_active = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.methode_paiement_fav = null;
							} else {
	                         		
        	row1.methode_paiement_fav = routines.system.JDBCUtil.getString(rs_tDBInput_1, 18, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.frais_bancaires_mensuels = null;
							} else {
	                         		
            row1.frais_bancaires_mensuels = rs_tDBInput_1.getDouble(19);
            if(rs_tDBInput_1.wasNull()){
                    row1.frais_bancaires_mensuels = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.total_frais_cumules = null;
							} else {
	                         		
            row1.total_frais_cumules = rs_tDBInput_1.getDouble(20);
            if(rs_tDBInput_1.wasNull()){
                    row1.total_frais_cumules = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.revenu_mensuel = null;
							} else {
	                         		
            row1.revenu_mensuel = rs_tDBInput_1.getDouble(21);
            if(rs_tDBInput_1.wasNull()){
                    row1.revenu_mensuel = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.nb_produits_actifs = null;
							} else {
		                          
            row1.nb_produits_actifs = rs_tDBInput_1.getLong(22);
            if(rs_tDBInput_1.wasNull()){
                    row1.nb_produits_actifs = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.score_risque_interne = null;
							} else {
		                          
            row1.score_risque_interne = rs_tDBInput_1.getLong(23);
            if(rs_tDBInput_1.wasNull()){
                    row1.score_risque_interne = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.churn = null;
							} else {
		                          
            row1.churn = rs_tDBInput_1.getLong(24);
            if(rs_tDBInput_1.wasNull()){
                    row1.churn = null;
            }
		                    }
					


 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row8" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow8 = false;
       		  	    	
       		  	    	
 							row8Struct row8ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row8HashKey.id_client = row1.id_client ;
                        		    		

								
		                        	row8HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row8.lookup( row8HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row8 != null && tHash_Lookup_row8.getCount(row8HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row8' and it contains more one result from keys :  row8.id_client = '" + row8HashKey.id_client + "'");
								} // G 071
							

							row8Struct row8 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row8Struct fromLookup_row8 = null;
							row8 = row8Default;
										 
							
								 
							
							
								if (tHash_Lookup_row8 !=null && tHash_Lookup_row8.hasNext()) { // G 099
								
							
								
								fromLookup_row8 = tHash_Lookup_row8.next();

							
							
								} // G 099
							
							

							if(fromLookup_row8 != null) {
								row8 = fromLookup_row8;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row7" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow7 = false;
       		  	    	
       		  	    	
 							row7Struct row7ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row7HashKey.id_client = row1.id_client ;
                        		    		

								
		                        	row7HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row7.lookup( row7HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row7 != null && tHash_Lookup_row7.getCount(row7HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row7' and it contains more one result from keys :  row7.id_client = '" + row7HashKey.id_client + "'");
								} // G 071
							

							row7Struct row7 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row7Struct fromLookup_row7 = null;
							row7 = row7Default;
										 
							
								 
							
							
								if (tHash_Lookup_row7 !=null && tHash_Lookup_row7.hasNext()) { // G 099
								
							
								
								fromLookup_row7 = tHash_Lookup_row7.next();

							
							
								} // G 099
							
							

							if(fromLookup_row7 != null) {
								row7 = fromLookup_row7;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row9" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow9 = false;
       		  	    	
       		  	    	
 							row9Struct row9ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row9HashKey.id_client = row1.id_client ;
                        		    		

								
		                        	row9HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row9.lookup( row9HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row9 != null && tHash_Lookup_row9.getCount(row9HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row9' and it contains more one result from keys :  row9.id_client = '" + row9HashKey.id_client + "'");
								} // G 071
							

							row9Struct row9 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row9Struct fromLookup_row9 = null;
							row9 = row9Default;
										 
							
								 
							
							
								if (tHash_Lookup_row9 !=null && tHash_Lookup_row9.hasNext()) { // G 099
								
							
								
								fromLookup_row9 = tHash_Lookup_row9.next();

							
							
								} // G 099
							
							

							if(fromLookup_row9 != null) {
								row9 = fromLookup_row9;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row4" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow4 = false;
       		  	    	
       		  	    	
 							row4Struct row4ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row4HashKey.id_client = row1.id_client ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4' and it contains more one result from keys :  row4.id_client = '" + row4HashKey.id_client + "'");
								} // G 071
							

							row4Struct row4 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row4Struct fromLookup_row4 = null;
							row4 = row4Default;
										 
							
								 
							
							
								if (tHash_Lookup_row4 !=null && tHash_Lookup_row4.hasNext()) { // G 099
								
							
								
								fromLookup_row4 = tHash_Lookup_row4.next();

							
							
								} // G 099
							
							

							if(fromLookup_row4 != null) {
								row4 = fromLookup_row4;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row3HashKey.id_client = row1.id_client ;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.id_client = '" + row3HashKey.id_client + "'");
								} // G 071
							

							row3Struct row3 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row3Struct fromLookup_row3 = null;
							row3 = row3Default;
										 
							
								 
							
							
								if (tHash_Lookup_row3 !=null && tHash_Lookup_row3.hasNext()) { // G 099
								
							
								
								fromLookup_row3 = tHash_Lookup_row3.next();

							
							
								} // G 099
							
							

							if(fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row10" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow10 = false;
       		  	    	
       		  	    	
 							row10Struct row10ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row10HashKey.id_client = row1.id_client ;
                        		    		

								
		                        	row10HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row10.lookup( row10HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row10 != null && tHash_Lookup_row10.getCount(row10HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row10' and it contains more one result from keys :  row10.id_client = '" + row10HashKey.id_client + "'");
								} // G 071
							

							row10Struct row10 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row10Struct fromLookup_row10 = null;
							row10 = row10Default;
										 
							
								 
							
							
								if (tHash_Lookup_row10 !=null && tHash_Lookup_row10.hasNext()) { // G 099
								
							
								
								fromLookup_row10 = tHash_Lookup_row10.next();

							
							
								} // G 099
							
							

							if(fromLookup_row10 != null) {
								row10 = fromLookup_row10;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row5" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow5 = false;
       		  	    	
       		  	    	
 							row5Struct row5ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row5HashKey.date_complete = row8 == null ? null : row8.date_transaction == null ? null : new java.util.Date(row8 == null ? null : row8.date_transaction.getTime());
                        		    		

								
		                        	row5HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row5.lookup( row5HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5' and it contains more one result from keys :  row5.date_complete = '" + row5HashKey.date_complete + "'");
								} // G 071
							

							row5Struct row5 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row5Struct fromLookup_row5 = null;
							row5 = row5Default;
										 
							
								 
							
							
								if (tHash_Lookup_row5 !=null && tHash_Lookup_row5.hasNext()) { // G 099
								
							
								
								fromLookup_row5 = tHash_Lookup_row5.next();

							
							
								} // G 099
							
							

							if(fromLookup_row5 != null) {
								row5 = fromLookup_row5;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

fact = null;


// # Output table : 'fact'
fact_tmp.id_fact_churn_sk = 0;
fact_tmp.id_client = row1.id_client ;
fact_tmp.id_transaction_pk = row8 == null || row8.id_transaction == null ? "AUCUN" : row8.id_transaction;
fact_tmp.id_interaction_pk = row7 == null || row7.id_interaction == null ? "AUCUN" : row7.id_interaction;
fact_tmp.id_reclamation_pk = row9 == null || row9.id_interaction == null ? "AUCUN" : row9.id_interaction;
fact_tmp.id_date_fk = row5.id_date_sk ;
fact_tmp.anciennete_mois = row1.anciennete_mois ;
fact_tmp.score_risque_interne = row1.score_risque_interne ;
fact_tmp.nb_produits_actifs = row1.nb_produits_actifs ;
fact_tmp.revenu_mensuel = row1.revenu_mensuel ;
fact_tmp.solde_moy = (row3 == null || row3.solde_moy == null) ? 0.0 : row3.solde_moy;
fact_tmp.monte_mensuel = (row3 == null || row3.monte_mensuel == null) ? 0.0 : row3.monte_mensuel;
fact_tmp.nb_rejet = (row3 == null || row3.nb_rejet == null) ? 0 : row3.nb_rejet;
fact_tmp.nb_transactions = (row3 == null || row3.nb_transactions == null) ? 0 : row3.nb_transactions;
fact_tmp.nb_reclamations = (row10 == null || row10.nb_reclamations == null) ? 0 : row10.nb_reclamations ;
fact_tmp.nb_interactions = (row10 == null || row10.nb_interactions == null) ? 0 : row10.nb_interactions;
fact_tmp.delai_resolution_moyen = (row10 == null || row10.delai_resolution_moyen == null) ? 0.0 : row10.delai_resolution_moyen;
fact_tmp.duree_inact_connexion_sec = (row10 == null || row10.duree_inact_connexion_sec == null) ? 0.0 : row10.duree_inact_connexion_sec;
fact_tmp.churn = row1.churn ;
fact = fact_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "fact"
if(fact != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fact"
						
						);
					}
					
///////////////////////		
						



				strBuffer_tLogRow_1 = new StringBuilder();




              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.id_fact_churn_sk)							
				);


							  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.id_client != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.id_client)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.id_transaction_pk != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.id_transaction_pk)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.id_interaction_pk != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.id_interaction_pk)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.id_reclamation_pk != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.id_reclamation_pk)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.id_date_fk != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.id_date_fk)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.anciennete_mois != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.anciennete_mois)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.score_risque_interne != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.score_risque_interne)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.nb_produits_actifs != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.nb_produits_actifs)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.revenu_mensuel != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(fact.revenu_mensuel)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.solde_moy != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(fact.solde_moy)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.monte_mensuel != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(fact.monte_mensuel)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.nb_rejet != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.nb_rejet)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.nb_transactions != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.nb_transactions)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.nb_reclamations != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.nb_reclamations)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.nb_interactions != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.nb_interactions)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.delai_resolution_moyen != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(fact.delai_resolution_moyen)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.duree_inact_connexion_sec != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(fact.duree_inact_connexion_sec)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(fact.churn != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(fact.churn)							
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    consoleOut_tLogRow_1.println(strBuffer_tLogRow_1.toString());
                    consoleOut_tLogRow_1.flush();
                    nb_line_tLogRow_1++;
//////

//////                    
                    
///////////////////////    			

 
     row11 = fact;


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row11"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(row11.id_client == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, row11.id_client);
}

                    if(row11.id_date_fk == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(2, row11.id_date_fk);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(row11.id_client == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, row11.id_client);
}

                        if(row11.id_transaction_pk == null) {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(2, row11.id_transaction_pk);
}

                        if(row11.id_interaction_pk == null) {
pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(3, row11.id_interaction_pk);
}

                        if(row11.id_reclamation_pk == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(4, row11.id_reclamation_pk);
}

                        if(row11.anciennete_mois == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(5, row11.anciennete_mois);
}

                        if(row11.score_risque_interne == null) {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(6, row11.score_risque_interne);
}

                        if(row11.nb_produits_actifs == null) {
pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(7, row11.nb_produits_actifs);
}

                        if(row11.revenu_mensuel == null) {
pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.DOUBLE);
} else {pstmtUpdate_tDBOutput_1.setDouble(8, row11.revenu_mensuel);
}

                        if(row11.solde_moy == null) {
pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.DOUBLE);
} else {pstmtUpdate_tDBOutput_1.setDouble(9, row11.solde_moy);
}

                        if(row11.monte_mensuel == null) {
pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.DOUBLE);
} else {pstmtUpdate_tDBOutput_1.setDouble(10, row11.monte_mensuel);
}

                        if(row11.nb_rejet == null) {
pstmtUpdate_tDBOutput_1.setNull(11, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(11, row11.nb_rejet);
}

                        if(row11.nb_transactions == null) {
pstmtUpdate_tDBOutput_1.setNull(12, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(12, row11.nb_transactions);
}

                        if(row11.nb_reclamations == null) {
pstmtUpdate_tDBOutput_1.setNull(13, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(13, row11.nb_reclamations);
}

                        if(row11.nb_interactions == null) {
pstmtUpdate_tDBOutput_1.setNull(14, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(14, row11.nb_interactions);
}

                        if(row11.delai_resolution_moyen == null) {
pstmtUpdate_tDBOutput_1.setNull(15, java.sql.Types.DOUBLE);
} else {pstmtUpdate_tDBOutput_1.setDouble(15, row11.delai_resolution_moyen);
}

                        if(row11.duree_inact_connexion_sec == null) {
pstmtUpdate_tDBOutput_1.setNull(16, java.sql.Types.DOUBLE);
} else {pstmtUpdate_tDBOutput_1.setDouble(16, row11.duree_inact_connexion_sec);
}

                        if(row11.churn == null) {
pstmtUpdate_tDBOutput_1.setNull(17, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(17, row11.churn);
}

                        if(row11.id_client == null) {
pstmtUpdate_tDBOutput_1.setNull(18 + count_tDBOutput_1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(18 + count_tDBOutput_1, row11.id_client);
}

                        if(row11.id_date_fk == null) {
pstmtUpdate_tDBOutput_1.setNull(19 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(19 + count_tDBOutput_1, row11.id_date_fk);
}

                try {
					
                    int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1.executeUpdate();
                    updatedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_1 = true;
                        nb_line_tDBOutput_1++;
                            System.err.print(e.getMessage());
                }
            } else {
                        if(row11.id_client == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(1, row11.id_client);
}

                        if(row11.id_transaction_pk == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(2, row11.id_transaction_pk);
}

                        if(row11.id_interaction_pk == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(3, row11.id_interaction_pk);
}

                        if(row11.id_reclamation_pk == null) {
pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(4, row11.id_reclamation_pk);
}

                        if(row11.id_date_fk == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(5, row11.id_date_fk);
}

                        if(row11.anciennete_mois == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(6, row11.anciennete_mois);
}

                        if(row11.score_risque_interne == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(7, row11.score_risque_interne);
}

                        if(row11.nb_produits_actifs == null) {
pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(8, row11.nb_produits_actifs);
}

                        if(row11.revenu_mensuel == null) {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.DOUBLE);
} else {pstmtInsert_tDBOutput_1.setDouble(9, row11.revenu_mensuel);
}

                        if(row11.solde_moy == null) {
pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.DOUBLE);
} else {pstmtInsert_tDBOutput_1.setDouble(10, row11.solde_moy);
}

                        if(row11.monte_mensuel == null) {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.DOUBLE);
} else {pstmtInsert_tDBOutput_1.setDouble(11, row11.monte_mensuel);
}

                        if(row11.nb_rejet == null) {
pstmtInsert_tDBOutput_1.setNull(12, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(12, row11.nb_rejet);
}

                        if(row11.nb_transactions == null) {
pstmtInsert_tDBOutput_1.setNull(13, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(13, row11.nb_transactions);
}

                        if(row11.nb_reclamations == null) {
pstmtInsert_tDBOutput_1.setNull(14, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(14, row11.nb_reclamations);
}

                        if(row11.nb_interactions == null) {
pstmtInsert_tDBOutput_1.setNull(15, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(15, row11.nb_interactions);
}

                        if(row11.delai_resolution_moyen == null) {
pstmtInsert_tDBOutput_1.setNull(16, java.sql.Types.DOUBLE);
} else {pstmtInsert_tDBOutput_1.setDouble(16, row11.delai_resolution_moyen);
}

                        if(row11.duree_inact_connexion_sec == null) {
pstmtInsert_tDBOutput_1.setNull(17, java.sql.Types.DOUBLE);
} else {pstmtInsert_tDBOutput_1.setDouble(17, row11.duree_inact_connexion_sec);
}

                        if(row11.churn == null) {
pstmtInsert_tDBOutput_1.setNull(18, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(18, row11.churn);
}

                try {
					
                    int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
                    insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_1 = true;
                        nb_line_tDBOutput_1++;
                            System.err.print(e.getMessage());
                }
            }
    		    commitCounter_tDBOutput_1++;
                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    	
                    }
                    conn_tDBOutput_1.commit();
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_1 = 0;
                    }
                    commitCounter_tDBOutput_1=0;
                }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */

} // End of branch "fact"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
	if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
		
			conn_tDBInput_1.commit();
			
		
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row8 != null) {
						tHash_Lookup_row8.endGet();
					}
					globalMap.remove( "tHash_Lookup_row8" );

					
					
				
					if(tHash_Lookup_row7 != null) {
						tHash_Lookup_row7.endGet();
					}
					globalMap.remove( "tHash_Lookup_row7" );

					
					
				
					if(tHash_Lookup_row9 != null) {
						tHash_Lookup_row9.endGet();
					}
					globalMap.remove( "tHash_Lookup_row9" );

					
					
				
					if(tHash_Lookup_row4 != null) {
						tHash_Lookup_row4.endGet();
					}
					globalMap.remove( "tHash_Lookup_row4" );

					
					
				
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
					if(tHash_Lookup_row10 != null) {
						tHash_Lookup_row10.endGet();
					}
					globalMap.remove( "tHash_Lookup_row10" );

					
					
				
					if(tHash_Lookup_row5 != null) {
						tHash_Lookup_row5.endGet();
					}
					globalMap.remove( "tHash_Lookup_row5" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	


//////
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fact");
			  	}
			  	
 

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




/**
 * [tLogRow_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



        if(pstmtUpdate_tDBOutput_1 != null){
            pstmtUpdate_tDBOutput_1.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_1");
        }
        if(pstmtInsert_tDBOutput_1 != null){
            pstmtInsert_tDBOutput_1.close();
            resourceMap.remove("pstmtInsert_tDBOutput_1");
        }
        if(pstmt_tDBOutput_1 != null) {
            pstmt_tDBOutput_1.close();
            resourceMap.remove("pstmt_tDBOutput_1");
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);
			if(rowsToCommitCount_tDBOutput_1 != 0){
				
			}
			conn_tDBOutput_1.commit();
			if(rowsToCommitCount_tDBOutput_1 != 0){
				
				rowsToCommitCount_tDBOutput_1 = 0;
			}
			commitCounter_tDBOutput_1 = 0;
		
    	conn_tDBOutput_1 .close();
    	
    	resourceMap.put("finish_tDBOutput_1", true);
    	

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row11");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */









				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row4"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row7"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row8"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row9"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row10"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row5"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_1 = null;
                if ((pstmtUpdateToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_1")) != null) {
                    pstmtUpdateToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_1 = null;
                if ((pstmtInsertToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_1")) != null) {
                    pstmtInsertToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */









				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_client_sk;

				public int getId_client_sk () {
					return this.id_client_sk;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public int id_produit_fk;

				public int getId_produit_fk () {
					return this.id_produit_fk;
				}
				
			    public int id_profil_fk;

				public int getId_profil_fk () {
					return this.id_profil_fk;
				}
				
			    public int id_financier_fk;

				public int getId_financier_fk () {
					return this.id_financier_fk;
				}
				
			    public int id_digital_fk;

				public int getId_digital_fk () {
					return this.id_digital_fk;
				}
				
			    public String sexe;

				public String getSexe () {
					return this.sexe;
				}
				
			    public java.util.Date date_naissance;

				public java.util.Date getDate_naissance () {
					return this.date_naissance;
				}
				
			    public Long anciennete_mois;

				public Long getAnciennete_mois () {
					return this.anciennete_mois;
				}
				
			    public Long score_risque_interne;

				public Long getScore_risque_interne () {
					return this.score_risque_interne;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row4Struct other = (row4Struct) obj;
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.id_client_sk = this.id_client_sk;
	            other.id_client = this.id_client;
	            other.id_produit_fk = this.id_produit_fk;
	            other.id_profil_fk = this.id_profil_fk;
	            other.id_financier_fk = this.id_financier_fk;
	            other.id_digital_fk = this.id_digital_fk;
	            other.sexe = this.sexe;
	            other.date_naissance = this.date_naissance;
	            other.anciennete_mois = this.anciennete_mois;
	            other.score_risque_interne = this.score_risque_interne;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.id_client = this.id_client;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.id_client_sk = dis.readInt();
					
			            this.id_produit_fk = dis.readInt();
					
			            this.id_profil_fk = dis.readInt();
					
			            this.id_financier_fk = dis.readInt();
					
			            this.id_digital_fk = dis.readInt();
					
						this.sexe = readString(dis,ois);
					
						this.date_naissance = readDate(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.id_client_sk = objectIn.readInt();
					
			            this.id_produit_fk = objectIn.readInt();
					
			            this.id_profil_fk = objectIn.readInt();
					
			            this.id_financier_fk = objectIn.readInt();
					
			            this.id_digital_fk = objectIn.readInt();
					
						this.sexe = readString(dis,objectIn);
					
						this.date_naissance = readDate(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.anciennete_mois = null;
           				} else {
           			    	this.anciennete_mois = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.score_risque_interne = null;
           				} else {
           			    	this.score_risque_interne = objectIn.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.id_client_sk);
					
		            	dos.writeInt(this.id_produit_fk);
					
		            	dos.writeInt(this.id_profil_fk);
					
		            	dos.writeInt(this.id_financier_fk);
					
		            	dos.writeInt(this.id_digital_fk);
					
						writeString(this.sexe, dos, oos);
					
						writeDate(this.date_naissance, dos, oos);
					
						if(this.anciennete_mois == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.anciennete_mois);
		            	}
					
						if(this.score_risque_interne == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.score_risque_interne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.id_client_sk);
					
					objectOut.writeInt(this.id_produit_fk);
					
					objectOut.writeInt(this.id_profil_fk);
					
					objectOut.writeInt(this.id_financier_fk);
					
					objectOut.writeInt(this.id_digital_fk);
					
						writeString(this.sexe, dos, objectOut);
					
						writeDate(this.date_naissance, dos, objectOut);
					
						if(this.anciennete_mois == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.anciennete_mois);
		            	}
					
						if(this.score_risque_interne == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.score_risque_interne);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_client_sk="+String.valueOf(id_client_sk));
		sb.append(",id_client="+id_client);
		sb.append(",id_produit_fk="+String.valueOf(id_produit_fk));
		sb.append(",id_profil_fk="+String.valueOf(id_profil_fk));
		sb.append(",id_financier_fk="+String.valueOf(id_financier_fk));
		sb.append(",id_digital_fk="+String.valueOf(id_digital_fk));
		sb.append(",sexe="+sexe);
		sb.append(",date_naissance="+String.valueOf(date_naissance));
		sb.append(",anciennete_mois="+String.valueOf(anciennete_mois));
		sb.append(",score_risque_interne="+String.valueOf(score_risque_interne));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row4Struct row4 = new row4Struct();




	
	/**
	 * [tAdvancedHash_row4 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row4", false);
		start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tAdvancedHash_row4 = 0;
		

			   		// connection name:row4
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row4,row7,row8,row9,row3,row10,row5) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row4Struct>getLookup(matchingModeEnum_row4);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row4 begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";

	
		int tos_count_tDBInput_3 = 0;
		
	
    
	
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = context.username;
				
				
	final String decryptedPassword_tDBInput_3 = context.password; 
				
				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;
				
				String url_tDBInput_3 = "jdbc:postgresql://" + context.host + ":" + context.port + "/" + context.database + "?" + context.params;
				
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3,dbUser_tDBInput_3,dbPwd_tDBInput_3);
		        
				conn_tDBInput_3.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT \n  \"DWH_ATTEJARI\".\"DIM_CLIENT\".\"id_client_sk\", \n  \"DWH_ATTEJARI\".\"DIM_CLIENT\".\"id_client\", \n  \"DWH_"
+"ATTEJARI\".\"DIM_CLIENT\".\"id_produit_fk\", \n  \"DWH_ATTEJARI\".\"DIM_CLIENT\".\"id_profil_fk\", \n  \"DWH_ATTEJARI\".\""
+"DIM_CLIENT\".\"id_financier_fk\", \n  \"DWH_ATTEJARI\".\"DIM_CLIENT\".\"id_digital_fk\", \n  \"DWH_ATTEJARI\".\"DIM_CLIENT"
+"\".\"sexe\", \n  \"DWH_ATTEJARI\".\"DIM_CLIENT\".\"date_naissance\", \n  \"DWH_ATTEJARI\".\"DIM_CLIENT\".\"anciennete_mois"
+"\", \n  \"DWH_ATTEJARI\".\"DIM_CLIENT\".\"score_risque_interne\"\nFROM \"DWH_ATTEJARI\".\"DIM_CLIENT\"";
		    

            	globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);
		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								row4.id_client_sk = 0;
							} else {
		                          
            row4.id_client_sk = rs_tDBInput_3.getInt(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row4.id_client = null;
							} else {
	                         		
        	row4.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row4.id_produit_fk = 0;
							} else {
		                          
            row4.id_produit_fk = rs_tDBInput_3.getInt(3);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row4.id_profil_fk = 0;
							} else {
		                          
            row4.id_profil_fk = rs_tDBInput_3.getInt(4);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								row4.id_financier_fk = 0;
							} else {
		                          
            row4.id_financier_fk = rs_tDBInput_3.getInt(5);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								row4.id_digital_fk = 0;
							} else {
		                          
            row4.id_digital_fk = rs_tDBInput_3.getInt(6);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 7) {
								row4.sexe = null;
							} else {
	                         		
        	row4.sexe = routines.system.JDBCUtil.getString(rs_tDBInput_3, 7, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 8) {
								row4.date_naissance = null;
							} else {
										
			row4.date_naissance = routines.system.JDBCUtil.getDate(rs_tDBInput_3, 8);
		                    }
							if(colQtyInRs_tDBInput_3 < 9) {
								row4.anciennete_mois = null;
							} else {
		                          
            row4.anciennete_mois = rs_tDBInput_3.getLong(9);
            if(rs_tDBInput_3.wasNull()){
                    row4.anciennete_mois = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 10) {
								row4.score_risque_interne = null;
							} else {
		                          
            row4.score_risque_interne = rs_tDBInput_3.getLong(10);
            if(rs_tDBInput_3.wasNull()){
                    row4.score_risque_interne = null;
            }
		                    }
					


 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					


			   
			   

					row4Struct row4_HashRow = new row4Struct();
		   	   	   
				
				row4_HashRow.id_client_sk = row4.id_client_sk;
				
				row4_HashRow.id_client = row4.id_client;
				
				row4_HashRow.id_produit_fk = row4.id_produit_fk;
				
				row4_HashRow.id_profil_fk = row4.id_profil_fk;
				
				row4_HashRow.id_financier_fk = row4.id_financier_fk;
				
				row4_HashRow.id_digital_fk = row4.id_digital_fk;
				
				row4_HashRow.sexe = row4.sexe;
				
				row4_HashRow.date_naissance = row4.date_naissance;
				
				row4_HashRow.anciennete_mois = row4.anciennete_mois;
				
				row4_HashRow.score_risque_interne = row4.score_risque_interne;
				
			tHash_Lookup_row4.put(row4_HashRow);
			
            




 


	tos_count_tAdvancedHash_row4++;

/**
 * [tAdvancedHash_row4 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
	if(conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {
		
			conn_tDBInput_3.commit();
			
		
			conn_tDBInput_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);
 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

tHash_Lookup_row4.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row4", true);
end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());




/**
 * [tAdvancedHash_row4 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class row7Struct implements routines.system.IPersistableComparableLookupRow<row7Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_intr_sk;

				public int getId_intr_sk () {
					return this.id_intr_sk;
				}
				
			    public String id_interaction;

				public String getId_interaction () {
					return this.id_interaction;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public java.util.Date date_interaction;

				public java.util.Date getDate_interaction () {
					return this.date_interaction;
				}
				
			    public String score_satisfaction_nps;

				public String getScore_satisfaction_nps () {
					return this.score_satisfaction_nps;
				}
				
			    public Long duree_connexion_sec;

				public Long getDuree_connexion_sec () {
					return this.duree_connexion_sec;
				}
				
			    public int id_canal_intr;

				public int getId_canal_intr () {
					return this.id_canal_intr;
				}
				
			    public int id_type_intr_sk;

				public int getId_type_intr_sk () {
					return this.id_type_intr_sk;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row7Struct other = (row7Struct) obj;
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row7Struct other) {

		other.id_intr_sk = this.id_intr_sk;
	            other.id_interaction = this.id_interaction;
	            other.id_client = this.id_client;
	            other.date_interaction = this.date_interaction;
	            other.score_satisfaction_nps = this.score_satisfaction_nps;
	            other.duree_connexion_sec = this.duree_connexion_sec;
	            other.id_canal_intr = this.id_canal_intr;
	            other.id_type_intr_sk = this.id_type_intr_sk;
	            
	}

	public void copyKeysDataTo(row7Struct other) {

		other.id_client = this.id_client;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.id_intr_sk = dis.readInt();
					
						this.id_interaction = readString(dis,ois);
					
						this.date_interaction = readDate(dis,ois);
					
						this.score_satisfaction_nps = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_connexion_sec = null;
           				} else {
           			    	this.duree_connexion_sec = dis.readLong();
           				}
					
			            this.id_canal_intr = dis.readInt();
					
			            this.id_type_intr_sk = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.id_intr_sk = objectIn.readInt();
					
						this.id_interaction = readString(dis,objectIn);
					
						this.date_interaction = readDate(dis,objectIn);
					
						this.score_satisfaction_nps = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.duree_connexion_sec = null;
           				} else {
           			    	this.duree_connexion_sec = objectIn.readLong();
           				}
					
			            this.id_canal_intr = objectIn.readInt();
					
			            this.id_type_intr_sk = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.id_intr_sk);
					
						writeString(this.id_interaction, dos, oos);
					
						writeDate(this.date_interaction, dos, oos);
					
						writeString(this.score_satisfaction_nps, dos, oos);
					
						if(this.duree_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.duree_connexion_sec);
		            	}
					
		            	dos.writeInt(this.id_canal_intr);
					
		            	dos.writeInt(this.id_type_intr_sk);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.id_intr_sk);
					
						writeString(this.id_interaction, dos, objectOut);
					
						writeDate(this.date_interaction, dos, objectOut);
					
						writeString(this.score_satisfaction_nps, dos, objectOut);
					
						if(this.duree_connexion_sec == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.duree_connexion_sec);
		            	}
					
					objectOut.writeInt(this.id_canal_intr);
					
					objectOut.writeInt(this.id_type_intr_sk);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_intr_sk="+String.valueOf(id_intr_sk));
		sb.append(",id_interaction="+id_interaction);
		sb.append(",id_client="+id_client);
		sb.append(",date_interaction="+String.valueOf(date_interaction));
		sb.append(",score_satisfaction_nps="+score_satisfaction_nps);
		sb.append(",duree_connexion_sec="+String.valueOf(duree_connexion_sec));
		sb.append(",id_canal_intr="+String.valueOf(id_canal_intr));
		sb.append(",id_type_intr_sk="+String.valueOf(id_type_intr_sk));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row7Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row7Struct row7 = new row7Struct();




	
	/**
	 * [tAdvancedHash_row7 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row7", false);
		start_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row7";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row7");
					}
				
		int tos_count_tAdvancedHash_row7 = 0;
		

			   		// connection name:row7
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(row7,row7) | target node:tAdvancedHash_row7 - inputs:(row7) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row4,row7,row8,row9,row3,row10,row5) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row7 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row7Struct>getLookup(matchingModeEnum_row7);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row7", tHash_Lookup_row7);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row7 begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";

	
		int tos_count_tDBInput_4 = 0;
		
	
    
	
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = context.username;
				
				
	final String decryptedPassword_tDBInput_4 = context.password; 
				
				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;
				
				String url_tDBInput_4 = "jdbc:postgresql://" + context.host + ":" + context.port + "/" + context.database + "?" + context.params;
				
				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4,dbUser_tDBInput_4,dbPwd_tDBInput_4);
		        
				conn_tDBInput_4.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "SELECT \n  \"DWH_ATTEJARI\".\"DIM_INTERACTION\".\"id_intr_sk\", \n  \"DWH_ATTEJARI\".\"DIM_INTERACTION\".\"id_interaction"
+"\", \n  \"DWH_ATTEJARI\".\"DIM_INTERACTION\".\"id_client\", \n  \"DWH_ATTEJARI\".\"DIM_INTERACTION\".\"date_interaction\","
+" \n  \"DWH_ATTEJARI\".\"DIM_INTERACTION\".\"score_satisfaction_nps\", \n  \"DWH_ATTEJARI\".\"DIM_INTERACTION\".\"duree_con"
+"nexion_sec\", \n  \"DWH_ATTEJARI\".\"DIM_INTERACTION\".\"id_canal_intr\", \n  \"DWH_ATTEJARI\".\"DIM_INTERACTION\".\"id_ty"
+"pe_intr_pk\"\nFROM \"DWH_ATTEJARI\".\"DIM_INTERACTION\"";
		    

            	globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);
		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								row7.id_intr_sk = 0;
							} else {
		                          
            row7.id_intr_sk = rs_tDBInput_4.getInt(1);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row7.id_interaction = null;
							} else {
	                         		
        	row7.id_interaction = routines.system.JDBCUtil.getString(rs_tDBInput_4, 2, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								row7.id_client = null;
							} else {
	                         		
        	row7.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_4, 3, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								row7.date_interaction = null;
							} else {
										
			row7.date_interaction = routines.system.JDBCUtil.getDate(rs_tDBInput_4, 4);
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								row7.score_satisfaction_nps = null;
							} else {
	                         		
        	row7.score_satisfaction_nps = routines.system.JDBCUtil.getString(rs_tDBInput_4, 5, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 6) {
								row7.duree_connexion_sec = null;
							} else {
		                          
            row7.duree_connexion_sec = rs_tDBInput_4.getLong(6);
            if(rs_tDBInput_4.wasNull()){
                    row7.duree_connexion_sec = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 7) {
								row7.id_canal_intr = 0;
							} else {
		                          
            row7.id_canal_intr = rs_tDBInput_4.getInt(7);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 8) {
								row7.id_type_intr_sk = 0;
							} else {
		                          
            row7.id_type_intr_sk = rs_tDBInput_4.getInt(8);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					


 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row7"
						
						);
					}
					


			   
			   

					row7Struct row7_HashRow = new row7Struct();
		   	   	   
				
				row7_HashRow.id_intr_sk = row7.id_intr_sk;
				
				row7_HashRow.id_interaction = row7.id_interaction;
				
				row7_HashRow.id_client = row7.id_client;
				
				row7_HashRow.date_interaction = row7.date_interaction;
				
				row7_HashRow.score_satisfaction_nps = row7.score_satisfaction_nps;
				
				row7_HashRow.duree_connexion_sec = row7.duree_connexion_sec;
				
				row7_HashRow.id_canal_intr = row7.id_canal_intr;
				
				row7_HashRow.id_type_intr_sk = row7.id_type_intr_sk;
				
			tHash_Lookup_row7.put(row7_HashRow);
			
            




 


	tos_count_tAdvancedHash_row7++;

/**
 * [tAdvancedHash_row7 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row7 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
	if(conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {
		
			conn_tDBInput_4.commit();
			
		
			conn_tDBInput_4.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);
 

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

tHash_Lookup_row7.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row7");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row7", true);
end_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());




/**
 * [tAdvancedHash_row7 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class row8Struct implements routines.system.IPersistableComparableLookupRow<row8Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer id_dim_tx_sk;

				public Integer getId_dim_tx_sk () {
					return this.id_dim_tx_sk;
				}
				
			    public String id_transaction;

				public String getId_transaction () {
					return this.id_transaction;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public Integer id_canal_tx_fk;

				public Integer getId_canal_tx_fk () {
					return this.id_canal_tx_fk;
				}
				
			    public Integer id_sensOper_tx_fk;

				public Integer getId_sensOper_tx_fk () {
					return this.id_sensOper_tx_fk;
				}
				
			    public Integer id_operation_tx_fk;

				public Integer getId_operation_tx_fk () {
					return this.id_operation_tx_fk;
				}
				
			    public java.util.Date date_transaction;

				public java.util.Date getDate_transaction () {
					return this.date_transaction;
				}
				
			    public Double montant;

				public Double getMontant () {
					return this.montant;
				}
				
			    public Long est_rejete;

				public Long getEst_rejete () {
					return this.est_rejete;
				}
				
			    public Double solde_apres_operation;

				public Double getSolde_apres_operation () {
					return this.solde_apres_operation;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row8Struct other = (row8Struct) obj;
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row8Struct other) {

		other.id_dim_tx_sk = this.id_dim_tx_sk;
	            other.id_transaction = this.id_transaction;
	            other.id_client = this.id_client;
	            other.id_canal_tx_fk = this.id_canal_tx_fk;
	            other.id_sensOper_tx_fk = this.id_sensOper_tx_fk;
	            other.id_operation_tx_fk = this.id_operation_tx_fk;
	            other.date_transaction = this.date_transaction;
	            other.montant = this.montant;
	            other.est_rejete = this.est_rejete;
	            other.solde_apres_operation = this.solde_apres_operation;
	            
	}

	public void copyKeysDataTo(row8Struct other) {

		other.id_client = this.id_client;
	            	
	}



	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.id_dim_tx_sk = readInteger(dis,ois);
					
						this.id_transaction = readString(dis,ois);
					
						this.id_canal_tx_fk = readInteger(dis,ois);
					
						this.id_sensOper_tx_fk = readInteger(dis,ois);
					
						this.id_operation_tx_fk = readInteger(dis,ois);
					
						this.date_transaction = readDate(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant = null;
           				} else {
           			    	this.montant = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_rejete = null;
           				} else {
           			    	this.est_rejete = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_apres_operation = null;
           				} else {
           			    	this.solde_apres_operation = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.id_dim_tx_sk = readInteger(dis,objectIn);
					
						this.id_transaction = readString(dis,objectIn);
					
						this.id_canal_tx_fk = readInteger(dis,objectIn);
					
						this.id_sensOper_tx_fk = readInteger(dis,objectIn);
					
						this.id_operation_tx_fk = readInteger(dis,objectIn);
					
						this.date_transaction = readDate(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.montant = null;
           				} else {
           			    	this.montant = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.est_rejete = null;
           				} else {
           			    	this.est_rejete = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.solde_apres_operation = null;
           				} else {
           			    	this.solde_apres_operation = objectIn.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
					writeInteger(this.id_dim_tx_sk, dos, oos);
					
						writeString(this.id_transaction, dos, oos);
					
					writeInteger(this.id_canal_tx_fk, dos, oos);
					
					writeInteger(this.id_sensOper_tx_fk, dos, oos);
					
					writeInteger(this.id_operation_tx_fk, dos, oos);
					
						writeDate(this.date_transaction, dos, oos);
					
						if(this.montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.montant);
		            	}
					
						if(this.est_rejete == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_rejete);
		            	}
					
						if(this.solde_apres_operation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_apres_operation);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					writeInteger(this.id_dim_tx_sk, dos, objectOut);
					
						writeString(this.id_transaction, dos, objectOut);
					
					writeInteger(this.id_canal_tx_fk, dos, objectOut);
					
					writeInteger(this.id_sensOper_tx_fk, dos, objectOut);
					
					writeInteger(this.id_operation_tx_fk, dos, objectOut);
					
						writeDate(this.date_transaction, dos, objectOut);
					
						if(this.montant == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.montant);
		            	}
					
						if(this.est_rejete == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.est_rejete);
		            	}
					
						if(this.solde_apres_operation == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.solde_apres_operation);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_dim_tx_sk="+String.valueOf(id_dim_tx_sk));
		sb.append(",id_transaction="+id_transaction);
		sb.append(",id_client="+id_client);
		sb.append(",id_canal_tx_fk="+String.valueOf(id_canal_tx_fk));
		sb.append(",id_sensOper_tx_fk="+String.valueOf(id_sensOper_tx_fk));
		sb.append(",id_operation_tx_fk="+String.valueOf(id_operation_tx_fk));
		sb.append(",date_transaction="+String.valueOf(date_transaction));
		sb.append(",montant="+String.valueOf(montant));
		sb.append(",est_rejete="+String.valueOf(est_rejete));
		sb.append(",solde_apres_operation="+String.valueOf(solde_apres_operation));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row8Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row8Struct row8 = new row8Struct();




	
	/**
	 * [tAdvancedHash_row8 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row8", false);
		start_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row8";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row8");
					}
				
		int tos_count_tAdvancedHash_row8 = 0;
		

			   		// connection name:row8
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(row8,row8) | target node:tAdvancedHash_row8 - inputs:(row8) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row4,row7,row8,row9,row3,row10,row5) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row8 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row8Struct>getLookup(matchingModeEnum_row8);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row8", tHash_Lookup_row8);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row8 begin ] stop
 */



	
	/**
	 * [tDBInput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_5", false);
		start_Hash.put("tDBInput_5", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_5";

	
		int tos_count_tDBInput_5 = 0;
		
	
    
	
		    int nb_line_tDBInput_5 = 0;
		    java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = context.username;
				
				
	final String decryptedPassword_tDBInput_5 = context.password; 
				
				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;
				
				String url_tDBInput_5 = "jdbc:postgresql://" + context.host + ":" + context.port + "/" + context.database + "?" + context.params;
				
				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5,dbUser_tDBInput_5,dbPwd_tDBInput_5);
		        
				conn_tDBInput_5.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

		    String dbquery_tDBInput_5 = "SELECT \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"id_dim_tx_sk\", \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"id_transacti"
+"on\", \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"id_client\", \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"id_canal_tx_fk\","
+" \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"id_sens_oper_tx_fk\", \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"id_operation_"
+"tx_fk\", \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"date_transaction\", \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"montant"
+"\", \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"est_rejete\", \n  \"DWH_ATTEJARI\".\"DIM_TRANSACTION\".\"solde_apres_operat"
+"ion\"\nFROM \"DWH_ATTEJARI\".\"DIM_TRANSACTION\"";
		    

            	globalMap.put("tDBInput_5_QUERY",dbquery_tDBInput_5);
		    java.sql.ResultSet rs_tDBInput_5 = null;

		    try {
		    	rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
		    	int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

		    String tmpContent_tDBInput_5 = null;
		    
		    
		    while (rs_tDBInput_5.next()) {
		        nb_line_tDBInput_5++;
		        
							if(colQtyInRs_tDBInput_5 < 1) {
								row8.id_dim_tx_sk = null;
							} else {
		                          
            row8.id_dim_tx_sk = rs_tDBInput_5.getInt(1);
            if(rs_tDBInput_5.wasNull()){
                    row8.id_dim_tx_sk = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								row8.id_transaction = null;
							} else {
	                         		
        	row8.id_transaction = routines.system.JDBCUtil.getString(rs_tDBInput_5, 2, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 3) {
								row8.id_client = null;
							} else {
	                         		
        	row8.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_5, 3, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 4) {
								row8.id_canal_tx_fk = null;
							} else {
		                          
            row8.id_canal_tx_fk = rs_tDBInput_5.getInt(4);
            if(rs_tDBInput_5.wasNull()){
                    row8.id_canal_tx_fk = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 5) {
								row8.id_sensOper_tx_fk = null;
							} else {
		                          
            row8.id_sensOper_tx_fk = rs_tDBInput_5.getInt(5);
            if(rs_tDBInput_5.wasNull()){
                    row8.id_sensOper_tx_fk = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 6) {
								row8.id_operation_tx_fk = null;
							} else {
		                          
            row8.id_operation_tx_fk = rs_tDBInput_5.getInt(6);
            if(rs_tDBInput_5.wasNull()){
                    row8.id_operation_tx_fk = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 7) {
								row8.date_transaction = null;
							} else {
										
			row8.date_transaction = routines.system.JDBCUtil.getDate(rs_tDBInput_5, 7);
		                    }
							if(colQtyInRs_tDBInput_5 < 8) {
								row8.montant = null;
							} else {
	                         		
            row8.montant = rs_tDBInput_5.getDouble(8);
            if(rs_tDBInput_5.wasNull()){
                    row8.montant = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 9) {
								row8.est_rejete = null;
							} else {
		                          
            row8.est_rejete = rs_tDBInput_5.getLong(9);
            if(rs_tDBInput_5.wasNull()){
                    row8.est_rejete = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 10) {
								row8.solde_apres_operation = null;
							} else {
	                         		
            row8.solde_apres_operation = rs_tDBInput_5.getDouble(10);
            if(rs_tDBInput_5.wasNull()){
                    row8.solde_apres_operation = null;
            }
		                    }
					


 



/**
 * [tDBInput_5 begin ] stop
 */
	
	/**
	 * [tDBInput_5 main ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 


	tos_count_tDBInput_5++;

/**
 * [tDBInput_5 main ] stop
 */
	
	/**
	 * [tDBInput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row8 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row8"
						
						);
					}
					


			   
			   

					row8Struct row8_HashRow = new row8Struct();
		   	   	   
				
				row8_HashRow.id_dim_tx_sk = row8.id_dim_tx_sk;
				
				row8_HashRow.id_transaction = row8.id_transaction;
				
				row8_HashRow.id_client = row8.id_client;
				
				row8_HashRow.id_canal_tx_fk = row8.id_canal_tx_fk;
				
				row8_HashRow.id_sensOper_tx_fk = row8.id_sensOper_tx_fk;
				
				row8_HashRow.id_operation_tx_fk = row8.id_operation_tx_fk;
				
				row8_HashRow.date_transaction = row8.date_transaction;
				
				row8_HashRow.montant = row8.montant;
				
				row8_HashRow.est_rejete = row8.est_rejete;
				
				row8_HashRow.solde_apres_operation = row8.solde_apres_operation;
				
			tHash_Lookup_row8.put(row8_HashRow);
			
            




 


	tos_count_tAdvancedHash_row8++;

/**
 * [tAdvancedHash_row8 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

 



/**
 * [tAdvancedHash_row8 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row8 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

 



/**
 * [tAdvancedHash_row8 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_5 end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

	}
}finally{
	if (rs_tDBInput_5 != null) {
		rs_tDBInput_5.close();
	}
	if (stmt_tDBInput_5 != null) {
		stmt_tDBInput_5.close();
	}
	if(conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {
		
			conn_tDBInput_5.commit();
			
		
			conn_tDBInput_5.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_5_NB_LINE",nb_line_tDBInput_5);
 

ok_Hash.put("tDBInput_5", true);
end_Hash.put("tDBInput_5", System.currentTimeMillis());




/**
 * [tDBInput_5 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row8 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

tHash_Lookup_row8.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row8");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row8", true);
end_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());




/**
 * [tAdvancedHash_row8 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_5 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row8 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

 



/**
 * [tAdvancedHash_row8 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}
	


public static class row9Struct implements routines.system.IPersistableComparableLookupRow<row9Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_reclamation_sk;

				public int getId_reclamation_sk () {
					return this.id_reclamation_sk;
				}
				
			    public int id_motif_recla_fk;

				public int getId_motif_recla_fk () {
					return this.id_motif_recla_fk;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public Long est_reclamation;

				public Long getEst_reclamation () {
					return this.est_reclamation;
				}
				
			    public String delai_resolution_jours;

				public String getDelai_resolution_jours () {
					return this.delai_resolution_jours;
				}
				
			    public int id_status_recl_fk;

				public int getId_status_recl_fk () {
					return this.id_status_recl_fk;
				}
				
			    public String id_interaction;

				public String getId_interaction () {
					return this.id_interaction;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row9Struct other = (row9Struct) obj;
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row9Struct other) {

		other.id_reclamation_sk = this.id_reclamation_sk;
	            other.id_motif_recla_fk = this.id_motif_recla_fk;
	            other.id_client = this.id_client;
	            other.est_reclamation = this.est_reclamation;
	            other.delai_resolution_jours = this.delai_resolution_jours;
	            other.id_status_recl_fk = this.id_status_recl_fk;
	            other.id_interaction = this.id_interaction;
	            
	}

	public void copyKeysDataTo(row9Struct other) {

		other.id_client = this.id_client;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.id_reclamation_sk = dis.readInt();
					
			            this.id_motif_recla_fk = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
						this.delai_resolution_jours = readString(dis,ois);
					
			            this.id_status_recl_fk = dis.readInt();
					
						this.id_interaction = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.id_reclamation_sk = objectIn.readInt();
					
			            this.id_motif_recla_fk = objectIn.readInt();
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = objectIn.readLong();
           				}
					
						this.delai_resolution_jours = readString(dis,objectIn);
					
			            this.id_status_recl_fk = objectIn.readInt();
					
						this.id_interaction = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.id_reclamation_sk);
					
		            	dos.writeInt(this.id_motif_recla_fk);
					
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
						writeString(this.delai_resolution_jours, dos, oos);
					
		            	dos.writeInt(this.id_status_recl_fk);
					
						writeString(this.id_interaction, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.id_reclamation_sk);
					
					objectOut.writeInt(this.id_motif_recla_fk);
					
						if(this.est_reclamation == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.est_reclamation);
		            	}
					
						writeString(this.delai_resolution_jours, dos, objectOut);
					
					objectOut.writeInt(this.id_status_recl_fk);
					
						writeString(this.id_interaction, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_reclamation_sk="+String.valueOf(id_reclamation_sk));
		sb.append(",id_motif_recla_fk="+String.valueOf(id_motif_recla_fk));
		sb.append(",id_client="+id_client);
		sb.append(",est_reclamation="+String.valueOf(est_reclamation));
		sb.append(",delai_resolution_jours="+delai_resolution_jours);
		sb.append(",id_status_recl_fk="+String.valueOf(id_status_recl_fk));
		sb.append(",id_interaction="+id_interaction);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row9Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_6_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row9Struct row9 = new row9Struct();




	
	/**
	 * [tAdvancedHash_row9 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row9", false);
		start_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row9";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row9");
					}
				
		int tos_count_tAdvancedHash_row9 = 0;
		

			   		// connection name:row9
			   		// source node:tDBInput_6 - inputs:(after_tDBInput_1) outputs:(row9,row9) | target node:tAdvancedHash_row9 - inputs:(row9) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row4,row7,row8,row9,row3,row10,row5) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row9 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row9Struct>getLookup(matchingModeEnum_row9);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row9", tHash_Lookup_row9);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row9 begin ] stop
 */



	
	/**
	 * [tDBInput_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_6", false);
		start_Hash.put("tDBInput_6", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_6";

	
		int tos_count_tDBInput_6 = 0;
		
	
    
	
		    int nb_line_tDBInput_6 = 0;
		    java.sql.Connection conn_tDBInput_6 = null;
				String driverClass_tDBInput_6 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_6 = java.lang.Class.forName(driverClass_tDBInput_6);
				String dbUser_tDBInput_6 = context.username;
				
				
	final String decryptedPassword_tDBInput_6 = context.password; 
				
				String dbPwd_tDBInput_6 = decryptedPassword_tDBInput_6;
				
				String url_tDBInput_6 = "jdbc:postgresql://" + context.host + ":" + context.port + "/" + context.database + "?" + context.params;
				
				conn_tDBInput_6 = java.sql.DriverManager.getConnection(url_tDBInput_6,dbUser_tDBInput_6,dbPwd_tDBInput_6);
		        
				conn_tDBInput_6.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_6 = conn_tDBInput_6.createStatement();

		    String dbquery_tDBInput_6 = "SELECT \n  \"DWH_ATTEJARI\".\"DIM_RECLAMATION\".\"id_reclamation_sk\", \n  \"DWH_ATTEJARI\".\"DIM_RECLAMATION\".\"id_moti"
+"f_recla_fk\", \n  \"DWH_ATTEJARI\".\"DIM_RECLAMATION\".\"id_client\", \n  \"DWH_ATTEJARI\".\"DIM_RECLAMATION\".\"est_recla"
+"mation\", \n  \"DWH_ATTEJARI\".\"DIM_RECLAMATION\".\"delai_resolution_jours\", \n  \"DWH_ATTEJARI\".\"DIM_RECLAMATION\".\""
+"id_status_recl_fk\", \n  \"DWH_ATTEJARI\".\"DIM_RECLAMATION\".\"id_interaction\"\nFROM \"DWH_ATTEJARI\".\"DIM_RECLAMATION"
+"\"";
		    

            	globalMap.put("tDBInput_6_QUERY",dbquery_tDBInput_6);
		    java.sql.ResultSet rs_tDBInput_6 = null;

		    try {
		    	rs_tDBInput_6 = stmt_tDBInput_6.executeQuery(dbquery_tDBInput_6);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_6 = rs_tDBInput_6.getMetaData();
		    	int colQtyInRs_tDBInput_6 = rsmd_tDBInput_6.getColumnCount();

		    String tmpContent_tDBInput_6 = null;
		    
		    
		    while (rs_tDBInput_6.next()) {
		        nb_line_tDBInput_6++;
		        
							if(colQtyInRs_tDBInput_6 < 1) {
								row9.id_reclamation_sk = 0;
							} else {
		                          
            row9.id_reclamation_sk = rs_tDBInput_6.getInt(1);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 2) {
								row9.id_motif_recla_fk = 0;
							} else {
		                          
            row9.id_motif_recla_fk = rs_tDBInput_6.getInt(2);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 3) {
								row9.id_client = null;
							} else {
	                         		
        	row9.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_6, 3, false);
		                    }
							if(colQtyInRs_tDBInput_6 < 4) {
								row9.est_reclamation = null;
							} else {
		                          
            row9.est_reclamation = rs_tDBInput_6.getLong(4);
            if(rs_tDBInput_6.wasNull()){
                    row9.est_reclamation = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 5) {
								row9.delai_resolution_jours = null;
							} else {
	                         		
        	row9.delai_resolution_jours = routines.system.JDBCUtil.getString(rs_tDBInput_6, 5, false);
		                    }
							if(colQtyInRs_tDBInput_6 < 6) {
								row9.id_status_recl_fk = 0;
							} else {
		                          
            row9.id_status_recl_fk = rs_tDBInput_6.getInt(6);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 7) {
								row9.id_interaction = null;
							} else {
	                         		
        	row9.id_interaction = routines.system.JDBCUtil.getString(rs_tDBInput_6, 7, false);
		                    }
					


 



/**
 * [tDBInput_6 begin ] stop
 */
	
	/**
	 * [tDBInput_6 main ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 


	tos_count_tDBInput_6++;

/**
 * [tDBInput_6 main ] stop
 */
	
	/**
	 * [tDBInput_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row9 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row9"
						
						);
					}
					


			   
			   

					row9Struct row9_HashRow = new row9Struct();
		   	   	   
				
				row9_HashRow.id_reclamation_sk = row9.id_reclamation_sk;
				
				row9_HashRow.id_motif_recla_fk = row9.id_motif_recla_fk;
				
				row9_HashRow.id_client = row9.id_client;
				
				row9_HashRow.est_reclamation = row9.est_reclamation;
				
				row9_HashRow.delai_resolution_jours = row9.delai_resolution_jours;
				
				row9_HashRow.id_status_recl_fk = row9.id_status_recl_fk;
				
				row9_HashRow.id_interaction = row9.id_interaction;
				
			tHash_Lookup_row9.put(row9_HashRow);
			
            




 


	tos_count_tAdvancedHash_row9++;

/**
 * [tAdvancedHash_row9 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

 



/**
 * [tAdvancedHash_row9 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row9 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

 



/**
 * [tAdvancedHash_row9 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_6 end ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

	}
}finally{
	if (rs_tDBInput_6 != null) {
		rs_tDBInput_6.close();
	}
	if (stmt_tDBInput_6 != null) {
		stmt_tDBInput_6.close();
	}
	if(conn_tDBInput_6 != null && !conn_tDBInput_6.isClosed()) {
		
			conn_tDBInput_6.commit();
			
		
			conn_tDBInput_6.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_6_NB_LINE",nb_line_tDBInput_6);
 

ok_Hash.put("tDBInput_6", true);
end_Hash.put("tDBInput_6", System.currentTimeMillis());




/**
 * [tDBInput_6 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row9 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

tHash_Lookup_row9.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row9");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row9", true);
end_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());




/**
 * [tAdvancedHash_row9 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_6 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row9 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

 



/**
 * [tAdvancedHash_row9 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_6_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_transaction;

				public String getId_transaction () {
					return this.id_transaction;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public java.util.Date date_transaction;

				public java.util.Date getDate_transaction () {
					return this.date_transaction;
				}
				
			    public String type_operation;

				public String getType_operation () {
					return this.type_operation;
				}
				
			    public Double montant;

				public Double getMontant () {
					return this.montant;
				}
				
			    public String sens_operation;

				public String getSens_operation () {
					return this.sens_operation;
				}
				
			    public String canal_transaction;

				public String getCanal_transaction () {
					return this.canal_transaction;
				}
				
			    public Double solde_apres_operation;

				public Double getSolde_apres_operation () {
					return this.solde_apres_operation;
				}
				
			    public Long est_rejete;

				public Long getEst_rejete () {
					return this.est_rejete;
				}
				
			    public String categorie_depense;

				public String getCategorie_depense () {
					return this.categorie_depense;
				}
				
			    public Long nb_transactions;

				public Long getNb_transactions () {
					return this.nb_transactions;
				}
				
			    public Double solde_moy;

				public Double getSolde_moy () {
					return this.solde_moy;
				}
				
			    public Long nb_rejet;

				public Long getNb_rejet () {
					return this.nb_rejet;
				}
				
			    public Double monte_mensuel;

				public Double getMonte_mensuel () {
					return this.monte_mensuel;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row3Struct other = (row3Struct) obj;
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.id_transaction = this.id_transaction;
	            other.id_client = this.id_client;
	            other.date_transaction = this.date_transaction;
	            other.type_operation = this.type_operation;
	            other.montant = this.montant;
	            other.sens_operation = this.sens_operation;
	            other.canal_transaction = this.canal_transaction;
	            other.solde_apres_operation = this.solde_apres_operation;
	            other.est_rejete = this.est_rejete;
	            other.categorie_depense = this.categorie_depense;
	            other.nb_transactions = this.nb_transactions;
	            other.solde_moy = this.solde_moy;
	            other.nb_rejet = this.nb_rejet;
	            other.monte_mensuel = this.monte_mensuel;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.id_client = this.id_client;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.id_transaction = readString(dis,ois);
					
						this.date_transaction = readDate(dis,ois);
					
						this.type_operation = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant = null;
           				} else {
           			    	this.montant = dis.readDouble();
           				}
					
						this.sens_operation = readString(dis,ois);
					
						this.canal_transaction = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_apres_operation = null;
           				} else {
           			    	this.solde_apres_operation = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_rejete = null;
           				} else {
           			    	this.est_rejete = dis.readLong();
           				}
					
						this.categorie_depense = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_transactions = null;
           				} else {
           			    	this.nb_transactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_moy = null;
           				} else {
           			    	this.solde_moy = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_rejet = null;
           				} else {
           			    	this.nb_rejet = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.monte_mensuel = null;
           				} else {
           			    	this.monte_mensuel = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.id_transaction = readString(dis,objectIn);
					
						this.date_transaction = readDate(dis,objectIn);
					
						this.type_operation = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.montant = null;
           				} else {
           			    	this.montant = objectIn.readDouble();
           				}
					
						this.sens_operation = readString(dis,objectIn);
					
						this.canal_transaction = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.solde_apres_operation = null;
           				} else {
           			    	this.solde_apres_operation = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.est_rejete = null;
           				} else {
           			    	this.est_rejete = objectIn.readLong();
           				}
					
						this.categorie_depense = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.nb_transactions = null;
           				} else {
           			    	this.nb_transactions = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.solde_moy = null;
           				} else {
           			    	this.solde_moy = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.nb_rejet = null;
           				} else {
           			    	this.nb_rejet = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.monte_mensuel = null;
           				} else {
           			    	this.monte_mensuel = objectIn.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.id_transaction, dos, oos);
					
						writeDate(this.date_transaction, dos, oos);
					
						writeString(this.type_operation, dos, oos);
					
						if(this.montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.montant);
		            	}
					
						writeString(this.sens_operation, dos, oos);
					
						writeString(this.canal_transaction, dos, oos);
					
						if(this.solde_apres_operation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_apres_operation);
		            	}
					
						if(this.est_rejete == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_rejete);
		            	}
					
						writeString(this.categorie_depense, dos, oos);
					
						if(this.nb_transactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_transactions);
		            	}
					
						if(this.solde_moy == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_moy);
		            	}
					
						if(this.nb_rejet == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_rejet);
		            	}
					
						if(this.monte_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.monte_mensuel);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.id_transaction, dos, objectOut);
					
						writeDate(this.date_transaction, dos, objectOut);
					
						writeString(this.type_operation, dos, objectOut);
					
						if(this.montant == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.montant);
		            	}
					
						writeString(this.sens_operation, dos, objectOut);
					
						writeString(this.canal_transaction, dos, objectOut);
					
						if(this.solde_apres_operation == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.solde_apres_operation);
		            	}
					
						if(this.est_rejete == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.est_rejete);
		            	}
					
						writeString(this.categorie_depense, dos, objectOut);
					
						if(this.nb_transactions == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.nb_transactions);
		            	}
					
						if(this.solde_moy == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.solde_moy);
		            	}
					
						if(this.nb_rejet == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.nb_rejet);
		            	}
					
						if(this.monte_mensuel == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.monte_mensuel);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_transaction="+id_transaction);
		sb.append(",id_client="+id_client);
		sb.append(",date_transaction="+String.valueOf(date_transaction));
		sb.append(",type_operation="+type_operation);
		sb.append(",montant="+String.valueOf(montant));
		sb.append(",sens_operation="+sens_operation);
		sb.append(",canal_transaction="+canal_transaction);
		sb.append(",solde_apres_operation="+String.valueOf(solde_apres_operation));
		sb.append(",est_rejete="+String.valueOf(est_rejete));
		sb.append(",categorie_depense="+categorie_depense);
		sb.append(",nb_transactions="+String.valueOf(nb_transactions));
		sb.append(",solde_moy="+String.valueOf(solde_moy));
		sb.append(",nb_rejet="+String.valueOf(nb_rejet));
		sb.append(",monte_mensuel="+String.valueOf(monte_mensuel));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class OnRowsEndStructtAggregateRow_1 implements routines.system.IPersistableRow<OnRowsEndStructtAggregateRow_1> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_transaction;

				public String getId_transaction () {
					return this.id_transaction;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public java.util.Date date_transaction;

				public java.util.Date getDate_transaction () {
					return this.date_transaction;
				}
				
			    public String type_operation;

				public String getType_operation () {
					return this.type_operation;
				}
				
			    public Double montant;

				public Double getMontant () {
					return this.montant;
				}
				
			    public String sens_operation;

				public String getSens_operation () {
					return this.sens_operation;
				}
				
			    public String canal_transaction;

				public String getCanal_transaction () {
					return this.canal_transaction;
				}
				
			    public Double solde_apres_operation;

				public Double getSolde_apres_operation () {
					return this.solde_apres_operation;
				}
				
			    public Long est_rejete;

				public Long getEst_rejete () {
					return this.est_rejete;
				}
				
			    public String categorie_depense;

				public String getCategorie_depense () {
					return this.categorie_depense;
				}
				
			    public Long nb_transactions;

				public Long getNb_transactions () {
					return this.nb_transactions;
				}
				
			    public Double solde_moy;

				public Double getSolde_moy () {
					return this.solde_moy;
				}
				
			    public Long nb_rejet;

				public Long getNb_rejet () {
					return this.nb_rejet;
				}
				
			    public Double monte_mensuel;

				public Double getMonte_mensuel () {
					return this.monte_mensuel;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_transaction == null) ? 0 : this.id_transaction.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final OnRowsEndStructtAggregateRow_1 other = (OnRowsEndStructtAggregateRow_1) obj;
		
						if (this.id_transaction == null) {
							if (other.id_transaction != null)
								return false;
						
						} else if (!this.id_transaction.equals(other.id_transaction))
						
							return false;
					

		return true;
    }

	public void copyDataTo(OnRowsEndStructtAggregateRow_1 other) {

		other.id_transaction = this.id_transaction;
	            other.id_client = this.id_client;
	            other.date_transaction = this.date_transaction;
	            other.type_operation = this.type_operation;
	            other.montant = this.montant;
	            other.sens_operation = this.sens_operation;
	            other.canal_transaction = this.canal_transaction;
	            other.solde_apres_operation = this.solde_apres_operation;
	            other.est_rejete = this.est_rejete;
	            other.categorie_depense = this.categorie_depense;
	            other.nb_transactions = this.nb_transactions;
	            other.solde_moy = this.solde_moy;
	            other.nb_rejet = this.nb_rejet;
	            other.monte_mensuel = this.monte_mensuel;
	            
	}

	public void copyKeysDataTo(OnRowsEndStructtAggregateRow_1 other) {

		other.id_transaction = this.id_transaction;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_transaction = readString(dis);
					
					this.id_client = readString(dis);
					
					this.date_transaction = readDate(dis);
					
					this.type_operation = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant = null;
           				} else {
           			    	this.montant = dis.readDouble();
           				}
					
					this.sens_operation = readString(dis);
					
					this.canal_transaction = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_apres_operation = null;
           				} else {
           			    	this.solde_apres_operation = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_rejete = null;
           				} else {
           			    	this.est_rejete = dis.readLong();
           				}
					
					this.categorie_depense = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_transactions = null;
           				} else {
           			    	this.nb_transactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_moy = null;
           				} else {
           			    	this.solde_moy = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_rejet = null;
           				} else {
           			    	this.nb_rejet = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.monte_mensuel = null;
           				} else {
           			    	this.monte_mensuel = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_transaction = readString(dis);
					
					this.id_client = readString(dis);
					
					this.date_transaction = readDate(dis);
					
					this.type_operation = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant = null;
           				} else {
           			    	this.montant = dis.readDouble();
           				}
					
					this.sens_operation = readString(dis);
					
					this.canal_transaction = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_apres_operation = null;
           				} else {
           			    	this.solde_apres_operation = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_rejete = null;
           				} else {
           			    	this.est_rejete = dis.readLong();
           				}
					
					this.categorie_depense = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_transactions = null;
           				} else {
           			    	this.nb_transactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_moy = null;
           				} else {
           			    	this.solde_moy = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_rejet = null;
           				} else {
           			    	this.nb_rejet = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.monte_mensuel = null;
           				} else {
           			    	this.monte_mensuel = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_transaction,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// java.util.Date
				
						writeDate(this.date_transaction,dos);
					
					// String
				
						writeString(this.type_operation,dos);
					
					// Double
				
						if(this.montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.montant);
		            	}
					
					// String
				
						writeString(this.sens_operation,dos);
					
					// String
				
						writeString(this.canal_transaction,dos);
					
					// Double
				
						if(this.solde_apres_operation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_apres_operation);
		            	}
					
					// Long
				
						if(this.est_rejete == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_rejete);
		            	}
					
					// String
				
						writeString(this.categorie_depense,dos);
					
					// Long
				
						if(this.nb_transactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_transactions);
		            	}
					
					// Double
				
						if(this.solde_moy == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_moy);
		            	}
					
					// Long
				
						if(this.nb_rejet == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_rejet);
		            	}
					
					// Double
				
						if(this.monte_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.monte_mensuel);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_transaction,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// java.util.Date
				
						writeDate(this.date_transaction,dos);
					
					// String
				
						writeString(this.type_operation,dos);
					
					// Double
				
						if(this.montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.montant);
		            	}
					
					// String
				
						writeString(this.sens_operation,dos);
					
					// String
				
						writeString(this.canal_transaction,dos);
					
					// Double
				
						if(this.solde_apres_operation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_apres_operation);
		            	}
					
					// Long
				
						if(this.est_rejete == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_rejete);
		            	}
					
					// String
				
						writeString(this.categorie_depense,dos);
					
					// Long
				
						if(this.nb_transactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_transactions);
		            	}
					
					// Double
				
						if(this.solde_moy == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_moy);
		            	}
					
					// Long
				
						if(this.nb_rejet == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_rejet);
		            	}
					
					// Double
				
						if(this.monte_mensuel == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.monte_mensuel);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_transaction="+id_transaction);
		sb.append(",id_client="+id_client);
		sb.append(",date_transaction="+String.valueOf(date_transaction));
		sb.append(",type_operation="+type_operation);
		sb.append(",montant="+String.valueOf(montant));
		sb.append(",sens_operation="+sens_operation);
		sb.append(",canal_transaction="+canal_transaction);
		sb.append(",solde_apres_operation="+String.valueOf(solde_apres_operation));
		sb.append(",est_rejete="+String.valueOf(est_rejete));
		sb.append(",categorie_depense="+categorie_depense);
		sb.append(",nb_transactions="+String.valueOf(nb_transactions));
		sb.append(",solde_moy="+String.valueOf(solde_moy));
		sb.append(",nb_rejet="+String.valueOf(nb_rejet));
		sb.append(",monte_mensuel="+String.valueOf(monte_mensuel));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(OnRowsEndStructtAggregateRow_1 other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_transaction, other.id_transaction);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_transaction;

				public String getId_transaction () {
					return this.id_transaction;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public java.util.Date date_transaction;

				public java.util.Date getDate_transaction () {
					return this.date_transaction;
				}
				
			    public String type_operation;

				public String getType_operation () {
					return this.type_operation;
				}
				
			    public Double montant;

				public Double getMontant () {
					return this.montant;
				}
				
			    public String sens_operation;

				public String getSens_operation () {
					return this.sens_operation;
				}
				
			    public String canal_transaction;

				public String getCanal_transaction () {
					return this.canal_transaction;
				}
				
			    public Double solde_apres_operation;

				public Double getSolde_apres_operation () {
					return this.solde_apres_operation;
				}
				
			    public Long est_rejete;

				public Long getEst_rejete () {
					return this.est_rejete;
				}
				
			    public String categorie_depense;

				public String getCategorie_depense () {
					return this.categorie_depense;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_transaction == null) ? 0 : this.id_transaction.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.id_transaction == null) {
							if (other.id_transaction != null)
								return false;
						
						} else if (!this.id_transaction.equals(other.id_transaction))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.id_transaction = this.id_transaction;
	            other.id_client = this.id_client;
	            other.date_transaction = this.date_transaction;
	            other.type_operation = this.type_operation;
	            other.montant = this.montant;
	            other.sens_operation = this.sens_operation;
	            other.canal_transaction = this.canal_transaction;
	            other.solde_apres_operation = this.solde_apres_operation;
	            other.est_rejete = this.est_rejete;
	            other.categorie_depense = this.categorie_depense;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.id_transaction = this.id_transaction;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_transaction = readString(dis);
					
					this.id_client = readString(dis);
					
					this.date_transaction = readDate(dis);
					
					this.type_operation = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant = null;
           				} else {
           			    	this.montant = dis.readDouble();
           				}
					
					this.sens_operation = readString(dis);
					
					this.canal_transaction = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_apres_operation = null;
           				} else {
           			    	this.solde_apres_operation = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_rejete = null;
           				} else {
           			    	this.est_rejete = dis.readLong();
           				}
					
					this.categorie_depense = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_transaction = readString(dis);
					
					this.id_client = readString(dis);
					
					this.date_transaction = readDate(dis);
					
					this.type_operation = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.montant = null;
           				} else {
           			    	this.montant = dis.readDouble();
           				}
					
					this.sens_operation = readString(dis);
					
					this.canal_transaction = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.solde_apres_operation = null;
           				} else {
           			    	this.solde_apres_operation = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_rejete = null;
           				} else {
           			    	this.est_rejete = dis.readLong();
           				}
					
					this.categorie_depense = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_transaction,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// java.util.Date
				
						writeDate(this.date_transaction,dos);
					
					// String
				
						writeString(this.type_operation,dos);
					
					// Double
				
						if(this.montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.montant);
		            	}
					
					// String
				
						writeString(this.sens_operation,dos);
					
					// String
				
						writeString(this.canal_transaction,dos);
					
					// Double
				
						if(this.solde_apres_operation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_apres_operation);
		            	}
					
					// Long
				
						if(this.est_rejete == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_rejete);
		            	}
					
					// String
				
						writeString(this.categorie_depense,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_transaction,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// java.util.Date
				
						writeDate(this.date_transaction,dos);
					
					// String
				
						writeString(this.type_operation,dos);
					
					// Double
				
						if(this.montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.montant);
		            	}
					
					// String
				
						writeString(this.sens_operation,dos);
					
					// String
				
						writeString(this.canal_transaction,dos);
					
					// Double
				
						if(this.solde_apres_operation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.solde_apres_operation);
		            	}
					
					// Long
				
						if(this.est_rejete == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_rejete);
		            	}
					
					// String
				
						writeString(this.categorie_depense,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_transaction="+id_transaction);
		sb.append(",id_client="+id_client);
		sb.append(",date_transaction="+String.valueOf(date_transaction));
		sb.append(",type_operation="+type_operation);
		sb.append(",montant="+String.valueOf(montant));
		sb.append(",sens_operation="+sens_operation);
		sb.append(",canal_transaction="+canal_transaction);
		sb.append(",solde_apres_operation="+String.valueOf(solde_apres_operation));
		sb.append(",est_rejete="+String.valueOf(est_rejete));
		sb.append(",categorie_depense="+categorie_depense);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_transaction, other.id_transaction);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_7_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
		String currentVirtualComponent = null;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();
row3Struct row3 = new row3Struct();




	
	/**
	 * [tAggregateRow_1_AGGOUT begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_1_AGGOUT", false);
		start_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tAggregateRow_1_AGGOUT = 0;
		

// ------------ Seems it is not used

java.util.Map hashAggreg_tAggregateRow_1 = new java.util.HashMap(); 

// ------------

	class UtilClass_tAggregateRow_1 { // G_OutBegin_AggR_144

		public double sd(Double[] data) {
	        final int n = data.length;
        	if (n < 2) {
	            return Double.NaN;
        	}
        	double d1 = 0d;
        	double d2 =0d;
	        
	        for (int i = 0; i < data.length; i++) {
            	d1 += (data[i]*data[i]);
            	d2 += data[i];
        	}
        
	        return Math.sqrt((n*d1 - d2*d2)/n/(n-1));
	    }
	    
		public void checkedIADD(byte a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		    byte r = (byte) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'short/Short'", "'byte/Byte'"));
		    }
		}
		
		public void checkedIADD(short a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		    short r = (short) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'int/Integer'", "'short/Short'"));
		    }
		}
		
		public void checkedIADD(int a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		    int r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'long/Long'", "'int/Integer'"));
		    }
		}
		
		public void checkedIADD(long a, long b, boolean checkTypeOverFlow, boolean checkUlp) {
		    long r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'long/Long'"));
		    }
		}
		
		public void checkedIADD(float a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    float minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
			    }
			}
			
		    if (checkTypeOverFlow && ((double) a + (double) b > (double) Float.MAX_VALUE) || ((double) a + (double) b < (double) -Float.MAX_VALUE)) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
		    }
		}
		
		public void checkedIADD(double a, double b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		private String buildOverflowMessage(String a, String b, String advicedTypes, String originalType) {
		    return "Type overflow when adding " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}
		
		private String buildPrecisionMessage(String a, String b, String advicedTypes, String originalType) {
		    return "The double precision is unsufficient to add the value " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}

	} // G_OutBegin_AggR_144

	UtilClass_tAggregateRow_1 utilClass_tAggregateRow_1 = new UtilClass_tAggregateRow_1();

	

	class AggOperationStruct_tAggregateRow_1 { // G_OutBegin_AggR_100

		private static final int DEFAULT_HASHCODE = 1;
	    private static final int PRIME = 31;
	    private int hashCode = DEFAULT_HASHCODE;
	    public boolean hashCodeDirty = true;

    				String id_client;int count = 0;
       			int nb_transactions_clmCount = 0;
           			BigDecimal solde_moy_sum;
           			int solde_moy_count = 0;
           			
         			Long nb_rejet_sum;BigDecimal monte_mensuel_sum;
           			int monte_mensuel_count = 0;
           			
        
	    @Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;
		
							result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
							
	    		this.hashCode = result;
	    		this.hashCodeDirty = false;		
			}
			return this.hashCode;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			final AggOperationStruct_tAggregateRow_1 other = (AggOperationStruct_tAggregateRow_1) obj;
			
							if (this.id_client == null) {
								if (other.id_client != null) 
									return false;
							} else if (!this.id_client.equals(other.id_client)) 
								return false;
						
			
			return true;
		}
  
        
	} // G_OutBegin_AggR_100

	AggOperationStruct_tAggregateRow_1 operation_result_tAggregateRow_1 = null;
	AggOperationStruct_tAggregateRow_1 operation_finder_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();
	java.util.Map<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1> hash_tAggregateRow_1 = new java.util.HashMap<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1>();
	

 



/**
 * [tAggregateRow_1_AGGOUT begin ] stop
 */



	
	/**
	 * [tDBInput_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_7", false);
		start_Hash.put("tDBInput_7", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_7";

	
		int tos_count_tDBInput_7 = 0;
		
	
    
	
		    int nb_line_tDBInput_7 = 0;
		    java.sql.Connection conn_tDBInput_7 = null;
				String driverClass_tDBInput_7 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_7 = java.lang.Class.forName(driverClass_tDBInput_7);
				String dbUser_tDBInput_7 = context.username;
				
				
	final String decryptedPassword_tDBInput_7 = context.password; 
				
				String dbPwd_tDBInput_7 = decryptedPassword_tDBInput_7;
				
				String url_tDBInput_7 = "jdbc:postgresql://" + context.host + ":" + context.port + "/" + context.database + "?" + context.params;
				
				conn_tDBInput_7 = java.sql.DriverManager.getConnection(url_tDBInput_7,dbUser_tDBInput_7,dbPwd_tDBInput_7);
		        
				conn_tDBInput_7.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_7 = conn_tDBInput_7.createStatement();

		    String dbquery_tDBInput_7 = "SELECT \n  \"staging\".\"STG_TRANSACTIONS\".\"id_transaction\", \n  \"staging\".\"STG_TRANSACTIONS\".\"id_client\", \n  \""
+"staging\".\"STG_TRANSACTIONS\".\"date_transaction\", \n  \"staging\".\"STG_TRANSACTIONS\".\"type_operation\", \n  \"stagin"
+"g\".\"STG_TRANSACTIONS\".\"montant\", \n  \"staging\".\"STG_TRANSACTIONS\".\"sens_operation\", \n  \"staging\".\"STG_TRANS"
+"ACTIONS\".\"canal_transaction\", \n  \"staging\".\"STG_TRANSACTIONS\".\"solde_apres_operation\", \n  \"staging\".\"STG_TRA"
+"NSACTIONS\".\"est_rejete\", \n  \"staging\".\"STG_TRANSACTIONS\".\"categorie_depense\"\nFROM \"staging\".\"STG_TRANSACTION"
+"S\"";
		    

            	globalMap.put("tDBInput_7_QUERY",dbquery_tDBInput_7);
		    java.sql.ResultSet rs_tDBInput_7 = null;

		    try {
		    	rs_tDBInput_7 = stmt_tDBInput_7.executeQuery(dbquery_tDBInput_7);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_7 = rs_tDBInput_7.getMetaData();
		    	int colQtyInRs_tDBInput_7 = rsmd_tDBInput_7.getColumnCount();

		    String tmpContent_tDBInput_7 = null;
		    
		    
		    while (rs_tDBInput_7.next()) {
		        nb_line_tDBInput_7++;
		        
							if(colQtyInRs_tDBInput_7 < 1) {
								row2.id_transaction = null;
							} else {
	                         		
        	row2.id_transaction = routines.system.JDBCUtil.getString(rs_tDBInput_7, 1, false);
		                    }
							if(colQtyInRs_tDBInput_7 < 2) {
								row2.id_client = null;
							} else {
	                         		
        	row2.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_7, 2, false);
		                    }
							if(colQtyInRs_tDBInput_7 < 3) {
								row2.date_transaction = null;
							} else {
										
			row2.date_transaction = routines.system.JDBCUtil.getDate(rs_tDBInput_7, 3);
		                    }
							if(colQtyInRs_tDBInput_7 < 4) {
								row2.type_operation = null;
							} else {
	                         		
        	row2.type_operation = routines.system.JDBCUtil.getString(rs_tDBInput_7, 4, false);
		                    }
							if(colQtyInRs_tDBInput_7 < 5) {
								row2.montant = null;
							} else {
	                         		
            row2.montant = rs_tDBInput_7.getDouble(5);
            if(rs_tDBInput_7.wasNull()){
                    row2.montant = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 6) {
								row2.sens_operation = null;
							} else {
	                         		
        	row2.sens_operation = routines.system.JDBCUtil.getString(rs_tDBInput_7, 6, false);
		                    }
							if(colQtyInRs_tDBInput_7 < 7) {
								row2.canal_transaction = null;
							} else {
	                         		
        	row2.canal_transaction = routines.system.JDBCUtil.getString(rs_tDBInput_7, 7, false);
		                    }
							if(colQtyInRs_tDBInput_7 < 8) {
								row2.solde_apres_operation = null;
							} else {
	                         		
            row2.solde_apres_operation = rs_tDBInput_7.getDouble(8);
            if(rs_tDBInput_7.wasNull()){
                    row2.solde_apres_operation = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 9) {
								row2.est_rejete = null;
							} else {
		                          
            row2.est_rejete = rs_tDBInput_7.getLong(9);
            if(rs_tDBInput_7.wasNull()){
                    row2.est_rejete = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 10) {
								row2.categorie_depense = null;
							} else {
	                         		
        	row2.categorie_depense = routines.system.JDBCUtil.getString(rs_tDBInput_7, 10, false);
		                    }
					


 



/**
 * [tDBInput_7 begin ] stop
 */
	
	/**
	 * [tDBInput_7 main ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 


	tos_count_tDBInput_7++;

/**
 * [tDBInput_7 main ] stop
 */
	
	/**
	 * [tDBInput_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 process_data_begin ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					
	
operation_finder_tAggregateRow_1.id_client = row2.id_client;
			

	operation_finder_tAggregateRow_1.hashCodeDirty = true;
	
	operation_result_tAggregateRow_1 = hash_tAggregateRow_1.get(operation_finder_tAggregateRow_1);

	

	if(operation_result_tAggregateRow_1 == null) { // G_OutMain_AggR_001

		operation_result_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();

		operation_result_tAggregateRow_1.id_client = operation_finder_tAggregateRow_1.id_client;
				
		
		

		hash_tAggregateRow_1.put(operation_result_tAggregateRow_1, operation_result_tAggregateRow_1);
	
	} // G_OutMain_AggR_001


	
				operation_result_tAggregateRow_1.nb_transactions_clmCount++;
				operation_result_tAggregateRow_1.count++;
				
				operation_result_tAggregateRow_1.solde_moy_count++;
				
					if(operation_result_tAggregateRow_1.solde_moy_sum == null) {
						operation_result_tAggregateRow_1.solde_moy_sum = new BigDecimal(0);
					}
					operation_result_tAggregateRow_1.solde_moy_sum = operation_result_tAggregateRow_1.solde_moy_sum.add(
						new BigDecimal(
							String.valueOf(
								row2.solde_apres_operation
							)
						)
					);
					
					if(operation_result_tAggregateRow_1.nb_rejet_sum == null) {
						operation_result_tAggregateRow_1.nb_rejet_sum = (long) 0;
					}
					
					if( row2.est_rejete != null)
						operation_result_tAggregateRow_1.nb_rejet_sum += row2.est_rejete;
				operation_result_tAggregateRow_1.monte_mensuel_count++;
				
					if(operation_result_tAggregateRow_1.monte_mensuel_sum == null) {
						operation_result_tAggregateRow_1.monte_mensuel_sum = new BigDecimal(0);
					}
					operation_result_tAggregateRow_1.monte_mensuel_sum = operation_result_tAggregateRow_1.monte_mensuel_sum.add(
						new BigDecimal(
							String.valueOf(
								row2.montant
							)
						)
					);
					


 


	tos_count_tAggregateRow_1_AGGOUT++;

/**
 * [tAggregateRow_1_AGGOUT main ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGOUT process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

 



/**
 * [tAggregateRow_1_AGGOUT process_data_begin ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGOUT process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

 



/**
 * [tAggregateRow_1_AGGOUT process_data_end ] stop
 */



	
	/**
	 * [tDBInput_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_7 end ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

	}
}finally{
	if (rs_tDBInput_7 != null) {
		rs_tDBInput_7.close();
	}
	if (stmt_tDBInput_7 != null) {
		stmt_tDBInput_7.close();
	}
	if(conn_tDBInput_7 != null && !conn_tDBInput_7.isClosed()) {
		
			conn_tDBInput_7.commit();
			
		
			conn_tDBInput_7.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_7_NB_LINE",nb_line_tDBInput_7);
 

ok_Hash.put("tDBInput_7", true);
end_Hash.put("tDBInput_7", System.currentTimeMillis());




/**
 * [tDBInput_7 end ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tAggregateRow_1_AGGOUT", true);
end_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());




/**
 * [tAggregateRow_1_AGGOUT end ] stop
 */


	
	/**
	 * [tAdvancedHash_row3 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row3", false);
		start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tAdvancedHash_row3 = 0;
		

			   		// connection name:row3
			   		// source node:tAggregateRow_1_AGGIN - inputs:(OnRowsEnd) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row4,row7,row8,row9,row3,row10,row5) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
 */



	
	/**
	 * [tAggregateRow_1_AGGIN begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_1_AGGIN", false);
		start_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	
		int tos_count_tAggregateRow_1_AGGIN = 0;
		

java.util.Collection<AggOperationStruct_tAggregateRow_1> values_tAggregateRow_1 = hash_tAggregateRow_1.values();

globalMap.put("tAggregateRow_1_NB_LINE", values_tAggregateRow_1.size());

for(AggOperationStruct_tAggregateRow_1 aggregated_row_tAggregateRow_1 : values_tAggregateRow_1) { // G_AggR_600



 



/**
 * [tAggregateRow_1_AGGIN begin ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGIN main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

            				    row3.id_client = aggregated_row_tAggregateRow_1.id_client;
            				    row3.nb_transactions = (long) aggregated_row_tAggregateRow_1.count;
	                                	row3.nb_transactions = (long) aggregated_row_tAggregateRow_1.nb_transactions_clmCount;
	                                	
                                if(aggregated_row_tAggregateRow_1.solde_moy_count > 0){
                                	
	    								row3.solde_moy = aggregated_row_tAggregateRow_1.solde_moy_sum.divide(new BigDecimal(String.valueOf(aggregated_row_tAggregateRow_1.solde_moy_count)), 10, BigDecimal.ROUND_HALF_UP)
	    								
	    									.doubleValue()
	    								
	    								;
    								
                                } else {
                                		String count = "0";
   	    								
    		    							row3.solde_moy = ParserUtils.parseTo_Double(count);
    									
                                }row3.nb_rejet = aggregated_row_tAggregateRow_1.nb_rejet_sum;
                                	
                                if(aggregated_row_tAggregateRow_1.monte_mensuel_count > 0){
                                	
	    								row3.monte_mensuel = aggregated_row_tAggregateRow_1.monte_mensuel_sum.divide(new BigDecimal(String.valueOf(aggregated_row_tAggregateRow_1.monte_mensuel_count)), 10, BigDecimal.ROUND_HALF_UP)
	    								
	    									.doubleValue()
	    								
	    								;
    								
                                } else {
                                		String count = "0";
   	    								
    		    							row3.monte_mensuel = ParserUtils.parseTo_Double(count);
    									
                                }

 


	tos_count_tAggregateRow_1_AGGIN++;

/**
 * [tAggregateRow_1_AGGIN main ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGIN process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

 



/**
 * [tAggregateRow_1_AGGIN process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.id_transaction = row3.id_transaction;
				
				row3_HashRow.id_client = row3.id_client;
				
				row3_HashRow.date_transaction = row3.date_transaction;
				
				row3_HashRow.type_operation = row3.type_operation;
				
				row3_HashRow.montant = row3.montant;
				
				row3_HashRow.sens_operation = row3.sens_operation;
				
				row3_HashRow.canal_transaction = row3.canal_transaction;
				
				row3_HashRow.solde_apres_operation = row3.solde_apres_operation;
				
				row3_HashRow.est_rejete = row3.est_rejete;
				
				row3_HashRow.categorie_depense = row3.categorie_depense;
				
				row3_HashRow.nb_transactions = row3.nb_transactions;
				
				row3_HashRow.solde_moy = row3.solde_moy;
				
				row3_HashRow.nb_rejet = row3.nb_rejet;
				
				row3_HashRow.monte_mensuel = row3.monte_mensuel;
				
			tHash_Lookup_row3.put(row3_HashRow);
			
            




 


	tos_count_tAdvancedHash_row3++;

/**
 * [tAdvancedHash_row3 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_end ] stop
 */



	
	/**
	 * [tAggregateRow_1_AGGIN process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

 



/**
 * [tAggregateRow_1_AGGIN process_data_end ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGIN end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

} // G_AggR_600

 

ok_Hash.put("tAggregateRow_1_AGGIN", true);
end_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());




/**
 * [tAggregateRow_1_AGGIN end ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

tHash_Lookup_row3.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row3", true);
end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());




/**
 * [tAdvancedHash_row3 end ] stop
 */









				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
							//free memory for "tAggregateRow_1_AGGIN"
							globalMap.remove("tAggregateRow_1");
						
				try{
					
	
	/**
	 * [tDBInput_7 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 finally ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

 



/**
 * [tAggregateRow_1_AGGOUT finally ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGIN finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

 



/**
 * [tAggregateRow_1_AGGIN finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 finally ] stop
 */









				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_7_SUBPROCESS_STATE", 1);
	}
	


public static class row10Struct implements routines.system.IPersistableComparableLookupRow<row10Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_interaction;

				public String getId_interaction () {
					return this.id_interaction;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public java.util.Date date_interaction;

				public java.util.Date getDate_interaction () {
					return this.date_interaction;
				}
				
			    public String canal_interaction;

				public String getCanal_interaction () {
					return this.canal_interaction;
				}
				
			    public String type_interaction;

				public String getType_interaction () {
					return this.type_interaction;
				}
				
			    public Long est_reclamation;

				public Long getEst_reclamation () {
					return this.est_reclamation;
				}
				
			    public String motif_reclamation;

				public String getMotif_reclamation () {
					return this.motif_reclamation;
				}
				
			    public String statut_resolution;

				public String getStatut_resolution () {
					return this.statut_resolution;
				}
				
			    public Double delai_resolution_jours;

				public Double getDelai_resolution_jours () {
					return this.delai_resolution_jours;
				}
				
			    public Double score_satisfaction_nps;

				public Double getScore_satisfaction_nps () {
					return this.score_satisfaction_nps;
				}
				
			    public Long duree_connexion_sec;

				public Long getDuree_connexion_sec () {
					return this.duree_connexion_sec;
				}
				
			    public Long nb_reclamations;

				public Long getNb_reclamations () {
					return this.nb_reclamations;
				}
				
			    public Long nb_interactions;

				public Long getNb_interactions () {
					return this.nb_interactions;
				}
				
			    public Double delai_resolution_moyen;

				public Double getDelai_resolution_moyen () {
					return this.delai_resolution_moyen;
				}
				
			    public Double duree_inact_connexion_sec;

				public Double getDuree_inact_connexion_sec () {
					return this.duree_inact_connexion_sec;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row10Struct other = (row10Struct) obj;
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row10Struct other) {

		other.id_interaction = this.id_interaction;
	            other.id_client = this.id_client;
	            other.date_interaction = this.date_interaction;
	            other.canal_interaction = this.canal_interaction;
	            other.type_interaction = this.type_interaction;
	            other.est_reclamation = this.est_reclamation;
	            other.motif_reclamation = this.motif_reclamation;
	            other.statut_resolution = this.statut_resolution;
	            other.delai_resolution_jours = this.delai_resolution_jours;
	            other.score_satisfaction_nps = this.score_satisfaction_nps;
	            other.duree_connexion_sec = this.duree_connexion_sec;
	            other.nb_reclamations = this.nb_reclamations;
	            other.nb_interactions = this.nb_interactions;
	            other.delai_resolution_moyen = this.delai_resolution_moyen;
	            other.duree_inact_connexion_sec = this.duree_inact_connexion_sec;
	            
	}

	public void copyKeysDataTo(row10Struct other) {

		other.id_client = this.id_client;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.id_interaction = readString(dis,ois);
					
						this.date_interaction = readDate(dis,ois);
					
						this.canal_interaction = readString(dis,ois);
					
						this.type_interaction = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
						this.motif_reclamation = readString(dis,ois);
					
						this.statut_resolution = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_satisfaction_nps = null;
           				} else {
           			    	this.score_satisfaction_nps = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_connexion_sec = null;
           				} else {
           			    	this.duree_connexion_sec = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_reclamations = null;
           				} else {
           			    	this.nb_reclamations = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_interactions = null;
           				} else {
           			    	this.nb_interactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_moyen = null;
           				} else {
           			    	this.delai_resolution_moyen = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_inact_connexion_sec = null;
           				} else {
           			    	this.duree_inact_connexion_sec = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.id_interaction = readString(dis,objectIn);
					
						this.date_interaction = readDate(dis,objectIn);
					
						this.canal_interaction = readString(dis,objectIn);
					
						this.type_interaction = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = objectIn.readLong();
           				}
					
						this.motif_reclamation = readString(dis,objectIn);
					
						this.statut_resolution = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.score_satisfaction_nps = null;
           				} else {
           			    	this.score_satisfaction_nps = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.duree_connexion_sec = null;
           				} else {
           			    	this.duree_connexion_sec = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.nb_reclamations = null;
           				} else {
           			    	this.nb_reclamations = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.nb_interactions = null;
           				} else {
           			    	this.nb_interactions = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_moyen = null;
           				} else {
           			    	this.delai_resolution_moyen = objectIn.readDouble();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.duree_inact_connexion_sec = null;
           				} else {
           			    	this.duree_inact_connexion_sec = objectIn.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.id_interaction, dos, oos);
					
						writeDate(this.date_interaction, dos, oos);
					
						writeString(this.canal_interaction, dos, oos);
					
						writeString(this.type_interaction, dos, oos);
					
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
						writeString(this.motif_reclamation, dos, oos);
					
						writeString(this.statut_resolution, dos, oos);
					
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_jours);
		            	}
					
						if(this.score_satisfaction_nps == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.score_satisfaction_nps);
		            	}
					
						if(this.duree_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.duree_connexion_sec);
		            	}
					
						if(this.nb_reclamations == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_reclamations);
		            	}
					
						if(this.nb_interactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_interactions);
		            	}
					
						if(this.delai_resolution_moyen == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_moyen);
		            	}
					
						if(this.duree_inact_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.duree_inact_connexion_sec);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.id_interaction, dos, objectOut);
					
						writeDate(this.date_interaction, dos, objectOut);
					
						writeString(this.canal_interaction, dos, objectOut);
					
						writeString(this.type_interaction, dos, objectOut);
					
						if(this.est_reclamation == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.est_reclamation);
		            	}
					
						writeString(this.motif_reclamation, dos, objectOut);
					
						writeString(this.statut_resolution, dos, objectOut);
					
						if(this.delai_resolution_jours == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.delai_resolution_jours);
		            	}
					
						if(this.score_satisfaction_nps == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.score_satisfaction_nps);
		            	}
					
						if(this.duree_connexion_sec == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.duree_connexion_sec);
		            	}
					
						if(this.nb_reclamations == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.nb_reclamations);
		            	}
					
						if(this.nb_interactions == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.nb_interactions);
		            	}
					
						if(this.delai_resolution_moyen == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.delai_resolution_moyen);
		            	}
					
						if(this.duree_inact_connexion_sec == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.duree_inact_connexion_sec);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_interaction="+id_interaction);
		sb.append(",id_client="+id_client);
		sb.append(",date_interaction="+String.valueOf(date_interaction));
		sb.append(",canal_interaction="+canal_interaction);
		sb.append(",type_interaction="+type_interaction);
		sb.append(",est_reclamation="+String.valueOf(est_reclamation));
		sb.append(",motif_reclamation="+motif_reclamation);
		sb.append(",statut_resolution="+statut_resolution);
		sb.append(",delai_resolution_jours="+String.valueOf(delai_resolution_jours));
		sb.append(",score_satisfaction_nps="+String.valueOf(score_satisfaction_nps));
		sb.append(",duree_connexion_sec="+String.valueOf(duree_connexion_sec));
		sb.append(",nb_reclamations="+String.valueOf(nb_reclamations));
		sb.append(",nb_interactions="+String.valueOf(nb_interactions));
		sb.append(",delai_resolution_moyen="+String.valueOf(delai_resolution_moyen));
		sb.append(",duree_inact_connexion_sec="+String.valueOf(duree_inact_connexion_sec));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row10Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class OnRowsEndStructtAggregateRow_2 implements routines.system.IPersistableRow<OnRowsEndStructtAggregateRow_2> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_interaction;

				public String getId_interaction () {
					return this.id_interaction;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public java.util.Date date_interaction;

				public java.util.Date getDate_interaction () {
					return this.date_interaction;
				}
				
			    public String canal_interaction;

				public String getCanal_interaction () {
					return this.canal_interaction;
				}
				
			    public String type_interaction;

				public String getType_interaction () {
					return this.type_interaction;
				}
				
			    public Long est_reclamation;

				public Long getEst_reclamation () {
					return this.est_reclamation;
				}
				
			    public String motif_reclamation;

				public String getMotif_reclamation () {
					return this.motif_reclamation;
				}
				
			    public String statut_resolution;

				public String getStatut_resolution () {
					return this.statut_resolution;
				}
				
			    public Double delai_resolution_jours;

				public Double getDelai_resolution_jours () {
					return this.delai_resolution_jours;
				}
				
			    public Double score_satisfaction_nps;

				public Double getScore_satisfaction_nps () {
					return this.score_satisfaction_nps;
				}
				
			    public Long duree_connexion_sec;

				public Long getDuree_connexion_sec () {
					return this.duree_connexion_sec;
				}
				
			    public Long nb_reclamations;

				public Long getNb_reclamations () {
					return this.nb_reclamations;
				}
				
			    public Long nb_interactions;

				public Long getNb_interactions () {
					return this.nb_interactions;
				}
				
			    public Double delai_resolution_moyen;

				public Double getDelai_resolution_moyen () {
					return this.delai_resolution_moyen;
				}
				
			    public Double duree_inact_connexion_sec;

				public Double getDuree_inact_connexion_sec () {
					return this.duree_inact_connexion_sec;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_interaction == null) ? 0 : this.id_interaction.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final OnRowsEndStructtAggregateRow_2 other = (OnRowsEndStructtAggregateRow_2) obj;
		
						if (this.id_interaction == null) {
							if (other.id_interaction != null)
								return false;
						
						} else if (!this.id_interaction.equals(other.id_interaction))
						
							return false;
					

		return true;
    }

	public void copyDataTo(OnRowsEndStructtAggregateRow_2 other) {

		other.id_interaction = this.id_interaction;
	            other.id_client = this.id_client;
	            other.date_interaction = this.date_interaction;
	            other.canal_interaction = this.canal_interaction;
	            other.type_interaction = this.type_interaction;
	            other.est_reclamation = this.est_reclamation;
	            other.motif_reclamation = this.motif_reclamation;
	            other.statut_resolution = this.statut_resolution;
	            other.delai_resolution_jours = this.delai_resolution_jours;
	            other.score_satisfaction_nps = this.score_satisfaction_nps;
	            other.duree_connexion_sec = this.duree_connexion_sec;
	            other.nb_reclamations = this.nb_reclamations;
	            other.nb_interactions = this.nb_interactions;
	            other.delai_resolution_moyen = this.delai_resolution_moyen;
	            other.duree_inact_connexion_sec = this.duree_inact_connexion_sec;
	            
	}

	public void copyKeysDataTo(OnRowsEndStructtAggregateRow_2 other) {

		other.id_interaction = this.id_interaction;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_interaction = readString(dis);
					
					this.id_client = readString(dis);
					
					this.date_interaction = readDate(dis);
					
					this.canal_interaction = readString(dis);
					
					this.type_interaction = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
					this.motif_reclamation = readString(dis);
					
					this.statut_resolution = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_satisfaction_nps = null;
           				} else {
           			    	this.score_satisfaction_nps = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_connexion_sec = null;
           				} else {
           			    	this.duree_connexion_sec = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_reclamations = null;
           				} else {
           			    	this.nb_reclamations = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_interactions = null;
           				} else {
           			    	this.nb_interactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_moyen = null;
           				} else {
           			    	this.delai_resolution_moyen = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_inact_connexion_sec = null;
           				} else {
           			    	this.duree_inact_connexion_sec = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_interaction = readString(dis);
					
					this.id_client = readString(dis);
					
					this.date_interaction = readDate(dis);
					
					this.canal_interaction = readString(dis);
					
					this.type_interaction = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
					this.motif_reclamation = readString(dis);
					
					this.statut_resolution = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_satisfaction_nps = null;
           				} else {
           			    	this.score_satisfaction_nps = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_connexion_sec = null;
           				} else {
           			    	this.duree_connexion_sec = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_reclamations = null;
           				} else {
           			    	this.nb_reclamations = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.nb_interactions = null;
           				} else {
           			    	this.nb_interactions = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_moyen = null;
           				} else {
           			    	this.delai_resolution_moyen = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_inact_connexion_sec = null;
           				} else {
           			    	this.duree_inact_connexion_sec = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_interaction,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// java.util.Date
				
						writeDate(this.date_interaction,dos);
					
					// String
				
						writeString(this.canal_interaction,dos);
					
					// String
				
						writeString(this.type_interaction,dos);
					
					// Long
				
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
					// String
				
						writeString(this.motif_reclamation,dos);
					
					// String
				
						writeString(this.statut_resolution,dos);
					
					// Double
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_jours);
		            	}
					
					// Double
				
						if(this.score_satisfaction_nps == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.score_satisfaction_nps);
		            	}
					
					// Long
				
						if(this.duree_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.duree_connexion_sec);
		            	}
					
					// Long
				
						if(this.nb_reclamations == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_reclamations);
		            	}
					
					// Long
				
						if(this.nb_interactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_interactions);
		            	}
					
					// Double
				
						if(this.delai_resolution_moyen == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_moyen);
		            	}
					
					// Double
				
						if(this.duree_inact_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.duree_inact_connexion_sec);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_interaction,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// java.util.Date
				
						writeDate(this.date_interaction,dos);
					
					// String
				
						writeString(this.canal_interaction,dos);
					
					// String
				
						writeString(this.type_interaction,dos);
					
					// Long
				
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
					// String
				
						writeString(this.motif_reclamation,dos);
					
					// String
				
						writeString(this.statut_resolution,dos);
					
					// Double
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_jours);
		            	}
					
					// Double
				
						if(this.score_satisfaction_nps == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.score_satisfaction_nps);
		            	}
					
					// Long
				
						if(this.duree_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.duree_connexion_sec);
		            	}
					
					// Long
				
						if(this.nb_reclamations == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_reclamations);
		            	}
					
					// Long
				
						if(this.nb_interactions == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.nb_interactions);
		            	}
					
					// Double
				
						if(this.delai_resolution_moyen == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_moyen);
		            	}
					
					// Double
				
						if(this.duree_inact_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.duree_inact_connexion_sec);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_interaction="+id_interaction);
		sb.append(",id_client="+id_client);
		sb.append(",date_interaction="+String.valueOf(date_interaction));
		sb.append(",canal_interaction="+canal_interaction);
		sb.append(",type_interaction="+type_interaction);
		sb.append(",est_reclamation="+String.valueOf(est_reclamation));
		sb.append(",motif_reclamation="+motif_reclamation);
		sb.append(",statut_resolution="+statut_resolution);
		sb.append(",delai_resolution_jours="+String.valueOf(delai_resolution_jours));
		sb.append(",score_satisfaction_nps="+String.valueOf(score_satisfaction_nps));
		sb.append(",duree_connexion_sec="+String.valueOf(duree_connexion_sec));
		sb.append(",nb_reclamations="+String.valueOf(nb_reclamations));
		sb.append(",nb_interactions="+String.valueOf(nb_interactions));
		sb.append(",delai_resolution_moyen="+String.valueOf(delai_resolution_moyen));
		sb.append(",duree_inact_connexion_sec="+String.valueOf(duree_inact_connexion_sec));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(OnRowsEndStructtAggregateRow_2 other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_interaction, other.id_interaction);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_interaction;

				public String getId_interaction () {
					return this.id_interaction;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public java.util.Date date_interaction;

				public java.util.Date getDate_interaction () {
					return this.date_interaction;
				}
				
			    public String canal_interaction;

				public String getCanal_interaction () {
					return this.canal_interaction;
				}
				
			    public String type_interaction;

				public String getType_interaction () {
					return this.type_interaction;
				}
				
			    public Long est_reclamation;

				public Long getEst_reclamation () {
					return this.est_reclamation;
				}
				
			    public String motif_reclamation;

				public String getMotif_reclamation () {
					return this.motif_reclamation;
				}
				
			    public String statut_resolution;

				public String getStatut_resolution () {
					return this.statut_resolution;
				}
				
			    public Double delai_resolution_jours;

				public Double getDelai_resolution_jours () {
					return this.delai_resolution_jours;
				}
				
			    public Double score_satisfaction_nps;

				public Double getScore_satisfaction_nps () {
					return this.score_satisfaction_nps;
				}
				
			    public Long duree_connexion_sec;

				public Long getDuree_connexion_sec () {
					return this.duree_connexion_sec;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_interaction == null) ? 0 : this.id_interaction.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row6Struct other = (row6Struct) obj;
		
						if (this.id_interaction == null) {
							if (other.id_interaction != null)
								return false;
						
						} else if (!this.id_interaction.equals(other.id_interaction))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row6Struct other) {

		other.id_interaction = this.id_interaction;
	            other.id_client = this.id_client;
	            other.date_interaction = this.date_interaction;
	            other.canal_interaction = this.canal_interaction;
	            other.type_interaction = this.type_interaction;
	            other.est_reclamation = this.est_reclamation;
	            other.motif_reclamation = this.motif_reclamation;
	            other.statut_resolution = this.statut_resolution;
	            other.delai_resolution_jours = this.delai_resolution_jours;
	            other.score_satisfaction_nps = this.score_satisfaction_nps;
	            other.duree_connexion_sec = this.duree_connexion_sec;
	            
	}

	public void copyKeysDataTo(row6Struct other) {

		other.id_interaction = this.id_interaction;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_interaction = readString(dis);
					
					this.id_client = readString(dis);
					
					this.date_interaction = readDate(dis);
					
					this.canal_interaction = readString(dis);
					
					this.type_interaction = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
					this.motif_reclamation = readString(dis);
					
					this.statut_resolution = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_satisfaction_nps = null;
           				} else {
           			    	this.score_satisfaction_nps = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_connexion_sec = null;
           				} else {
           			    	this.duree_connexion_sec = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.id_interaction = readString(dis);
					
					this.id_client = readString(dis);
					
					this.date_interaction = readDate(dis);
					
					this.canal_interaction = readString(dis);
					
					this.type_interaction = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
					this.motif_reclamation = readString(dis);
					
					this.statut_resolution = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_satisfaction_nps = null;
           				} else {
           			    	this.score_satisfaction_nps = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_connexion_sec = null;
           				} else {
           			    	this.duree_connexion_sec = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_interaction,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// java.util.Date
				
						writeDate(this.date_interaction,dos);
					
					// String
				
						writeString(this.canal_interaction,dos);
					
					// String
				
						writeString(this.type_interaction,dos);
					
					// Long
				
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
					// String
				
						writeString(this.motif_reclamation,dos);
					
					// String
				
						writeString(this.statut_resolution,dos);
					
					// Double
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_jours);
		            	}
					
					// Double
				
						if(this.score_satisfaction_nps == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.score_satisfaction_nps);
		            	}
					
					// Long
				
						if(this.duree_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.duree_connexion_sec);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_interaction,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// java.util.Date
				
						writeDate(this.date_interaction,dos);
					
					// String
				
						writeString(this.canal_interaction,dos);
					
					// String
				
						writeString(this.type_interaction,dos);
					
					// Long
				
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
					// String
				
						writeString(this.motif_reclamation,dos);
					
					// String
				
						writeString(this.statut_resolution,dos);
					
					// Double
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.delai_resolution_jours);
		            	}
					
					// Double
				
						if(this.score_satisfaction_nps == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.score_satisfaction_nps);
		            	}
					
					// Long
				
						if(this.duree_connexion_sec == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.duree_connexion_sec);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_interaction="+id_interaction);
		sb.append(",id_client="+id_client);
		sb.append(",date_interaction="+String.valueOf(date_interaction));
		sb.append(",canal_interaction="+canal_interaction);
		sb.append(",type_interaction="+type_interaction);
		sb.append(",est_reclamation="+String.valueOf(est_reclamation));
		sb.append(",motif_reclamation="+motif_reclamation);
		sb.append(",statut_resolution="+statut_resolution);
		sb.append(",delai_resolution_jours="+String.valueOf(delai_resolution_jours));
		sb.append(",score_satisfaction_nps="+String.valueOf(score_satisfaction_nps));
		sb.append(",duree_connexion_sec="+String.valueOf(duree_connexion_sec));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row6Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_interaction, other.id_interaction);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_8_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
		String currentVirtualComponent = null;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row6Struct row6 = new row6Struct();
row10Struct row10 = new row10Struct();




	
	/**
	 * [tAggregateRow_2_AGGOUT begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_2_AGGOUT", false);
		start_Hash.put("tAggregateRow_2_AGGOUT", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row6");
					}
				
		int tos_count_tAggregateRow_2_AGGOUT = 0;
		

// ------------ Seems it is not used

java.util.Map hashAggreg_tAggregateRow_2 = new java.util.HashMap(); 

// ------------

	class UtilClass_tAggregateRow_2 { // G_OutBegin_AggR_144

		public double sd(Double[] data) {
	        final int n = data.length;
        	if (n < 2) {
	            return Double.NaN;
        	}
        	double d1 = 0d;
        	double d2 =0d;
	        
	        for (int i = 0; i < data.length; i++) {
            	d1 += (data[i]*data[i]);
            	d2 += data[i];
        	}
        
	        return Math.sqrt((n*d1 - d2*d2)/n/(n-1));
	    }
	    
		public void checkedIADD(byte a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		    byte r = (byte) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'short/Short'", "'byte/Byte'"));
		    }
		}
		
		public void checkedIADD(short a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		    short r = (short) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'int/Integer'", "'short/Short'"));
		    }
		}
		
		public void checkedIADD(int a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		    int r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'long/Long'", "'int/Integer'"));
		    }
		}
		
		public void checkedIADD(long a, long b, boolean checkTypeOverFlow, boolean checkUlp) {
		    long r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'long/Long'"));
		    }
		}
		
		public void checkedIADD(float a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    float minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
			    }
			}
			
		    if (checkTypeOverFlow && ((double) a + (double) b > (double) Float.MAX_VALUE) || ((double) a + (double) b < (double) -Float.MAX_VALUE)) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
		    }
		}
		
		public void checkedIADD(double a, double b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		private String buildOverflowMessage(String a, String b, String advicedTypes, String originalType) {
		    return "Type overflow when adding " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}
		
		private String buildPrecisionMessage(String a, String b, String advicedTypes, String originalType) {
		    return "The double precision is unsufficient to add the value " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}

	} // G_OutBegin_AggR_144

	UtilClass_tAggregateRow_2 utilClass_tAggregateRow_2 = new UtilClass_tAggregateRow_2();

	

	class AggOperationStruct_tAggregateRow_2 { // G_OutBegin_AggR_100

		private static final int DEFAULT_HASHCODE = 1;
	    private static final int PRIME = 31;
	    private int hashCode = DEFAULT_HASHCODE;
	    public boolean hashCodeDirty = true;

    				String id_client;int count = 0;
       			int nb_interactions_clmCount = 0;
           			
         			Long nb_reclamations_sum;BigDecimal delai_resolution_moyen_sum;
           			int delai_resolution_moyen_count = 0;
           			
           			Double duree_inact_connexion_sec_sum;
					int duree_inact_connexion_sec_count = 0;
           			
        
	    @Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;
		
							result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
							
	    		this.hashCode = result;
	    		this.hashCodeDirty = false;		
			}
			return this.hashCode;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			final AggOperationStruct_tAggregateRow_2 other = (AggOperationStruct_tAggregateRow_2) obj;
			
							if (this.id_client == null) {
								if (other.id_client != null) 
									return false;
							} else if (!this.id_client.equals(other.id_client)) 
								return false;
						
			
			return true;
		}
  
        
	} // G_OutBegin_AggR_100

	AggOperationStruct_tAggregateRow_2 operation_result_tAggregateRow_2 = null;
	AggOperationStruct_tAggregateRow_2 operation_finder_tAggregateRow_2 = new AggOperationStruct_tAggregateRow_2();
	java.util.Map<AggOperationStruct_tAggregateRow_2,AggOperationStruct_tAggregateRow_2> hash_tAggregateRow_2 = new java.util.HashMap<AggOperationStruct_tAggregateRow_2,AggOperationStruct_tAggregateRow_2>();
	

 



/**
 * [tAggregateRow_2_AGGOUT begin ] stop
 */



	
	/**
	 * [tDBInput_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_8", false);
		start_Hash.put("tDBInput_8", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_8";

	
		int tos_count_tDBInput_8 = 0;
		
	
    
	
		    int nb_line_tDBInput_8 = 0;
		    java.sql.Connection conn_tDBInput_8 = null;
				String driverClass_tDBInput_8 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_8 = java.lang.Class.forName(driverClass_tDBInput_8);
				String dbUser_tDBInput_8 = context.username;
				
				
	final String decryptedPassword_tDBInput_8 = context.password; 
				
				String dbPwd_tDBInput_8 = decryptedPassword_tDBInput_8;
				
				String url_tDBInput_8 = "jdbc:postgresql://" + context.host + ":" + context.port + "/" + context.database + "?" + context.params;
				
				conn_tDBInput_8 = java.sql.DriverManager.getConnection(url_tDBInput_8,dbUser_tDBInput_8,dbPwd_tDBInput_8);
		        
				conn_tDBInput_8.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_8 = conn_tDBInput_8.createStatement();

		    String dbquery_tDBInput_8 = "SELECT \n    \"staging\".\"stg_interactions\".\"id_interaction\", \n    \"staging\".\"stg_interactions\".\"id_client\","
+" \n    \"staging\".\"stg_interactions\".\"date_interaction\", \n    \"staging\".\"stg_interactions\".\"canal_interaction"
+"\", \n    \"staging\".\"stg_interactions\".\"type_interaction\", \n    \"staging\".\"stg_interactions\".\"est_reclamatio"
+"n\", \n    \"staging\".\"stg_interactions\".\"motif_reclamation\", \n    \"staging\".\"stg_interactions\".\"statut_resol"
+"ution\", \n    COALESCE(NULLIF(TRIM(\"staging\".\"stg_interactions\".\"delai_resolution_jours\"), '')::FLOAT8, 0.0) \n  "
+"      AS \"delai_resolution_jours\",\n    COALESCE(NULLIF(TRIM(\"staging\".\"stg_interactions\".\"score_satisfaction_nps"
+"\"), '')::FLOAT8, 0.0) \n        AS \"score_satisfaction_nps\",\n    \"staging\".\"stg_interactions\".\"duree_connexion_"
+"sec\"\nFROM \"staging\".\"stg_interactions\"";
		    

            	globalMap.put("tDBInput_8_QUERY",dbquery_tDBInput_8);
		    java.sql.ResultSet rs_tDBInput_8 = null;

		    try {
		    	rs_tDBInput_8 = stmt_tDBInput_8.executeQuery(dbquery_tDBInput_8);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_8 = rs_tDBInput_8.getMetaData();
		    	int colQtyInRs_tDBInput_8 = rsmd_tDBInput_8.getColumnCount();

		    String tmpContent_tDBInput_8 = null;
		    
		    
		    while (rs_tDBInput_8.next()) {
		        nb_line_tDBInput_8++;
		        
							if(colQtyInRs_tDBInput_8 < 1) {
								row6.id_interaction = null;
							} else {
	                         		
        	row6.id_interaction = routines.system.JDBCUtil.getString(rs_tDBInput_8, 1, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 2) {
								row6.id_client = null;
							} else {
	                         		
        	row6.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_8, 2, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 3) {
								row6.date_interaction = null;
							} else {
										
			row6.date_interaction = routines.system.JDBCUtil.getDate(rs_tDBInput_8, 3);
		                    }
							if(colQtyInRs_tDBInput_8 < 4) {
								row6.canal_interaction = null;
							} else {
	                         		
        	row6.canal_interaction = routines.system.JDBCUtil.getString(rs_tDBInput_8, 4, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 5) {
								row6.type_interaction = null;
							} else {
	                         		
        	row6.type_interaction = routines.system.JDBCUtil.getString(rs_tDBInput_8, 5, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 6) {
								row6.est_reclamation = null;
							} else {
		                          
            row6.est_reclamation = rs_tDBInput_8.getLong(6);
            if(rs_tDBInput_8.wasNull()){
                    row6.est_reclamation = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 7) {
								row6.motif_reclamation = null;
							} else {
	                         		
        	row6.motif_reclamation = routines.system.JDBCUtil.getString(rs_tDBInput_8, 7, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 8) {
								row6.statut_resolution = null;
							} else {
	                         		
        	row6.statut_resolution = routines.system.JDBCUtil.getString(rs_tDBInput_8, 8, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 9) {
								row6.delai_resolution_jours = null;
							} else {
	                         		
            row6.delai_resolution_jours = rs_tDBInput_8.getDouble(9);
            if(rs_tDBInput_8.wasNull()){
                    row6.delai_resolution_jours = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 10) {
								row6.score_satisfaction_nps = null;
							} else {
	                         		
            row6.score_satisfaction_nps = rs_tDBInput_8.getDouble(10);
            if(rs_tDBInput_8.wasNull()){
                    row6.score_satisfaction_nps = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 11) {
								row6.duree_connexion_sec = null;
							} else {
		                          
            row6.duree_connexion_sec = rs_tDBInput_8.getLong(11);
            if(rs_tDBInput_8.wasNull()){
                    row6.duree_connexion_sec = null;
            }
		                    }
					


 



/**
 * [tDBInput_8 begin ] stop
 */
	
	/**
	 * [tDBInput_8 main ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 


	tos_count_tDBInput_8++;

/**
 * [tDBInput_8 main ] stop
 */
	
	/**
	 * [tDBInput_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 process_data_begin ] stop
 */

	
	/**
	 * [tAggregateRow_2_AGGOUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
						);
					}
					
	
operation_finder_tAggregateRow_2.id_client = row6.id_client;
			

	operation_finder_tAggregateRow_2.hashCodeDirty = true;
	
	operation_result_tAggregateRow_2 = hash_tAggregateRow_2.get(operation_finder_tAggregateRow_2);

	

	if(operation_result_tAggregateRow_2 == null) { // G_OutMain_AggR_001

		operation_result_tAggregateRow_2 = new AggOperationStruct_tAggregateRow_2();

		operation_result_tAggregateRow_2.id_client = operation_finder_tAggregateRow_2.id_client;
				
		
		

		hash_tAggregateRow_2.put(operation_result_tAggregateRow_2, operation_result_tAggregateRow_2);
	
	} // G_OutMain_AggR_001


	
				operation_result_tAggregateRow_2.nb_interactions_clmCount++;
				operation_result_tAggregateRow_2.count++;
				
					if(operation_result_tAggregateRow_2.nb_reclamations_sum == null) {
						operation_result_tAggregateRow_2.nb_reclamations_sum = (long) 0;
					}
					
					if( row6.est_reclamation != null)
						operation_result_tAggregateRow_2.nb_reclamations_sum += row6.est_reclamation;
				operation_result_tAggregateRow_2.delai_resolution_moyen_count++;
				
					if(operation_result_tAggregateRow_2.delai_resolution_moyen_sum == null) {
						operation_result_tAggregateRow_2.delai_resolution_moyen_sum = new BigDecimal(0);
					}
					operation_result_tAggregateRow_2.delai_resolution_moyen_sum = operation_result_tAggregateRow_2.delai_resolution_moyen_sum.add(
						new BigDecimal(
							String.valueOf(
								row6.delai_resolution_jours
							)
						)
					);
					
				operation_result_tAggregateRow_2.duree_inact_connexion_sec_count++;
				
					if(operation_result_tAggregateRow_2.duree_inact_connexion_sec_sum == null) {
						operation_result_tAggregateRow_2.duree_inact_connexion_sec_sum = (double) 0;
					}
					
					if( row6.duree_connexion_sec != null)
						operation_result_tAggregateRow_2.duree_inact_connexion_sec_sum += row6.duree_connexion_sec;


 


	tos_count_tAggregateRow_2_AGGOUT++;

/**
 * [tAggregateRow_2_AGGOUT main ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGOUT process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	

 



/**
 * [tAggregateRow_2_AGGOUT process_data_begin ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGOUT process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	

 



/**
 * [tAggregateRow_2_AGGOUT process_data_end ] stop
 */



	
	/**
	 * [tDBInput_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_8 end ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

	}
}finally{
	if (rs_tDBInput_8 != null) {
		rs_tDBInput_8.close();
	}
	if (stmt_tDBInput_8 != null) {
		stmt_tDBInput_8.close();
	}
	if(conn_tDBInput_8 != null && !conn_tDBInput_8.isClosed()) {
		
			conn_tDBInput_8.commit();
			
		
			conn_tDBInput_8.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_8_NB_LINE",nb_line_tDBInput_8);
 

ok_Hash.put("tDBInput_8", true);
end_Hash.put("tDBInput_8", System.currentTimeMillis());




/**
 * [tDBInput_8 end ] stop
 */

	
	/**
	 * [tAggregateRow_2_AGGOUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row6");
			  	}
			  	
 

ok_Hash.put("tAggregateRow_2_AGGOUT", true);
end_Hash.put("tAggregateRow_2_AGGOUT", System.currentTimeMillis());




/**
 * [tAggregateRow_2_AGGOUT end ] stop
 */


	
	/**
	 * [tAdvancedHash_row10 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row10", false);
		start_Hash.put("tAdvancedHash_row10", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row10";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row10");
					}
				
		int tos_count_tAdvancedHash_row10 = 0;
		

			   		// connection name:row10
			   		// source node:tAggregateRow_2_AGGIN - inputs:(OnRowsEnd) outputs:(row10,row10) | target node:tAdvancedHash_row10 - inputs:(row10) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row4,row7,row8,row9,row3,row10,row5) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row10 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row10Struct> tHash_Lookup_row10 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row10Struct>getLookup(matchingModeEnum_row10);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row10", tHash_Lookup_row10);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row10 begin ] stop
 */



	
	/**
	 * [tAggregateRow_2_AGGIN begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_2_AGGIN", false);
		start_Hash.put("tAggregateRow_2_AGGIN", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	
		int tos_count_tAggregateRow_2_AGGIN = 0;
		

java.util.Collection<AggOperationStruct_tAggregateRow_2> values_tAggregateRow_2 = hash_tAggregateRow_2.values();

globalMap.put("tAggregateRow_2_NB_LINE", values_tAggregateRow_2.size());

for(AggOperationStruct_tAggregateRow_2 aggregated_row_tAggregateRow_2 : values_tAggregateRow_2) { // G_AggR_600



 



/**
 * [tAggregateRow_2_AGGIN begin ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGIN main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

            				    row10.id_client = aggregated_row_tAggregateRow_2.id_client;
            				    row10.nb_reclamations = aggregated_row_tAggregateRow_2.nb_reclamations_sum;
                                	row10.nb_interactions = (long) aggregated_row_tAggregateRow_2.count;
	                                	row10.nb_interactions = (long) aggregated_row_tAggregateRow_2.nb_interactions_clmCount;
	                                	
                                if(aggregated_row_tAggregateRow_2.delai_resolution_moyen_count > 0){
                                	
	    								row10.delai_resolution_moyen = aggregated_row_tAggregateRow_2.delai_resolution_moyen_sum.divide(new BigDecimal(String.valueOf(aggregated_row_tAggregateRow_2.delai_resolution_moyen_count)), 10, BigDecimal.ROUND_HALF_UP)
	    								
	    									.doubleValue()
	    								
	    								;
    								
                                } else {
                                		String count = "0";
   	    								
    		    							row10.delai_resolution_moyen = ParserUtils.parseTo_Double(count);
    									
                                }
                                if(aggregated_row_tAggregateRow_2.duree_inact_connexion_sec_count > 0){
                                	
	    								double row10_duree_inact_connexion_sec_temp = (double) aggregated_row_tAggregateRow_2.duree_inact_connexion_sec_sum / (double) aggregated_row_tAggregateRow_2.duree_inact_connexion_sec_count;
	    								
	    								row10.duree_inact_connexion_sec = (double) row10_duree_inact_connexion_sec_temp;
										
    								
                                } else {
                                		String count = "0";
   	    								
    		    							row10.duree_inact_connexion_sec = ParserUtils.parseTo_Double(count);
    									
                                }

 


	tos_count_tAggregateRow_2_AGGIN++;

/**
 * [tAggregateRow_2_AGGIN main ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGIN process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

 



/**
 * [tAggregateRow_2_AGGIN process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row10 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row10"
						
						);
					}
					


			   
			   

					row10Struct row10_HashRow = new row10Struct();
		   	   	   
				
				row10_HashRow.id_interaction = row10.id_interaction;
				
				row10_HashRow.id_client = row10.id_client;
				
				row10_HashRow.date_interaction = row10.date_interaction;
				
				row10_HashRow.canal_interaction = row10.canal_interaction;
				
				row10_HashRow.type_interaction = row10.type_interaction;
				
				row10_HashRow.est_reclamation = row10.est_reclamation;
				
				row10_HashRow.motif_reclamation = row10.motif_reclamation;
				
				row10_HashRow.statut_resolution = row10.statut_resolution;
				
				row10_HashRow.delai_resolution_jours = row10.delai_resolution_jours;
				
				row10_HashRow.score_satisfaction_nps = row10.score_satisfaction_nps;
				
				row10_HashRow.duree_connexion_sec = row10.duree_connexion_sec;
				
				row10_HashRow.nb_reclamations = row10.nb_reclamations;
				
				row10_HashRow.nb_interactions = row10.nb_interactions;
				
				row10_HashRow.delai_resolution_moyen = row10.delai_resolution_moyen;
				
				row10_HashRow.duree_inact_connexion_sec = row10.duree_inact_connexion_sec;
				
			tHash_Lookup_row10.put(row10_HashRow);
			
            




 


	tos_count_tAdvancedHash_row10++;

/**
 * [tAdvancedHash_row10 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row10 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	

 



/**
 * [tAdvancedHash_row10 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row10 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	

 



/**
 * [tAdvancedHash_row10 process_data_end ] stop
 */



	
	/**
	 * [tAggregateRow_2_AGGIN process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

 



/**
 * [tAggregateRow_2_AGGIN process_data_end ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGIN end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

} // G_AggR_600

 

ok_Hash.put("tAggregateRow_2_AGGIN", true);
end_Hash.put("tAggregateRow_2_AGGIN", System.currentTimeMillis());




/**
 * [tAggregateRow_2_AGGIN end ] stop
 */

	
	/**
	 * [tAdvancedHash_row10 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	

tHash_Lookup_row10.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row10");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row10", true);
end_Hash.put("tAdvancedHash_row10", System.currentTimeMillis());




/**
 * [tAdvancedHash_row10 end ] stop
 */









				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
							//free memory for "tAggregateRow_2_AGGIN"
							globalMap.remove("tAggregateRow_2");
						
				try{
					
	
	/**
	 * [tDBInput_8 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 finally ] stop
 */

	
	/**
	 * [tAggregateRow_2_AGGOUT finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	

 



/**
 * [tAggregateRow_2_AGGOUT finally ] stop
 */

	
	/**
	 * [tAggregateRow_2_AGGIN finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

 



/**
 * [tAggregateRow_2_AGGIN finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row10 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	

 



/**
 * [tAdvancedHash_row10 finally ] stop
 */









				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 1);
	}
	


public static class row5Struct implements routines.system.IPersistableComparableLookupRow<row5Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_date_sk;

				public int getId_date_sk () {
					return this.id_date_sk;
				}
				
			    public java.util.Date date_complete;

				public java.util.Date getDate_complete () {
					return this.date_complete;
				}
				
			    public Integer annee;

				public Integer getAnnee () {
					return this.annee;
				}
				
			    public Integer mois;

				public Integer getMois () {
					return this.mois;
				}
				
			    public String nom_mois;

				public String getNom_mois () {
					return this.nom_mois;
				}
				
			    public Integer jour;

				public Integer getJour () {
					return this.jour;
				}
				
			    public Integer jour_semaine;

				public Integer getJour_semaine () {
					return this.jour_semaine;
				}
				
			    public String nom_jour;

				public String getNom_jour () {
					return this.nom_jour;
				}
				
			    public Integer trimestre;

				public Integer getTrimestre () {
					return this.trimestre;
				}
				
			    public Boolean est_weekend;

				public Boolean getEst_weekend () {
					return this.est_weekend;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.date_complete == null) ? 0 : this.date_complete.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row5Struct other = (row5Struct) obj;
		
						if (this.date_complete == null) {
							if (other.date_complete != null)
								return false;
						
						} else if (!this.date_complete.equals(other.date_complete))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row5Struct other) {

		other.id_date_sk = this.id_date_sk;
	            other.date_complete = this.date_complete;
	            other.annee = this.annee;
	            other.mois = this.mois;
	            other.nom_mois = this.nom_mois;
	            other.jour = this.jour;
	            other.jour_semaine = this.jour_semaine;
	            other.nom_jour = this.nom_jour;
	            other.trimestre = this.trimestre;
	            other.est_weekend = this.est_weekend;
	            
	}

	public void copyKeysDataTo(row5Struct other) {

		other.date_complete = this.date_complete;
	            	
	}




	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.date_complete = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_FAIT_churn_client) {

        	try {

        		int length = 0;
		
					this.date_complete = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.date_complete,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.date_complete,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.id_date_sk = dis.readInt();
					
						this.annee = readInteger(dis,ois);
					
						this.mois = readInteger(dis,ois);
					
						this.nom_mois = readString(dis,ois);
					
						this.jour = readInteger(dis,ois);
					
						this.jour_semaine = readInteger(dis,ois);
					
						this.nom_jour = readString(dis,ois);
					
						this.trimestre = readInteger(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_weekend = null;
           				} else {
           			    	this.est_weekend = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.id_date_sk = objectIn.readInt();
					
						this.annee = readInteger(dis,objectIn);
					
						this.mois = readInteger(dis,objectIn);
					
						this.nom_mois = readString(dis,objectIn);
					
						this.jour = readInteger(dis,objectIn);
					
						this.jour_semaine = readInteger(dis,objectIn);
					
						this.nom_jour = readString(dis,objectIn);
					
						this.trimestre = readInteger(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.est_weekend = null;
           				} else {
           			    	this.est_weekend = objectIn.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.id_date_sk);
					
					writeInteger(this.annee, dos, oos);
					
					writeInteger(this.mois, dos, oos);
					
						writeString(this.nom_mois, dos, oos);
					
					writeInteger(this.jour, dos, oos);
					
					writeInteger(this.jour_semaine, dos, oos);
					
						writeString(this.nom_jour, dos, oos);
					
					writeInteger(this.trimestre, dos, oos);
					
						if(this.est_weekend == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.est_weekend);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.id_date_sk);
					
					writeInteger(this.annee, dos, objectOut);
					
					writeInteger(this.mois, dos, objectOut);
					
						writeString(this.nom_mois, dos, objectOut);
					
					writeInteger(this.jour, dos, objectOut);
					
					writeInteger(this.jour_semaine, dos, objectOut);
					
						writeString(this.nom_jour, dos, objectOut);
					
					writeInteger(this.trimestre, dos, objectOut);
					
						if(this.est_weekend == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeBoolean(this.est_weekend);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_date_sk="+String.valueOf(id_date_sk));
		sb.append(",date_complete="+String.valueOf(date_complete));
		sb.append(",annee="+String.valueOf(annee));
		sb.append(",mois="+String.valueOf(mois));
		sb.append(",nom_mois="+nom_mois);
		sb.append(",jour="+String.valueOf(jour));
		sb.append(",jour_semaine="+String.valueOf(jour_semaine));
		sb.append(",nom_jour="+nom_jour);
		sb.append(",trimestre="+String.valueOf(trimestre));
		sb.append(",est_weekend="+String.valueOf(est_weekend));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.date_complete, other.date_complete);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row5Struct row5 = new row5Struct();




	
	/**
	 * [tAdvancedHash_row5 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row5", false);
		start_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tAdvancedHash_row5 = 0;
		

			   		// connection name:row5
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row5,row5) | target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row4,row7,row8,row9,row3,row10,row5) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row5Struct>getLookup(matchingModeEnum_row5);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row5 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
	
    
	
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = context.username;
				
				
	final String decryptedPassword_tDBInput_2 = context.password; 
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
				String url_tDBInput_2 = "jdbc:postgresql://" + context.host + ":" + context.port + "/" + context.database + "?" + context.params;
				
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
		        
				conn_tDBInput_2.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT \n  \"DWH_ATTEJARI\".\"DIM_DATE\".\"id_date_sk\", \n  \"DWH_ATTEJARI\".\"DIM_DATE\".\"date_complete\", \n  \"DWH_AT"
+"TEJARI\".\"DIM_DATE\".\"annee\", \n  \"DWH_ATTEJARI\".\"DIM_DATE\".\"mois\", \n  \"DWH_ATTEJARI\".\"DIM_DATE\".\"nom_mois"
+"\", \n  \"DWH_ATTEJARI\".\"DIM_DATE\".\"jour\", \n  \"DWH_ATTEJARI\".\"DIM_DATE\".\"jour_semaine\", \n  \"DWH_ATTEJARI\".\""
+"DIM_DATE\".\"nom_jour\", \n  \"DWH_ATTEJARI\".\"DIM_DATE\".\"trimestre\", \n  \"DWH_ATTEJARI\".\"DIM_DATE\".\"est_weekend"
+"\"\nFROM \"DWH_ATTEJARI\".\"DIM_DATE\"";
		    

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row5.id_date_sk = 0;
							} else {
		                          
            row5.id_date_sk = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row5.date_complete = null;
							} else {
										
			row5.date_complete = routines.system.JDBCUtil.getDate(rs_tDBInput_2, 2);
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row5.annee = null;
							} else {
		                          
            row5.annee = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    row5.annee = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row5.mois = null;
							} else {
		                          
            row5.mois = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    row5.mois = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row5.nom_mois = null;
							} else {
	                         		
        	row5.nom_mois = routines.system.JDBCUtil.getString(rs_tDBInput_2, 5, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row5.jour = null;
							} else {
		                          
            row5.jour = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    row5.jour = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row5.jour_semaine = null;
							} else {
		                          
            row5.jour_semaine = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    row5.jour_semaine = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row5.nom_jour = null;
							} else {
	                         		
        	row5.nom_jour = routines.system.JDBCUtil.getString(rs_tDBInput_2, 8, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row5.trimestre = null;
							} else {
		                          
            row5.trimestre = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    row5.trimestre = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row5.est_weekend = null;
							} else {
	                         		
            row5.est_weekend = rs_tDBInput_2.getBoolean(10);
            if(rs_tDBInput_2.wasNull()){
                    row5.est_weekend = null;
            }
		                    }
					


 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row5 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					


			   
			   

					row5Struct row5_HashRow = new row5Struct();
		   	   	   
				
				row5_HashRow.id_date_sk = row5.id_date_sk;
				
				row5_HashRow.date_complete = row5.date_complete;
				
				row5_HashRow.annee = row5.annee;
				
				row5_HashRow.mois = row5.mois;
				
				row5_HashRow.nom_mois = row5.nom_mois;
				
				row5_HashRow.jour = row5.jour;
				
				row5_HashRow.jour_semaine = row5.jour_semaine;
				
				row5_HashRow.nom_jour = row5.nom_jour;
				
				row5_HashRow.trimestre = row5.trimestre;
				
				row5_HashRow.est_weekend = row5.est_weekend;
				
			tHash_Lookup_row5.put(row5_HashRow);
			
            




 


	tos_count_tAdvancedHash_row5++;

/**
 * [tAdvancedHash_row5 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

 



/**
 * [tAdvancedHash_row5 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row5 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

 



/**
 * [tAdvancedHash_row5 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
	if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
		
			conn_tDBInput_2.commit();
			
		
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
 

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row5 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

tHash_Lookup_row5.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row5", true);
end_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());




/**
 * [tAdvancedHash_row5 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row5 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

 



/**
 * [tAdvancedHash_row5 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Docker";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final J_Load_FAIT_churn_client J_Load_FAIT_churn_clientClass = new J_Load_FAIT_churn_client();

        int exitCode = J_Load_FAIT_churn_clientClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = J_Load_FAIT_churn_client.class.getClassLoader().getResourceAsStream("dwh_attejaribank/j_load_fait_churn_client_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = J_Load_FAIT_churn_client.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("host", "id_String");
                        if(context.getStringValue("host") == null) {
                            context.host = null;
                        } else {
                            context.host=(String) context.getProperty("host");
                        }
                        context.setContextType("port", "id_BigDecimal");
                        if(context.getStringValue("port") == null) {
                            context.port = null;
                        } else {
                            try{
                                context.port=routines.system.ParserUtils.parseTo_BigDecimal (context.getProperty("port"));
                            } catch(NumberFormatException e){
                                System.err.println(String.format("Null value will be used for context parameter %s: %s", "port", e.getMessage()));
                                context.port=null;
                            }
                        }
                        context.setContextType("schema", "id_String");
                        if(context.getStringValue("schema") == null) {
                            context.schema = null;
                        } else {
                            context.schema=(String) context.getProperty("schema");
                        }
                        context.setContextType("database", "id_String");
                        if(context.getStringValue("database") == null) {
                            context.database = null;
                        } else {
                            context.database=(String) context.getProperty("database");
                        }
                        context.setContextType("password", "id_String");
                        if(context.getStringValue("password") == null) {
                            context.password = null;
                        } else {
                            context.password=(String) context.getProperty("password");
                        }
                        context.setContextType("params", "id_String");
                        if(context.getStringValue("params") == null) {
                            context.params = null;
                        } else {
                            context.params=(String) context.getProperty("params");
                        }
                        context.setContextType("username", "id_String");
                        if(context.getStringValue("username") == null) {
                            context.username = null;
                        } else {
                            context.username=(String) context.getProperty("username");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("host")) {
                context.host = (String) parentContextMap.get("host");
            }if (parentContextMap.containsKey("port")) {
                context.port = (BigDecimal) parentContextMap.get("port");
            }if (parentContextMap.containsKey("schema")) {
                context.schema = (String) parentContextMap.get("schema");
            }if (parentContextMap.containsKey("database")) {
                context.database = (String) parentContextMap.get("database");
            }if (parentContextMap.containsKey("password")) {
                context.password = (String) parentContextMap.get("password");
            }if (parentContextMap.containsKey("params")) {
                context.params = (String) parentContextMap.get("params");
            }if (parentContextMap.containsKey("username")) {
                context.username = (String) parentContextMap.get("username");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : J_Load_FAIT_churn_client");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     512454 characters generated by Talend Open Studio for Data Integration 
 *     on the 1 avril 2026 à 16:41:19 WAT
 ************************************************************************************************/