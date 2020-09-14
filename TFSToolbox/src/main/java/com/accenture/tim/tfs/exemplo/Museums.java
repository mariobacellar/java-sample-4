package com.accenture.tim.tfs.exemplo;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.util.ResourceUtils;

@XmlRootElement( name = "MUSEUMS" )
public class Museums {
	
	List museums;

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement( name = "MUSEUM" )
    public void setMuseums( List museums ) {
        this.museums = museums;
    }

    public static void main(String[] args) {
		try {
			File file= ResourceUtils.getFile("classpath:MUSEUMS.xml");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Museums.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			Museums museums = (Museums)jaxbUnmarshaller.unmarshal(file);
			
			System.out.println(museums);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
