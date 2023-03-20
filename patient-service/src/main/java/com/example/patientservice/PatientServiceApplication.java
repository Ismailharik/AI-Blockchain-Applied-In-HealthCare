package com.example.patientservice;

import com.example.patientservice.entities.Patient;
import com.example.patientservice.repository.PatientRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@OpenAPIDefinition
@EnableMongoRepositories(basePackageClasses = PatientRepository.class)
@EnableDiscoveryClient
public class PatientServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatientServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository) {

		return args -> {

			List<Patient> patients = new ArrayList<>();

			patients.add(new Patient(1L, "053543" , "ismail 1","ismail1"+ "@gmail.com", new Date(),"$2a$04$Qsp6DjEWWp9bDmaJ4oELjOCDdYRnB1NEakKd7324sxF0gfh8kgo0i",false));
			patients.add(new Patient(2L, "053543" , "ismail 2","ismail2"+ "@gmail.com", new Date(),"01aa8c12-3609-43cf-87d4-1d75f6b844da",false));
			patients.add(new Patient(3L, "053543" , "ismail 3","ismail3"+ "@gmail.com", new Date(),"5bb56046-6065-48f1-8406-bea967dae721",false));
			patients.add(new Patient(4L, "053543" , "ismail 4","ismail4"+ "@gmail.com", new Date(),"78c3fc84-3d44-495e-a87c-cff45f6420ec",false));

			patientRepository.saveAll(patients);

//			System.out.println(customerRepository.findAll());
		};
	}


}
