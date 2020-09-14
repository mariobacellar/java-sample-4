package com.accenture.xmlmanager;

import com.accenture.xmlmanager.commons.Common;
import com.accenture.xmlmanager.gen.GenerateXSDFromXPath;

public class XmlManagerApplication {
	
	public static void log(String str) { System.out.println(str); 	}

	public static void main(String[] args) {
		log("-> main"  );
		try {
			
			log("- java.version.......=["+System.getProperty("java.version"));
			log("- java.class.path....=["+System.getProperty("java.class.path"));
			log("- user.home..........=["+System.getProperty("java.home"));
			log("- user.dir...........=["+System.getProperty("user.dir"));
				
			// Cria estrutura de projeto SOA12c
			Common.generateProjectFolder();


			GenerateXSDFromXPath genXSD = new GenerateXSDFromXPath();
			
			// Cria XSDs do Barramento
			genXSD.generateOSB_RequestXSD();
			genXSD.generateOSB_ResponseXSD();

			// Cria XSDs do sistema provedor do serviço
			genXSD.generateProvider_ResquestXSD();
			genXSD.generateProvider_ResponseXSD();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		log("<- main"  );
	}
	


}
