package com.cg.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dto.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer>{
}