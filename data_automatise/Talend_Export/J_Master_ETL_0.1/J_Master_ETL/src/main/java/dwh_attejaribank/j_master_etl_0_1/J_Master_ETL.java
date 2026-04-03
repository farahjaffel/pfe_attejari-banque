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


package dwh_attejaribank.j_master_etl_0_1;

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
 * Job: J_Master_ETL Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class J_Master_ETL implements TalendJob {

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
	private final String jobName = "J_Master_ETL";
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
				J_Master_ETL.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(J_Master_ETL.this, new Object[] { e , currentComponent, globalMap});
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

			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_7_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_9_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_10_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_10_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_11_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_11_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_12_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_12_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_13_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_13_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_14_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_14_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_15_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_15_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_16_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_16_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_17_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_17_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_5_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_6_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_7_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_8_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_9_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_10_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_11_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_12_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_13_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_14_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_15_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_16_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_17_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	





public void tRunJob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_1_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_1", false);
		start_Hash.put("tRunJob_1", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_1";

	
		int tos_count_tRunJob_1 = 0;
		
class DealChildJobLibrary_tRunJob_1 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_1 dealChildJobLibrary_tRunJob_1 = new DealChildJobLibrary_tRunJob_1();

	class JVMArgumentHelper_tRunJob_1 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_1 jvm_argument_helper_tRunJob_1 = new JVMArgumentHelper_tRunJob_1();
	
	String audit_jar_path_tRunJob_1 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_1 begin ] stop
 */
	
	/**
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	
	java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_1 = System.getProperty("os.name");
			if (osName_tRunJob_1 != null && osName_tRunJob_1.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_1.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_1.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_1 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_1 != null){
								paraList_tRunJob_1.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_1);
							}
							String log4j2_config_tRunJob_1 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_1 != null){
								paraList_tRunJob_1.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_1);
							}
							if (log4j1_config_tRunJob_1 != null || log4j2_config_tRunJob_1 != null) {
								paraList_tRunJob_1.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_1.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_1.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "-Xms512m");
		      				
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "-Xmx4096m");
		      				
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "-cp");
		      				
              					String classpath_tRunJob_1_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_dim_canal_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_1!=null && !audit_jar_path_tRunJob_1.isEmpty()) {
		      						classpath_tRunJob_1_5 += audit_jar_path_tRunJob_1;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(classpath_tRunJob_1_5), true);
		      				
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "dwh_attejaribank.j_load_dim_canal_0_1.J_Load_Dim_Canal");
		      				
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "--father_node=tRunJob_1");
		      				
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_1.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_1.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_1 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_1 != null){
								paraList_tRunJob_1.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_1);
							}
							String log4j2_config_tRunJob_1 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_1 != null){
								paraList_tRunJob_1.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_1);
							}
							if (log4j1_config_tRunJob_1 != null || log4j2_config_tRunJob_1 != null) {
								paraList_tRunJob_1.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_1.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_1.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "-Xms512m");
		      				
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "-Xmx4096m");
		      				
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "-cp");
		      				
		      					String classpath_tRunJob_1_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_dim_canal_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_1!=null && !audit_jar_path_tRunJob_1.isEmpty()) {
		      						classpath_tRunJob_1_5 += audit_jar_path_tRunJob_1;
		      					}
		      					
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(classpath_tRunJob_1_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "dwh_attejaribank.j_load_dim_canal_0_1.J_Load_Dim_Canal");
		      				
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "--father_node=tRunJob_1");
		      				
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_1.addArgumentsTo(paraList_tRunJob_1, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_1.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_1.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null){
		paraList_tRunJob_1.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_1 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_1.put("host", context.host);
                    paraList_tRunJob_1.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("port", context.port);
                    paraList_tRunJob_1.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_1.put("schema", context.schema);
                    paraList_tRunJob_1.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("database", context.database);
                    paraList_tRunJob_1.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("password", context.password);
                    paraList_tRunJob_1.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("params", context.params);
                    paraList_tRunJob_1.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("username", context.username);
                    paraList_tRunJob_1.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_1().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_1 = context.propertyNames();
		while (propertyNames_tRunJob_1.hasMoreElements()) {
			String key_tRunJob_1 = (String) propertyNames_tRunJob_1.nextElement();
			Object value_tRunJob_1 = (Object) context.get(key_tRunJob_1);
			if(value_tRunJob_1!=null) {  
				paraList_tRunJob_1.add("--context_param " + key_tRunJob_1 + "=" + value_tRunJob_1);
			} else {
				paraList_tRunJob_1.add("--context_param " + key_tRunJob_1 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_1 = null;

	
	
				class ConsoleHelper_tRunJob_1 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_1_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_1_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_1 consoleHelper_tRunJob_1 = new ConsoleHelper_tRunJob_1();

		Runtime runtime_tRunJob_1 = Runtime.getRuntime();
		Process ps_tRunJob_1 = null;

		//0 indicates normal termination
        int result_tRunJob_1;
        StringBuffer errorMsg_tRunJob_1 = new StringBuffer();
        try {
            ps_tRunJob_1 = runtime_tRunJob_1.exec((String[])paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));

            Thread normal_tRunJob_1 = consoleHelper_tRunJob_1.getNormalThread(ps_tRunJob_1);
            normal_tRunJob_1.start();

            Thread error_tRunJob_1 = consoleHelper_tRunJob_1.getErrorThread(ps_tRunJob_1, errorMsg_tRunJob_1);
            error_tRunJob_1.start();

            result_tRunJob_1 = ps_tRunJob_1.waitFor();
            normal_tRunJob_1.join();
            error_tRunJob_1.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_1_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_1.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_1_CHILD_RETURN_CODE",result_tRunJob_1);
		if(result_tRunJob_1 != 0){
   			globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_1.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_1 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_1.toString());
			
  		}

		

 


	tos_count_tRunJob_1++;

/**
 * [tRunJob_1 main ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 

ok_Hash.put("tRunJob_1", true);
end_Hash.put("tRunJob_1", System.currentTimeMillis());




/**
 * [tRunJob_1 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
								} 
							
							tRunJob_2Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_1 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_2_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_2", false);
		start_Hash.put("tRunJob_2", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_2";

	
		int tos_count_tRunJob_2 = 0;
		
class DealChildJobLibrary_tRunJob_2 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_2 dealChildJobLibrary_tRunJob_2 = new DealChildJobLibrary_tRunJob_2();

	class JVMArgumentHelper_tRunJob_2 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_2 jvm_argument_helper_tRunJob_2 = new JVMArgumentHelper_tRunJob_2();
	
	String audit_jar_path_tRunJob_2 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_2 begin ] stop
 */
	
	/**
	 * [tRunJob_2 main ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	
	java.util.List<String> paraList_tRunJob_2 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_2 = System.getProperty("os.name");
			if (osName_tRunJob_2 != null && osName_tRunJob_2.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_2.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_2.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_2 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_2 != null){
								paraList_tRunJob_2.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_2);
							}
							String log4j2_config_tRunJob_2 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_2 != null){
								paraList_tRunJob_2.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_2);
							}
							if (log4j1_config_tRunJob_2 != null || log4j2_config_tRunJob_2 != null) {
								paraList_tRunJob_2.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_2.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_2.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "-cp");
		      				
              					String classpath_tRunJob_2_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/trove.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_dim_finanier_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_2!=null && !audit_jar_path_tRunJob_2.isEmpty()) {
		      						classpath_tRunJob_2_5 += audit_jar_path_tRunJob_2;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, dealChildJobLibrary_tRunJob_2.replaceJarPathsFromCrcMap(classpath_tRunJob_2_5), true);
		      				
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "dwh_attejaribank.j_load_dim_finanier_0_1.J_Load_Dim_Finanier");
		      				
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "--father_node=tRunJob_2");
		      				
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_2.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_2.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_2 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_2 != null){
								paraList_tRunJob_2.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_2);
							}
							String log4j2_config_tRunJob_2 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_2 != null){
								paraList_tRunJob_2.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_2);
							}
							if (log4j1_config_tRunJob_2 != null || log4j2_config_tRunJob_2 != null) {
								paraList_tRunJob_2.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_2.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_2.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "-cp");
		      				
		      					String classpath_tRunJob_2_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/log4j-1.2-api-2.13.2.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/jboss-marshalling-river-2.0.12.Final.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/advancedPersistentLookupLib-1.3.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/trove.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_dim_finanier_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_2!=null && !audit_jar_path_tRunJob_2.isEmpty()) {
		      						classpath_tRunJob_2_5 += audit_jar_path_tRunJob_2;
		      					}
		      					
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, dealChildJobLibrary_tRunJob_2.replaceJarPathsFromCrcMap(classpath_tRunJob_2_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "dwh_attejaribank.j_load_dim_finanier_0_1.J_Load_Dim_Finanier");
		      				
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "--father_node=tRunJob_2");
		      				
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_2.addArgumentsTo(paraList_tRunJob_2, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_2.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_2.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_2.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_2 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_2 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_2".equals(tRunJobName_tRunJob_2) && childResumePath_tRunJob_2 != null){
		paraList_tRunJob_2.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_2.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_2");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_2 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_2 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_2.put("host", context.host);
                    paraList_tRunJob_2.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("port", context.port);
                    paraList_tRunJob_2.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_2.put("schema", context.schema);
                    paraList_tRunJob_2.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("database", context.database);
                    paraList_tRunJob_2.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("password", context.password);
                    paraList_tRunJob_2.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("params", context.params);
                    paraList_tRunJob_2.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("username", context.username);
                    paraList_tRunJob_2.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_2().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_2 = context.propertyNames();
		while (propertyNames_tRunJob_2.hasMoreElements()) {
			String key_tRunJob_2 = (String) propertyNames_tRunJob_2.nextElement();
			Object value_tRunJob_2 = (Object) context.get(key_tRunJob_2);
			if(value_tRunJob_2!=null) {  
				paraList_tRunJob_2.add("--context_param " + key_tRunJob_2 + "=" + value_tRunJob_2);
			} else {
				paraList_tRunJob_2.add("--context_param " + key_tRunJob_2 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_2 = null;

	
	
				class ConsoleHelper_tRunJob_2 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_2_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_2_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_2 consoleHelper_tRunJob_2 = new ConsoleHelper_tRunJob_2();

		Runtime runtime_tRunJob_2 = Runtime.getRuntime();
		Process ps_tRunJob_2 = null;

		//0 indicates normal termination
        int result_tRunJob_2;
        StringBuffer errorMsg_tRunJob_2 = new StringBuffer();
        try {
            ps_tRunJob_2 = runtime_tRunJob_2.exec((String[])paraList_tRunJob_2.toArray(new String[paraList_tRunJob_2.size()]));

            Thread normal_tRunJob_2 = consoleHelper_tRunJob_2.getNormalThread(ps_tRunJob_2);
            normal_tRunJob_2.start();

            Thread error_tRunJob_2 = consoleHelper_tRunJob_2.getErrorThread(ps_tRunJob_2, errorMsg_tRunJob_2);
            error_tRunJob_2.start();

            result_tRunJob_2 = ps_tRunJob_2.waitFor();
            normal_tRunJob_2.join();
            error_tRunJob_2.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_2_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_2.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_2_CHILD_RETURN_CODE",result_tRunJob_2);
		if(result_tRunJob_2 != 0){
   			globalMap.put("tRunJob_2_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_2.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_2 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_2.toString());
			
  		}

		

 


	tos_count_tRunJob_2++;

/**
 * [tRunJob_2 main ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_2 end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 

ok_Hash.put("tRunJob_2", true);
end_Hash.put("tRunJob_2", System.currentTimeMillis());




/**
 * [tRunJob_2 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_2:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
								} 
							
							tRunJob_3Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_2 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_2_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_3_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_3", false);
		start_Hash.put("tRunJob_3", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_3";

	
		int tos_count_tRunJob_3 = 0;
		
class DealChildJobLibrary_tRunJob_3 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_3 dealChildJobLibrary_tRunJob_3 = new DealChildJobLibrary_tRunJob_3();

	class JVMArgumentHelper_tRunJob_3 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_3 jvm_argument_helper_tRunJob_3 = new JVMArgumentHelper_tRunJob_3();
	
	String audit_jar_path_tRunJob_3 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_3 begin ] stop
 */
	
	/**
	 * [tRunJob_3 main ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	
	java.util.List<String> paraList_tRunJob_3 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_3 = System.getProperty("os.name");
			if (osName_tRunJob_3 != null && osName_tRunJob_3.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_3.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_3.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_3 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_3 != null){
								paraList_tRunJob_3.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_3);
							}
							String log4j2_config_tRunJob_3 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_3 != null){
								paraList_tRunJob_3.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_3);
							}
							if (log4j1_config_tRunJob_3 != null || log4j2_config_tRunJob_3 != null) {
								paraList_tRunJob_3.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_3.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_3.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "-cp");
		      				
              					String classpath_tRunJob_3_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_dim_profil_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_3!=null && !audit_jar_path_tRunJob_3.isEmpty()) {
		      						classpath_tRunJob_3_5 += audit_jar_path_tRunJob_3;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, dealChildJobLibrary_tRunJob_3.replaceJarPathsFromCrcMap(classpath_tRunJob_3_5), true);
		      				
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "dwh_attejaribank.j_load_dim_profil_0_1.J_Load_DIM_PROFIL");
		      				
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "--father_node=tRunJob_3");
		      				
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_3.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_3.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_3 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_3 != null){
								paraList_tRunJob_3.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_3);
							}
							String log4j2_config_tRunJob_3 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_3 != null){
								paraList_tRunJob_3.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_3);
							}
							if (log4j1_config_tRunJob_3 != null || log4j2_config_tRunJob_3 != null) {
								paraList_tRunJob_3.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_3.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_3.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "-cp");
		      				
		      					String classpath_tRunJob_3_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_dim_profil_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_3!=null && !audit_jar_path_tRunJob_3.isEmpty()) {
		      						classpath_tRunJob_3_5 += audit_jar_path_tRunJob_3;
		      					}
		      					
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, dealChildJobLibrary_tRunJob_3.replaceJarPathsFromCrcMap(classpath_tRunJob_3_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "dwh_attejaribank.j_load_dim_profil_0_1.J_Load_DIM_PROFIL");
		      				
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "--father_node=tRunJob_3");
		      				
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_3.addArgumentsTo(paraList_tRunJob_3, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_3.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_3.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_3.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_3 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_3 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_3".equals(tRunJobName_tRunJob_3) && childResumePath_tRunJob_3 != null){
		paraList_tRunJob_3.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_3.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_3");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_3 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_3 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_3.put("host", context.host);
                    paraList_tRunJob_3.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("port", context.port);
                    paraList_tRunJob_3.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_3.put("schema", context.schema);
                    paraList_tRunJob_3.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("database", context.database);
                    paraList_tRunJob_3.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("password", context.password);
                    paraList_tRunJob_3.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("params", context.params);
                    paraList_tRunJob_3.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("username", context.username);
                    paraList_tRunJob_3.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_3().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_3 = context.propertyNames();
		while (propertyNames_tRunJob_3.hasMoreElements()) {
			String key_tRunJob_3 = (String) propertyNames_tRunJob_3.nextElement();
			Object value_tRunJob_3 = (Object) context.get(key_tRunJob_3);
			if(value_tRunJob_3!=null) {  
				paraList_tRunJob_3.add("--context_param " + key_tRunJob_3 + "=" + value_tRunJob_3);
			} else {
				paraList_tRunJob_3.add("--context_param " + key_tRunJob_3 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_3 = null;

	
	
				class ConsoleHelper_tRunJob_3 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_3_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_3_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_3 consoleHelper_tRunJob_3 = new ConsoleHelper_tRunJob_3();

		Runtime runtime_tRunJob_3 = Runtime.getRuntime();
		Process ps_tRunJob_3 = null;

		//0 indicates normal termination
        int result_tRunJob_3;
        StringBuffer errorMsg_tRunJob_3 = new StringBuffer();
        try {
            ps_tRunJob_3 = runtime_tRunJob_3.exec((String[])paraList_tRunJob_3.toArray(new String[paraList_tRunJob_3.size()]));

            Thread normal_tRunJob_3 = consoleHelper_tRunJob_3.getNormalThread(ps_tRunJob_3);
            normal_tRunJob_3.start();

            Thread error_tRunJob_3 = consoleHelper_tRunJob_3.getErrorThread(ps_tRunJob_3, errorMsg_tRunJob_3);
            error_tRunJob_3.start();

            result_tRunJob_3 = ps_tRunJob_3.waitFor();
            normal_tRunJob_3.join();
            error_tRunJob_3.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_3_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_3.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_3_CHILD_RETURN_CODE",result_tRunJob_3);
		if(result_tRunJob_3 != 0){
   			globalMap.put("tRunJob_3_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_3.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_3 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_3.toString());
			
  		}

		

 


	tos_count_tRunJob_3++;

/**
 * [tRunJob_3 main ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_3 end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 

ok_Hash.put("tRunJob_3", true);
end_Hash.put("tRunJob_3", System.currentTimeMillis());




/**
 * [tRunJob_3 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_3:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk4", 0, "ok");
								} 
							
							tRunJob_4Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_3 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_3_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_4_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_4", false);
		start_Hash.put("tRunJob_4", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_4";

	
		int tos_count_tRunJob_4 = 0;
		
class DealChildJobLibrary_tRunJob_4 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_4 dealChildJobLibrary_tRunJob_4 = new DealChildJobLibrary_tRunJob_4();

	class JVMArgumentHelper_tRunJob_4 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_4 jvm_argument_helper_tRunJob_4 = new JVMArgumentHelper_tRunJob_4();
	
	String audit_jar_path_tRunJob_4 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_4 begin ] stop
 */
	
	/**
	 * [tRunJob_4 main ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	
	java.util.List<String> paraList_tRunJob_4 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_4 = System.getProperty("os.name");
			if (osName_tRunJob_4 != null && osName_tRunJob_4.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_4.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_4.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_4 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_4 != null){
								paraList_tRunJob_4.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_4);
							}
							String log4j2_config_tRunJob_4 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_4 != null){
								paraList_tRunJob_4.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_4);
							}
							if (log4j1_config_tRunJob_4 != null || log4j2_config_tRunJob_4 != null) {
								paraList_tRunJob_4.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_4.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_4.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "-cp");
		      				
              					String classpath_tRunJob_4_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_dim_produit_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_4!=null && !audit_jar_path_tRunJob_4.isEmpty()) {
		      						classpath_tRunJob_4_5 += audit_jar_path_tRunJob_4;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, dealChildJobLibrary_tRunJob_4.replaceJarPathsFromCrcMap(classpath_tRunJob_4_5), true);
		      				
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "dwh_attejaribank.j_load_dim_produit_0_1.J_Load_DIM_Produit");
		      				
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "--father_node=tRunJob_4");
		      				
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_4.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_4.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_4 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_4 != null){
								paraList_tRunJob_4.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_4);
							}
							String log4j2_config_tRunJob_4 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_4 != null){
								paraList_tRunJob_4.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_4);
							}
							if (log4j1_config_tRunJob_4 != null || log4j2_config_tRunJob_4 != null) {
								paraList_tRunJob_4.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_4.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_4.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "-cp");
		      				
		      					String classpath_tRunJob_4_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_dim_produit_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_4!=null && !audit_jar_path_tRunJob_4.isEmpty()) {
		      						classpath_tRunJob_4_5 += audit_jar_path_tRunJob_4;
		      					}
		      					
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, dealChildJobLibrary_tRunJob_4.replaceJarPathsFromCrcMap(classpath_tRunJob_4_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "dwh_attejaribank.j_load_dim_produit_0_1.J_Load_DIM_Produit");
		      				
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "--father_node=tRunJob_4");
		      				
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_4.addArgumentsTo(paraList_tRunJob_4, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_4.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_4.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_4.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_4 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_4 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_4".equals(tRunJobName_tRunJob_4) && childResumePath_tRunJob_4 != null){
		paraList_tRunJob_4.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_4.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_4");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_4 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_4 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_4.put("host", context.host);
                    paraList_tRunJob_4.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_4.put("port", context.port);
                    paraList_tRunJob_4.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_4.put("schema", context.schema);
                    paraList_tRunJob_4.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_4.put("database", context.database);
                    paraList_tRunJob_4.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_4.put("password", context.password);
                    paraList_tRunJob_4.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_4.put("params", context.params);
                    paraList_tRunJob_4.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_4.put("username", context.username);
                    paraList_tRunJob_4.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_4().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_4 = context.propertyNames();
		while (propertyNames_tRunJob_4.hasMoreElements()) {
			String key_tRunJob_4 = (String) propertyNames_tRunJob_4.nextElement();
			Object value_tRunJob_4 = (Object) context.get(key_tRunJob_4);
			if(value_tRunJob_4!=null) {  
				paraList_tRunJob_4.add("--context_param " + key_tRunJob_4 + "=" + value_tRunJob_4);
			} else {
				paraList_tRunJob_4.add("--context_param " + key_tRunJob_4 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_4 = null;

	
	
				class ConsoleHelper_tRunJob_4 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_4_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_4_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_4 consoleHelper_tRunJob_4 = new ConsoleHelper_tRunJob_4();

		Runtime runtime_tRunJob_4 = Runtime.getRuntime();
		Process ps_tRunJob_4 = null;

		//0 indicates normal termination
        int result_tRunJob_4;
        StringBuffer errorMsg_tRunJob_4 = new StringBuffer();
        try {
            ps_tRunJob_4 = runtime_tRunJob_4.exec((String[])paraList_tRunJob_4.toArray(new String[paraList_tRunJob_4.size()]));

            Thread normal_tRunJob_4 = consoleHelper_tRunJob_4.getNormalThread(ps_tRunJob_4);
            normal_tRunJob_4.start();

            Thread error_tRunJob_4 = consoleHelper_tRunJob_4.getErrorThread(ps_tRunJob_4, errorMsg_tRunJob_4);
            error_tRunJob_4.start();

            result_tRunJob_4 = ps_tRunJob_4.waitFor();
            normal_tRunJob_4.join();
            error_tRunJob_4.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_4_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_4.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_4_CHILD_RETURN_CODE",result_tRunJob_4);
		if(result_tRunJob_4 != 0){
   			globalMap.put("tRunJob_4_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_4.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_4 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_4.toString());
			
  		}

		

 


	tos_count_tRunJob_4++;

/**
 * [tRunJob_4 main ] stop
 */
	
	/**
	 * [tRunJob_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	

 



/**
 * [tRunJob_4 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	

 



/**
 * [tRunJob_4 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_4 end ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	

 

ok_Hash.put("tRunJob_4", true);
end_Hash.put("tRunJob_4", System.currentTimeMillis());




/**
 * [tRunJob_4 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_4:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk5", 0, "ok");
								} 
							
							tRunJob_5Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_4 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	

 



/**
 * [tRunJob_4 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_4_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_5_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_5", false);
		start_Hash.put("tRunJob_5", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_5";

	
		int tos_count_tRunJob_5 = 0;
		
class DealChildJobLibrary_tRunJob_5 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_5 dealChildJobLibrary_tRunJob_5 = new DealChildJobLibrary_tRunJob_5();

	class JVMArgumentHelper_tRunJob_5 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_5 jvm_argument_helper_tRunJob_5 = new JVMArgumentHelper_tRunJob_5();
	
	String audit_jar_path_tRunJob_5 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_5 begin ] stop
 */
	
	/**
	 * [tRunJob_5 main ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	
	java.util.List<String> paraList_tRunJob_5 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_5 = System.getProperty("os.name");
			if (osName_tRunJob_5 != null && osName_tRunJob_5.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_5.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_5.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_5 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_5 != null){
								paraList_tRunJob_5.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_5);
							}
							String log4j2_config_tRunJob_5 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_5 != null){
								paraList_tRunJob_5.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_5);
							}
							if (log4j1_config_tRunJob_5 != null || log4j2_config_tRunJob_5 != null) {
								paraList_tRunJob_5.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_5.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_5.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "-Xms512m");
		      				
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "-Xmx2048m");
		      				
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "-cp");
		      				
              					String classpath_tRunJob_5_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_dim_produit_tx_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_5!=null && !audit_jar_path_tRunJob_5.isEmpty()) {
		      						classpath_tRunJob_5_5 += audit_jar_path_tRunJob_5;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, dealChildJobLibrary_tRunJob_5.replaceJarPathsFromCrcMap(classpath_tRunJob_5_5), true);
		      				
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "dwh_attejaribank.j_load_dim_produit_tx_0_1.J_Load_dim_produit_tx");
		      				
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "--father_node=tRunJob_5");
		      				
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_5.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_5.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_5 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_5 != null){
								paraList_tRunJob_5.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_5);
							}
							String log4j2_config_tRunJob_5 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_5 != null){
								paraList_tRunJob_5.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_5);
							}
							if (log4j1_config_tRunJob_5 != null || log4j2_config_tRunJob_5 != null) {
								paraList_tRunJob_5.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_5.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_5.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "-Xms512m");
		      				
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "-Xmx2048m");
		      				
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "-cp");
		      				
		      					String classpath_tRunJob_5_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_dim_produit_tx_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_5!=null && !audit_jar_path_tRunJob_5.isEmpty()) {
		      						classpath_tRunJob_5_5 += audit_jar_path_tRunJob_5;
		      					}
		      					
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, dealChildJobLibrary_tRunJob_5.replaceJarPathsFromCrcMap(classpath_tRunJob_5_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "dwh_attejaribank.j_load_dim_produit_tx_0_1.J_Load_dim_produit_tx");
		      				
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "--father_node=tRunJob_5");
		      				
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_5.addArgumentsTo(paraList_tRunJob_5, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_5.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_5.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_5.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_5 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_5 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_5".equals(tRunJobName_tRunJob_5) && childResumePath_tRunJob_5 != null){
		paraList_tRunJob_5.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_5.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_5");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_5 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_5 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_5.put("host", context.host);
                    paraList_tRunJob_5.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_5.put("port", context.port);
                    paraList_tRunJob_5.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_5.put("schema", context.schema);
                    paraList_tRunJob_5.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_5.put("database", context.database);
                    paraList_tRunJob_5.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_5.put("password", context.password);
                    paraList_tRunJob_5.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_5.put("params", context.params);
                    paraList_tRunJob_5.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_5.put("username", context.username);
                    paraList_tRunJob_5.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_5().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_5 = context.propertyNames();
		while (propertyNames_tRunJob_5.hasMoreElements()) {
			String key_tRunJob_5 = (String) propertyNames_tRunJob_5.nextElement();
			Object value_tRunJob_5 = (Object) context.get(key_tRunJob_5);
			if(value_tRunJob_5!=null) {  
				paraList_tRunJob_5.add("--context_param " + key_tRunJob_5 + "=" + value_tRunJob_5);
			} else {
				paraList_tRunJob_5.add("--context_param " + key_tRunJob_5 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_5 = null;

	
	
				class ConsoleHelper_tRunJob_5 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_5_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_5_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_5 consoleHelper_tRunJob_5 = new ConsoleHelper_tRunJob_5();

		Runtime runtime_tRunJob_5 = Runtime.getRuntime();
		Process ps_tRunJob_5 = null;

		//0 indicates normal termination
        int result_tRunJob_5;
        StringBuffer errorMsg_tRunJob_5 = new StringBuffer();
        try {
            ps_tRunJob_5 = runtime_tRunJob_5.exec((String[])paraList_tRunJob_5.toArray(new String[paraList_tRunJob_5.size()]));

            Thread normal_tRunJob_5 = consoleHelper_tRunJob_5.getNormalThread(ps_tRunJob_5);
            normal_tRunJob_5.start();

            Thread error_tRunJob_5 = consoleHelper_tRunJob_5.getErrorThread(ps_tRunJob_5, errorMsg_tRunJob_5);
            error_tRunJob_5.start();

            result_tRunJob_5 = ps_tRunJob_5.waitFor();
            normal_tRunJob_5.join();
            error_tRunJob_5.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_5_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_5.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_5_CHILD_RETURN_CODE",result_tRunJob_5);
		if(result_tRunJob_5 != 0){
   			globalMap.put("tRunJob_5_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_5.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_5 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_5.toString());
			
  		}

		

 


	tos_count_tRunJob_5++;

/**
 * [tRunJob_5 main ] stop
 */
	
	/**
	 * [tRunJob_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	

 



/**
 * [tRunJob_5 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	

 



/**
 * [tRunJob_5 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_5 end ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	

 

ok_Hash.put("tRunJob_5", true);
end_Hash.put("tRunJob_5", System.currentTimeMillis());




/**
 * [tRunJob_5 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_5:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk6", 0, "ok");
								} 
							
							tRunJob_6Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_5 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	

 



/**
 * [tRunJob_5 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_5_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_6_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_6", false);
		start_Hash.put("tRunJob_6", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_6";

	
		int tos_count_tRunJob_6 = 0;
		
class DealChildJobLibrary_tRunJob_6 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_6 dealChildJobLibrary_tRunJob_6 = new DealChildJobLibrary_tRunJob_6();

	class JVMArgumentHelper_tRunJob_6 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_6 jvm_argument_helper_tRunJob_6 = new JVMArgumentHelper_tRunJob_6();
	
	String audit_jar_path_tRunJob_6 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_6 begin ] stop
 */
	
	/**
	 * [tRunJob_6 main ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	
	java.util.List<String> paraList_tRunJob_6 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_6 = System.getProperty("os.name");
			if (osName_tRunJob_6 != null && osName_tRunJob_6.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_6.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_6.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_6 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_6 != null){
								paraList_tRunJob_6.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_6);
							}
							String log4j2_config_tRunJob_6 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_6 != null){
								paraList_tRunJob_6.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_6);
							}
							if (log4j1_config_tRunJob_6 != null || log4j2_config_tRunJob_6 != null) {
								paraList_tRunJob_6.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_6.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_6.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "-cp");
		      				
              					String classpath_tRunJob_6_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_type_convention_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_6!=null && !audit_jar_path_tRunJob_6.isEmpty()) {
		      						classpath_tRunJob_6_5 += audit_jar_path_tRunJob_6;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, dealChildJobLibrary_tRunJob_6.replaceJarPathsFromCrcMap(classpath_tRunJob_6_5), true);
		      				
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "dwh_attejaribank.j_load_type_convention_0_1.J_Load_Type_convention");
		      				
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "--father_node=tRunJob_6");
		      				
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_6.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_6.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_6 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_6 != null){
								paraList_tRunJob_6.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_6);
							}
							String log4j2_config_tRunJob_6 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_6 != null){
								paraList_tRunJob_6.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_6);
							}
							if (log4j1_config_tRunJob_6 != null || log4j2_config_tRunJob_6 != null) {
								paraList_tRunJob_6.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_6.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_6.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "-cp");
		      				
		      					String classpath_tRunJob_6_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_type_convention_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_6!=null && !audit_jar_path_tRunJob_6.isEmpty()) {
		      						classpath_tRunJob_6_5 += audit_jar_path_tRunJob_6;
		      					}
		      					
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, dealChildJobLibrary_tRunJob_6.replaceJarPathsFromCrcMap(classpath_tRunJob_6_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "dwh_attejaribank.j_load_type_convention_0_1.J_Load_Type_convention");
		      				
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "--father_node=tRunJob_6");
		      				
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_6.addArgumentsTo(paraList_tRunJob_6, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_6.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_6.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_6.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_6 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_6 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_6".equals(tRunJobName_tRunJob_6) && childResumePath_tRunJob_6 != null){
		paraList_tRunJob_6.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_6.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_6");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_6 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_6 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_6.put("host", context.host);
                    paraList_tRunJob_6.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_6.put("port", context.port);
                    paraList_tRunJob_6.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_6.put("schema", context.schema);
                    paraList_tRunJob_6.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_6.put("database", context.database);
                    paraList_tRunJob_6.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_6.put("password", context.password);
                    paraList_tRunJob_6.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_6.put("params", context.params);
                    paraList_tRunJob_6.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_6.put("username", context.username);
                    paraList_tRunJob_6.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_6().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_6 = context.propertyNames();
		while (propertyNames_tRunJob_6.hasMoreElements()) {
			String key_tRunJob_6 = (String) propertyNames_tRunJob_6.nextElement();
			Object value_tRunJob_6 = (Object) context.get(key_tRunJob_6);
			if(value_tRunJob_6!=null) {  
				paraList_tRunJob_6.add("--context_param " + key_tRunJob_6 + "=" + value_tRunJob_6);
			} else {
				paraList_tRunJob_6.add("--context_param " + key_tRunJob_6 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_6 = null;

	
	
				class ConsoleHelper_tRunJob_6 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_6_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_6_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_6 consoleHelper_tRunJob_6 = new ConsoleHelper_tRunJob_6();

		Runtime runtime_tRunJob_6 = Runtime.getRuntime();
		Process ps_tRunJob_6 = null;

		//0 indicates normal termination
        int result_tRunJob_6;
        StringBuffer errorMsg_tRunJob_6 = new StringBuffer();
        try {
            ps_tRunJob_6 = runtime_tRunJob_6.exec((String[])paraList_tRunJob_6.toArray(new String[paraList_tRunJob_6.size()]));

            Thread normal_tRunJob_6 = consoleHelper_tRunJob_6.getNormalThread(ps_tRunJob_6);
            normal_tRunJob_6.start();

            Thread error_tRunJob_6 = consoleHelper_tRunJob_6.getErrorThread(ps_tRunJob_6, errorMsg_tRunJob_6);
            error_tRunJob_6.start();

            result_tRunJob_6 = ps_tRunJob_6.waitFor();
            normal_tRunJob_6.join();
            error_tRunJob_6.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_6_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_6.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_6_CHILD_RETURN_CODE",result_tRunJob_6);
		if(result_tRunJob_6 != 0){
   			globalMap.put("tRunJob_6_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_6.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_6 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_6.toString());
			
  		}

		

 


	tos_count_tRunJob_6++;

/**
 * [tRunJob_6 main ] stop
 */
	
	/**
	 * [tRunJob_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	

 



/**
 * [tRunJob_6 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	

 



/**
 * [tRunJob_6 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_6 end ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	

 

ok_Hash.put("tRunJob_6", true);
end_Hash.put("tRunJob_6", System.currentTimeMillis());




/**
 * [tRunJob_6 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_6:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk7", 0, "ok");
								} 
							
							tRunJob_7Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_6 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	

 



/**
 * [tRunJob_6 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_6_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_7_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_7", false);
		start_Hash.put("tRunJob_7", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_7";

	
		int tos_count_tRunJob_7 = 0;
		
class DealChildJobLibrary_tRunJob_7 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_7 dealChildJobLibrary_tRunJob_7 = new DealChildJobLibrary_tRunJob_7();

	class JVMArgumentHelper_tRunJob_7 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_7 jvm_argument_helper_tRunJob_7 = new JVMArgumentHelper_tRunJob_7();
	
	String audit_jar_path_tRunJob_7 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_7 begin ] stop
 */
	
	/**
	 * [tRunJob_7 main ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	
	java.util.List<String> paraList_tRunJob_7 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_7 = System.getProperty("os.name");
			if (osName_tRunJob_7 != null && osName_tRunJob_7.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_7.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_7.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_7 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_7 != null){
								paraList_tRunJob_7.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_7);
							}
							String log4j2_config_tRunJob_7 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_7 != null){
								paraList_tRunJob_7.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_7);
							}
							if (log4j1_config_tRunJob_7 != null || log4j2_config_tRunJob_7 != null) {
								paraList_tRunJob_7.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_7.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_7.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "-cp");
		      				
              					String classpath_tRunJob_7_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load8dim_digital_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_7!=null && !audit_jar_path_tRunJob_7.isEmpty()) {
		      						classpath_tRunJob_7_5 += audit_jar_path_tRunJob_7;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, dealChildJobLibrary_tRunJob_7.replaceJarPathsFromCrcMap(classpath_tRunJob_7_5), true);
		      				
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "dwh_attejaribank.j_load8dim_digital_0_1.J_Load8DIM_DIGITAL");
		      				
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "--father_node=tRunJob_7");
		      				
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_7.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_7.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_7 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_7 != null){
								paraList_tRunJob_7.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_7);
							}
							String log4j2_config_tRunJob_7 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_7 != null){
								paraList_tRunJob_7.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_7);
							}
							if (log4j1_config_tRunJob_7 != null || log4j2_config_tRunJob_7 != null) {
								paraList_tRunJob_7.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_7.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_7.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "-cp");
		      				
		      					String classpath_tRunJob_7_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load8dim_digital_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_7!=null && !audit_jar_path_tRunJob_7.isEmpty()) {
		      						classpath_tRunJob_7_5 += audit_jar_path_tRunJob_7;
		      					}
		      					
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, dealChildJobLibrary_tRunJob_7.replaceJarPathsFromCrcMap(classpath_tRunJob_7_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "dwh_attejaribank.j_load8dim_digital_0_1.J_Load8DIM_DIGITAL");
		      				
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "--father_node=tRunJob_7");
		      				
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_7.addArgumentsTo(paraList_tRunJob_7, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_7.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_7.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_7.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_7 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_7 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_7".equals(tRunJobName_tRunJob_7) && childResumePath_tRunJob_7 != null){
		paraList_tRunJob_7.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_7.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_7");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_7 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_7 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_7.put("host", context.host);
                    paraList_tRunJob_7.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_7.put("port", context.port);
                    paraList_tRunJob_7.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_7.put("schema", context.schema);
                    paraList_tRunJob_7.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_7.put("database", context.database);
                    paraList_tRunJob_7.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_7.put("password", context.password);
                    paraList_tRunJob_7.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_7.put("params", context.params);
                    paraList_tRunJob_7.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_7.put("username", context.username);
                    paraList_tRunJob_7.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_7().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_7 = context.propertyNames();
		while (propertyNames_tRunJob_7.hasMoreElements()) {
			String key_tRunJob_7 = (String) propertyNames_tRunJob_7.nextElement();
			Object value_tRunJob_7 = (Object) context.get(key_tRunJob_7);
			if(value_tRunJob_7!=null) {  
				paraList_tRunJob_7.add("--context_param " + key_tRunJob_7 + "=" + value_tRunJob_7);
			} else {
				paraList_tRunJob_7.add("--context_param " + key_tRunJob_7 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_7 = null;

	
	
				class ConsoleHelper_tRunJob_7 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_7_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_7_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_7 consoleHelper_tRunJob_7 = new ConsoleHelper_tRunJob_7();

		Runtime runtime_tRunJob_7 = Runtime.getRuntime();
		Process ps_tRunJob_7 = null;

		//0 indicates normal termination
        int result_tRunJob_7;
        StringBuffer errorMsg_tRunJob_7 = new StringBuffer();
        try {
            ps_tRunJob_7 = runtime_tRunJob_7.exec((String[])paraList_tRunJob_7.toArray(new String[paraList_tRunJob_7.size()]));

            Thread normal_tRunJob_7 = consoleHelper_tRunJob_7.getNormalThread(ps_tRunJob_7);
            normal_tRunJob_7.start();

            Thread error_tRunJob_7 = consoleHelper_tRunJob_7.getErrorThread(ps_tRunJob_7, errorMsg_tRunJob_7);
            error_tRunJob_7.start();

            result_tRunJob_7 = ps_tRunJob_7.waitFor();
            normal_tRunJob_7.join();
            error_tRunJob_7.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_7_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_7.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_7_CHILD_RETURN_CODE",result_tRunJob_7);
		if(result_tRunJob_7 != 0){
   			globalMap.put("tRunJob_7_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_7.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_7 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_7.toString());
			
  		}

		

 


	tos_count_tRunJob_7++;

/**
 * [tRunJob_7 main ] stop
 */
	
	/**
	 * [tRunJob_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	

 



/**
 * [tRunJob_7 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	

 



/**
 * [tRunJob_7 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_7 end ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	

 

ok_Hash.put("tRunJob_7", true);
end_Hash.put("tRunJob_7", System.currentTimeMillis());




/**
 * [tRunJob_7 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_7:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk8", 0, "ok");
								} 
							
							tRunJob_8Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_7 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	

 



/**
 * [tRunJob_7 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_7_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_8_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_8", false);
		start_Hash.put("tRunJob_8", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_8";

	
		int tos_count_tRunJob_8 = 0;
		
class DealChildJobLibrary_tRunJob_8 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_8 dealChildJobLibrary_tRunJob_8 = new DealChildJobLibrary_tRunJob_8();

	class JVMArgumentHelper_tRunJob_8 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_8 jvm_argument_helper_tRunJob_8 = new JVMArgumentHelper_tRunJob_8();
	
	String audit_jar_path_tRunJob_8 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_8 begin ] stop
 */
	
	/**
	 * [tRunJob_8 main ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	
	java.util.List<String> paraList_tRunJob_8 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_8 = System.getProperty("os.name");
			if (osName_tRunJob_8 != null && osName_tRunJob_8.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_8.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_8.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_8 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_8 != null){
								paraList_tRunJob_8.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_8);
							}
							String log4j2_config_tRunJob_8 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_8 != null){
								paraList_tRunJob_8.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_8);
							}
							if (log4j1_config_tRunJob_8 != null || log4j2_config_tRunJob_8 != null) {
								paraList_tRunJob_8.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_8.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_8.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "-cp");
		      				
              					String classpath_tRunJob_8_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/trove.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_dim_client_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_8!=null && !audit_jar_path_tRunJob_8.isEmpty()) {
		      						classpath_tRunJob_8_5 += audit_jar_path_tRunJob_8;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, dealChildJobLibrary_tRunJob_8.replaceJarPathsFromCrcMap(classpath_tRunJob_8_5), true);
		      				
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "dwh_attejaribank.j_load_dim_client_0_1.J_Load_DIM_CLIENT");
		      				
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "--father_node=tRunJob_8");
		      				
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_8.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_8.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_8 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_8 != null){
								paraList_tRunJob_8.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_8);
							}
							String log4j2_config_tRunJob_8 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_8 != null){
								paraList_tRunJob_8.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_8);
							}
							if (log4j1_config_tRunJob_8 != null || log4j2_config_tRunJob_8 != null) {
								paraList_tRunJob_8.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_8.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_8.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "-cp");
		      				
		      					String classpath_tRunJob_8_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/log4j-1.2-api-2.13.2.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/jboss-marshalling-river-2.0.12.Final.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/advancedPersistentLookupLib-1.3.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/trove.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_dim_client_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_8!=null && !audit_jar_path_tRunJob_8.isEmpty()) {
		      						classpath_tRunJob_8_5 += audit_jar_path_tRunJob_8;
		      					}
		      					
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, dealChildJobLibrary_tRunJob_8.replaceJarPathsFromCrcMap(classpath_tRunJob_8_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "dwh_attejaribank.j_load_dim_client_0_1.J_Load_DIM_CLIENT");
		      				
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "--father_node=tRunJob_8");
		      				
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_8.addArgumentsTo(paraList_tRunJob_8, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_8.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_8.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_8.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_8 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_8 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_8".equals(tRunJobName_tRunJob_8) && childResumePath_tRunJob_8 != null){
		paraList_tRunJob_8.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_8.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_8");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_8 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_8 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_8.put("host", context.host);
                    paraList_tRunJob_8.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_8.put("port", context.port);
                    paraList_tRunJob_8.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_8.put("schema", context.schema);
                    paraList_tRunJob_8.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_8.put("database", context.database);
                    paraList_tRunJob_8.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_8.put("password", context.password);
                    paraList_tRunJob_8.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_8.put("params", context.params);
                    paraList_tRunJob_8.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_8.put("username", context.username);
                    paraList_tRunJob_8.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_8().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_8 = context.propertyNames();
		while (propertyNames_tRunJob_8.hasMoreElements()) {
			String key_tRunJob_8 = (String) propertyNames_tRunJob_8.nextElement();
			Object value_tRunJob_8 = (Object) context.get(key_tRunJob_8);
			if(value_tRunJob_8!=null) {  
				paraList_tRunJob_8.add("--context_param " + key_tRunJob_8 + "=" + value_tRunJob_8);
			} else {
				paraList_tRunJob_8.add("--context_param " + key_tRunJob_8 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_8 = null;

	
	
				class ConsoleHelper_tRunJob_8 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_8_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_8_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_8 consoleHelper_tRunJob_8 = new ConsoleHelper_tRunJob_8();

		Runtime runtime_tRunJob_8 = Runtime.getRuntime();
		Process ps_tRunJob_8 = null;

		//0 indicates normal termination
        int result_tRunJob_8;
        StringBuffer errorMsg_tRunJob_8 = new StringBuffer();
        try {
            ps_tRunJob_8 = runtime_tRunJob_8.exec((String[])paraList_tRunJob_8.toArray(new String[paraList_tRunJob_8.size()]));

            Thread normal_tRunJob_8 = consoleHelper_tRunJob_8.getNormalThread(ps_tRunJob_8);
            normal_tRunJob_8.start();

            Thread error_tRunJob_8 = consoleHelper_tRunJob_8.getErrorThread(ps_tRunJob_8, errorMsg_tRunJob_8);
            error_tRunJob_8.start();

            result_tRunJob_8 = ps_tRunJob_8.waitFor();
            normal_tRunJob_8.join();
            error_tRunJob_8.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_8_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_8.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_8_CHILD_RETURN_CODE",result_tRunJob_8);
		if(result_tRunJob_8 != 0){
   			globalMap.put("tRunJob_8_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_8.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_8 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_8.toString());
			
  		}

		

 


	tos_count_tRunJob_8++;

/**
 * [tRunJob_8 main ] stop
 */
	
	/**
	 * [tRunJob_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	

 



/**
 * [tRunJob_8 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	

 



/**
 * [tRunJob_8 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_8 end ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	

 

ok_Hash.put("tRunJob_8", true);
end_Hash.put("tRunJob_8", System.currentTimeMillis());




/**
 * [tRunJob_8 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_8:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk9", 0, "ok");
								} 
							
							tRunJob_9Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_8 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	

 



/**
 * [tRunJob_8 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_8_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_9Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_9_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_9", false);
		start_Hash.put("tRunJob_9", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_9";

	
		int tos_count_tRunJob_9 = 0;
		
class DealChildJobLibrary_tRunJob_9 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_9 dealChildJobLibrary_tRunJob_9 = new DealChildJobLibrary_tRunJob_9();

	class JVMArgumentHelper_tRunJob_9 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_9 jvm_argument_helper_tRunJob_9 = new JVMArgumentHelper_tRunJob_9();
	
	String audit_jar_path_tRunJob_9 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_9 begin ] stop
 */
	
	/**
	 * [tRunJob_9 main ] start
	 */

	

	
	
	currentComponent="tRunJob_9";

	
	java.util.List<String> paraList_tRunJob_9 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_9 = System.getProperty("os.name");
			if (osName_tRunJob_9 != null && osName_tRunJob_9.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_9.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_9.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_9 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_9 != null){
								paraList_tRunJob_9.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_9);
							}
							String log4j2_config_tRunJob_9 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_9 != null){
								paraList_tRunJob_9.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_9);
							}
							if (log4j1_config_tRunJob_9 != null || log4j2_config_tRunJob_9 != null) {
								paraList_tRunJob_9.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_9.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_9.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "-cp");
		      				
              					String classpath_tRunJob_9_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;job_load_dim_canal_int_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_9!=null && !audit_jar_path_tRunJob_9.isEmpty()) {
		      						classpath_tRunJob_9_5 += audit_jar_path_tRunJob_9;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, dealChildJobLibrary_tRunJob_9.replaceJarPathsFromCrcMap(classpath_tRunJob_9_5), true);
		      				
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "dwh_attejaribank.job_load_dim_canal_int_0_1.Job_Load_DIM_CANAL_INT");
		      				
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "--father_node=tRunJob_9");
		      				
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_9.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_9.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_9 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_9 != null){
								paraList_tRunJob_9.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_9);
							}
							String log4j2_config_tRunJob_9 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_9 != null){
								paraList_tRunJob_9.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_9);
							}
							if (log4j1_config_tRunJob_9 != null || log4j2_config_tRunJob_9 != null) {
								paraList_tRunJob_9.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_9.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_9.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "-cp");
		      				
		      					String classpath_tRunJob_9_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/job_load_dim_canal_int_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_9!=null && !audit_jar_path_tRunJob_9.isEmpty()) {
		      						classpath_tRunJob_9_5 += audit_jar_path_tRunJob_9;
		      					}
		      					
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, dealChildJobLibrary_tRunJob_9.replaceJarPathsFromCrcMap(classpath_tRunJob_9_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "dwh_attejaribank.job_load_dim_canal_int_0_1.Job_Load_DIM_CANAL_INT");
		      				
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "--father_node=tRunJob_9");
		      				
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_9.addArgumentsTo(paraList_tRunJob_9, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_9.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_9.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_9.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_9 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_9 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_9".equals(tRunJobName_tRunJob_9) && childResumePath_tRunJob_9 != null){
		paraList_tRunJob_9.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_9.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_9");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_9 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_9 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_9.put("host", context.host);
                    paraList_tRunJob_9.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_9.put("port", context.port);
                    paraList_tRunJob_9.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_9.put("schema", context.schema);
                    paraList_tRunJob_9.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_9.put("database", context.database);
                    paraList_tRunJob_9.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_9.put("password", context.password);
                    paraList_tRunJob_9.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_9.put("params", context.params);
                    paraList_tRunJob_9.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_9.put("username", context.username);
                    paraList_tRunJob_9.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_9().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_9 = context.propertyNames();
		while (propertyNames_tRunJob_9.hasMoreElements()) {
			String key_tRunJob_9 = (String) propertyNames_tRunJob_9.nextElement();
			Object value_tRunJob_9 = (Object) context.get(key_tRunJob_9);
			if(value_tRunJob_9!=null) {  
				paraList_tRunJob_9.add("--context_param " + key_tRunJob_9 + "=" + value_tRunJob_9);
			} else {
				paraList_tRunJob_9.add("--context_param " + key_tRunJob_9 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_9 = null;

	
	
				class ConsoleHelper_tRunJob_9 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_9_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_9_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_9 consoleHelper_tRunJob_9 = new ConsoleHelper_tRunJob_9();

		Runtime runtime_tRunJob_9 = Runtime.getRuntime();
		Process ps_tRunJob_9 = null;

		//0 indicates normal termination
        int result_tRunJob_9;
        StringBuffer errorMsg_tRunJob_9 = new StringBuffer();
        try {
            ps_tRunJob_9 = runtime_tRunJob_9.exec((String[])paraList_tRunJob_9.toArray(new String[paraList_tRunJob_9.size()]));

            Thread normal_tRunJob_9 = consoleHelper_tRunJob_9.getNormalThread(ps_tRunJob_9);
            normal_tRunJob_9.start();

            Thread error_tRunJob_9 = consoleHelper_tRunJob_9.getErrorThread(ps_tRunJob_9, errorMsg_tRunJob_9);
            error_tRunJob_9.start();

            result_tRunJob_9 = ps_tRunJob_9.waitFor();
            normal_tRunJob_9.join();
            error_tRunJob_9.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_9_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_9.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_9_CHILD_RETURN_CODE",result_tRunJob_9);
		if(result_tRunJob_9 != 0){
   			globalMap.put("tRunJob_9_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_9.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_9 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_9.toString());
			
  		}

		

 


	tos_count_tRunJob_9++;

/**
 * [tRunJob_9 main ] stop
 */
	
	/**
	 * [tRunJob_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_9";

	

 



/**
 * [tRunJob_9 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_9";

	

 



/**
 * [tRunJob_9 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_9 end ] start
	 */

	

	
	
	currentComponent="tRunJob_9";

	

 

ok_Hash.put("tRunJob_9", true);
end_Hash.put("tRunJob_9", System.currentTimeMillis());




/**
 * [tRunJob_9 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_9:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk10", 0, "ok");
								} 
							
							tRunJob_10Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_9 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_9";

	

 



/**
 * [tRunJob_9 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_9_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_10Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_10_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_10 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_10", false);
		start_Hash.put("tRunJob_10", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_10";

	
		int tos_count_tRunJob_10 = 0;
		
class DealChildJobLibrary_tRunJob_10 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_10 dealChildJobLibrary_tRunJob_10 = new DealChildJobLibrary_tRunJob_10();

	class JVMArgumentHelper_tRunJob_10 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_10 jvm_argument_helper_tRunJob_10 = new JVMArgumentHelper_tRunJob_10();
	
	String audit_jar_path_tRunJob_10 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_10 begin ] stop
 */
	
	/**
	 * [tRunJob_10 main ] start
	 */

	

	
	
	currentComponent="tRunJob_10";

	
	java.util.List<String> paraList_tRunJob_10 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_10 = System.getProperty("os.name");
			if (osName_tRunJob_10 != null && osName_tRunJob_10.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_10.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_10.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_10 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_10 != null){
								paraList_tRunJob_10.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_10);
							}
							String log4j2_config_tRunJob_10 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_10 != null){
								paraList_tRunJob_10.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_10);
							}
							if (log4j1_config_tRunJob_10 != null || log4j2_config_tRunJob_10 != null) {
								paraList_tRunJob_10.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_10.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_10.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "-cp");
		      				
              					String classpath_tRunJob_10_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;job_load_dim_type_int_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_10!=null && !audit_jar_path_tRunJob_10.isEmpty()) {
		      						classpath_tRunJob_10_5 += audit_jar_path_tRunJob_10;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, dealChildJobLibrary_tRunJob_10.replaceJarPathsFromCrcMap(classpath_tRunJob_10_5), true);
		      				
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "dwh_attejaribank.job_load_dim_type_int_0_1.Job_Load_DIM_TYPE_INT");
		      				
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "--father_node=tRunJob_10");
		      				
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_10.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_10.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_10 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_10 != null){
								paraList_tRunJob_10.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_10);
							}
							String log4j2_config_tRunJob_10 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_10 != null){
								paraList_tRunJob_10.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_10);
							}
							if (log4j1_config_tRunJob_10 != null || log4j2_config_tRunJob_10 != null) {
								paraList_tRunJob_10.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_10.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_10.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "-cp");
		      				
		      					String classpath_tRunJob_10_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/job_load_dim_type_int_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_10!=null && !audit_jar_path_tRunJob_10.isEmpty()) {
		      						classpath_tRunJob_10_5 += audit_jar_path_tRunJob_10;
		      					}
		      					
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, dealChildJobLibrary_tRunJob_10.replaceJarPathsFromCrcMap(classpath_tRunJob_10_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "dwh_attejaribank.job_load_dim_type_int_0_1.Job_Load_DIM_TYPE_INT");
		      				
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "--father_node=tRunJob_10");
		      				
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_10.addArgumentsTo(paraList_tRunJob_10, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_10.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_10.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_10.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_10 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_10 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_10".equals(tRunJobName_tRunJob_10) && childResumePath_tRunJob_10 != null){
		paraList_tRunJob_10.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_10.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_10");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_10 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_10 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_10.put("host", context.host);
                    paraList_tRunJob_10.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_10.put("port", context.port);
                    paraList_tRunJob_10.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_10.put("schema", context.schema);
                    paraList_tRunJob_10.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_10.put("database", context.database);
                    paraList_tRunJob_10.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_10.put("password", context.password);
                    paraList_tRunJob_10.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_10.put("params", context.params);
                    paraList_tRunJob_10.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_10.put("username", context.username);
                    paraList_tRunJob_10.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_10().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_10 = context.propertyNames();
		while (propertyNames_tRunJob_10.hasMoreElements()) {
			String key_tRunJob_10 = (String) propertyNames_tRunJob_10.nextElement();
			Object value_tRunJob_10 = (Object) context.get(key_tRunJob_10);
			if(value_tRunJob_10!=null) {  
				paraList_tRunJob_10.add("--context_param " + key_tRunJob_10 + "=" + value_tRunJob_10);
			} else {
				paraList_tRunJob_10.add("--context_param " + key_tRunJob_10 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_10 = null;

	
	
				class ConsoleHelper_tRunJob_10 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_10_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_10_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_10 consoleHelper_tRunJob_10 = new ConsoleHelper_tRunJob_10();

		Runtime runtime_tRunJob_10 = Runtime.getRuntime();
		Process ps_tRunJob_10 = null;

		//0 indicates normal termination
        int result_tRunJob_10;
        StringBuffer errorMsg_tRunJob_10 = new StringBuffer();
        try {
            ps_tRunJob_10 = runtime_tRunJob_10.exec((String[])paraList_tRunJob_10.toArray(new String[paraList_tRunJob_10.size()]));

            Thread normal_tRunJob_10 = consoleHelper_tRunJob_10.getNormalThread(ps_tRunJob_10);
            normal_tRunJob_10.start();

            Thread error_tRunJob_10 = consoleHelper_tRunJob_10.getErrorThread(ps_tRunJob_10, errorMsg_tRunJob_10);
            error_tRunJob_10.start();

            result_tRunJob_10 = ps_tRunJob_10.waitFor();
            normal_tRunJob_10.join();
            error_tRunJob_10.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_10_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_10.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_10_CHILD_RETURN_CODE",result_tRunJob_10);
		if(result_tRunJob_10 != 0){
   			globalMap.put("tRunJob_10_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_10.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_10 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_10.toString());
			
  		}

		

 


	tos_count_tRunJob_10++;

/**
 * [tRunJob_10 main ] stop
 */
	
	/**
	 * [tRunJob_10 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_10";

	

 



/**
 * [tRunJob_10 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_10 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_10";

	

 



/**
 * [tRunJob_10 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_10 end ] start
	 */

	

	
	
	currentComponent="tRunJob_10";

	

 

ok_Hash.put("tRunJob_10", true);
end_Hash.put("tRunJob_10", System.currentTimeMillis());




/**
 * [tRunJob_10 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_10:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk11", 0, "ok");
								} 
							
							tRunJob_11Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_10 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_10";

	

 



/**
 * [tRunJob_10 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_10_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_11Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_11_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_11 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_11", false);
		start_Hash.put("tRunJob_11", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_11";

	
		int tos_count_tRunJob_11 = 0;
		
class DealChildJobLibrary_tRunJob_11 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_11 dealChildJobLibrary_tRunJob_11 = new DealChildJobLibrary_tRunJob_11();

	class JVMArgumentHelper_tRunJob_11 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_11 jvm_argument_helper_tRunJob_11 = new JVMArgumentHelper_tRunJob_11();
	
	String audit_jar_path_tRunJob_11 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_11 begin ] stop
 */
	
	/**
	 * [tRunJob_11 main ] start
	 */

	

	
	
	currentComponent="tRunJob_11";

	
	java.util.List<String> paraList_tRunJob_11 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_11 = System.getProperty("os.name");
			if (osName_tRunJob_11 != null && osName_tRunJob_11.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_11.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_11.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_11 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_11 != null){
								paraList_tRunJob_11.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_11);
							}
							String log4j2_config_tRunJob_11 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_11 != null){
								paraList_tRunJob_11.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_11);
							}
							if (log4j1_config_tRunJob_11 != null || log4j2_config_tRunJob_11 != null) {
								paraList_tRunJob_11.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_11.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_11.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "-cp");
		      				
              					String classpath_tRunJob_11_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;job_load_dim_statut_recl_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_11!=null && !audit_jar_path_tRunJob_11.isEmpty()) {
		      						classpath_tRunJob_11_5 += audit_jar_path_tRunJob_11;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, dealChildJobLibrary_tRunJob_11.replaceJarPathsFromCrcMap(classpath_tRunJob_11_5), true);
		      				
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "dwh_attejaribank.job_load_dim_statut_recl_0_1.Job_Load_DIM_STATUT_RECL");
		      				
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "--father_node=tRunJob_11");
		      				
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_11.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_11.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_11 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_11 != null){
								paraList_tRunJob_11.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_11);
							}
							String log4j2_config_tRunJob_11 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_11 != null){
								paraList_tRunJob_11.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_11);
							}
							if (log4j1_config_tRunJob_11 != null || log4j2_config_tRunJob_11 != null) {
								paraList_tRunJob_11.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_11.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_11.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "-cp");
		      				
		      					String classpath_tRunJob_11_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/job_load_dim_statut_recl_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_11!=null && !audit_jar_path_tRunJob_11.isEmpty()) {
		      						classpath_tRunJob_11_5 += audit_jar_path_tRunJob_11;
		      					}
		      					
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, dealChildJobLibrary_tRunJob_11.replaceJarPathsFromCrcMap(classpath_tRunJob_11_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "dwh_attejaribank.job_load_dim_statut_recl_0_1.Job_Load_DIM_STATUT_RECL");
		      				
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "--father_node=tRunJob_11");
		      				
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_11.addArgumentsTo(paraList_tRunJob_11, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_11.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_11.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_11.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_11 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_11 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_11".equals(tRunJobName_tRunJob_11) && childResumePath_tRunJob_11 != null){
		paraList_tRunJob_11.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_11.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_11");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_11 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_11 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_11.put("host", context.host);
                    paraList_tRunJob_11.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_11.put("port", context.port);
                    paraList_tRunJob_11.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_11.put("schema", context.schema);
                    paraList_tRunJob_11.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_11.put("database", context.database);
                    paraList_tRunJob_11.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_11.put("password", context.password);
                    paraList_tRunJob_11.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_11.put("params", context.params);
                    paraList_tRunJob_11.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_11.put("username", context.username);
                    paraList_tRunJob_11.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_11().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_11 = context.propertyNames();
		while (propertyNames_tRunJob_11.hasMoreElements()) {
			String key_tRunJob_11 = (String) propertyNames_tRunJob_11.nextElement();
			Object value_tRunJob_11 = (Object) context.get(key_tRunJob_11);
			if(value_tRunJob_11!=null) {  
				paraList_tRunJob_11.add("--context_param " + key_tRunJob_11 + "=" + value_tRunJob_11);
			} else {
				paraList_tRunJob_11.add("--context_param " + key_tRunJob_11 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_11 = null;

	
	
				class ConsoleHelper_tRunJob_11 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_11_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_11_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_11 consoleHelper_tRunJob_11 = new ConsoleHelper_tRunJob_11();

		Runtime runtime_tRunJob_11 = Runtime.getRuntime();
		Process ps_tRunJob_11 = null;

		//0 indicates normal termination
        int result_tRunJob_11;
        StringBuffer errorMsg_tRunJob_11 = new StringBuffer();
        try {
            ps_tRunJob_11 = runtime_tRunJob_11.exec((String[])paraList_tRunJob_11.toArray(new String[paraList_tRunJob_11.size()]));

            Thread normal_tRunJob_11 = consoleHelper_tRunJob_11.getNormalThread(ps_tRunJob_11);
            normal_tRunJob_11.start();

            Thread error_tRunJob_11 = consoleHelper_tRunJob_11.getErrorThread(ps_tRunJob_11, errorMsg_tRunJob_11);
            error_tRunJob_11.start();

            result_tRunJob_11 = ps_tRunJob_11.waitFor();
            normal_tRunJob_11.join();
            error_tRunJob_11.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_11_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_11.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_11_CHILD_RETURN_CODE",result_tRunJob_11);
		if(result_tRunJob_11 != 0){
   			globalMap.put("tRunJob_11_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_11.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_11 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_11.toString());
			
  		}

		

 


	tos_count_tRunJob_11++;

/**
 * [tRunJob_11 main ] stop
 */
	
	/**
	 * [tRunJob_11 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_11";

	

 



/**
 * [tRunJob_11 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_11 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_11";

	

 



/**
 * [tRunJob_11 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_11 end ] start
	 */

	

	
	
	currentComponent="tRunJob_11";

	

 

ok_Hash.put("tRunJob_11", true);
end_Hash.put("tRunJob_11", System.currentTimeMillis());




/**
 * [tRunJob_11 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_11:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk12", 0, "ok");
								} 
							
							tRunJob_12Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_11 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_11";

	

 



/**
 * [tRunJob_11 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_11_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_12Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_12_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_12 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_12", false);
		start_Hash.put("tRunJob_12", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_12";

	
		int tos_count_tRunJob_12 = 0;
		
class DealChildJobLibrary_tRunJob_12 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_12 dealChildJobLibrary_tRunJob_12 = new DealChildJobLibrary_tRunJob_12();

	class JVMArgumentHelper_tRunJob_12 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_12 jvm_argument_helper_tRunJob_12 = new JVMArgumentHelper_tRunJob_12();
	
	String audit_jar_path_tRunJob_12 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_12 begin ] stop
 */
	
	/**
	 * [tRunJob_12 main ] start
	 */

	

	
	
	currentComponent="tRunJob_12";

	
	java.util.List<String> paraList_tRunJob_12 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_12 = System.getProperty("os.name");
			if (osName_tRunJob_12 != null && osName_tRunJob_12.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_12.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_12.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_12 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_12 != null){
								paraList_tRunJob_12.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_12);
							}
							String log4j2_config_tRunJob_12 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_12 != null){
								paraList_tRunJob_12.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_12);
							}
							if (log4j1_config_tRunJob_12 != null || log4j2_config_tRunJob_12 != null) {
								paraList_tRunJob_12.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_12.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_12.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "-Xms64m");
		      				
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "-Xmx512m");
		      				
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "-cp");
		      				
              					String classpath_tRunJob_12_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;job_load_dim_motif_recl_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_12!=null && !audit_jar_path_tRunJob_12.isEmpty()) {
		      						classpath_tRunJob_12_5 += audit_jar_path_tRunJob_12;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, dealChildJobLibrary_tRunJob_12.replaceJarPathsFromCrcMap(classpath_tRunJob_12_5), true);
		      				
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "dwh_attejaribank.job_load_dim_motif_recl_0_1.Job_Load_DIM_MOTIF_RECL");
		      				
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "--father_node=tRunJob_12");
		      				
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_12.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_12.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_12 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_12 != null){
								paraList_tRunJob_12.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_12);
							}
							String log4j2_config_tRunJob_12 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_12 != null){
								paraList_tRunJob_12.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_12);
							}
							if (log4j1_config_tRunJob_12 != null || log4j2_config_tRunJob_12 != null) {
								paraList_tRunJob_12.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_12.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_12.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "-Xms64m");
		      				
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "-Xmx512m");
		      				
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "-cp");
		      				
		      					String classpath_tRunJob_12_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/job_load_dim_motif_recl_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_12!=null && !audit_jar_path_tRunJob_12.isEmpty()) {
		      						classpath_tRunJob_12_5 += audit_jar_path_tRunJob_12;
		      					}
		      					
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, dealChildJobLibrary_tRunJob_12.replaceJarPathsFromCrcMap(classpath_tRunJob_12_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "dwh_attejaribank.job_load_dim_motif_recl_0_1.Job_Load_DIM_MOTIF_RECL");
		      				
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "--father_node=tRunJob_12");
		      				
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_12.addArgumentsTo(paraList_tRunJob_12, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_12.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_12.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_12.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_12 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_12 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_12".equals(tRunJobName_tRunJob_12) && childResumePath_tRunJob_12 != null){
		paraList_tRunJob_12.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_12.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_12");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_12 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_12 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_12.put("host", context.host);
                    paraList_tRunJob_12.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_12.put("port", context.port);
                    paraList_tRunJob_12.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_12.put("schema", context.schema);
                    paraList_tRunJob_12.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_12.put("database", context.database);
                    paraList_tRunJob_12.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_12.put("password", context.password);
                    paraList_tRunJob_12.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_12.put("params", context.params);
                    paraList_tRunJob_12.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_12.put("username", context.username);
                    paraList_tRunJob_12.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_12().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_12 = context.propertyNames();
		while (propertyNames_tRunJob_12.hasMoreElements()) {
			String key_tRunJob_12 = (String) propertyNames_tRunJob_12.nextElement();
			Object value_tRunJob_12 = (Object) context.get(key_tRunJob_12);
			if(value_tRunJob_12!=null) {  
				paraList_tRunJob_12.add("--context_param " + key_tRunJob_12 + "=" + value_tRunJob_12);
			} else {
				paraList_tRunJob_12.add("--context_param " + key_tRunJob_12 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_12 = null;

	
	
				class ConsoleHelper_tRunJob_12 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_12_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_12_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_12 consoleHelper_tRunJob_12 = new ConsoleHelper_tRunJob_12();

		Runtime runtime_tRunJob_12 = Runtime.getRuntime();
		Process ps_tRunJob_12 = null;

		//0 indicates normal termination
        int result_tRunJob_12;
        StringBuffer errorMsg_tRunJob_12 = new StringBuffer();
        try {
            ps_tRunJob_12 = runtime_tRunJob_12.exec((String[])paraList_tRunJob_12.toArray(new String[paraList_tRunJob_12.size()]));

            Thread normal_tRunJob_12 = consoleHelper_tRunJob_12.getNormalThread(ps_tRunJob_12);
            normal_tRunJob_12.start();

            Thread error_tRunJob_12 = consoleHelper_tRunJob_12.getErrorThread(ps_tRunJob_12, errorMsg_tRunJob_12);
            error_tRunJob_12.start();

            result_tRunJob_12 = ps_tRunJob_12.waitFor();
            normal_tRunJob_12.join();
            error_tRunJob_12.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_12_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_12.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_12_CHILD_RETURN_CODE",result_tRunJob_12);
		if(result_tRunJob_12 != 0){
   			globalMap.put("tRunJob_12_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_12.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_12 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_12.toString());
			
  		}

		

 


	tos_count_tRunJob_12++;

/**
 * [tRunJob_12 main ] stop
 */
	
	/**
	 * [tRunJob_12 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_12";

	

 



/**
 * [tRunJob_12 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_12 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_12";

	

 



/**
 * [tRunJob_12 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_12 end ] start
	 */

	

	
	
	currentComponent="tRunJob_12";

	

 

ok_Hash.put("tRunJob_12", true);
end_Hash.put("tRunJob_12", System.currentTimeMillis());




/**
 * [tRunJob_12 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_12:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk13", 0, "ok");
								} 
							
							tRunJob_13Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_12 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_12";

	

 



/**
 * [tRunJob_12 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_12_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_13Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_13_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_13 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_13", false);
		start_Hash.put("tRunJob_13", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_13";

	
		int tos_count_tRunJob_13 = 0;
		
class DealChildJobLibrary_tRunJob_13 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_13 dealChildJobLibrary_tRunJob_13 = new DealChildJobLibrary_tRunJob_13();

	class JVMArgumentHelper_tRunJob_13 {
		
		
		
		private boolean have_set_custom_argument;
		
		private java.util.List<String> custom_arguments;
		
		
		boolean custom_file_encoding;
		boolean custom_jmxremote;
		boolean custom_jmxremote_port;
		boolean custom_jmxremote_ssl;
		boolean custom_jmxremote_authenticate;
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			if(!have_set_custom_argument) {
				custom_arguments = new java.util.ArrayList<>();
				
				
				for(String current_custom_argument : custom_arguments) {
					if(current_custom_argument == null || current_custom_argument.isEmpty()) {
						continue;
					}
					
					target_argument_list.add(current_custom_argument);
					
					if(current_custom_argument.startsWith("-Dfile.encoding=")) {
						custom_file_encoding = true;
					}
					
					if(current_custom_argument.equals("-Dcom.sun.management.jmxremote")) {
						custom_jmxremote = true;
					}
					
					if(current_custom_argument.startsWith("-Dcom.sun.management.jmxremote.port=")) {
						custom_jmxremote_port = true;
					}
					
					if(current_custom_argument.startsWith("-Dcom.sun.management.jmxremote.ssl=")) {
						custom_jmxremote_ssl = true;
					}
					
					if(current_custom_argument.startsWith("-Dcom.sun.management.jmxremote.authenticate=")) {
						custom_jmxremote_authenticate = true;
					}
				}
				
				have_set_custom_argument = true;
			}
			
			if(argument_from_child == null || argument_from_child.isEmpty()) {
				return;
			}
			
			if(argument_from_child.startsWith("-Dfile.encoding=") && custom_file_encoding) {
				return;
			}
			
			if(argument_from_child.equals("-Dcom.sun.management.jmxremote") && custom_jmxremote) {
				return;
			}
			
			if(argument_from_child.startsWith("-Dcom.sun.management.jmxremote.port=") && custom_jmxremote_port) {
				return;
			}
			
			if(argument_from_child.equals("-Dcom.sun.management.jmxremote.ssl=false") && custom_jmxremote_ssl) {
				return;
			}
			
			if(argument_from_child.equals("-Dcom.sun.management.jmxremote.authenticate=false") && custom_jmxremote_authenticate) {
				return;
			}
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
		public void reset() {
			have_set_custom_argument = false;
			custom_arguments.clear();
			
			custom_file_encoding = false;
			custom_jmxremote = false;
			custom_jmxremote_port = false;
			custom_jmxremote_ssl = false;
			custom_jmxremote_authenticate = false;
		}
		
	}
	
	JVMArgumentHelper_tRunJob_13 jvm_argument_helper_tRunJob_13 = new JVMArgumentHelper_tRunJob_13();
	
	String audit_jar_path_tRunJob_13 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_13 begin ] stop
 */
	
	/**
	 * [tRunJob_13 main ] start
	 */

	

	
	
	currentComponent="tRunJob_13";

	
	java.util.List<String> paraList_tRunJob_13 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_13 = System.getProperty("os.name");
			if (osName_tRunJob_13 != null && osName_tRunJob_13.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_13.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_13.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_13 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_13 != null){
								paraList_tRunJob_13.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_13);
							}
							String log4j2_config_tRunJob_13 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_13 != null){
								paraList_tRunJob_13.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_13);
							}
							if (log4j1_config_tRunJob_13 != null || log4j2_config_tRunJob_13 != null) {
								paraList_tRunJob_13.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_13.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_13.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "-cp");
		      				
              					String classpath_tRunJob_13_3 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/trove.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;job_load_dim_interaction_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_13!=null && !audit_jar_path_tRunJob_13.isEmpty()) {
		      						classpath_tRunJob_13_3 += audit_jar_path_tRunJob_13;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, dealChildJobLibrary_tRunJob_13.replaceJarPathsFromCrcMap(classpath_tRunJob_13_3), true);
		      				
		      					jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "dwh_attejaribank.job_load_dim_interaction_0_1.Job_Load_DIM_INTERACTION");
		      				
		      					jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "--father_node=tRunJob_13");
		      				
		      					jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_13.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_13.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_13 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_13 != null){
								paraList_tRunJob_13.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_13);
							}
							String log4j2_config_tRunJob_13 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_13 != null){
								paraList_tRunJob_13.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_13);
							}
							if (log4j1_config_tRunJob_13 != null || log4j2_config_tRunJob_13 != null) {
								paraList_tRunJob_13.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_13.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_13.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "-cp");
		      				
		      					String classpath_tRunJob_13_3 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/log4j-1.2-api-2.13.2.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/jboss-marshalling-river-2.0.12.Final.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/advancedPersistentLookupLib-1.3.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/trove.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/job_load_dim_interaction_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_13!=null && !audit_jar_path_tRunJob_13.isEmpty()) {
		      						classpath_tRunJob_13_3 += audit_jar_path_tRunJob_13;
		      					}
		      					
								jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, dealChildJobLibrary_tRunJob_13.replaceJarPathsFromCrcMap(classpath_tRunJob_13_3).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "dwh_attejaribank.job_load_dim_interaction_0_1.Job_Load_DIM_INTERACTION");
		      				
								jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "--father_node=tRunJob_13");
		      				
								jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_13.addArgumentsTo(paraList_tRunJob_13, "$@");
		      				
			}

			
			jvm_argument_helper_tRunJob_13.reset();
			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_13.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_13.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_13.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_13 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_13 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_13".equals(tRunJobName_tRunJob_13) && childResumePath_tRunJob_13 != null){
		paraList_tRunJob_13.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_13.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_13");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_13 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_13 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_13.put("host", context.host);
                    paraList_tRunJob_13.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_13.put("port", context.port);
                    paraList_tRunJob_13.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_13.put("schema", context.schema);
                    paraList_tRunJob_13.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_13.put("database", context.database);
                    paraList_tRunJob_13.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_13.put("password", context.password);
                    paraList_tRunJob_13.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_13.put("params", context.params);
                    paraList_tRunJob_13.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_13.put("username", context.username);
                    paraList_tRunJob_13.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_13().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_13 = context.propertyNames();
		while (propertyNames_tRunJob_13.hasMoreElements()) {
			String key_tRunJob_13 = (String) propertyNames_tRunJob_13.nextElement();
			Object value_tRunJob_13 = (Object) context.get(key_tRunJob_13);
			if(value_tRunJob_13!=null) {  
				paraList_tRunJob_13.add("--context_param " + key_tRunJob_13 + "=" + value_tRunJob_13);
			} else {
				paraList_tRunJob_13.add("--context_param " + key_tRunJob_13 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_13 = null;

	
	
				class ConsoleHelper_tRunJob_13 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_13_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_13_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_13 consoleHelper_tRunJob_13 = new ConsoleHelper_tRunJob_13();

		Runtime runtime_tRunJob_13 = Runtime.getRuntime();
		Process ps_tRunJob_13 = null;

		//0 indicates normal termination
        int result_tRunJob_13;
        StringBuffer errorMsg_tRunJob_13 = new StringBuffer();
        try {
            ps_tRunJob_13 = runtime_tRunJob_13.exec((String[])paraList_tRunJob_13.toArray(new String[paraList_tRunJob_13.size()]));

            Thread normal_tRunJob_13 = consoleHelper_tRunJob_13.getNormalThread(ps_tRunJob_13);
            normal_tRunJob_13.start();

            Thread error_tRunJob_13 = consoleHelper_tRunJob_13.getErrorThread(ps_tRunJob_13, errorMsg_tRunJob_13);
            error_tRunJob_13.start();

            result_tRunJob_13 = ps_tRunJob_13.waitFor();
            normal_tRunJob_13.join();
            error_tRunJob_13.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_13_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_13.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_13_CHILD_RETURN_CODE",result_tRunJob_13);
		if(result_tRunJob_13 != 0){
   			globalMap.put("tRunJob_13_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_13.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_13 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_13.toString());
			
  		}

		

 


	tos_count_tRunJob_13++;

/**
 * [tRunJob_13 main ] stop
 */
	
	/**
	 * [tRunJob_13 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_13";

	

 



/**
 * [tRunJob_13 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_13 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_13";

	

 



/**
 * [tRunJob_13 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_13 end ] start
	 */

	

	
	
	currentComponent="tRunJob_13";

	

 

ok_Hash.put("tRunJob_13", true);
end_Hash.put("tRunJob_13", System.currentTimeMillis());




/**
 * [tRunJob_13 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_13:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk14", 0, "ok");
								} 
							
							tRunJob_14Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_13 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_13";

	

 



/**
 * [tRunJob_13 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_13_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_14Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_14_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_14 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_14", false);
		start_Hash.put("tRunJob_14", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_14";

	
		int tos_count_tRunJob_14 = 0;
		
class DealChildJobLibrary_tRunJob_14 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_14 dealChildJobLibrary_tRunJob_14 = new DealChildJobLibrary_tRunJob_14();

	class JVMArgumentHelper_tRunJob_14 {
		
		
		
		private boolean have_set_custom_argument;
		
		private java.util.List<String> custom_arguments;
		
		
		boolean custom_file_encoding;
		boolean custom_jmxremote;
		boolean custom_jmxremote_port;
		boolean custom_jmxremote_ssl;
		boolean custom_jmxremote_authenticate;
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			if(!have_set_custom_argument) {
				custom_arguments = new java.util.ArrayList<>();
				
				
				for(String current_custom_argument : custom_arguments) {
					if(current_custom_argument == null || current_custom_argument.isEmpty()) {
						continue;
					}
					
					target_argument_list.add(current_custom_argument);
					
					if(current_custom_argument.startsWith("-Dfile.encoding=")) {
						custom_file_encoding = true;
					}
					
					if(current_custom_argument.equals("-Dcom.sun.management.jmxremote")) {
						custom_jmxremote = true;
					}
					
					if(current_custom_argument.startsWith("-Dcom.sun.management.jmxremote.port=")) {
						custom_jmxremote_port = true;
					}
					
					if(current_custom_argument.startsWith("-Dcom.sun.management.jmxremote.ssl=")) {
						custom_jmxremote_ssl = true;
					}
					
					if(current_custom_argument.startsWith("-Dcom.sun.management.jmxremote.authenticate=")) {
						custom_jmxremote_authenticate = true;
					}
				}
				
				have_set_custom_argument = true;
			}
			
			if(argument_from_child == null || argument_from_child.isEmpty()) {
				return;
			}
			
			if(argument_from_child.startsWith("-Dfile.encoding=") && custom_file_encoding) {
				return;
			}
			
			if(argument_from_child.equals("-Dcom.sun.management.jmxremote") && custom_jmxremote) {
				return;
			}
			
			if(argument_from_child.startsWith("-Dcom.sun.management.jmxremote.port=") && custom_jmxremote_port) {
				return;
			}
			
			if(argument_from_child.equals("-Dcom.sun.management.jmxremote.ssl=false") && custom_jmxremote_ssl) {
				return;
			}
			
			if(argument_from_child.equals("-Dcom.sun.management.jmxremote.authenticate=false") && custom_jmxremote_authenticate) {
				return;
			}
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
		public void reset() {
			have_set_custom_argument = false;
			custom_arguments.clear();
			
			custom_file_encoding = false;
			custom_jmxremote = false;
			custom_jmxremote_port = false;
			custom_jmxremote_ssl = false;
			custom_jmxremote_authenticate = false;
		}
		
	}
	
	JVMArgumentHelper_tRunJob_14 jvm_argument_helper_tRunJob_14 = new JVMArgumentHelper_tRunJob_14();
	
	String audit_jar_path_tRunJob_14 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_14 begin ] stop
 */
	
	/**
	 * [tRunJob_14 main ] start
	 */

	

	
	
	currentComponent="tRunJob_14";

	
	java.util.List<String> paraList_tRunJob_14 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_14 = System.getProperty("os.name");
			if (osName_tRunJob_14 != null && osName_tRunJob_14.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_14.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_14.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_14 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_14 != null){
								paraList_tRunJob_14.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_14);
							}
							String log4j2_config_tRunJob_14 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_14 != null){
								paraList_tRunJob_14.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_14);
							}
							if (log4j1_config_tRunJob_14 != null || log4j2_config_tRunJob_14 != null) {
								paraList_tRunJob_14.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_14.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_14.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "-cp");
		      				
              					String classpath_tRunJob_14_3 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/trove.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;job_load_dim_reclamation_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_14!=null && !audit_jar_path_tRunJob_14.isEmpty()) {
		      						classpath_tRunJob_14_3 += audit_jar_path_tRunJob_14;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, dealChildJobLibrary_tRunJob_14.replaceJarPathsFromCrcMap(classpath_tRunJob_14_3), true);
		      				
		      					jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "dwh_attejaribank.job_load_dim_reclamation_0_1.Job_Load_DIM_RECLAMATION");
		      				
		      					jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "--father_node=tRunJob_14");
		      				
		      					jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_14.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_14.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_14 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_14 != null){
								paraList_tRunJob_14.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_14);
							}
							String log4j2_config_tRunJob_14 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_14 != null){
								paraList_tRunJob_14.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_14);
							}
							if (log4j1_config_tRunJob_14 != null || log4j2_config_tRunJob_14 != null) {
								paraList_tRunJob_14.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_14.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_14.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "-cp");
		      				
		      					String classpath_tRunJob_14_3 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/log4j-1.2-api-2.13.2.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/jboss-marshalling-river-2.0.12.Final.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/advancedPersistentLookupLib-1.3.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/trove.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/job_load_dim_reclamation_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_14!=null && !audit_jar_path_tRunJob_14.isEmpty()) {
		      						classpath_tRunJob_14_3 += audit_jar_path_tRunJob_14;
		      					}
		      					
								jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, dealChildJobLibrary_tRunJob_14.replaceJarPathsFromCrcMap(classpath_tRunJob_14_3).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "dwh_attejaribank.job_load_dim_reclamation_0_1.Job_Load_DIM_RECLAMATION");
		      				
								jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "--father_node=tRunJob_14");
		      				
								jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_14.addArgumentsTo(paraList_tRunJob_14, "$@");
		      				
			}

			
			jvm_argument_helper_tRunJob_14.reset();
			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_14.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_14.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_14.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_14 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_14 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_14".equals(tRunJobName_tRunJob_14) && childResumePath_tRunJob_14 != null){
		paraList_tRunJob_14.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_14.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_14");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_14 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_14 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_14.put("host", context.host);
                    paraList_tRunJob_14.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_14.put("port", context.port);
                    paraList_tRunJob_14.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_14.put("schema", context.schema);
                    paraList_tRunJob_14.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_14.put("database", context.database);
                    paraList_tRunJob_14.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_14.put("password", context.password);
                    paraList_tRunJob_14.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_14.put("params", context.params);
                    paraList_tRunJob_14.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_14.put("username", context.username);
                    paraList_tRunJob_14.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_14().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_14 = context.propertyNames();
		while (propertyNames_tRunJob_14.hasMoreElements()) {
			String key_tRunJob_14 = (String) propertyNames_tRunJob_14.nextElement();
			Object value_tRunJob_14 = (Object) context.get(key_tRunJob_14);
			if(value_tRunJob_14!=null) {  
				paraList_tRunJob_14.add("--context_param " + key_tRunJob_14 + "=" + value_tRunJob_14);
			} else {
				paraList_tRunJob_14.add("--context_param " + key_tRunJob_14 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_14 = null;

	
	
				class ConsoleHelper_tRunJob_14 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_14_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_14_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_14 consoleHelper_tRunJob_14 = new ConsoleHelper_tRunJob_14();

		Runtime runtime_tRunJob_14 = Runtime.getRuntime();
		Process ps_tRunJob_14 = null;

		//0 indicates normal termination
        int result_tRunJob_14;
        StringBuffer errorMsg_tRunJob_14 = new StringBuffer();
        try {
            ps_tRunJob_14 = runtime_tRunJob_14.exec((String[])paraList_tRunJob_14.toArray(new String[paraList_tRunJob_14.size()]));

            Thread normal_tRunJob_14 = consoleHelper_tRunJob_14.getNormalThread(ps_tRunJob_14);
            normal_tRunJob_14.start();

            Thread error_tRunJob_14 = consoleHelper_tRunJob_14.getErrorThread(ps_tRunJob_14, errorMsg_tRunJob_14);
            error_tRunJob_14.start();

            result_tRunJob_14 = ps_tRunJob_14.waitFor();
            normal_tRunJob_14.join();
            error_tRunJob_14.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_14_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_14.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_14_CHILD_RETURN_CODE",result_tRunJob_14);
		if(result_tRunJob_14 != 0){
   			globalMap.put("tRunJob_14_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_14.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_14 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_14.toString());
			
  		}

		

 


	tos_count_tRunJob_14++;

/**
 * [tRunJob_14 main ] stop
 */
	
	/**
	 * [tRunJob_14 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_14";

	

 



/**
 * [tRunJob_14 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_14 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_14";

	

 



/**
 * [tRunJob_14 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_14 end ] start
	 */

	

	
	
	currentComponent="tRunJob_14";

	

 

ok_Hash.put("tRunJob_14", true);
end_Hash.put("tRunJob_14", System.currentTimeMillis());




/**
 * [tRunJob_14 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_14:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk15", 0, "ok");
								} 
							
							tRunJob_15Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_14 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_14";

	

 



/**
 * [tRunJob_14 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_14_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_15Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_15_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_15 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_15", false);
		start_Hash.put("tRunJob_15", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_15";

	
		int tos_count_tRunJob_15 = 0;
		
class DealChildJobLibrary_tRunJob_15 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_15 dealChildJobLibrary_tRunJob_15 = new DealChildJobLibrary_tRunJob_15();

	class JVMArgumentHelper_tRunJob_15 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_15 jvm_argument_helper_tRunJob_15 = new JVMArgumentHelper_tRunJob_15();
	
	String audit_jar_path_tRunJob_15 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_15 begin ] stop
 */
	
	/**
	 * [tRunJob_15 main ] start
	 */

	

	
	
	currentComponent="tRunJob_15";

	
	java.util.List<String> paraList_tRunJob_15 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_15 = System.getProperty("os.name");
			if (osName_tRunJob_15 != null && osName_tRunJob_15.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_15.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_15.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_15 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_15 != null){
								paraList_tRunJob_15.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_15);
							}
							String log4j2_config_tRunJob_15 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_15 != null){
								paraList_tRunJob_15.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_15);
							}
							if (log4j1_config_tRunJob_15 != null || log4j2_config_tRunJob_15 != null) {
								paraList_tRunJob_15.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_15.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_15.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "-Xms512m");
		      				
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "-Xmx2048m");
		      				
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "-cp");
		      				
              					String classpath_tRunJob_15_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_operation_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_15!=null && !audit_jar_path_tRunJob_15.isEmpty()) {
		      						classpath_tRunJob_15_5 += audit_jar_path_tRunJob_15;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, dealChildJobLibrary_tRunJob_15.replaceJarPathsFromCrcMap(classpath_tRunJob_15_5), true);
		      				
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "dwh_attejaribank.j_load_operation_0_1.J_Load_OPERATION");
		      				
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "--father_node=tRunJob_15");
		      				
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_15.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_15.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_15 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_15 != null){
								paraList_tRunJob_15.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_15);
							}
							String log4j2_config_tRunJob_15 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_15 != null){
								paraList_tRunJob_15.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_15);
							}
							if (log4j1_config_tRunJob_15 != null || log4j2_config_tRunJob_15 != null) {
								paraList_tRunJob_15.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_15.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_15.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "-Xms512m");
		      				
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "-Xmx2048m");
		      				
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "-cp");
		      				
		      					String classpath_tRunJob_15_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_operation_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_15!=null && !audit_jar_path_tRunJob_15.isEmpty()) {
		      						classpath_tRunJob_15_5 += audit_jar_path_tRunJob_15;
		      					}
		      					
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, dealChildJobLibrary_tRunJob_15.replaceJarPathsFromCrcMap(classpath_tRunJob_15_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "dwh_attejaribank.j_load_operation_0_1.J_Load_OPERATION");
		      				
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "--father_node=tRunJob_15");
		      				
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_15.addArgumentsTo(paraList_tRunJob_15, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_15.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_15.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_15.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_15 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_15 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_15".equals(tRunJobName_tRunJob_15) && childResumePath_tRunJob_15 != null){
		paraList_tRunJob_15.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_15.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_15");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_15 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_15 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_15.put("host", context.host);
                    paraList_tRunJob_15.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_15.put("port", context.port);
                    paraList_tRunJob_15.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_15.put("schema", context.schema);
                    paraList_tRunJob_15.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_15.put("database", context.database);
                    paraList_tRunJob_15.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_15.put("password", context.password);
                    paraList_tRunJob_15.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_15.put("params", context.params);
                    paraList_tRunJob_15.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_15.put("username", context.username);
                    paraList_tRunJob_15.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_15().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_15 = context.propertyNames();
		while (propertyNames_tRunJob_15.hasMoreElements()) {
			String key_tRunJob_15 = (String) propertyNames_tRunJob_15.nextElement();
			Object value_tRunJob_15 = (Object) context.get(key_tRunJob_15);
			if(value_tRunJob_15!=null) {  
				paraList_tRunJob_15.add("--context_param " + key_tRunJob_15 + "=" + value_tRunJob_15);
			} else {
				paraList_tRunJob_15.add("--context_param " + key_tRunJob_15 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_15 = null;

	
	
				class ConsoleHelper_tRunJob_15 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_15_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_15_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_15 consoleHelper_tRunJob_15 = new ConsoleHelper_tRunJob_15();

		Runtime runtime_tRunJob_15 = Runtime.getRuntime();
		Process ps_tRunJob_15 = null;

		//0 indicates normal termination
        int result_tRunJob_15;
        StringBuffer errorMsg_tRunJob_15 = new StringBuffer();
        try {
            ps_tRunJob_15 = runtime_tRunJob_15.exec((String[])paraList_tRunJob_15.toArray(new String[paraList_tRunJob_15.size()]));

            Thread normal_tRunJob_15 = consoleHelper_tRunJob_15.getNormalThread(ps_tRunJob_15);
            normal_tRunJob_15.start();

            Thread error_tRunJob_15 = consoleHelper_tRunJob_15.getErrorThread(ps_tRunJob_15, errorMsg_tRunJob_15);
            error_tRunJob_15.start();

            result_tRunJob_15 = ps_tRunJob_15.waitFor();
            normal_tRunJob_15.join();
            error_tRunJob_15.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_15_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_15.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_15_CHILD_RETURN_CODE",result_tRunJob_15);
		if(result_tRunJob_15 != 0){
   			globalMap.put("tRunJob_15_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_15.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_15 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_15.toString());
			
  		}

		

 


	tos_count_tRunJob_15++;

/**
 * [tRunJob_15 main ] stop
 */
	
	/**
	 * [tRunJob_15 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_15";

	

 



/**
 * [tRunJob_15 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_15 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_15";

	

 



/**
 * [tRunJob_15 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_15 end ] start
	 */

	

	
	
	currentComponent="tRunJob_15";

	

 

ok_Hash.put("tRunJob_15", true);
end_Hash.put("tRunJob_15", System.currentTimeMillis());




/**
 * [tRunJob_15 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_15:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk16", 0, "ok");
								} 
							
							tRunJob_16Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_15 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_15";

	

 



/**
 * [tRunJob_15 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_15_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_16Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_16_SUBPROCESS_STATE", 0);

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



		


	
	/**
	 * [tRunJob_16 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_16", false);
		start_Hash.put("tRunJob_16", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_16";

	
		int tos_count_tRunJob_16 = 0;
		
class DealChildJobLibrary_tRunJob_16 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_16 dealChildJobLibrary_tRunJob_16 = new DealChildJobLibrary_tRunJob_16();

	class JVMArgumentHelper_tRunJob_16 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_16 jvm_argument_helper_tRunJob_16 = new JVMArgumentHelper_tRunJob_16();
	
	String audit_jar_path_tRunJob_16 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_16 begin ] stop
 */
	
	/**
	 * [tRunJob_16 main ] start
	 */

	

	
	
	currentComponent="tRunJob_16";

	
	java.util.List<String> paraList_tRunJob_16 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_16 = System.getProperty("os.name");
			if (osName_tRunJob_16 != null && osName_tRunJob_16.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_16.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_16.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_16 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_16 != null){
								paraList_tRunJob_16.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_16);
							}
							String log4j2_config_tRunJob_16 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_16 != null){
								paraList_tRunJob_16.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_16);
							}
							if (log4j1_config_tRunJob_16 != null || log4j2_config_tRunJob_16 != null) {
								paraList_tRunJob_16.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_16.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_16.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "-Xms2g");
		      				
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "-Xmx4g");
		      				
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "-cp");
		      				
              					String classpath_tRunJob_16_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/trove.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_dim_transaction_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_16!=null && !audit_jar_path_tRunJob_16.isEmpty()) {
		      						classpath_tRunJob_16_5 += audit_jar_path_tRunJob_16;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, dealChildJobLibrary_tRunJob_16.replaceJarPathsFromCrcMap(classpath_tRunJob_16_5), true);
		      				
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "dwh_attejaribank.j_load_dim_transaction_0_1.J_load_DIM_TRANSACTION");
		      				
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "--father_node=tRunJob_16");
		      				
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_16.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_16.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_16 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_16 != null){
								paraList_tRunJob_16.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_16);
							}
							String log4j2_config_tRunJob_16 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_16 != null){
								paraList_tRunJob_16.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_16);
							}
							if (log4j1_config_tRunJob_16 != null || log4j2_config_tRunJob_16 != null) {
								paraList_tRunJob_16.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_16.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_16.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "-Xms2g");
		      				
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "-Xmx4g");
		      				
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "-cp");
		      				
		      					String classpath_tRunJob_16_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/log4j-1.2-api-2.13.2.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/jboss-marshalling-river-2.0.12.Final.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/advancedPersistentLookupLib-1.3.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/trove.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_dim_transaction_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_16!=null && !audit_jar_path_tRunJob_16.isEmpty()) {
		      						classpath_tRunJob_16_5 += audit_jar_path_tRunJob_16;
		      					}
		      					
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, dealChildJobLibrary_tRunJob_16.replaceJarPathsFromCrcMap(classpath_tRunJob_16_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "dwh_attejaribank.j_load_dim_transaction_0_1.J_load_DIM_TRANSACTION");
		      				
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "--father_node=tRunJob_16");
		      				
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_16.addArgumentsTo(paraList_tRunJob_16, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_16.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_16.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_16.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_16 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_16 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_16".equals(tRunJobName_tRunJob_16) && childResumePath_tRunJob_16 != null){
		paraList_tRunJob_16.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_16.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_16");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_16 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_16 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_16.put("host", context.host);
                    paraList_tRunJob_16.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_16.put("port", context.port);
                    paraList_tRunJob_16.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_16.put("schema", context.schema);
                    paraList_tRunJob_16.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_16.put("database", context.database);
                    paraList_tRunJob_16.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_16.put("password", context.password);
                    paraList_tRunJob_16.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_16.put("params", context.params);
                    paraList_tRunJob_16.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_16.put("username", context.username);
                    paraList_tRunJob_16.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_16().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_16 = context.propertyNames();
		while (propertyNames_tRunJob_16.hasMoreElements()) {
			String key_tRunJob_16 = (String) propertyNames_tRunJob_16.nextElement();
			Object value_tRunJob_16 = (Object) context.get(key_tRunJob_16);
			if(value_tRunJob_16!=null) {  
				paraList_tRunJob_16.add("--context_param " + key_tRunJob_16 + "=" + value_tRunJob_16);
			} else {
				paraList_tRunJob_16.add("--context_param " + key_tRunJob_16 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_16 = null;

	
	
				class ConsoleHelper_tRunJob_16 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_16_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_16_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_16 consoleHelper_tRunJob_16 = new ConsoleHelper_tRunJob_16();

		Runtime runtime_tRunJob_16 = Runtime.getRuntime();
		Process ps_tRunJob_16 = null;

		//0 indicates normal termination
        int result_tRunJob_16;
        StringBuffer errorMsg_tRunJob_16 = new StringBuffer();
        try {
            ps_tRunJob_16 = runtime_tRunJob_16.exec((String[])paraList_tRunJob_16.toArray(new String[paraList_tRunJob_16.size()]));

            Thread normal_tRunJob_16 = consoleHelper_tRunJob_16.getNormalThread(ps_tRunJob_16);
            normal_tRunJob_16.start();

            Thread error_tRunJob_16 = consoleHelper_tRunJob_16.getErrorThread(ps_tRunJob_16, errorMsg_tRunJob_16);
            error_tRunJob_16.start();

            result_tRunJob_16 = ps_tRunJob_16.waitFor();
            normal_tRunJob_16.join();
            error_tRunJob_16.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_16_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_16.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_16_CHILD_RETURN_CODE",result_tRunJob_16);
		if(result_tRunJob_16 != 0){
   			globalMap.put("tRunJob_16_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_16.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_16 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_16.toString());
			
  		}

		

 


	tos_count_tRunJob_16++;

/**
 * [tRunJob_16 main ] stop
 */
	
	/**
	 * [tRunJob_16 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_16";

	

 



/**
 * [tRunJob_16 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_16 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_16";

	

 



/**
 * [tRunJob_16 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_16 end ] start
	 */

	

	
	
	currentComponent="tRunJob_16";

	

 

ok_Hash.put("tRunJob_16", true);
end_Hash.put("tRunJob_16", System.currentTimeMillis());




/**
 * [tRunJob_16 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_16:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk17", 0, "ok");
								} 
							
							tRunJob_17Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_16 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_16";

	

 



/**
 * [tRunJob_16 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_16_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_17Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_17_SUBPROCESS_STATE", 0);

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





	
	/**
	 * [tRunJob_17 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_17", false);
		start_Hash.put("tRunJob_17", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_17";

	
		int tos_count_tRunJob_17 = 0;
		
class DealChildJobLibrary_tRunJob_17 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_17 dealChildJobLibrary_tRunJob_17 = new DealChildJobLibrary_tRunJob_17();

	class JVMArgumentHelper_tRunJob_17 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_17 jvm_argument_helper_tRunJob_17 = new JVMArgumentHelper_tRunJob_17();
	
	String audit_jar_path_tRunJob_17 = System.getProperty("classpath.extended");
	

 



/**
 * [tRunJob_17 begin ] stop
 */
	
	/**
	 * [tRunJob_17 main ] start
	 */

	

	
	
	currentComponent="tRunJob_17";

	
	java.util.List<String> paraList_tRunJob_17 = new java.util.ArrayList<String>();
	
			
			String osName_tRunJob_17 = System.getProperty("os.name");
			if (osName_tRunJob_17 != null && osName_tRunJob_17.toLowerCase().startsWith("win")){
				
						paraList_tRunJob_17.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_17.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_17 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_17 != null){
								paraList_tRunJob_17.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_17);
							}
							String log4j2_config_tRunJob_17 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_17 != null){
								paraList_tRunJob_17.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_17);
							}
							if (log4j1_config_tRunJob_17 != null || log4j2_config_tRunJob_17 != null) {
								paraList_tRunJob_17.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_17.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_17.add("-D" + key + "=" + System.getProperty(key)));
					
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "-Dtalend.component.manager.m2.repository=../lib");
		      				
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "-Xmx4096M");
		      				
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "-Xmx8192M");
		      				
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "-cp");
		      				
              					String classpath_tRunJob_17_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/trove.jar;../lib/postgresql-42.2.14.jar;../lib/crypto-utils-0.31.12.jar;j_load_fait_churn_client_0_1.jar;";
              					
              					if(audit_jar_path_tRunJob_17!=null && !audit_jar_path_tRunJob_17.isEmpty()) {
		      						classpath_tRunJob_17_5 += audit_jar_path_tRunJob_17;
		      					}
		      					
	        					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, dealChildJobLibrary_tRunJob_17.replaceJarPathsFromCrcMap(classpath_tRunJob_17_5), true);
		      				
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "dwh_attejaribank.j_load_fait_churn_client_0_1.J_Load_FAIT_churn_client");
		      				
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "--father_pid="+pid);
		      				
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "--root_pid="+rootPid);
		      				
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "--father_node=tRunJob_17");
		      				
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "--context=Docker");
		      				
		      					jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "%*");
		      				
			} else {
	      		
						paraList_tRunJob_17.add("java");
						String m2 = System.getProperty("talend.component.manager.m2.repository");
						if (m2 != null){
							paraList_tRunJob_17.add("-Dtalend.component.manager.m2.repository=" + m2);
						}
						
						if (Boolean.getBoolean("propagateLoggingConfiguration")) {
							String log4j1_config_tRunJob_17 = System.getProperty("log4j.configuration");
							if (log4j1_config_tRunJob_17 != null){
								paraList_tRunJob_17.add("-Dlog4j.configuration=" + log4j1_config_tRunJob_17);
							}
							String log4j2_config_tRunJob_17 = System.getProperty("log4j.configurationFile");
							if (log4j2_config_tRunJob_17 != null){
								paraList_tRunJob_17.add("-Dlog4j.configurationFile=" + log4j2_config_tRunJob_17);
							}
							if (log4j1_config_tRunJob_17 != null || log4j2_config_tRunJob_17 != null) {
								paraList_tRunJob_17.add("-DpropagateLoggingConfiguration=true");
							}
						}
						
						if(enableLogStash){
							System.getProperties().stringPropertyNames().stream()
								.filter(it -> it.startsWith("audit."))
								.forEach(key -> paraList_tRunJob_17.add("-D" + key + "=" + System.getProperty(key)));
						}
							
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
							.forEach(key -> paraList_tRunJob_17.add("-D" + key + "=" + System.getProperty(key)));
					
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "-Dtalend.component.manager.m2.repository=../lib");
		      				
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "-Xmx4096M");
		      				
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "-Xmx8192M");
		      				
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "-cp");
		      				
		      					String classpath_tRunJob_17_5 = ".:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.13.2.jar:$ROOT_PATH/../lib/log4j-api-2.13.2.jar:$ROOT_PATH/../lib/log4j-core-2.13.2.jar:$ROOT_PATH/../lib/log4j-1.2-api-2.13.2.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/jboss-marshalling-river-2.0.12.Final.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/advancedPersistentLookupLib-1.3.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/slf4j-api-1.7.29.jar:$ROOT_PATH/../lib/trove.jar:$ROOT_PATH/../lib/postgresql-42.2.14.jar:$ROOT_PATH/../lib/crypto-utils-0.31.12.jar:$ROOT_PATH/j_load_fait_churn_client_0_1.jar:";
		      					
		      					if(audit_jar_path_tRunJob_17!=null && !audit_jar_path_tRunJob_17.isEmpty()) {
		      						classpath_tRunJob_17_5 += audit_jar_path_tRunJob_17;
		      					}
		      					
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, dealChildJobLibrary_tRunJob_17.replaceJarPathsFromCrcMap(classpath_tRunJob_17_5).replace("$ROOT_PATH",System.getProperty("user.dir")), true);
		      				
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "dwh_attejaribank.j_load_fait_churn_client_0_1.J_Load_FAIT_churn_client");
		      				
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "--father_pid="+pid);
		      				
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "--root_pid="+rootPid);
		      				
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "--father_node=tRunJob_17");
		      				
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "--context=Docker");
		      				
								jvm_argument_helper_tRunJob_17.addArgumentsTo(paraList_tRunJob_17, "$@");
		      				
			}

			
			
	  	
		if(enableLogStash){
			paraList_tRunJob_17.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_17.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_17.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_17 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_17 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_17".equals(tRunJobName_tRunJob_17) && childResumePath_tRunJob_17 != null){
		paraList_tRunJob_17.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_17.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_17");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_17 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_17 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_17.put("host", context.host);
                    paraList_tRunJob_17.add("--context_type " + "host" + "=" + "id_String");
                    parentContextMap_tRunJob_17.put("port", context.port);
                    paraList_tRunJob_17.add("--context_type " + "port" + "=" + "id_BigDecimal");
                    parentContextMap_tRunJob_17.put("schema", context.schema);
                    paraList_tRunJob_17.add("--context_type " + "schema" + "=" + "id_String");
                    parentContextMap_tRunJob_17.put("database", context.database);
                    paraList_tRunJob_17.add("--context_type " + "database" + "=" + "id_String");
                    parentContextMap_tRunJob_17.put("password", context.password);
                    paraList_tRunJob_17.add("--context_type " + "password" + "=" + "id_String");
                    parentContextMap_tRunJob_17.put("params", context.params);
                    paraList_tRunJob_17.add("--context_type " + "params" + "=" + "id_String");
                    parentContextMap_tRunJob_17.put("username", context.username);
                    paraList_tRunJob_17.add("--context_type " + "username" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_17().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_17 = context.propertyNames();
		while (propertyNames_tRunJob_17.hasMoreElements()) {
			String key_tRunJob_17 = (String) propertyNames_tRunJob_17.nextElement();
			Object value_tRunJob_17 = (Object) context.get(key_tRunJob_17);
			if(value_tRunJob_17!=null) {  
				paraList_tRunJob_17.add("--context_param " + key_tRunJob_17 + "=" + value_tRunJob_17);
			} else {
				paraList_tRunJob_17.add("--context_param " + key_tRunJob_17 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_17 = null;

	
	
				class ConsoleHelper_tRunJob_17 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_17_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_17_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_17 consoleHelper_tRunJob_17 = new ConsoleHelper_tRunJob_17();

		Runtime runtime_tRunJob_17 = Runtime.getRuntime();
		Process ps_tRunJob_17 = null;

		//0 indicates normal termination
        int result_tRunJob_17;
        StringBuffer errorMsg_tRunJob_17 = new StringBuffer();
        try {
            ps_tRunJob_17 = runtime_tRunJob_17.exec((String[])paraList_tRunJob_17.toArray(new String[paraList_tRunJob_17.size()]));

            Thread normal_tRunJob_17 = consoleHelper_tRunJob_17.getNormalThread(ps_tRunJob_17);
            normal_tRunJob_17.start();

            Thread error_tRunJob_17 = consoleHelper_tRunJob_17.getErrorThread(ps_tRunJob_17, errorMsg_tRunJob_17);
            error_tRunJob_17.start();

            result_tRunJob_17 = ps_tRunJob_17.waitFor();
            normal_tRunJob_17.join();
            error_tRunJob_17.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_17_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_17.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_17_CHILD_RETURN_CODE",result_tRunJob_17);
		if(result_tRunJob_17 != 0){
   			globalMap.put("tRunJob_17_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_17.toString());
			  
	    		throw new RuntimeException("Child job returns " + result_tRunJob_17 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_17.toString());
			
  		}

		

 


	tos_count_tRunJob_17++;

/**
 * [tRunJob_17 main ] stop
 */
	
	/**
	 * [tRunJob_17 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_17";

	

 



/**
 * [tRunJob_17 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_17 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_17";

	

 



/**
 * [tRunJob_17 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_17 end ] start
	 */

	

	
	
	currentComponent="tRunJob_17";

	

 

ok_Hash.put("tRunJob_17", true);
end_Hash.put("tRunJob_17", System.currentTimeMillis());




/**
 * [tRunJob_17 end ] stop
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
	 * [tRunJob_17 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_17";

	

 



/**
 * [tRunJob_17 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_17_SUBPROCESS_STATE", 1);
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
        final J_Master_ETL J_Master_ETLClass = new J_Master_ETL();

        int exitCode = J_Master_ETLClass.runJobInTOS(args);

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
            java.io.InputStream inContext = J_Master_ETL.class.getClassLoader().getResourceAsStream("dwh_attejaribank/j_master_etl_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = J_Master_ETL.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
errorCode = null;tRunJob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tRunJob_1) {
globalMap.put("tRunJob_1_SUBPROCESS_STATE", -1);

e_tRunJob_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : J_Master_ETL");
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
 *     400360 characters generated by Talend Open Studio for Data Integration 
 *     on the 1 avril 2026 à 16:41:19 WAT
 ************************************************************************************************/