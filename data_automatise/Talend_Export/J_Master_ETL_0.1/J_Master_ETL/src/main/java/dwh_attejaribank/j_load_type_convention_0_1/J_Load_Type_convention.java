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


package dwh_attejaribank.j_load_type_convention_0_1;

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
 * Job: J_Load_Type_convention Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class J_Load_Type_convention implements TalendJob {

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
	private final String jobName = "J_Load_Type_convention";
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
				J_Load_Type_convention.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(J_Load_Type_convention.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tUniqRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_type_convention_sk;

				public int getId_type_convention_sk () {
					return this.id_type_convention_sk;
				}
				
			    public String type_convention;

				public String getType_convention () {
					return this.type_convention;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.type_convention == null) ? 0 : this.type_convention.hashCode());
					
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
		
						if (this.type_convention == null) {
							if (other.type_convention != null)
								return false;
						
						} else if (!this.type_convention.equals(other.type_convention))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.id_type_convention_sk = this.id_type_convention_sk;
	            other.type_convention = this.type_convention;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.type_convention = this.type_convention;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention) {

        	try {

        		int length = 0;
		
			        this.id_type_convention_sk = dis.readInt();
					
					this.type_convention = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention) {

        	try {

        		int length = 0;
		
			        this.id_type_convention_sk = dis.readInt();
					
					this.type_convention = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_type_convention_sk);
					
					// String
				
						writeString(this.type_convention,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_type_convention_sk);
					
					// String
				
						writeString(this.type_convention,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_type_convention_sk="+String.valueOf(id_type_convention_sk));
		sb.append(",type_convention="+type_convention);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.type_convention, other.type_convention);
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
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_type_convention_sk;

				public int getId_type_convention_sk () {
					return this.id_type_convention_sk;
				}
				
			    public String type_convention;

				public String getType_convention () {
					return this.type_convention;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.type_convention == null) ? 0 : this.type_convention.hashCode());
					
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
		
						if (this.type_convention == null) {
							if (other.type_convention != null)
								return false;
						
						} else if (!this.type_convention.equals(other.type_convention))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.id_type_convention_sk = this.id_type_convention_sk;
	            other.type_convention = this.type_convention;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.type_convention = this.type_convention;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention) {

        	try {

        		int length = 0;
		
			        this.id_type_convention_sk = dis.readInt();
					
					this.type_convention = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention) {

        	try {

        		int length = 0;
		
			        this.id_type_convention_sk = dis.readInt();
					
					this.type_convention = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_type_convention_sk);
					
					// String
				
						writeString(this.type_convention,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_type_convention_sk);
					
					// String
				
						writeString(this.type_convention,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_type_convention_sk="+String.valueOf(id_type_convention_sk));
		sb.append(",type_convention="+type_convention);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.type_convention, other.type_convention);
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

public static class typeconventionStruct implements routines.system.IPersistableRow<typeconventionStruct> {
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_type_convention_sk;

				public int getId_type_convention_sk () {
					return this.id_type_convention_sk;
				}
				
			    public String type_convention;

				public String getType_convention () {
					return this.type_convention;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.type_convention == null) ? 0 : this.type_convention.hashCode());
					
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
		final typeconventionStruct other = (typeconventionStruct) obj;
		
						if (this.type_convention == null) {
							if (other.type_convention != null)
								return false;
						
						} else if (!this.type_convention.equals(other.type_convention))
						
							return false;
					

		return true;
    }

	public void copyDataTo(typeconventionStruct other) {

		other.id_type_convention_sk = this.id_type_convention_sk;
	            other.type_convention = this.type_convention;
	            
	}

	public void copyKeysDataTo(typeconventionStruct other) {

		other.type_convention = this.type_convention;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention) {

        	try {

        		int length = 0;
		
			        this.id_type_convention_sk = dis.readInt();
					
					this.type_convention = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention) {

        	try {

        		int length = 0;
		
			        this.id_type_convention_sk = dis.readInt();
					
					this.type_convention = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_type_convention_sk);
					
					// String
				
						writeString(this.type_convention,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_type_convention_sk);
					
					// String
				
						writeString(this.type_convention,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_type_convention_sk="+String.valueOf(id_type_convention_sk));
		sb.append(",type_convention="+type_convention);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(typeconventionStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.type_convention, other.type_convention);
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
    final static byte[] commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[0];
    static byte[] commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[0];

	
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length, utf8Charset);
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
			if(length > commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length) {
				if(length < 1024 && commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention.length == 0) {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[1024];
				} else {
   					commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length);
			strReturn = new String(commonByteArray_DWH_ATTEJARIBANK_J_Load_Type_convention, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention) {

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

		synchronized(commonByteArrayLock_DWH_ATTEJARIBANK_J_Load_Type_convention) {

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



		row1Struct row1 = new row1Struct();
typeconventionStruct typeconvention = new typeconventionStruct();
row2Struct row2 = new row2Struct();
row2Struct row3 = row2;







	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = context.schema;
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = ("DIM_TYPE_CONVENTION");
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("DIM_TYPE_CONVENTION");
}

        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 2 && true) {
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
	    String update_tDBOutput_1 = "UPDATE \"" + tableName_tDBOutput_1 + "\" SET \"type_convention\" = ? WHERE \"type_convention\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
	    resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);
	    String insert_tDBOutput_1 = "INSERT INTO \"" + tableName_tDBOutput_1 + "\" (\"type_convention\") VALUES (?)";
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
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
	 * [tUniqRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tUniqRow_1", false);
		start_Hash.put("tUniqRow_1", System.currentTimeMillis());
		
	
	currentComponent="tUniqRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"typeconvention");
					}
				
		int tos_count_tUniqRow_1 = 0;
		

	
		class KeyStruct_tUniqRow_1 {
	
			private static final int DEFAULT_HASHCODE = 1;
		    private static final int PRIME = 31;
		    private int hashCode = DEFAULT_HASHCODE;
		    public boolean hashCodeDirty = true;
	
	        
					String type_convention;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
								result = prime * result + ((this.type_convention == null) ? 0 : this.type_convention.hashCode());
								
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
				final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;
				
									if (this.type_convention == null) {
										if (other.type_convention != null) 
											return false;
								
									} else if (!this.type_convention.equals(other.type_convention))
								 
										return false;
								
				
				return true;
			}
	  
	        
		}

	
int nb_uniques_tUniqRow_1 = 0;
int nb_duplicates_tUniqRow_1 = 0;
KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>(); 

 



/**
 * [tUniqRow_1 begin ] stop
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
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
typeconventionStruct typeconvention_tmp = new typeconventionStruct();
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
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

typeconvention = null;


// # Output table : 'typeconvention'
typeconvention_tmp.id_type_convention_sk = Numeric.sequence("s_type_convention",1,1);
typeconvention_tmp.type_convention = row1.type_convention ;
typeconvention = typeconvention_tmp;
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
// Start of branch "typeconvention"
if(typeconvention != null) { 



	
	/**
	 * [tUniqRow_1 main ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"typeconvention"
						
						);
					}
					
row2 = null;			
if(typeconvention.type_convention == null){
	finder_tUniqRow_1.type_convention = null;
}else{
	finder_tUniqRow_1.type_convention = typeconvention.type_convention.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
if(typeconvention.type_convention == null){
	new_tUniqRow_1.type_convention = null;
}else{
	new_tUniqRow_1.type_convention = typeconvention.type_convention.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.id_type_convention_sk = typeconvention.id_type_convention_sk;			row2.type_convention = typeconvention.type_convention;					
		nb_uniques_tUniqRow_1++;
	} else {
	  nb_duplicates_tUniqRow_1++;
	}

 


	tos_count_tUniqRow_1++;

/**
 * [tUniqRow_1 main ] stop
 */
	
	/**
	 * [tUniqRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 process_data_begin ] stop
 */
// Start of branch "row2"
if(row2 != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					
///////////////////////		
						



				strBuffer_tLogRow_1 = new StringBuilder();




              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row2.id_type_convention_sk)							
				);


							  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(row2.type_convention != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row2.type_convention)							
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

 
     row3 = row2;


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
						
							,"row3"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
            int updateFlag_tDBOutput_1=0;
                    if(row3.type_convention == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, row3.type_convention);
}


                    if(row3.type_convention == null) {
pstmtUpdate_tDBOutput_1.setNull(2 + count_tDBOutput_1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(2 + count_tDBOutput_1, row3.type_convention);
}


            try {
				
                updateFlag_tDBOutput_1=pstmtUpdate_tDBOutput_1.executeUpdate();
                updatedCount_tDBOutput_1 = updatedCount_tDBOutput_1+updateFlag_tDBOutput_1;
                rowsToCommitCount_tDBOutput_1 += updateFlag_tDBOutput_1;
				
            if(updateFlag_tDBOutput_1 == 0) {
            	
                        if(row3.type_convention == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(1, row3.type_convention);
}

					
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

} // End of branch "row2"




	
	/**
	 * [tUniqRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 process_data_end ] stop
 */

} // End of branch "typeconvention"




	
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
	 * [tUniqRow_1 end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

globalMap.put("tUniqRow_1_NB_UNIQUES",nb_uniques_tUniqRow_1);
globalMap.put("tUniqRow_1_NB_DUPLICATES",nb_duplicates_tUniqRow_1);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"typeconvention");
			  	}
			  	
 

ok_Hash.put("tUniqRow_1", true);
end_Hash.put("tUniqRow_1", System.currentTimeMillis());




/**
 * [tUniqRow_1 end ] stop
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
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
	 * [tUniqRow_1 finally ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 finally ] stop
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
        final J_Load_Type_convention J_Load_Type_conventionClass = new J_Load_Type_convention();

        int exitCode = J_Load_Type_conventionClass.runJobInTOS(args);

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
            java.io.InputStream inContext = J_Load_Type_convention.class.getClassLoader().getResourceAsStream("dwh_attejaribank/j_load_type_convention_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = J_Load_Type_convention.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : J_Load_Type_convention");
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
 *     112299 characters generated by Talend Open Studio for Data Integration 
 *     on the 1 avril 2026 à 16:41:17 WAT
 ************************************************************************************************/