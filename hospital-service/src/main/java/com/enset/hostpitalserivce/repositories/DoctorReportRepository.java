package com.enset.hostpitalserivce.repositories;

import com.enset.hostpitalserivce.entities.Doctor;
import com.enset.hostpitalserivce.entities.DoctorReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorReportRepository extends JpaRepository<DoctorReport,Long> {

}
