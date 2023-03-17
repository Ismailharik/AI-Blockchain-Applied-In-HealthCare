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
			List<Patient> customers = new ArrayList<>(10);
			for (int i = 0; i < 10; i++) {
				customers.add(new Patient(i+1L, "053543" + i, "ismail "+i+1,"ismail" + i + "gmail.com", new Date()));
			}
			patientRepository.saveAll(customers);

//			System.out.println(customerRepository.findAll());
		};
	}


}
