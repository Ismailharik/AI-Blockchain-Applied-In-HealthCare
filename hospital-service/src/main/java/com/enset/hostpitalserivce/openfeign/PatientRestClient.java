package com.enset.hostpitalserivce.openfeign;

import com.enset.hostpitalserivce.model.Patient;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "patients-service",fallback = FeignFallback.class)
public interface PatientRestClient {
    @Retry(name = "patients-service")
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id);

    @GetMapping("/patients")
    public List<Patient> getAllPatient();

    @DeleteMapping("/patients/{id}")
    public Patient deletePatient(@PathVariable Long id);


}
