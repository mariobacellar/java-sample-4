package com.accenture.xmlmanager.gen;

import java.io.File;
import java.util.List;


import com.accenture.xmlmanager.parser.xsd.XsdGen;
//import org.wiztools.xsdgen.XsdGen;

import com.accenture.xmlmanager.commons.Common;
import com.accenture.xmlmanager.model.Element;

public class GenerateXSDFromXPath {

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
	

	
	
	
	public void generateOSB_RequestXSD() {
		log("-> generateOSB_RequestXSD()");
		GenerateXMLFromXPath	smp		= new GenerateXMLFromXPath();
		List<String>			lines	= smp.loadDataSetFromDataMapping(Common.xpath_file_request_osb);
		Element					rootXML	= smp.parserByFullTagName( lines );
		
		if (rootXML==null) {
			log("<- Nenhum XSD gerado");
			log("<- generateOSB_RequestXSD()");
			return;
		}
		log("-  Element=["+rootXML.toString()+"]");

		Common.writeFile(Common.xml_request_osb , Common.C_XML_HEADER+"\n"+ rootXML.writeXml() );
		
		String xmlFile = System.getProperty("user.dir") + Common.xml_request_osb ;
		String xsd = formatXSD( xmlFile );
		
		Common.writeFile(Common.xsd_request_osb ,  xsd );
		log("<- generateOSB_RequestXSD()");
	}
	
	public void generateOSB_ResponseXSD() {
		log("-> generateOSB_ResponseXSD()");
		GenerateXMLFromXPath	smp		= new GenerateXMLFromXPath();
		List<String>		lines	= smp.loadDataSetFromDataMapping(Common.xpath_file_response_osb);
		Element				rootXML	= smp.parserByFullTagName( lines );
		if (rootXML==null) {
			log("<- Nenhum XSD gerado");
			log("<- generateOSB_RequestXSD()");
			return;
		}
		log("-  Element=["+rootXML.toString()+"]");
		
		Common.writeFile(Common.xml_response_osb , Common.C_XML_HEADER+"\n"+ rootXML.writeXml() );
		
		String xmlFile = System.getProperty("user.dir") + Common.xml_response_osb ;
		String xsd = formatXSD( xmlFile );
		
		Common.writeFile(Common.xsd_response_osb ,  xsd );
		log("<- generateOSB_ResponseXSD()");
	}
	
	public void generateProvider_ResquestXSD() {
		log("-> generateProvider_ResquestXSD()");
		GenerateXMLFromXPath	smp		= new GenerateXMLFromXPath();
		List<String>		lines	= smp.loadDataSetFromDataMapping(Common.xpath_file_request_provider);
		Element				rootXML	= smp.parserByFullTagName( lines );
		if (rootXML==null) {
			log("<- Nenhum XSD gerado");
			log("<- generateOSB_RequestXSD()");
			return;
		}
		log("-  Element=["+rootXML.toString()+"]");
		
		Common.writeFile(Common.xml_request_provider , Common.C_XML_HEADER+"\n"+ rootXML.writeXml() );
		
		String xmlFile = System.getProperty("user.dir") + Common.xml_request_provider;
		String xsd = formatXSD( xmlFile );
		
		Common.writeFile(Common.xsd_request_provider,  xsd );
		log("<- generateProvider_ResquestXSD()");
		}

	public void generateProvider_ResponseXSD() {
		log("-> generateProvider_ResponseXSD()");
		GenerateXMLFromXPath	smp		= new GenerateXMLFromXPath();
		List<String>		lines	= smp.loadDataSetFromDataMapping(Common.xpath_file_response_provider);
		Element				rootXML	= smp.parserByFullTagName( lines );
		if (rootXML==null) {
			log("<- Nenhum XSD gerado");
			log("<- generateOSB_RequestXSD()");
			return;
		}
		log("-  Element=["+rootXML.toString()+"]");
		
		Common.writeFile(Common.xml_response_provider , Common.C_XML_HEADER+"\n"+ rootXML.writeXml() );
		
		String xmlFile = System.getProperty("user.dir") + Common.xml_response_provider;
		String xsd = formatXSD( xmlFile );
		
		Common.writeFile(Common.xsd_response_provider,  xsd );
		log("<- generateProvider_ResponseXSD()");
	}
	
	
	private static String formatXSD(String xmlFile) {
	    try {
	    	
	    	File file = new File(xmlFile);
	    	
	    	XsdGen 
	    	gen = new XsdGen();
	    	gen.mixed = false;
	    	gen.parse(file);
	    	//gen.write(System.out);
	 
	    	String ret = gen.toString(); 
	    	return ret;

	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static void log(String str) { System.out.println(str); 	}
}
