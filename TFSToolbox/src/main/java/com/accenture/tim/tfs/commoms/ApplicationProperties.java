package com.accenture.tim.tfs.commoms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.accenture.tim.tfs.EpicosDesevolvimentoTransformer;

public abstract class ApplicationProperties {

	//private static final Logger LOG = LoggerFactory.getLogger(ApplicationProperties.class.getName());
	private static final Logger LOG = Logger.getLogger(ApplicationProperties.class.getName());

	public static Properties properties = new Properties();
	
	
	public static Properties appProperties(){
		LOG.info("-> appProperties()");
        try {
    		LOG.info("- Reading application.properties");
            
    		File file= ResourceUtils.getFile("classpath:application.properties");
            
            InputStream in	= new FileInputStream(file);
            
            properties.load(in);

    		LOG.info("- Reading application.properties");
    		Enumeration<Object> keys = properties.keys();
    		while(keys.hasMoreElements()){
    			String param = (String) keys.nextElement();
    			System.out.println("- param=["+param+"] - \t\tvalue=["+properties.getProperty(param)+"]");
    		}    		
            LOG.info("-> appProperties(): NORMAL");
        } catch (IOException e) {
    		LOG.info("<- appProperties(): ERROR");
            LOG.error(e.getMessage());
        }
        return properties;
    }
	
	
	
	
	/**
	 * The URL to your Team Foundation Server, 
	 * including virtual directory but no collection name (like "http://server:8080/tfs").
	 */
	public static String SERVER_URL = "https://accenturetim.visualstudio.com/";

	/**
	 * The URL to a TFS project collection, including virtual directory and
	 * collection name (like "http://server:8080/tfs/DefaultCollection").
	 */
	public static String COLLECTION_URL = "https://accenturetim.visualstudio.com/DefaultCollection";

    /*
     * Authentication information. 
     * HTTP_PROXY_URL should be set to null if none is desired.
     */
    public static String USERNAME = "mario.bacellar@accenture.com";
    public static String PASSWORD = "Senha123";
    public static String HTTP_PROXY_URL      = null;
    public static String HTTP_PROXY_USERNAME = "";
    public static String HTTP_PROXY_PASSWORD = "";

    /**
     * A team project name (without the leading "$/") where files, work items, and builds can be created and modified.
     */
    public static String PROJECT_NAME = "WEB_VAS";

	    
    /**
     * The name of an existing build definition.
     */
    public static String BUILD_DEFINITION_NAME = "";

    /**
     * Set this to a writable UNC share (like "\\server\share\drops") where build results can be copied.
     */
    public static String BUILD_DROP_LOCATION = "";
 
}

	
