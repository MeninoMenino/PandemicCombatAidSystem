package com.menino.pcas.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;

public class Negotiation {
	private Long idFirstHospital;
	private List<HospitalResource> resourcesFirstHospital;
	private Long idSecondHospital;
	private List<HospitalResource> resourcesSecondHospital;
	private LocalDateTime dateTime;
	
	
	//Getters and Setters
	public Long getIdFirstHospital() {
		return idFirstHospital;
	}
	public void setIdFirstHospital(Long idFirstHospital) {
		this.idFirstHospital = idFirstHospital;
	}
	public List<HospitalResource> getResourcesFirstHospital() {
		return resourcesFirstHospital;
	}
	public void setResourcesFirstHospital(List<HospitalResource> resourcesFirstHospital) {
		this.resourcesFirstHospital = resourcesFirstHospital;
	}
	public Long getIdSecondHospital() {
		return idSecondHospital;
	}
	public void setIdSecondHospital(Long idSecondHospital) {
		this.idSecondHospital = idSecondHospital;
	}
	public List<HospitalResource> getResourcesSecondHospital() {
		return resourcesSecondHospital;
	}
	public void setResourcesSecondHospital(List<HospitalResource> resourcesSecondHospital) {
		this.resourcesSecondHospital = resourcesSecondHospital;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
