package com.accenture.xmlmanager.commons;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.accenture.xmlmanager.XmlManagerApplication;

public class Common {

	public static Properties config;
	
	public static String servico_operacao_versao_item;
	public static String servico_operacao_versao;
	public static String servico_operacao_pasta_item;
	public static String servico_operacao_pasta;
	public static String servico_operacao_pasta_resource;
	public static String servico_operacao_pasta_xsd;
	public static String servico_operacao_pasta_wsdl;
	public static String servico_operacao_pasta_transformations;
	public static String servico_operacao_pasta_inbound;
	public static String[] dirProjetoOSB12c;
	
	public static String xpath_file_request_osb;
	public static String xpath_file_response_osb;
	public static String xpath_file_request_provider;
	public static String xpath_file_response_provider;

	public static String xsd_request_osb;
	public static String xsd_response_osb;
	public static String xsd_request_provider;
	public static String xsd_response_provider;
	
	public static String xml_request_osb;
	public static String xml_response_osb;
	public static String xml_request_provider;
	public static String xml_response_provider;

	public static String C_XML_HEADER="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
	
static {
	
	InputStream input = null;
	try {
		input = XmlManagerApplication.class.getClassLoader().getResourceAsStream("config.properties"); //new FileInputStream("config.properties");
		if(input==null){
			System.out.println("Sorry, unable to find 'config.properties'");
		}
		config=new Properties();
		config.load(input);
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	servico_operacao_versao_item = config.getProperty("servico.operacao.versao");
	servico_operacao_versao		 = config.getProperty("servico.operacao.versao."	+ servico_operacao_versao_item);

	servico_operacao_pasta_item				= config.getProperty("servico.operacao.pasta");
	servico_operacao_pasta					= config.getProperty("servico.operacao.pasta."	+ servico_operacao_pasta_item);
	servico_operacao_pasta_resource			= config.getProperty("servico.operacao.pasta."	+ servico_operacao_pasta_item+".resource");
	servico_operacao_pasta_xsd				= config.getProperty("servico.operacao.pasta."	+ servico_operacao_pasta_item+".xsd");
	servico_operacao_pasta_wsdl				= config.getProperty("servico.operacao.pasta."	+ servico_operacao_pasta_item+".wsdl");
	servico_operacao_pasta_transformations	= config.getProperty("servico.operacao.pasta."	+ servico_operacao_pasta_item+".transformations");
	servico_operacao_pasta_inbound			= config.getProperty("servico.operacao.pasta."	+ servico_operacao_pasta_item+".inbound");


	xpath_file_request_osb			= config.getProperty("xpath.file.request.osb");
	xpath_file_response_osb			= config.getProperty("xpath.file.response.osb");
	xpath_file_request_provider		= config.getProperty("xpath.file.request.provider");
	xpath_file_response_provider	= config.getProperty("xpath.file.response.provider");

	xsd_request_osb			= config.getProperty("xsd.request.osb");
	xsd_response_osb		= config.getProperty("xsd.response.osb");
	xsd_request_provider	= config.getProperty("xsd.request.provider");
	xsd_response_provider	= config.getProperty("xsd.response.provider");

	xml_request_osb			= config.getProperty("xml.request.osb");
	xml_response_osb		= config.getProperty("xml.response.osb");
	xml_request_provider	= config.getProperty("xml.request.provider");
	xml_response_provider	= config.getProperty("xml.response.provider");

}
			
			
	public static void writeFile(String fileName, String content) {
		Path file = Paths.get(System.getProperty("user.dir")+fileName);
		try {
			Files.write(file, content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void generateProjectFolder() {
		try {
			dirProjetoOSB12c = new String[5];
			dirProjetoOSB12c[0]= Common.servico_operacao_pasta + "\\" + Common.servico_operacao_versao + Common.servico_operacao_pasta_resource;
			dirProjetoOSB12c[1]= Common.servico_operacao_pasta + "\\" + Common.servico_operacao_versao + Common.servico_operacao_pasta_xsd;
			dirProjetoOSB12c[2]= Common.servico_operacao_pasta + "\\" + Common.servico_operacao_versao + Common.servico_operacao_pasta_wsdl;
			dirProjetoOSB12c[3]= Common.servico_operacao_pasta + "\\" + Common.servico_operacao_versao + Common.servico_operacao_pasta_transformations;
			dirProjetoOSB12c[4]= Common.servico_operacao_pasta + "\\" + Common.servico_operacao_versao + Common.servico_operacao_pasta_inbound;
			for (String str : dirProjetoOSB12c) new File(str).mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
