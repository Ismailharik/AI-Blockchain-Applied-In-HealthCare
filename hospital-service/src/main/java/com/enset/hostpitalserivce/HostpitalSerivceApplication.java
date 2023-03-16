package com.enset.hostpitalserivce;

import com.enset.hostpitalserivce.entities.Doctor;
import com.enset.hostpitalserivce.entities.Hospital;
import com.enset.hostpitalserivce.repositories.DoctorRepository;
import com.enset.hostpitalserivce.repositories.HospitalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HostpitalSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostpitalSerivceApplication.class, args);
	}
//
	@Bean
	CommandLineRunner start(DoctorRepository doctorRepository, HospitalRepository hospitalRepository){
		return args->{
			List<Doctor> doctors = new ArrayList<>();
			List<Hospital> hospitals = new ArrayList<>();


			for (int i = 0; i < 10; i++) {
				doctors.add(new Doctor(null,"address "+i,"phone "+i,i*20));
				hospitals.add(new Hospital( null,"address "+i,"0438544"+i, null));
			}
			doctorRepository.saveAll(doctors);
			hospitalRepository.saveAll(hospitals);
		};
	}
}
