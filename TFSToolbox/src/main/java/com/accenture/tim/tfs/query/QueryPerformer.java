package com.accenture.tim.tfs.query;

import java.io.File;

import org.apache.log4j.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.accenture.tim.tfs.query.model.Query;
import com.microsoft.tfs.core.clients.workitem.query.WorkItemCollection;

public class QueryPerformer {

//	private static final Logger LOG = LoggerFactory.getLogger(QueryPerformer.class.getName());
	private static final Logger LOG = Logger.getLogger(QueryPerformer.class.getName());
	
	public String queryId;
	public String queryName;
			
	public Query query; 
	
	public QueryPerformer(String queryId, String queryName) {
		this.queryId   = queryId;
		this.queryName = queryName;
	}
	
	
	public QueryPerformer(Query query) {
		this.query=query;
	}


	public void perform() throws Exception {
		
		LOG.debug("-> perform() ");
		Query q = query; //Query.newInstance(queryName, queryId);
		
        // Define the WIQL query. Ex: "SELECT ID, Title, [Work Item Type] FROM WorkItems WHERE (State = 'Active') order by Title"
        String[]	columns		= {"Id","WorkItemType","Title","Assigned To","State","Tags"};
        String		wiqlQuery	= q.getWiql();  
        String		fileName	= ".//csv//"+q.getName().replaceAll("\\s+","")+".csv"; // remove space em branco
        File		csvFile		= new File(fileName); 
        
        LOG.debug("<- perform():NORMAL ");

        
        // The number of work items size limit of 20000
        int maxitems=200;

        QueryWorkItem		qwi		= new QueryWorkItem();
        WorkItemCollection  wic		= qwi.execute(wiqlQuery);
        QueryFormatCSV		qfcsv	= new QueryFormatCSV(wic, columns, maxitems, csvFile);
        
        qfcsv.writeFile();
        LOG.debug("<- perform():NORMAL ");
		
	}
	

	public static void main(String[] args) {
		try {
			String			queryId	  = "1";
			String			queryName = "Epicos Em Desenvolvimento";
			QueryPerformer	queryPerf = new QueryPerformer(queryId, queryName);
			queryPerf.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
