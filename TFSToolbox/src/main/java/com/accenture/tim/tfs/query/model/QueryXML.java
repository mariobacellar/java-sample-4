package com.accenture.tim.tfs.query.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QueryXML {
	
    private Queries Queries;

    
    
    public Queries getQueries (){
        return Queries;
    }

    public void setQueries (Queries Queries){
        this.Queries = Queries;
    }

    @Override
    public String toString() {
        return "ClassPojo [Queries = "+Queries+"]";
    }

}