package com.menino.pcas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menino.pcas.domain.model.HospitalResource;

@Repository
public interface HospitalResourceRepository extends JpaRepository<HospitalResource, Long>{

}