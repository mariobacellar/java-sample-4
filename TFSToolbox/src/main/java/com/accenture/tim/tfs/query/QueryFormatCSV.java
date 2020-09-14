package com.accenture.tim.tfs.query;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.accenture.tim.tfs.EpicosDesevolvimentoTransformer;
import com.microsoft.tfs.core.clients.workitem.query.WorkItemCollection;

public class QueryFormatCSV {
	
	//private static final Logger LOG = LoggerFactory.getLogger(QueryFormatCSV.class.getName());
	private static final Logger LOG = Logger.getLogger(QueryFormatCSV.class.getName());

	
	public	WorkItemCollection collection;
	public	String[] columns;
	public	int maxToPrint;

	public File csvFile;
	
	
	public QueryFormatCSV(WorkItemCollection collection, String[] columns, int maxToPrint, File csvFile) {
		this.collection	= collection;
		this.columns	= columns;
		this.maxToPrint	= maxToPrint;
		this.csvFile	= csvFile;
	}
	
	
	public void writeFile() throws Exception {
		
		LOG.debug("-> writeFile");

		BufferedWriter writer = new BufferedWriter (new FileWriter(csvFile));
		
		String strline = "";
	    
		LOG.debug("- EpicosDesevolvimentoTransformer");
	    EpicosDesevolvimentoTransformer transformer = new EpicosDesevolvimentoTransformer(maxToPrint);
	    
	    strline = transformer.header(columns);
	    writer.write(strline);
		LOG.info(strline);

	    strline = transformer.lines(collection);
	    writer.write(strline);
		LOG.info(strline);

        strline = ""+collection.size();
	    writer.write(strline);
		LOG.debug(strline);

   	    writer.close();
   	    LOG.debug("<- writeFile");
	}


	
}
