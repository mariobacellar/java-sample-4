package com.accenture.tim.tfs.query.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.util.ResourceUtils;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "queries")
public class Queries {

	@XmlElement(name = "query", type = Query.class)
    private List<Query> queries = new ArrayList<Query>();

	
	public List<Query> getQueries() {
		return queries;
	}

	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}

	@Override
    public String toString() {
		String id   = null;
		String name = null;
		String wiql = null;
		String ret  = ""; 
		for (Query q : queries) {
			id   = q.getId();
			name = q.getName();
			wiql = q.getWiql();
			ret  = ret+ "id=["+id+"] - name=["+name+"] - wiql=["+wiql+"]\n";
		}
        return ret;
    }


    public static List<Query> unmarshalAsQieryLis() throws Exception {
		File			file	= ResourceUtils.getFile("classpath:queries.xml");
    	Queries			queries	= new Queries();
        JAXBContext		context = JAXBContext.newInstance(Queries.class);
        Unmarshaller	um		= context.createUnmarshaller();
        queries = (Queries) um.unmarshal(file);
        return queries.getQueries();
    }
    
    public static Queries unmarshalAsQueries() throws Exception {
		File			file	= ResourceUtils.getFile("classpath:queries.xml");
    	Queries			queries	= new Queries();
        JAXBContext		context = JAXBContext.newInstance(Queries.class);
        Unmarshaller	um		= context.createUnmarshaller();
        queries = (Queries) um.unmarshal(file);
        return queries;
    }
    
    
    public static void main(String[] args) {

    	try {

//    		File			file	= ResourceUtils.getFile("classpath:queries.xml");
//            JAXBContext		context = JAXBContext.newInstance(Queries.class);
//            Unmarshaller	um		= context.createUnmarshaller();
//            Queries			queries = (Queries) um.unmarshal(file);
    		Queries queries = Queries.unmarshalAsQueries();
            System.out.println(queries);

    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    }


}