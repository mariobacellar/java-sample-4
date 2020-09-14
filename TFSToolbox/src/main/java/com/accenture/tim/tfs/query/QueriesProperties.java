package com.accenture.tim.tfs.query;

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

import com.accenture.tim.tfs.commoms.ApplicationProperties;

public class QueriesProperties {
	
	public static Properties properties = new Properties();

	//private static final Logger LOG = LoggerFactory.getLogger(QueriesProperties.class.getName());
	private static final Logger LOG = Logger.getLogger(QueriesProperties.class.getName());
	
	public static Properties queriesProperties(){
		LOG.info("-> queriesProperties()");
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
            LOG.info("-> queriesProperties(): NORMAL");
        } catch (IOException e) {
    		LOG.info("<- queriesProperties(): ERROR");
            LOG.error(e.getMessage());
        }
        return properties;
    }
	
	
	
	
}
