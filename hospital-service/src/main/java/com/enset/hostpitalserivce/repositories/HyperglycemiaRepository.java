package com.enset.hostpitalserivce.repositories;

import com.enset.hostpitalserivce.entities.Doctor;
import com.enset.hostpitalserivce.entities.Hyperglycemia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(collectionResourceRel = "hyperglycemia", path = "hyperglycemia")
public interface HyperglycemiaRepository extends JpaRepository<Hyperglycemia,Long> {
     @Query(nativeQuery = true,value = "SELECT * FROM hyperglycemia WHERE patient_block_chain_id=?1 ORDER BY date_of_analysis DESC LIMIT 1")
     Hyperglycemia findLastPatientAnalysis(String blockChainId);
}
