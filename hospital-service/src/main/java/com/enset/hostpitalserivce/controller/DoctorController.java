package com.enset.hostpitalserivce.controller;

import com.enset.hostpitalserivce.entities.Doctor;
import com.enset.hostpitalserivce.exceptions.DoctorNotFoundException;
import com.enset.hostpitalserivce.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {

    private DoctorService doctorService;
    @GetMapping("")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
    @GetMapping("/{doctorId}")
    public Doctor getDoctorById(@PathVariable  Long doctorId) throws DoctorNotFoundException {
        return doctorService.getDoctorById(doctorId);
    }
    @PostMapping("")
    public Doctor addDoctor(@PathVariable Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(@PathVariable Long doctorId ){
        try {
            this.doctorService.deleteDoctor(doctorId);
        }catch (DoctorNotFoundException doctorNotFoundException){
            System.out.println(doctorNotFoundException.getMessage());
        }
    }
    @PutMapping("")
    public Doctor updateDoctor(@RequestBody Doctor doctor){
        return this.doctorService.updateDoctor(doctor);
    }


}
