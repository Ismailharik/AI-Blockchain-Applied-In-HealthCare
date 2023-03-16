package com.enset.hostpitalserivce.services;

import com.enset.hostpitalserivce.entities.Doctor;
import com.enset.hostpitalserivce.exceptions.DoctorNotFoundException;
import com.enset.hostpitalserivce.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long doctorId) throws DoctorNotFoundException {
        Doctor doctor= doctorRepository.findById(doctorId).orElseThrow( ()->new DoctorNotFoundException(doctorId));
        return doctor;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /*
    * CRUD FOR doctor
    * */
}
