package com.accenture.tim.tfs;

import org.apache.log4j.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.microsoft.tfs.core.clients.workitem.WorkItem;
import com.microsoft.tfs.core.clients.workitem.query.WorkItemCollection;

public class EpicosDesevolvimentoTransformer {

	//private static final Logger LOG = LoggerFactory.getLogger(EpicosDesevolvimentoTransformer.class.getName());
	private static final Logger LOG = Logger.getLogger(EpicosDesevolvimentoTransformer.class.getName());

	
	private int maxToPrint = 0;
	
	public EpicosDesevolvimentoTransformer(int maxToPrint) {
		this.maxToPrint=maxToPrint;
	}
	
	public String lines(WorkItemCollection collection) {
		LOG.debug("-> lines(");
		String		strline  = "";
		WorkItem	workItem = null;
	    for (int i = 0; i < collection.size(); i++) {
	    	workItem = collection.getWorkItem(i);
	    	strline = 
	        strline +	workItem.getID()+";"+ 
						workItem.getFields().getWorkItemType()+";"+
						workItem.getTitle()+";"+
						workItem.getFields().getField("Assigned To").getValue()+";"+
						workItem.getFields().getField("State").getValue()+ ";"+
						workItem.getFields().getField("Tags").getValue()+"\n";
			if (maxToPrint>0 && i >= maxToPrint) {
	            LOG.debug("[...]");
	            break;
	        }
	    }
		LOG.debug("<- lines(");
	    return strline;
	}

	public String header(String[] columns) {
		String strline = "";
		for (int i = 0; i < columns.length; i++) {
			strline = strline + columns[i]+";";
			 LOG.debug(strline);
		}
		strline = strline + "\n";
	    return strline;
	}
	
}
