package com.accenture.siebel.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.siebel.model.SiebelMessage;

@RestController
public class MosckSiebelServerRESTController {

	private static final Logger log = LogManager.getLogger(MosckSiebelServerRESTController.class);
	
	
	@RequestMapping(value = "/eai/start.swe", method = RequestMethod.GET)
    public String greetingsSWE() {
		log.trace("-> greetingsSWE()");
		String ret = "*** Não use o BROWSER *** \n\n" + msgSendSiebelMessage();
		log.trace("-  ret = ["+ret+"]");
		log.trace("<- greetingsSWE()");
		return ret;
    }

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingsHomeGET() {
		log.trace("-> greetingsHomeGET()");
		String ret = "*** Não use o BROWSER *** \n\n"+msgSendSiebelMessage();
		log.trace("-  ret = ["+ret+"]");
		log.trace("<- greetingsHomeGET()");
		return ret;
    }	
	
//	@RequestMapping(value = "/eai/start.swe", method = RequestMethod.POST)
//    public String performSiebelMessage() {
//		String ret="xxxxxxxxxxxxx";
//		
//		return ret;
//	}
	
//	@RequestMapping(value = "/eai/start.swe", method = RequestMethod.POST, consumes = "text/xml")
	@RequestMapping(value = "/framework/start.swe", method = RequestMethod.POST, consumes = "text/xml")
    public String performSiebelMessage(@RequestBody String xml) {
		log.trace("-> performSiebelMessage("+xml+")");
		String ret=xml;
		
		
		try {
			log.debug("- Sleeping for 30s ....");
			Thread.sleep(20000);
			log.debug("- Wake after sleep.");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		String intObjectName = SiebelMessage.parserIntObjectName(xml);
		log.info("-  Performing IntObjectName = ["+intObjectName+"]" );

		if (!SiebelMessage.validaIntObjectName(intObjectName))
			return msgUnknownSiebelMessage(intObjectName);
		
		log.info(xml);
		try {
			SiebelMessage sm = SiebelMessage.loadSiebelMessage(intObjectName);
			log.info(sm);
			ret=sm.getXml();
		} catch (Exception e) {
			ret = e.getMessage();
		}

		log.trace("<- performSiebelMessage()");
		return ret;
    }

	

	private String msgUnknownSiebelMessage(String intobj) {
		return    "A SiebelMessage do IntegrationObject ["+intobj+"] não consta no cadastro.\n"
				+ "Envie as SiebelMessages de REQUEST e RESPONSE (com devido IntegrationObject) para mario.bacellar@accenture.com atualizar nosso cadastro."; 
			
	}
	private String msgSendSiebelMessage() {
		return  "Bem vindo ao SIMULADOR de retornos de SiebelMessage!\n\n"+  
				"Envie sua SiebelMessage (REQUEST) via SoapUi (Rest Project) para o endpoint 'http://localhost:8089/eai/start.swe'.\n\n"+
				"O SIMULADOR irá retornar a SiebelMessage de RESPONSE do respectivo 'IntegrationObject' enviado no atributo do campo SiebelMesage.";
	}
	
}
