package com.menino.pcas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menino.pcas.api.service.ReportService;
import com.menino.pcas.domain.dto.Report;
import com.menino.pcas.domain.model.Hospital;
import com.menino.pcas.domain.model.Negotiation;
import com.menino.pcas.domain.repository.HospitalRepository;
import com.menino.pcas.domain.repository.NegotiationRepository;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	HospitalRepository hospitalRepository;
	@Autowired
	NegotiationRepository negotiationRepository;
	@Autowired
	ReportService reportService;
	
	@GetMapping
	public Report getReport(){
		List<Hospital> hospitalList = hospitalRepository.findAll();
		List<Negotiation> negotiationHistory = negotiationRepository.findAll();
		
		float[] percentageValues = reportService.calculateOccupancyPercentage(hospitalList);
		
		Report report = new Report(percentageValues[0], percentageValues[1], negotiationHistory);
		return report;
	}
	
}