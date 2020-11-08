package com.menino.pcas.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.menino.pcas.domain.model.Hospital;
import com.menino.pcas.domain.repository.HospitalRepository;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@GetMapping
	public List<Hospital> getHospitalList(){
		return hospitalRepository.findAll();
	}
	
	@GetMapping("/{hospitalId}")
	public ResponseEntity<Hospital> getHospital(@PathVariable Long hospitalId) {
		Optional<Hospital> hospital = hospitalRepository.findById(hospitalId);
		if(hospital.isPresent()) {
			return ResponseEntity.ok(hospital.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Hospital postHospital(@Valid @RequestBody Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
}
