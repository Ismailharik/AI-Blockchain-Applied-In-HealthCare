package com.example.patientservice.repository;

import com.example.patientservice.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;



public interface PatientRepository extends MongoRepository<Patient,Long> {
    Patient findByEmail(String email);
    List<Patient> findAll();
}