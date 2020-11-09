package com.menino.pcas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menino.pcas.domain.model.Hospital;
import com.menino.pcas.domain.model.Report;
import com.menino.pcas.domain.repository.HospitalRepository;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@GetMapping
	public Report getReport(){
		List<Hospital> hospitalList = hospitalRepository.findAll();
		int highOccupancyCount = 0, lowOccupancyCount = 0;
		float highOccupancyPercentage, lowOccupancyPercentage;
		
		for(int i = 0; i < hospitalList.size(); i++) {
			if(hospitalList.get(i).getOccupancyRate() >= 90) {
				highOccupancyCount++;
			} else {
				lowOccupancyCount++;
			}
		}
		
		highOccupancyPercentage = (100 * highOccupancyCount)/hospitalList.size();
		lowOccupancyPercentage = (100 * lowOccupancyCount)/hospitalList.size();
		
		Report report = new Report(highOccupancyPercentage, lowOccupancyPercentage);
		return report;
	}
	
}