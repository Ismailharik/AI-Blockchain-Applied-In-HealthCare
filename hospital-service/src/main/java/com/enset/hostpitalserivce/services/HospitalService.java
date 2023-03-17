package com.enset.hostpitalserivce.services;

import com.enset.hostpitalserivce.entities.DoctorReport;
import com.enset.hostpitalserivce.model.Patient;

import java.util.List;

public interface HospitalService {
    DoctorReport diagnosticPatientState(DoctorReport doctorReport);
    List<Patient> getAllWaitingPatient() ;
    Patient getPatientById(Long patientId);
    Patient deletePatient(Long parientId);
}
