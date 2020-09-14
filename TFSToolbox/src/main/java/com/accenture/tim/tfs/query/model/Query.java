package com.accenture.tim.tfs.query.model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.util.ResourceUtils;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "query")
public class Query {
	
    private String id;
    private String name;
    private String wiql;
    private String status;
    private String interval;

	
    public String getId() {
		return id;
	}

    public void setId(String id) {
		this.id = id;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWiql() {
		return wiql;
	}

	public void setWiql(String wiql) {
		this.wiql = wiql;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	@Override
    public String toString() {
        return "Query=[id=["+id+"]-name=["+name+"]-wiql=["+wiql+"]-status=["+status+"]-interval=["+interval+"]";
    }

    
    
    /**
     * MOC
     * @param n
     * @param i
     * @return
     
    public static Query newInstance(String n, String i) {
    	Query 
    	q = new Query ();
    	q.setId(i);
    	q.setName(n);
    	q.setWiql("SELECT ID, [Work Item Type], Title, [Assigned To], State, Tags FROM WorkItems  WHERE  ([Work Item Type] = 'Epic' and [Text field 3] = 'Aguardando desenvolvimento')   OR  ([Work Item Type] = 'Epic' and [Text field 3] = 'Em desenvolvimento') ORDER BY ID");
    	q.setStatus("on");
    	q.setInterval("5000");
    	return q;
    }
    */

    public static void main(String[] args) {

    	try {

    		File			file			= ResourceUtils.getFile("classpath:query.xml");
    		JAXBContext		jaxbContext 	= JAXBContext.newInstance(Query.class);
    		Unmarshaller	jaxbUnmarshaller= jaxbContext.createUnmarshaller();
    		Query			query			= (Query) jaxbUnmarshaller.unmarshal(file);
    		
    		System.out.println(query);

    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    }

    
}
			
			