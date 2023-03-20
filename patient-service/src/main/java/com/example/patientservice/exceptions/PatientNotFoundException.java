package com.example.patientservice.exceptions;

public class PatientNotFoundException extends Exception {
    public PatientNotFoundException(Long id) {
        super("Patient with id : "+id+"isn't found");
    }
}
