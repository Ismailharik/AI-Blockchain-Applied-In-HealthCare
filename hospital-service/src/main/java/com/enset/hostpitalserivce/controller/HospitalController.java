package com.enset.hostpitalserivce.controller;

import com.enset.hostpitalserivce.entities.DoctorReport;
import com.enset.hostpitalserivce.entities.Hyperglycemia;
import com.enset.hostpitalserivce.model.Patient;
import com.enset.hostpitalserivce.openfeign.DoctorReportRestClient;
import com.enset.hostpitalserivce.openfeign.PatientRestClient;
import com.enset.hostpitalserivce.services.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hospital")
@AllArgsConstructor
public class HospitalController {
    private HospitalService hospitalService;
    private DoctorReportRestClient doctorReportRestClient;
    @PostMapping("/patientDiagnostic")
    public Object patientDiagnostic(@RequestBody DoctorReport doctorReport){
        hospitalService.diagnosticPatientState(doctorReport);

       return   this.doctorReportRestClient.postReportToBlockChain(doctorReport);

        /*
            I should add an attributed in patient to indicated if user reserved or not
        * */
        /*Traiment User et docteur */

        /*
        * After reserving patient you should delete him in this case to make sure doctor won't finnd him again
        * */
    }
    @GetMapping("/patients")
    public List<Patient> getAllPatient(){
        System.out.println("get all patient from hospital service");
       return this.hospitalService.getAllWaitingPatient();
    }
    @GetMapping("/patients/{patientId}")
    public Patient getPatientById(@PathVariable  Long patientId){
        System.out.println("get one patient from hospital service");
        return this.hospitalService.getPatientById(patientId);
    }
    @GetMapping("/patients/historic/{patientChain}")
    public Object getPatientHistory(@PathVariable String patientChain){
        return this.doctorReportRestClient.getPatientHistory(patientChain);
    }

    /*
    *this endpoint will return the analysis of the patient by it's id
     */
    @GetMapping("/patientAnalysis/{blockChainId}")
    public Hyperglycemia getPatientAnalysis(@PathVariable String blockChainId){
        return this.hospitalService.getPatientAnalysis(blockChainId);
    }

}
