package com.accenture.xmlmanager.parser.csv;

import java.util.ArrayList;
import java.util.List;

public class CSVData {
	
	public List<CSVData> ltCSVData;
	public String ordem;
	public String grupo;
	public String nomeCampo;
	public String descricao;
	public String tipo;
	public String tamanho;
	public String obrigatoriedade;
	public String ocorrenciaMin;
	public String ocorrenciaMax;
	public String dominio;
	
	public void add(CSVData data) {
		if (this.ltCSVData==null)this.ltCSVData=new ArrayList<CSVData>();
		this.ltCSVData.add(data);
	}
	
	public static CSVData factor(String[] campos) {
		CSVData 
		data = new CSVData();
		data.ordem			= (campos.length>=1 ? campos[0]:"");
		data.grupo			= (campos.length>=2 ? campos[1]:"");
		data.nomeCampo		= (campos.length>=3 ? campos[2]:"");
		data.descricao		= (campos.length>=4 ? campos[3]:"");
		data.tipo			= (campos.length>=5 ? campos[4]:"");
		data.tamanho		= (campos.length>=6 ? campos[5]:"");
		data.obrigatoriedade= (campos.length>=7 ? campos[6]:"");
		data.ocorrenciaMin	= (campos.length>=8 ? campos[7]:"");
		data.ocorrenciaMax	= (campos.length>=9 ? campos[8]:"");
		data.dominio		= (campos.length>=10? campos[9]:"");
		return data;
	}
	
	
	public String toString() {
		return 
		"ordem=["          +ordem+"] "+
		"grupo=["          +grupo+"] "+
		"nomeCampo=["      +nomeCampo+"] "+
		"descricao=["      +descricao+"] "+
		"tipo=["           +tipo+"] "+
		"tamanho=["        +tamanho+"] "+
		"obrigatoriedade=["+obrigatoriedade+"] "+
		"ocorrenciaMin=["  +ocorrenciaMin+"] "+
		"ocorrenciaMax=["  +ocorrenciaMax+"] "+
		"dominio=["        +dominio+"] ";
	}
	
	
}
