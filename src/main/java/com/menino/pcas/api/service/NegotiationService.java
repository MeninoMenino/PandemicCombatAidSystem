package com.menino.pcas.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menino.pcas.api.exception.RejectedTradeException;
import com.menino.pcas.domain.model.Hospital;
import com.menino.pcas.domain.model.HospitalResource;
import com.menino.pcas.domain.model.Negotiation;
import com.menino.pcas.domain.model.Resources;
import com.menino.pcas.domain.repository.HospitalRepository;
import com.menino.pcas.domain.repository.NegotiationRepository;
import com.menino.pcas.domain.repository.ResourcesRepository;

@Service
public class NegotiationService {

	@Autowired
	HospitalRepository hospitalRepository;
	@Autowired
	ResourcesRepository resourcesRepository;
	@Autowired
	NegotiationRepository negotiationRepository;

	public void negotiate(Negotiation negotiation) {
		Optional<Hospital> firstHospital = hospitalRepository.findById(negotiation.getId_first_hospital());
		Optional<Hospital> secondHospital = hospitalRepository.findById(negotiation.getId_second_hospital());

		List<Resources> resources = resourcesRepository.findAll();

		compareValues(negotiation, firstHospital.get(), secondHospital.get(), resources);
	}

	public void compareValues(Negotiation negotiation, Hospital firstHospital, Hospital secondHospital, List<Resources> resources) {
		int valueFirstHospital = 0, valueSecondHospital = 0;
		List<HospitalResource> resourcesFirstHospital = negotiation.getResources_first_hospital();
		List<HospitalResource> resourcesSecondHospital = negotiation.getResources_second_hospital();

		//Calculate the value of resources
		for(HospitalResource hospitalResource : resourcesFirstHospital) {
			for(Resources rsrc : resources) {
				if(hospitalResource.getName().toUpperCase().equals(rsrc.getName())) {
					valueFirstHospital += (rsrc.getValue() * hospitalResource.getQuantity());
				}
			}
		}

		//Calculate the value of resources
		for(HospitalResource hospitalResource : resourcesSecondHospital) {
			for(Resources rsrc : resources) {
				if(hospitalResource.getName().toUpperCase().equals(rsrc.getName())) {
					valueSecondHospital += (rsrc.getValue() * hospitalResource.getQuantity());
				}
			}
		}
		
		//Compare values
		if(valueFirstHospital < valueSecondHospital) {
			if(firstHospital.getOccupancyRate() > 90) {
				trade(firstHospital, secondHospital, negotiation);
			} else {
				throw new RejectedTradeException(firstHospital.getName());
			}
		} else if(valueFirstHospital > valueSecondHospital) {
			if(secondHospital.getOccupancyRate() > 90) {
				trade(firstHospital, secondHospital, negotiation);
			} else {
				throw new RejectedTradeException(firstHospital.getName());
			}
		} else {
			trade(firstHospital, secondHospital, negotiation);
		}
	}

	public void trade(Hospital firstHospital, Hospital secondHospital, Negotiation negotiation) {
		List<HospitalResource> resourcesFirstHospital = negotiation.getResources_first_hospital();
		List<HospitalResource> resourcesSecondHospital = negotiation.getResources_second_hospital();
		
		for(HospitalResource rsrc : resourcesFirstHospital) {
			for(HospitalResource hsptlRsrc : firstHospital.getResources()) {
				if(hsptlRsrc.getName().equals(rsrc.getName())) {
					if(hsptlRsrc.getQuantity() == 1) {
						//firstHospital.getResources().remove(hsptlRsrc);
						hsptlRsrc.setQuantity(hsptlRsrc.getQuantity()-1);
					} else {
						hsptlRsrc.setQuantity(hsptlRsrc.getQuantity()-1);
					}
				}
			}
			secondHospital.getResources().add(rsrc);
		}
		for(HospitalResource rsrc : resourcesSecondHospital) {
			for(HospitalResource hsptlRsrc : secondHospital.getResources()) {
				if(hsptlRsrc.getName().equals(rsrc.getName())) {
					if(hsptlRsrc.getQuantity() == 1) {
						//secondHospital.getResources().remove(hsptlRsrc);
						hsptlRsrc.setQuantity(hsptlRsrc.getQuantity()-1);
					} else {
						hsptlRsrc.setQuantity(hsptlRsrc.getQuantity()-1);
					}
				}
			}
			firstHospital.getResources().add(rsrc);
		}
		
		hospitalRepository.save(firstHospital);
		hospitalRepository.save(secondHospital);
	}
}
