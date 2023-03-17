package com.enset.hostpitalserivce.services;

import com.enset.hostpitalserivce.entities.Doctor;
import com.enset.hostpitalserivce.exceptions.DoctorNotFoundException;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long doctorId) throws DoctorNotFoundException;
    Doctor addDoctor(Doctor doctor);
    void deleteDoctor(Long doctorId) throws DoctorNotFoundException;
    Doctor updateDoctor(Doctor doctor);

}
