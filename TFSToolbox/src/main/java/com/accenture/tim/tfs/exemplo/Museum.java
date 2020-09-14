package com.accenture.tim.tfs.exemplo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement( name = "MUSEUM" )
public class Museum {
	
    String name;
    String city;

   public Museum() {
	   super();
   } 
    
   public Museum(String name, String city) {
	   super();
	   this.name=name;
	   this.city=city;
}

    
    @XmlElement( name = "NAME" )
    public void setName( String name ) {
        this.name = name;
    }

    @XmlElement( name = "CITY" )
    public void setCity( String city) {
        this.city = city;
    }

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "name=["+name+"]-city=["+city+"]";
	}
}