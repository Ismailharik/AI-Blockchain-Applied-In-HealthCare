package com.example.patientservice.controller;

import com.example.patientservice.entities.Patient;
import com.example.patientservice.exceptions.PatientNotFoundException;
import com.example.patientservice.services.PatientService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/patients")

public class PatientController {
    private PatientService patientService;
    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @GetMapping("/blockChainId/{blockChainId}")
    public Patient getPatientByBlockChainId(@PathVariable String blockChainId){
        log.info("get Patient by blockChainId "+ blockChainId);
        return this.patientService.getPatientByBlockChainId(blockChainId);
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        log.info("get Patient by blockChainId "+ id);
        try {
            Patient patient= this.patientService.getPatientById(id);
            return patient;
        }catch (PatientNotFoundException patientNotFoundException){
            System.out.println(patientNotFoundException.getMessage());
        }
        return null;
    }
    @GetMapping()
    public List<Patient> getAllPatients(){
        log.info("get all patients");
        return this.patientService.getAllPatients();
    }
    @PostMapping("")
    public Patient savePatient(@RequestBody Patient patient){
        log.info("Save patient : "+String.valueOf(patient));
        return this.patientService.addPatient(patient);
    }
    @PutMapping()
    public Patient updatePatient(@RequestBody Patient patient){
        log.info("update patient" +String.valueOf(patient));
        return this.patientService.updatePatient(patient);
    }

    @GetMapping("/totalPatient")
    public long totalPatients(){
        return this.patientService.getTotalPatient();
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        log.info("delete patient with id "+id);
        this.patientService.deletePatient(id);
    }
    @GetMapping("/waitingPatients")
    public List<Patient> getAllWaitingPatient(){
        return this.patientService.getAllWaitingPatient();
    }
    @GetMapping("/reservedPatients")
    public List<Patient> getAllReservedPatient(){
        return this.patientService.getAllReservedPatient();
    }

}
