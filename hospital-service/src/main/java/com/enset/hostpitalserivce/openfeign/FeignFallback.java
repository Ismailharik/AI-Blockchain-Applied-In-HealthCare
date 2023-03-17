package com.enset.hostpitalserivce.openfeign;

import com.enset.hostpitalserivce.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignFallback implements PatientRestClient {
    public Patient getPatientById(Long patientId){
        System.out.println("Patient not found");
        return null;
    }

    @Override
    public List<Patient> getAllPatient() {
        System.out.println("Patient not found");
        return null;
    }

    @Override
    public Patient deletePatient(Long id) {
        System.out.println("patient with Id : "+id);
        return null;
    }
}
