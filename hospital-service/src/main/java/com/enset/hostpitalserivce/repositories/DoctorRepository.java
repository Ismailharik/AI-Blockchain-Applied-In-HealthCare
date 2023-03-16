package com.enset.hostpitalserivce.repositories;

import com.enset.hostpitalserivce.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
