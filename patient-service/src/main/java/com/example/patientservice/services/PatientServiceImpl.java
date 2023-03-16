package com.example.patientservice.services;

import com.example.patientservice.entities.Patient;
import com.example.patientservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service 
 @AllArgsConstructor
public class PatientServiceImpl implements PatientService {
     private PatientRepository customerRepository;

    @Override
    public List<Patient> getAllPatients() {

        return this.customerRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return customerRepository.findById(patientId).get();
    }

    @Override
    public Patient getPatientByEmail(String email) {
        
        return customerRepository.findByEmail(email);
    }

    @Override
    public Patient addPatient(Patient patient) {
        Patient registeredCustomer = customerRepository.findByEmail(patient.getEmail());
       long id = customerRepository.count()+1;//
        if(registeredCustomer==null){
            patient.setId(id);
            System.out.println(patient);
            return customerRepository.save(patient);
        }
        return registeredCustomer;
    }

     @Override
     public Patient updatePatient(Patient patient) {

         return this.customerRepository.save(patient);
     }

     @Override
     public long getTotalPatient() {
         return this.customerRepository.count();
     }


     @Override
     public void deletePatient(Long id) {
         Patient customer = this.customerRepository.findById(id).get();
         this.customerRepository.delete(customer);
     }
 }
