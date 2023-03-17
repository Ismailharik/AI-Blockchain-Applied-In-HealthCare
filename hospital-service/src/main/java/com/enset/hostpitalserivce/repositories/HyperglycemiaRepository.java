package com.enset.hostpitalserivce.repositories;

import com.enset.hostpitalserivce.entities.Doctor;
import com.enset.hostpitalserivce.entities.Hyperglycemia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(collectionResourceRel = "hyperglycemia", path = "hyperglycemia")
public interface HyperglycemiaRepository extends JpaRepository<Hyperglycemia,Long> {

}
