package com.realEstate;  // The package declaration

import org.springframework.boot.SpringApplication;  // Importing SpringApplication class
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Importing SpringBootApplication annotation

/**
 * This is the main entry point for the Spring Boot application.
 * The @SpringBootApplication annotation enables several crucial Spring Boot features.
 */
@SpringBootApplication
public class RealEstateApplication {

	/**
	 * The main() method serves as the entry point for the Spring Boot application.
	 * It launches the application by calling SpringApplication.run().
	 */
	public static void main(String[] args) {
		SpringApplication.run(RealEstateApplication.class, args);
	}
}
