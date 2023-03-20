package com.example.patientservice.repository;

import com.example.patientservice.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;



public interface PatientRepository extends MongoRepository<Patient,Long> {
    Patient findByEmail(String email);
    List<Patient> findAll();

    List<Patient> getPatientsByStatusIsTrue();
    List<Patient> getPatientsByStatusIsFalse();
    Patient findByBlockChainId(String blockChainId);
}