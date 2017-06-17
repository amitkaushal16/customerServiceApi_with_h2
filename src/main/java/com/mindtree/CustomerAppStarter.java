package com.mindtree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerAppStarter {

	public static void main(String[] args) {
		//Sets up default configuration
		//Starts Spring application context
		//Perform class path scan
		//Start tomcat server.
		
		//This make spring boot as stand alone application.
		SpringApplication.run(CustomerAppStarter.class,args);
	}

}
