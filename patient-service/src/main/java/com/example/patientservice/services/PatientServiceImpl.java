package com.example.patientservice.services;

import com.example.patientservice.entities.Patient;
import com.example.patientservice.exceptions.PatientNotFoundException;
import com.example.patientservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service 
 @AllArgsConstructor
public class PatientServiceImpl implements PatientService {
     private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {

        return this.patientRepository.findAll();
    }

    @Override
    public Patient getPatientByBlockChainId(String blockChainId) {
        return patientRepository.findByBlockChainId(blockChainId);
    }

    @Override
    public Patient getPatientByEmail(String email) {
        
        return patientRepository.findByEmail(email);
    }

    @Override
    public Patient addPatient(Patient patient) {
        Patient registeredCustomer = patientRepository.findByEmail(patient.getEmail());
       long id = patientRepository.count()+1;//
        if(registeredCustomer==null){
            patient.setId(id);
            System.out.println(patient);
            return patientRepository.save(patient);
        }
        return registeredCustomer;
    }

     @Override
     public Patient updatePatient(Patient patient) {

         return this.patientRepository.save(patient);
     }

     @Override
     public long getTotalPatient() {
         return this.patientRepository.count();
     }


     @Override
     public void deletePatient(Long id) {
         Patient customer = this.patientRepository.findById(id).get();
         this.patientRepository.delete(customer);
     }

     @Override
     public List<Patient> getAllWaitingPatient() {
         return this.patientRepository.getPatientsByStatusIsFalse();
     }

     @Override
     public List<Patient> getAllReservedPatient() {
         return this.patientRepository.getPatientsByStatusIsTrue();
     }

     @Override
     public Patient getPatientById(Long id) throws PatientNotFoundException {
         Patient patient =  patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException(id));
         return patient;
     }
 }
