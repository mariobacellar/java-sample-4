package com.accenture.siebel;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockSiebelServerApplication {

	private static final Logger log = LogManager.getLogger(MockSiebelServerApplication.class);
	
	public static void main(String[] args) {
		
		log.info("-> Start");
		log.debug("-> Start");
		
		SpringApplication.run(MockSiebelServerApplication.class, args);

		log.info("-> Stop");
		log.debug("-> Stop");
	}


}
