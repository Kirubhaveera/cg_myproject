package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dto.Spectacles;

@Repository

public interface ISpectaclesRepository extends JpaRepository<Spectacles, Integer>{

}
