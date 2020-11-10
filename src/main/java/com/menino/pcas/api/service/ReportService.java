package com.menino.pcas.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.menino.pcas.domain.dto.ResourceAverageDto;
import com.menino.pcas.domain.model.Hospital;
import com.menino.pcas.domain.model.HospitalResource;

@Service
public class ReportService {
	public float[] calculateOccupancyPercentage(List<Hospital> hospitalList) {
		int highOccupancyCount = 0, lowOccupancyCount = 0;
		float highOccupancyPercentage, lowOccupancyPercentage;
		float[] percentageValues = new float[2];

		for(int i = 0; i < hospitalList.size(); i++) {
			if(hospitalList.get(i).getOccupancyRate() > 90) {
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

	public List<ResourceAverageDto> calculateResourcesAverage(List<HospitalResource> resourcesList, int hospitalQuant){
		List<ResourceAverageDto> resourceAverageList = new ArrayList<>();
		//Counters
		int medicoCount = 0, enfermeiroCount = 0, respiradorCount = 0, tomografoCount = 0, ambulanciaCount = 0; 

		for(HospitalResource rsrc : resourcesList) {
			switch(rsrc.getName()) {
			case "Médico": 
				medicoCount += rsrc.getQuantity();
				break;
			case "Enfermeiro": 
				enfermeiroCount += rsrc.getQuantity();
				break;
			case "Respirador": 
				respiradorCount += rsrc.getQuantity();
				break;
			case "Tomógrafo": 
				tomografoCount += rsrc.getQuantity();
				break;
			case "Ambulância": 
				ambulanciaCount += rsrc.getQuantity();
				break;
			}
		}

		resourceAverageList.add(new ResourceAverageDto("Médico", medicoCount/hospitalQuant));
		resourceAverageList.add(new ResourceAverageDto("Enfermeiro", enfermeiroCount/hospitalQuant));
		resourceAverageList.add(new ResourceAverageDto("Respirador", respiradorCount/hospitalQuant));
		resourceAverageList.add(new ResourceAverageDto("Tomógrafo", tomografoCount/hospitalQuant));
		resourceAverageList.add(new ResourceAverageDto("Ambulância", ambulanciaCount/hospitalQuant));

		return resourceAverageList;
	}
}