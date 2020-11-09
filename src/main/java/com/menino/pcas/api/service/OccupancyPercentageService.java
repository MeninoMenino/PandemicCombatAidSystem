package com.menino.pcas.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.menino.pcas.domain.model.Hospital;

@Service
public class OccupancyPercentageService {
	public float[] calculateOccupancyPercentage(List<Hospital> hospitalList) {
		int highOccupancyCount = 0, lowOccupancyCount = 0;
		float highOccupancyPercentage, lowOccupancyPercentage;
		float[] percentageValues = new float[2];
		
		for(int i = 0; i < hospitalList.size(); i++) {
			if(hospitalList.get(i).getOccupancyRate() >= 90) {
				highOccupancyCount++;
			} else {
				lowOccupancyCount++;
			}
		}
		
		highOccupancyPercentage = (100 * highOccupancyCount)/hospitalList.size();
		lowOccupancyPercentage = (100 * lowOccupancyCount)/hospitalList.size();
		
		percentageValues[0] = highOccupancyPercentage;
		percentageValues[1] = lowOccupancyPercentage;
		
		return percentageValues;
	}
}
