package com.enset.hostpitalserivce;

import com.enset.hostpitalserivce.entities.Doctor;
import com.enset.hostpitalserivce.entities.Hospital;
import com.enset.hostpitalserivce.entities.Hyperglycemia;
import com.enset.hostpitalserivce.repositories.DoctorRepository;
import com.enset.hostpitalserivce.repositories.HospitalRepository;
import com.enset.hostpitalserivce.repositories.HyperglycemiaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class HostpitalSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostpitalSerivceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(DoctorRepository doctorRepository,
							HospitalRepository hospitalRepository,
							HyperglycemiaRepository hyperglycemiaRepository){
		return args->{
			List<Doctor> doctors = new ArrayList<>();
			List<Hospital> hospitals = new ArrayList<>();
			List<Hyperglycemia> hyperglycemia = new ArrayList<>();

			/*add real Hyperglycemia Analysis  data from data set*/
			hyperglycemia.add(new Hyperglycemia(1L,6,148,72,35,0,  33.6,  0.627,50,1,new Date(),"$2a$04$Qsp6DjEWWp9bDmaJ4oELjOCDdYRnB1NEakKd7324sxF0gfh8kgo0i"));
			hyperglycemia.add(new Hyperglycemia(2L,1,85,66,29,0,26.6, 0.351,31,0,new Date(),"01aa8c12-3609-43cf-87d4-1d75f6b844da"));
			hyperglycemia.add(new Hyperglycemia(3L,8,183,64,0, 0,23.3,0.672,32,1,new Date(),"5bb56046-6065-48f1-8406-bea967dae721"));
			hyperglycemia.add(new Hyperglycemia(4L,1,89,66,23, 94, 28.1,0.167,21,0,new Date(),"78c3fc84-3d44-495e-a87c-cff45f6420ec"));

			for (int i = 0; i < 10; i++) {
				doctors.add(new Doctor(null,"address "+i,"phone "+i,i*20));
				hospitals.add(new Hospital( null,"address "+i,"0438544"+i, null));

			}
			doctorRepository.saveAll(doctors);
			hospitalRepository.saveAll(hospitals);
			hyperglycemiaRepository.saveAll(hyperglycemia);
		};
	}
}
