package com.example.patientservice.services;

import com.example.patientservice.entities.Patient;

import java.util.List;

public interface PatientService {
   List<Patient> getAllPatients();
    Patient getPatientById(Long customerId);
    Patient getPatientByEmail(String email);
    Patient addPatient(Patient customer);
    Patient updatePatient(Patient customer);


    long getTotalPatient();

    void deletePatient(Long id);

}
