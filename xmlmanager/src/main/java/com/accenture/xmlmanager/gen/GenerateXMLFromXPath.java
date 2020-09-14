package com.accenture.xmlmanager.gen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.accenture.xmlmanager.model.Element;

/**
 * SiebelMesageParser	smp		= new SiebelMesageParser();
 * List<String>			lines	= smp.loadDataSetFromDataMapping(xmlFileNAme);
 * Element				rootXML	= smp.parserByFullTagName( lines );
 * log(rootXML.writeXml());

 * @author mario.bacellar
 *
 */
public class GenerateXMLFromXPath {
	
	public static void log(String str) { System.out.println(str); 	}

	/**
	*  Exemplo de dataset:
	*  
	*  1) Crie um arquivo no padrão abaixo, exportando como CSV as colunsa 'Grupo' e 'Nome do Campo' do 'Diagrama de Interface'.
	*     Para exportar um arquivo CSV, primeiro abra uma nova planilha vazia e cole as colunas 'Grupo' e 'Nome do Campo'.
	*     Dentro desta nova planilha execute 'Save As' como CSV.
	*     Após a exportação, se for preciso, realize as alerações necessárias para que as linhas fiquem no padrão abaixo:
	*     ATENÇÃO: As tuplas serão geradas conforme informado nas linhas CSV, verifique se existe algume erro de digitação nos nomes dos campos.
	*        
	*   --<inicio do arquivo> ### não incluir esta linha no arquivo 
	*	9MessageId=""#MessageType="Integration Object"#IntObjectName="FRMPRetO"  
	*	SiebelMessage;IntObjectName
	*	SiebelMessage/;ListaCriarOrdemServico
	*	SiebelMessage/ListaCriarOrdemServico;Dados
	*	SiebelMessage/ListaCriarOrdemServico/Dados;ListaOrdens
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens;Ordem
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem;NumeroContaFatura
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem;NomePlano
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem;NomeCampanha
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem;NomeOferta
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem;VelocidadeVelox
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem;PDV
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem;ListaItensOrdem
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem;ItemOrdem
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem/ItemOrdem;DDD
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem/ItemOrdem;OpcaoOiDados
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem/ItemOrdem;MSISDN
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem/ItemOrdem;IMEI
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem/ItemOrdem;OiChip
	*	SiebelMessage/ListaCriarOrdemServico/Dados/ListaOrdens/Ordem/ListaItensOrdem/ItemOrdem;ModeloAparelho
	*   --<fim do arquivo> ### não incluir esta linha no arquivo 
	*
	*
	*	2) Para gerar o XSD, pegue copie o XML gerado no console para o site https://www.freeformatter.com/xsd-generator.html
	*	OBS: Se quiser gerar um XML a partir de um XSD cole o XSD no site http://xsd2xml.com/
	* 
	* @param root
	* @return
	*/
	public	List<String> loadDataSetFromDataMapping(String root) {
		log("-> loadDataSetFromDataMapping("+root+")");
		String userDir		= System.getProperty("user.dir");
		//String resourceDir	= userDir + "/src/main/resources/txt/";
		String resourceDir	= userDir;
		String fileName		= resourceDir + root;
		log("-  fileName=["+fileName+"]");
		List<String> ltRet = new ArrayList<String>(); 
		try {
			BufferedReader	fileReader	= new BufferedReader( new FileReader ( new File( fileName )));
			String			lineFromFile= "";
			while ( lineFromFile != null) {
				lineFromFile = fileReader.readLine();
				if (lineFromFile!=null)	{
					log("-  lineFromFile = ["+lineFromFile+"]");
					ltRet.add(lineFromFile);
				}
			}
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("<-  loadDataSetFromDataMapping("+root+")");
		return ltRet;
	}
	
	@Deprecated
	public Element parser( List<String> lines ) {

		Element	 root  = new Element();
		String[] parts = null; 

		for (String line : lines) {
			log("\n- line         =["+line+"]");
			
			if (line.indexOf("/")==-1) {
			// Ex: SiebelMessage;ListaCriarOrdemServico
			
				parts=line.split(";"); 

				String nodeRoot  = parts[0];
				log("- nodeRoot =["+nodeRoot+"]");

				String nodeChild = parts[1];
				log("- nodeChild=["+nodeChild+"]");

				root.tagName = nodeRoot;
				root.listOf.add(new Element(nodeChild));
				
				log("- XML =[" + root.writeXml()+"]");
				
				
			}else {
			//Ex: SiebelMessage/ListaCriarOrdemServico;Dados

				parts=line.split(";"); 

				// Ex: 'SiebelMessage' e 'ListaCriarOrdemServico' | (SiebelMessage/ListaCriarOrdemServico;Dados)
				String[] nodesRoot  = parts[0].split("/"); 
				log("- nodesRoot    =["+nodesRoot.length+"]");
				for (int i=0; i<=nodesRoot.length-1; i++) {
					log("- nodesRoot["+i+"] =["+nodesRoot[i]+"]");
				}

				String nodeRootFull = parts[0]; 
				log("- nodeRootFull =["+nodeRootFull+"]");

				String nodeChild = parts[1];
				log("- nodeChild    =["+nodeChild+"]");

				int	qtdNodes = nodesRoot.length;
				log("- qtdNodes     =["+qtdNodes+"]");
				
				String nodeParent=nodesRoot[qtdNodes-1];
				log("- nodeParent   =["+nodeParent+"]");

				Element nodeLast = root.getElement( nodeParent);

				if (nodeLast!=null) {
					log("- nodeLast(1)  =["+nodeLast.tagName+"]");
					nodeLast.listOf.add(new Element(nodeChild,nodeRootFull));
				}
				log("- XML =[" + root.writeXml()+"]");
			}
		}
		return root;
	}

	public Element parserByFullTagName(List<String> lines) {
		log("-> parserByFullTagName()");
		Element		root  		= null;
		String[]	parts		= null; 
		String		nodeRoot	= null;
		String		nodeRootFull= null; 
		String[] 	nodesRoot  	= null;
		String		nodeChild	= null;
		String 		nodeParent	= null;
		String[] 	nodeAttributes = null;
				
		for (String line : lines) {

			if (line.indexOf("/")==-1) {
				
				if (line.indexOf("9")>-1) {
					line = line.substring(line.indexOf("9")+1);
					nodeAttributes = line.split("#");
					continue;
				}
				
				//Ex: SiebelMessage;ListaCriarOrdemServico
				parts	  = line.split(";"); 
				nodeRoot  = parts[0];
				nodeChild = parts[1];
				log("- line..........=["+line+"]");
				log("- nodeRoot......=["+nodeRoot+"]");
				log("- nodeChild.....=["+nodeChild+"]");
				
				if (root==null) {
					root = new Element(nodeRoot,"");
					root.attributes=nodeAttributes;
				}
				root.tagName = nodeRoot;
				root.listOf.add(new Element(nodeChild, nodeRoot)); // Primeira tag/elemento do XML
			
			}else {

				//Ex: SiebelMessage/ListaCriarOrdemServico;Dados
				parts=line.split(";"); 

				// Ex: 'SiebelMessage' e 'ListaCriarOrdemServico' | (SiebelMessage/ListaCriarOrdemServico;Dados)
				nodesRoot	= parts[0].split("/"); 
				nodeRootFull= parts[0]; 
				nodeChild   = parts[1];
				int	qtdNodes= nodesRoot.length;
				nodeParent	= nodesRoot[qtdNodes-1];
				log("- line..........=["+line+"]");
				log("- nodeRoot......=["+nodeRoot+"]");
				log("- nodeRootFull..=["+nodeRootFull+"]");
				log("- nodeChild.....=["+nodeChild+"]");
				log("- qtdNodes......=["+qtdNodes+"]");
				log("- nodeParent....=["+nodeParent+"]");

				Element nodeLast = root.getElementByFullTagName(nodeRootFull);

				if (nodeLast!=null) {
				log("- nodeLast......=["+nodeLast.tagName+"]");
					nodeLast.listOf.add(new Element(nodeChild,nodeRootFull));
				}
			}
			log("- XML =[" + root.writeXml()+"]");
		}
		log("<- parserByFullTagName()");
		return root;
	}
}
