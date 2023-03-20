package com.enset.hostpitalserivce.services;

import com.enset.hostpitalserivce.entities.DoctorReport;
import com.enset.hostpitalserivce.entities.Hyperglycemia;
import com.enset.hostpitalserivce.model.Patient;
import com.enset.hostpitalserivce.openfeign.PatientRestClient;
import com.enset.hostpitalserivce.repositories.DoctorReportRepository;
import com.enset.hostpitalserivce.repositories.HyperglycemiaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private DoctorReportRepository doctorReportRepository;
    private HyperglycemiaRepository hyperglycemiaRepository;
    private PatientRestClient patientRestClient;
    @Override
    public DoctorReport diagnosticPatientState(DoctorReport doctorReport) {

        System.out.println(doctorReport);
        return doctorReportRepository.save(doctorReport);
        /*this endpoint should be stored on block chain*/
    }

    @Override
    public List<Patient> getAllWaitingPatient() {
        return this.patientRestClient.getAllPatient();
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return this.patientRestClient.getPatientById(patientId);
    }

    @Override
    public Patient deletePatient(Long patientId) {
        return this.patientRestClient.deletePatient(patientId);
    }



    @Override
    public Hyperglycemia getPatientAnalysis(String blockChainId) {
        return this.hyperglycemiaRepository.findLastPatientAnalysis(blockChainId);
    }


}
