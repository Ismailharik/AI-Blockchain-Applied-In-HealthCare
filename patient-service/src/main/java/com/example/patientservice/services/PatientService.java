package com.example.patientservice.services;

import com.example.patientservice.entities.Patient;
import com.example.patientservice.exceptions.PatientNotFoundException;

import java.util.List;

public interface PatientService {
   List<Patient> getAllPatients();
    Patient getPatientByBlockChainId(String blockChainId);
    Patient getPatientByEmail(String email);
    Patient addPatient(Patient customer);
    Patient updatePatient(Patient customer);


    long getTotalPatient();

    void deletePatient(Long id);


 List<Patient> getAllWaitingPatient();
 List<Patient> getAllReservedPatient();

 Patient getPatientById(Long id) throws PatientNotFoundException;
}
