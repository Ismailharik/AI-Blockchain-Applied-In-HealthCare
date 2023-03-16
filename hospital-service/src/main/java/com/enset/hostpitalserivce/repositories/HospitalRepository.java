package com.enset.hostpitalserivce.repositories;

import com.enset.hostpitalserivce.entities.Doctor;
import com.enset.hostpitalserivce.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {

}
