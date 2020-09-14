package com.accenture.tim.tfs.query;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.simpleframework.xml.core.Persister;
import org.springframework.util.ResourceUtils;

import com.accenture.tim.tfs.query.model.Queries;

public class QueriesXML {

	//private static final Logger LOG = LoggerFactory.getLogger(QueriesXML.class.getName());

	public Queries loadQueries() {
		Queries queries = null;
	    try {
            queries = Queries.unmarshalAsQueries();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return queries;
	}
	
	
	public static void main(String[] list) throws Exception {
		QueriesXML qxml = new QueriesXML();
		Queries	queries		= qxml.loadQueries();
	    System.out.println(queries);
   }

}
