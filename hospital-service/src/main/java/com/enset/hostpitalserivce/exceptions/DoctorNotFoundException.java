package com.enset.hostpitalserivce.exceptions;

public class DoctorNotFoundException extends Exception {
public DoctorNotFoundException(Long doctorId){
    super("Doctor with Id : "+doctorId+"isn't found");
}
}
