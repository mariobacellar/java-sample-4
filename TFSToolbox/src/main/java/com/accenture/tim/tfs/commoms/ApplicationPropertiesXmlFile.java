package com.accenture.tim.tfs.commoms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

public class ApplicationPropertiesXmlFile {

	//private static final Logger LOG = LoggerFactory.getLogger(ApplicationProperties.class.getName());
	private static final Logger LOG = Logger.getLogger(ApplicationProperties.class.getName());
	
	public static Properties properties = new Properties();
	
	public static void main(String[] args) {
	
		try {
			File file = ResourceUtils.getFile("classpath:queries.properties.xml");
			
			FileInputStream fileInput	= new FileInputStream(file);
			
			Properties
			properties	= new Properties();
			properties.loadFromXML(fileInput);

			fileInput.close();

			@SuppressWarnings("rawtypes")
			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				System.out.println("- key=["+key+ "] - val=["+value+"]");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}