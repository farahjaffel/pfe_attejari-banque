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


package dwh_attejaribank.job_load_dim_reclamation_0_1;

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
 * Job: Job_Load_DIM_RECLAMATION Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Job_Load_DIM_RECLAMATION implements TalendJob {

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
	private final String jobName = "Job_Load_DIM_RECLAMATION";
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
				Job_Load_DIM_RECLAMATION.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Job_Load_DIM_RECLAMATION.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tFilterRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_reclamation_sk;

				public int getId_reclamation_sk () {
					return this.id_reclamation_sk;
				}
				
			    public String id_interaction;

				public String getId_interaction () {
					return this.id_interaction;
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
				
			    public Float delai_resolution_jours;

				public Float getDelai_resolution_jours () {
					return this.delai_resolution_jours;
				}
				
			    public int id_status_recl_fk;

				public int getId_status_recl_fk () {
					return this.id_status_recl_fk;
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
		final row4Struct other = (row4Struct) obj;
		
						if (this.id_interaction == null) {
							if (other.id_interaction != null)
								return false;
						
						} else if (!this.id_interaction.equals(other.id_interaction))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.id_reclamation_sk = this.id_reclamation_sk;
	            other.id_interaction = this.id_interaction;
	            other.id_motif_recla_fk = this.id_motif_recla_fk;
	            other.id_client = this.id_client;
	            other.est_reclamation = this.est_reclamation;
	            other.delai_resolution_jours = this.delai_resolution_jours;
	            other.id_status_recl_fk = this.id_status_recl_fk;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.id_interaction = this.id_interaction;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

        	try {

        		int length = 0;
		
			        this.id_reclamation_sk = dis.readInt();
					
					this.id_interaction = readString(dis);
					
			        this.id_motif_recla_fk = dis.readInt();
					
					this.id_client = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
			        this.id_status_recl_fk = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

        	try {

        		int length = 0;
		
			        this.id_reclamation_sk = dis.readInt();
					
					this.id_interaction = readString(dis);
					
			        this.id_motif_recla_fk = dis.readInt();
					
					this.id_client = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
			        this.id_status_recl_fk = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_reclamation_sk);
					
					// String
				
						writeString(this.id_interaction,dos);
					
					// int
				
		            	dos.writeInt(this.id_motif_recla_fk);
					
					// String
				
						writeString(this.id_client,dos);
					
					// Long
				
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// int
				
		            	dos.writeInt(this.id_status_recl_fk);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_reclamation_sk);
					
					// String
				
						writeString(this.id_interaction,dos);
					
					// int
				
		            	dos.writeInt(this.id_motif_recla_fk);
					
					// String
				
						writeString(this.id_client,dos);
					
					// Long
				
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// int
				
		            	dos.writeInt(this.id_status_recl_fk);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_reclamation_sk="+String.valueOf(id_reclamation_sk));
		sb.append(",id_interaction="+id_interaction);
		sb.append(",id_motif_recla_fk="+String.valueOf(id_motif_recla_fk));
		sb.append(",id_client="+id_client);
		sb.append(",est_reclamation="+String.valueOf(est_reclamation));
		sb.append(",delai_resolution_jours="+String.valueOf(delai_resolution_jours));
		sb.append(",id_status_recl_fk="+String.valueOf(id_status_recl_fk));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

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

public static class reclamationStruct implements routines.system.IPersistableRow<reclamationStruct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_reclamation_sk;

				public int getId_reclamation_sk () {
					return this.id_reclamation_sk;
				}
				
			    public String id_interaction;

				public String getId_interaction () {
					return this.id_interaction;
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
				
			    public Float delai_resolution_jours;

				public Float getDelai_resolution_jours () {
					return this.delai_resolution_jours;
				}
				
			    public int id_status_recl_fk;

				public int getId_status_recl_fk () {
					return this.id_status_recl_fk;
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
		final reclamationStruct other = (reclamationStruct) obj;
		
						if (this.id_interaction == null) {
							if (other.id_interaction != null)
								return false;
						
						} else if (!this.id_interaction.equals(other.id_interaction))
						
							return false;
					

		return true;
    }

	public void copyDataTo(reclamationStruct other) {

		other.id_reclamation_sk = this.id_reclamation_sk;
	            other.id_interaction = this.id_interaction;
	            other.id_motif_recla_fk = this.id_motif_recla_fk;
	            other.id_client = this.id_client;
	            other.est_reclamation = this.est_reclamation;
	            other.delai_resolution_jours = this.delai_resolution_jours;
	            other.id_status_recl_fk = this.id_status_recl_fk;
	            
	}

	public void copyKeysDataTo(reclamationStruct other) {

		other.id_interaction = this.id_interaction;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

        	try {

        		int length = 0;
		
			        this.id_reclamation_sk = dis.readInt();
					
					this.id_interaction = readString(dis);
					
			        this.id_motif_recla_fk = dis.readInt();
					
					this.id_client = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
			        this.id_status_recl_fk = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

        	try {

        		int length = 0;
		
			        this.id_reclamation_sk = dis.readInt();
					
					this.id_interaction = readString(dis);
					
			        this.id_motif_recla_fk = dis.readInt();
					
					this.id_client = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.est_reclamation = null;
           				} else {
           			    	this.est_reclamation = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.delai_resolution_jours = null;
           				} else {
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
			        this.id_status_recl_fk = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_reclamation_sk);
					
					// String
				
						writeString(this.id_interaction,dos);
					
					// int
				
		            	dos.writeInt(this.id_motif_recla_fk);
					
					// String
				
						writeString(this.id_client,dos);
					
					// Long
				
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// int
				
		            	dos.writeInt(this.id_status_recl_fk);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_reclamation_sk);
					
					// String
				
						writeString(this.id_interaction,dos);
					
					// int
				
		            	dos.writeInt(this.id_motif_recla_fk);
					
					// String
				
						writeString(this.id_client,dos);
					
					// Long
				
						if(this.est_reclamation == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.est_reclamation);
		            	}
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// int
				
		            	dos.writeInt(this.id_status_recl_fk);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_reclamation_sk="+String.valueOf(id_reclamation_sk));
		sb.append(",id_interaction="+id_interaction);
		sb.append(",id_motif_recla_fk="+String.valueOf(id_motif_recla_fk));
		sb.append(",id_client="+id_client);
		sb.append(",est_reclamation="+String.valueOf(est_reclamation));
		sb.append(",delai_resolution_jours="+String.valueOf(delai_resolution_jours));
		sb.append(",id_status_recl_fk="+String.valueOf(id_status_recl_fk));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(reclamationStruct other) {

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

public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];

	
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
				
			    public Float delai_resolution_jours;

				public Float getDelai_resolution_jours () {
					return this.delai_resolution_jours;
				}
				
			    public String score_satisfaction_nps;

				public String getScore_satisfaction_nps () {
					return this.score_satisfaction_nps;
				}
				
			    public Long duree_connexion_sec;

				public Long getDuree_connexion_sec () {
					return this.duree_connexion_sec;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

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
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
					this.score_satisfaction_nps = readString(dis);
					
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

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
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
					this.score_satisfaction_nps = readString(dis);
					
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
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// String
				
						writeString(this.score_satisfaction_nps,dos);
					
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
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// String
				
						writeString(this.score_satisfaction_nps,dos);
					
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
		sb.append(",score_satisfaction_nps="+score_satisfaction_nps);
		sb.append(",duree_connexion_sec="+String.valueOf(duree_connexion_sec));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

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

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
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
				
			    public Float delai_resolution_jours;

				public Float getDelai_resolution_jours () {
					return this.delai_resolution_jours;
				}
				
			    public String score_satisfaction_nps;

				public String getScore_satisfaction_nps () {
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
		final row1Struct other = (row1Struct) obj;
		
						if (this.id_interaction == null) {
							if (other.id_interaction != null)
								return false;
						
						} else if (!this.id_interaction.equals(other.id_interaction))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row1Struct other) {

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

	public void copyKeysDataTo(row1Struct other) {

		other.id_interaction = this.id_interaction;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

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
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
					this.score_satisfaction_nps = readString(dis);
					
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

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
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
					this.score_satisfaction_nps = readString(dis);
					
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
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// String
				
						writeString(this.score_satisfaction_nps,dos);
					
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
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// String
				
						writeString(this.score_satisfaction_nps,dos);
					
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
		sb.append(",score_satisfaction_nps="+score_satisfaction_nps);
		sb.append(",duree_connexion_sec="+String.valueOf(duree_connexion_sec));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

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

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
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
				
			    public Float delai_resolution_jours;

				public Float getDelai_resolution_jours () {
					return this.delai_resolution_jours;
				}
				
			    public String score_satisfaction_nps;

				public String getScore_satisfaction_nps () {
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
		final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;
		
						if (this.id_interaction == null) {
							if (other.id_interaction != null)
								return false;
						
						} else if (!this.id_interaction.equals(other.id_interaction))
						
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_1Struct other) {

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

	public void copyKeysDataTo(after_tDBInput_1Struct other) {

		other.id_interaction = this.id_interaction;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

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
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
					this.score_satisfaction_nps = readString(dis);
					
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

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
           			    	this.delai_resolution_jours = dis.readFloat();
           				}
					
					this.score_satisfaction_nps = readString(dis);
					
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
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// String
				
						writeString(this.score_satisfaction_nps,dos);
					
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
					
					// Float
				
						if(this.delai_resolution_jours == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.delai_resolution_jours);
		            	}
					
					// String
				
						writeString(this.score_satisfaction_nps,dos);
					
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
		sb.append(",score_satisfaction_nps="+score_satisfaction_nps);
		sb.append(",duree_connexion_sec="+String.valueOf(duree_connexion_sec));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

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


		tDBInput_2Process(globalMap);
		tDBInput_3Process(globalMap);

		row1Struct row1 = new row1Struct();
row5Struct row5 = new row5Struct();
reclamationStruct reclamation = new reclamationStruct();
reclamationStruct row4 = reclamation;







	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = context.schema;
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = ("DIM_RECLAMATION");
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("DIM_RECLAMATION");
}

        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 7 && true) {
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
	    String update_tDBOutput_1 = "UPDATE \"" + tableName_tDBOutput_1 + "\" SET \"id_interaction\" = ?,\"id_motif_recla_fk\" = ?,\"id_client\" = ?,\"est_reclamation\" = ?,\"delai_resolution_jours\" = ?,\"id_status_recl_fk\" = ? WHERE \"id_interaction\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
	    resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);
	    String insert_tDBOutput_1 = "INSERT INTO \"" + tableName_tDBOutput_1 + "\" (\"id_interaction\",\"id_motif_recla_fk\",\"id_client\",\"est_reclamation\",\"delai_resolution_jours\",\"id_status_recl_fk\") VALUES (?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
	    

 



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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"reclamation");
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
reclamationStruct reclamation_tmp = new reclamationStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tFilterRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFilterRow_1", false);
		start_Hash.put("tFilterRow_1", System.currentTimeMillis());
		
	
	currentComponent="tFilterRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tFilterRow_1 = 0;
		
    int nb_line_tFilterRow_1 = 0;
    int nb_line_ok_tFilterRow_1 = 0;
    int nb_line_reject_tFilterRow_1 = 0;

    class Operator_tFilterRow_1 {
      private String sErrorMsg = "";
      private boolean bMatchFlag = true;
      private String sUnionFlag = "&&";

      public Operator_tFilterRow_1(String unionFlag){
        sUnionFlag = unionFlag;
        bMatchFlag =  "||".equals(unionFlag) ? false : true;
      }

      public String getErrorMsg() {
        if (sErrorMsg != null && sErrorMsg.length() > 1)
          return sErrorMsg.substring(1);
        else 
          return null;
      }

      public boolean getMatchFlag() {
        return bMatchFlag;
      }

      public void matches(boolean partMatched, String reason) {
        // no need to care about the next judgement
        if ("||".equals(sUnionFlag) && bMatchFlag){
          return;
        }

        if (!partMatched) {
          sErrorMsg += "|" + reason;
        }

        if ("||".equals(sUnionFlag))
          bMatchFlag = bMatchFlag || partMatched;
        else
          bMatchFlag = bMatchFlag && partMatched;
      }
    }

 



/**
 * [tFilterRow_1 begin ] stop
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

		    String dbquery_tDBInput_1 = "SELECT \n  \"staging\".\"stg_interactions\".\"id_interaction\", \n  \"staging\".\"stg_interactions\".\"id_client\", \n  \""
+"staging\".\"stg_interactions\".\"date_interaction\", \n  \"staging\".\"stg_interactions\".\"canal_interaction\", \n  \"sta"
+"ging\".\"stg_interactions\".\"type_interaction\", \n  \"staging\".\"stg_interactions\".\"est_reclamation\", \n  \"staging"
+"\".\"stg_interactions\".\"motif_reclamation\", \n  \"staging\".\"stg_interactions\".\"statut_resolution\", \n  \"staging\""
+".\"stg_interactions\".\"delai_resolution_jours\", \n  \"staging\".\"stg_interactions\".\"score_satisfaction_nps\", \n  \"s"
+"taging\".\"stg_interactions\".\"duree_connexion_sec\"\nFROM \"staging\".\"stg_interactions\"";
		    

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
								row1.id_interaction = null;
							} else {
	                         		
        	row1.id_interaction = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.id_client = null;
							} else {
	                         		
        	row1.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.date_interaction = null;
							} else {
										
			row1.date_interaction = routines.system.JDBCUtil.getDate(rs_tDBInput_1, 3);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.canal_interaction = null;
							} else {
	                         		
        	row1.canal_interaction = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.type_interaction = null;
							} else {
	                         		
        	row1.type_interaction = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.est_reclamation = null;
							} else {
		                          
            row1.est_reclamation = rs_tDBInput_1.getLong(6);
            if(rs_tDBInput_1.wasNull()){
                    row1.est_reclamation = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.motif_reclamation = null;
							} else {
	                         		
        	row1.motif_reclamation = routines.system.JDBCUtil.getString(rs_tDBInput_1, 7, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.statut_resolution = null;
							} else {
	                         		
        	row1.statut_resolution = routines.system.JDBCUtil.getString(rs_tDBInput_1, 8, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.delai_resolution_jours = null;
							} else {
		                          
            row1.delai_resolution_jours = rs_tDBInput_1.getFloat(9);
            if(rs_tDBInput_1.wasNull()){
                    row1.delai_resolution_jours = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.score_satisfaction_nps = null;
							} else {
	                         		
        	row1.score_satisfaction_nps = routines.system.JDBCUtil.getString(rs_tDBInput_1, 10, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.duree_connexion_sec = null;
							} else {
		                          
            row1.duree_connexion_sec = rs_tDBInput_1.getLong(11);
            if(rs_tDBInput_1.wasNull()){
                    row1.duree_connexion_sec = null;
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
	 * [tFilterRow_1 main ] start
	 */

	

	
	
	currentComponent="tFilterRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

          row5 = null;
    Operator_tFilterRow_1 ope_tFilterRow_1 = new Operator_tFilterRow_1("&&");
            ope_tFilterRow_1.matches((row1.est_reclamation == null? false : row1.est_reclamation.compareTo(ParserUtils.parseTo_Long(String.valueOf(1))) == 0)
                           , "est_reclamation.compareTo(1) == 0 failed");
		 	
    
    if (ope_tFilterRow_1.getMatchFlag()) {
              if(row5 == null){ 
                row5 = new row5Struct();
              }
               row5.id_interaction = row1.id_interaction;
               row5.id_client = row1.id_client;
               row5.date_interaction = row1.date_interaction;
               row5.canal_interaction = row1.canal_interaction;
               row5.type_interaction = row1.type_interaction;
               row5.est_reclamation = row1.est_reclamation;
               row5.motif_reclamation = row1.motif_reclamation;
               row5.statut_resolution = row1.statut_resolution;
               row5.delai_resolution_jours = row1.delai_resolution_jours;
               row5.score_satisfaction_nps = row1.score_satisfaction_nps;
               row5.duree_connexion_sec = row1.duree_connexion_sec;    
      nb_line_ok_tFilterRow_1++;
    } else {
      nb_line_reject_tFilterRow_1++;
    }

nb_line_tFilterRow_1++;

 


	tos_count_tFilterRow_1++;

/**
 * [tFilterRow_1 main ] stop
 */
	
	/**
	 * [tFilterRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFilterRow_1";

	

 



/**
 * [tFilterRow_1 process_data_begin ] stop
 */
// Start of branch "row5"
if(row5 != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row2HashKey.motif_reclamation = row1.motif_reclamation ;
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.motif_reclamation = '" + row2HashKey.motif_reclamation + "'");
								} // G 071
							

							row2Struct row2 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								 
							
							
								if (tHash_Lookup_row2 !=null && tHash_Lookup_row2.hasNext()) { // G 099
								
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							
							
								} // G 099
							
							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row3HashKey.statut_resolution = row1.statut_resolution ;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.statut_resolution = '" + row3HashKey.statut_resolution + "'");
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
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

reclamation = null;


// # Output table : 'reclamation'
reclamation_tmp.id_reclamation_sk = 0;
reclamation_tmp.id_interaction = row1.id_interaction ;
reclamation_tmp.id_motif_recla_fk = row2.id_motif_recla ;
reclamation_tmp.id_client = row1.id_client ;
reclamation_tmp.est_reclamation = row1.est_reclamation ;
reclamation_tmp.delai_resolution_jours = row1.delai_resolution_jours ;
reclamation_tmp.id_status_recl_fk = row3.id_status_recl ;
reclamation = reclamation_tmp;
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
// Start of branch "reclamation"
if(reclamation != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"reclamation"
						
						);
					}
					
///////////////////////		
						



				strBuffer_tLogRow_1 = new StringBuilder();




              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(reclamation.id_reclamation_sk)							
				);


							  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(reclamation.id_interaction != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(reclamation.id_interaction)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(reclamation.id_motif_recla_fk)							
				);


							  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(reclamation.id_client != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(reclamation.id_client)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(reclamation.est_reclamation != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(reclamation.est_reclamation)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(reclamation.delai_resolution_jours != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.formatUnwithE(reclamation.delai_resolution_jours)				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(reclamation.id_status_recl_fk)							
				);


							  			
 

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

 
     row4 = reclamation;


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
						
							,"row4"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
            int updateFlag_tDBOutput_1=0;
                    if(row4.id_interaction == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, row4.id_interaction);
}

                    pstmtUpdate_tDBOutput_1.setInt(2, row4.id_motif_recla_fk);

                    if(row4.id_client == null) {
pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(3, row4.id_client);
}

                    if(row4.est_reclamation == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(4, row4.est_reclamation);
}

                    if(row4.delai_resolution_jours == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.FLOAT);
} else {pstmtUpdate_tDBOutput_1.setFloat(5, row4.delai_resolution_jours);
}

                    pstmtUpdate_tDBOutput_1.setInt(6, row4.id_status_recl_fk);


                    if(row4.id_interaction == null) {
pstmtUpdate_tDBOutput_1.setNull(7 + count_tDBOutput_1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(7 + count_tDBOutput_1, row4.id_interaction);
}


            try {
				
                updateFlag_tDBOutput_1=pstmtUpdate_tDBOutput_1.executeUpdate();
                updatedCount_tDBOutput_1 = updatedCount_tDBOutput_1+updateFlag_tDBOutput_1;
                rowsToCommitCount_tDBOutput_1 += updateFlag_tDBOutput_1;
				
            if(updateFlag_tDBOutput_1 == 0) {
            	
                        if(row4.id_interaction == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(1, row4.id_interaction);
}

                        pstmtInsert_tDBOutput_1.setInt(2, row4.id_motif_recla_fk);

                        if(row4.id_client == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(3, row4.id_client);
}

                        if(row4.est_reclamation == null) {
pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(4, row4.est_reclamation);
}

                        if(row4.delai_resolution_jours == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.FLOAT);
} else {pstmtInsert_tDBOutput_1.setFloat(5, row4.delai_resolution_jours);
}

                        pstmtInsert_tDBOutput_1.setInt(6, row4.id_status_recl_fk);

					
                    int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
                    insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
					
    	            }else{
    					nb_line_tDBOutput_1++;
    					
     					
    				}
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_1 = true;
                        nb_line_tDBOutput_1++;
                            System.err.print(e.getMessage());
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

} // End of branch "reclamation"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "row5"




	
	/**
	 * [tFilterRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFilterRow_1";

	

 



/**
 * [tFilterRow_1 process_data_end ] stop
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
	 * [tFilterRow_1 end ] start
	 */

	

	
	
	currentComponent="tFilterRow_1";

	
    globalMap.put("tFilterRow_1_NB_LINE", nb_line_tFilterRow_1);
    globalMap.put("tFilterRow_1_NB_LINE_OK", nb_line_ok_tFilterRow_1);
    globalMap.put("tFilterRow_1_NB_LINE_REJECT", nb_line_reject_tFilterRow_1);
    

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tFilterRow_1", true);
end_Hash.put("tFilterRow_1", System.currentTimeMillis());




/**
 * [tFilterRow_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"reclamation");
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
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
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tFilterRow_1 finally ] start
	 */

	

	
	
	currentComponent="tFilterRow_1";

	

 



/**
 * [tFilterRow_1 finally ] stop
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
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_motif_recla;

				public int getId_motif_recla () {
					return this.id_motif_recla;
				}
				
			    public String motif_reclamation;

				public String getMotif_reclamation () {
					return this.motif_reclamation;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.motif_reclamation == null) ? 0 : this.motif_reclamation.hashCode());
					
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
		
						if (this.motif_reclamation == null) {
							if (other.motif_reclamation != null)
								return false;
						
						} else if (!this.motif_reclamation.equals(other.motif_reclamation))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.id_motif_recla = this.id_motif_recla;
	            other.motif_reclamation = this.motif_reclamation;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.motif_reclamation = this.motif_reclamation;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

        	try {

        		int length = 0;
		
					this.motif_reclamation = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

        	try {

        		int length = 0;
		
					this.motif_reclamation = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.motif_reclamation,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.motif_reclamation,dos);
					
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
		
			            this.id_motif_recla = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.id_motif_recla = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.id_motif_recla);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.id_motif_recla);
					
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
		sb.append("id_motif_recla="+String.valueOf(id_motif_recla));
		sb.append(",motif_reclamation="+motif_reclamation);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.motif_reclamation, other.motif_reclamation);
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



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tAdvancedHash_row2 = 0;
		

			   		// connection name:row2
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row5,row2,row3) outputs:(reclamation)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
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

		    String dbquery_tDBInput_2 = "SELECT \n  \"DWH_ATTEJARI\".\"DIM_MOTIF_RECLAMATION\".\"id_motif_recla_sk\", \n  \"DWH_ATTEJARI\".\"DIM_MOTIF_RECLAMATION"
+"\".\"motif_reclamation\"\nFROM \"DWH_ATTEJARI\".\"DIM_MOTIF_RECLAMATION\"";
		    

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
								row2.id_motif_recla = 0;
							} else {
		                          
            row2.id_motif_recla = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.motif_reclamation = null;
							} else {
	                         		
        	row2.motif_reclamation = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
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
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.id_motif_recla = row2.id_motif_recla;
				
				row2_HashRow.motif_reclamation = row2.motif_reclamation;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
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
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

tHash_Lookup_row2.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
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
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 finally ] stop
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
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_status_recl;

				public int getId_status_recl () {
					return this.id_status_recl;
				}
				
			    public String statut_resolution;

				public String getStatut_resolution () {
					return this.statut_resolution;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.statut_resolution == null) ? 0 : this.statut_resolution.hashCode());
					
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
		
						if (this.statut_resolution == null) {
							if (other.statut_resolution != null)
								return false;
						
						} else if (!this.statut_resolution.equals(other.statut_resolution))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.id_status_recl = this.id_status_recl;
	            other.statut_resolution = this.statut_resolution;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.statut_resolution = this.statut_resolution;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

        	try {

        		int length = 0;
		
					this.statut_resolution = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_Job_Load_DIM_RECLAMATION) {

        	try {

        		int length = 0;
		
					this.statut_resolution = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.statut_resolution,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.statut_resolution,dos);
					
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
		
			            this.id_status_recl = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.id_status_recl = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.id_status_recl);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.id_status_recl);
					
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
		sb.append("id_status_recl="+String.valueOf(id_status_recl));
		sb.append(",statut_resolution="+statut_resolution);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.statut_resolution, other.statut_resolution);
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



		row3Struct row3 = new row3Struct();




	
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
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_1 - inputs:(row5,row2,row3) outputs:(reclamation)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
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

		    String dbquery_tDBInput_3 = "SELECT \n  \"DWH_ATTEJARI\".\"DIM_STATUS_RECLAMATION\".\"id_status_recl_sk\", \n  \"DWH_ATTEJARI\".\"DIM_STATUS_RECLAMATI"
+"ON\".\"statut_resolution\"\nFROM \"DWH_ATTEJARI\".\"DIM_STATUS_RECLAMATION\"";
		    

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
								row3.id_status_recl = 0;
							} else {
		                          
            row3.id_status_recl = rs_tDBInput_3.getInt(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row3.statut_resolution = null;
							} else {
	                         		
        	row3.statut_resolution = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
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
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.id_status_recl = row3.id_status_recl;
				
				row3_HashRow.statut_resolution = row3.statut_resolution;
				
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
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
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
        final Job_Load_DIM_RECLAMATION Job_Load_DIM_RECLAMATIONClass = new Job_Load_DIM_RECLAMATION();

        int exitCode = Job_Load_DIM_RECLAMATIONClass.runJobInTOS(args);

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
            java.io.InputStream inContext = Job_Load_DIM_RECLAMATION.class.getClassLoader().getResourceAsStream("dwh_attejaribank/job_load_dim_reclamation_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Job_Load_DIM_RECLAMATION.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Job_Load_DIM_RECLAMATION");
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
 *     168667 characters generated by Talend Open Studio for Data Integration 
 *     on the 1 avril 2026 à 16:41:18 WAT
 ************************************************************************************************/