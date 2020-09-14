package com.accenture.siebel.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SiebelMessage {

	private static final Logger log = LogManager.getLogger(SiebelMessage.class);

	
	String messageId;
	String messageType;   // "Integration Object"
	String intObjectName; // "FRMIDACCI"
	String xml;
	
	
	public static boolean validaIntObjectName(String intObjectName2) {
		log.trace("-> validaIntObjectName("+intObjectName2+")");
		boolean ret = false;
		try {
			String	userDir		= System.getProperty("user.dir");
			log.info("-  userDir ("+userDir+")");

			String	resourceDir	= userDir + "/src/main/resources/xml/";
			log.info("-  resourceDir ("+resourceDir+")");

			String	fileName	= resourceDir + intObjectName2 + ".xml";
			File 	file		= new File( fileName );

			log.info("-  fileName ("+file.getName()+")");
			ret = file.isFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.debug("-  ret = ["+ret+"]");
		log.trace("<- validaIntObjectName("+intObjectName2+")");
		return ret;
	}
	
	public static SiebelMessage loadSiebelMessage(String intObjectName) throws Exception{
		String userDir		= System.getProperty("user.dir");
		String resourceDir	= userDir + "/src/main/resources/xml/";
		String fileName		= resourceDir + intObjectName + "_Response.xml";
		String siebelmessage="";		
		
		log.info("-  Loading fileName = ["+fileName+"]");
		
		BufferedReader br = new BufferedReader( new FileReader(new File( fileName )));
		String xml			= "";
		int	ln = 0;
		StringBuffer sb = new StringBuffer();
		while ( xml != null) {
			ln++;
			xml = br.readLine();
			if (ln==1) 		siebelmessage=xml;
			if (xml!=null)	sb.append(xml);
		}
		br.close();
		
		SiebelMessage sm = new SiebelMessage(siebelmessage, sb.toString());
		
		return sm;
	}
	
	public SiebelMessage(String sm, String xml) {
		this.messageId		= parserMessageId(sm);
		this.messageType	= parserMessageType(sm);
		this.intObjectName	= parserIntObjectName(sm);
		this.xml			= xml;
	}

	public static String parserIntObjectName(String sm) {
		String	word    ="IntObjectName=";
		int	posInit = sm.indexOf(word) + word.length() + 1;
		int	posFin	= sm.indexOf('\"', posInit);
		String ret= sm.substring(posInit,posFin);
		return ret;
	}

	private String parserMessageType(String sm) {
		String	word    ="MessageType=";
		int	posInit = sm.indexOf(word) + word.length() + 1;
		int	posFin	= sm.indexOf('\"', posInit);
		String ret= sm.substring(posInit,posFin);
		return ret;
	}

	private String parserMessageId(String sm) {
		String	word    ="MessageId=";
		int	posInit = sm.indexOf(word) + word.length() + 1;
		int	posFin	= sm.indexOf('\"', posInit);
		String ret= sm.substring(posInit,posFin);
		return ret;
	}

	public SiebelMessage(String MessageId, String MessageType, String IntObjectName, String xml) {
		this.messageId		= MessageId;
		this.messageType	= MessageType;   // "Integration Object"
		this.intObjectName	= IntObjectName; // "FRMIDACCI"
		this.xml			= xml;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getIntObjectName() {
		return intObjectName;
	}

	public void setIntObjectName(String intObjectName) {
		this.intObjectName = intObjectName;
	}
	
	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	@Override
	public String toString() {
		return 
		"<SiebelMessage MessageId=["+this.messageId+"] MessageType=["+this.messageType+"] IntObjectName=["+this.intObjectName+"] >"
		+"\n"+ this.xml
		;
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			
			System.out.println("-->");
			SiebelMessage smReq = loadSiebelMessage("FRMIDACCI");
			SiebelMessage smRes = loadSiebelMessage("FRMIDACCI_Response");
			System.out.println(smReq);
			System.out.println(smRes.getXml());
			
			System.out.println("<--");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
}
