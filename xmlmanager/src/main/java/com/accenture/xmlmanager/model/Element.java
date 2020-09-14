package com.accenture.xmlmanager.model;

import java.util.ArrayList;
import java.util.List;

public class Element {

	public String tagName;
	public String tagPath;
	public String fullTagName;
	public List<Element> listOf;
	public String[] attributes;
	
	public Element(String n) {
		this.tagName  = n;
		this.tagPath ="/";
		this.fullTagName = this.tagPath + "/" + this.tagName;  
		this.listOf   = new ArrayList<Element>();
	}
	
	public Element() { 
		this.tagName ="<none>";
		this.tagPath="/";
		this.fullTagName = this.tagPath + "/" + this.tagName;  
		this.listOf  = new ArrayList<Element>();
	}

	public Element(String nodeChild, String fullpath) {
		this.tagName  = nodeChild;
		this.tagPath = fullpath;
		this.fullTagName = this.tagPath + "/" + this.tagName;  
		this.listOf   = new ArrayList<Element>();
		log("########################################################################################");
		log("-  New Element=[ nameTag=["+this.tagName+"] parentTag=["+this.tagPath+"] fullTagName=["+this.fullTagName+"]");
		log("########################################################################################");
	}

	public String getIniTag()   {
		
		if (attributes!=null && attributes.length>1) {
			String attr = "";
			for (String tmp : attributes)
				attr = attr+ " "+ tmp; 
			return "<" +tagName +" " + attr+">\n";
			
		}else
			return "<" +tagName+">\n"; 
	}
	public String getEndTag()   { return "</"+tagName+">\n"; }
	public String getEmptyTag() { return "<"+tagName+"/>\n"; }
	
	public String writeXml() {
		StringBuffer  ret = new StringBuffer();
		if (listOf.size()>=1) {
			ret.append( getIniTag() );
			for (Element e : listOf)
			ret.append( e.writeXml() );
			ret.append( getEndTag());
		}else{
			ret.append( getEmptyTag() );
		}
		return ret.toString();
	}

	@Deprecated
	public Element getElement(String name){
		
		log("-> getElement("+name+")");
		log("-  ["+tagName+"] ("+listOf.size()+") has element(s)");
		
		for (Element e : listOf) {
			
			log("\t-  Elemento da lista ["+e.tagName+"]]");

			if (e.tagName.equals(name)) {
			
				log("<- getElement(1)("+name+") *** Retornando elemento(1) ["+e.tagName+"]");
				return e;
			
			}else {
				
				// Se o elemento não tiver mais elementos na sua lista, verifica se o elemento da sua lista tem mais de um elmento
				if (listOf.size()==1) {
					
					Element out2 = e.getElement(name); 
					log("<- getElement(2)("+name+") *** Retornando elemento(2) [" +(out2!=null?out2.tagName:"Elemento ["+name+"] nao estah no elemento ["+tagName+"]") + "]");
					if (out2!=null) return out2 ;
				
				}else {
					log("-  *** Elemento ["+e.tagName+"] incompativel ***");
					log("-  @@@ Verificando se o elemento ["+name+"] estah neste elemento ["+e.tagName+"]@@@");
					Element out3 = e.getElement(name); 
					log("<- getElement(3)("+name+") *** Retornando elemento(3) [" +(out3!=null?out3.tagName:"Elemento ["+name+"] nao estah no elemento ["+tagName+"]")+"]");
					if (out3!=null) return out3;
				}
			}
		}
		log("<- getElement(null)("+name+")");
		return null;
	}
	
	
	public  Element getElementByFullTagName(String fullTagName) {
		log("-> getElementByFullTagName("+fullTagName+")");
		log("-  ["+tagName+"] tem ("+listOf.size()+") element(s)");

		for (Element e : listOf) {
			
			log("\t-  Elemento ["+e.fullTagName+"] de ["+fullTagName+"]");

			if (e.fullTagName.equals(fullTagName)) {

				log("<- getElementByFullTagName(1) *** Retornando elemento ["+e.fullTagName+"]");
				return e;
	
			}else {

				Element out2 = e.getElementByFullTagName(fullTagName);
				if (out2!=null) {
					log("- *** Retornando elemento [" +out2.fullTagName+ "]");
					return out2;
				}
			}
		}
		log("<- getElementByFullTagName(null)("+fullTagName+")");
		return null;
	}

	
	public static void log(String str) { System.out.println(str); 	}

	
	public String toString() {
		return "nameTag=["+this.tagName+"] parentTag=["+this.tagPath+"] fullTagName=["+this.fullTagName+"] \n XML = [" +writeXml()+"]";
	}
	
	
	/**
	 * TESTE
	 * @param args
	 */

	public static void main(String[] args) {
		try {

            log("-> Main() - TESTE - "); 

			Element eSiebelMessage			= new Element("SiebelMessage"			, "");
			Element eListaCriarOrdemServico	= new Element("ListaCriarOrdemServico"	, "SiebelMessage");
			Element eDados 					= new Element("Dados"					, "SiebelMessage/ListaCriarOrdemServico");
			Element eListaOrdens 			= new Element("ListaOrdens"				, "SiebelMessage/ListaCriarOrdemServico/Dados");
			Element eOrdem					= new Element("Ordem"					, "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens");
			Element eNumeroContaFatura		= new Element("NumeroContaFatura"		, "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem");
			Element ePDV					= new Element("PDV"						, "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem");
			Element eListaItensOrdem		= new Element("ListaItensOrdem"			, "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem");
			Element eDDD2					= new Element("DDD"						, "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem");
			Element eOpcaoOiDados2			= new Element("OpcaoOiDados"			, "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/");
			Element eItemOrdem				= new Element("ItemOrdem"				, "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem");
			Element eDDD					= new Element("DDD"						, "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem/ItemOrdem");
			Element eOpcaoOiDados			= new Element("OpcaoOiDados"			, "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem/ItemOrdem");

			eSiebelMessage			.listOf.add(eListaCriarOrdemServico);
			eListaCriarOrdemServico	.listOf.add(eDados);
			eDados					.listOf.add(eListaOrdens);
			eListaOrdens			.listOf.add(eOrdem);
			 eOrdem.listOf			.add(eNumeroContaFatura);
			 eOrdem.listOf			.add(ePDV);
			 eOrdem.listOf			.add(eListaItensOrdem);
			 
			eListaItensOrdem		.listOf.add(eItemOrdem);
			 eItemOrdem.listOf		.add(eDDD);
			 eItemOrdem.listOf		.add(eOpcaoOiDados);

			eOrdem.listOf			.add(eDDD2);
			eOrdem.listOf			.add(eOpcaoOiDados2);

            log("======================================================================");
            log("eSiebelMessage --> \n" +eSiebelMessage.writeXml()); 
            log("======================================================================");
            

            String	fullTagName	=
            //"SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/DDD"
             "SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem/ItemOrdem/DDD" 
            //"SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/DDD"		
            ;

            Element elmt	=  eSiebelMessage.getElementByFullTagName(fullTagName);
            log("- elmt	= ["+elmt.fullTagName+"]");
            
            log("<- Main() - TESTE - "); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
