package com.menino.pcas.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.sun.istack.NotNull;

@Entity
public class Negotiation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long negotiation_id;
	@NotNull
	private Long id_first_hospital;
	@NotNull
	private Long id_second_hospital;
	private LocalDateTime negotiation_date_time;
	@Transient
	private List<HospitalResource> resources_first_hospital;
	@Transient
	private List<HospitalResource> resources_second_hospital;
	
	
	//Getters and Setters
	public Long getNegotiation_id() {
		return negotiation_id;
	}
	public void setNegotiation_id(Long negotiation_id) {
		this.negotiation_id = negotiation_id;
	}
	public Long getId_first_hospital() {
		return id_first_hospital;
	}
	public void setId_first_hospital(Long id_first_hospital) {
		this.id_first_hospital = id_first_hospital;
	}
	public Long getId_second_hospital() {
		return id_second_hospital;
	}
	public void setId_second_hospital(Long id_second_hospital) {
		this.id_second_hospital = id_second_hospital;
	}
	public LocalDateTime getNegotiation_date_time() {
		return negotiation_date_time;
	}
	public void setNegotiation_date_time(LocalDateTime negotiation_date_time) {
		this.negotiation_date_time = negotiation_date_time;
	}
	public List<HospitalResource> getResources_first_hospital() {
		return resources_first_hospital;
	}
	public void setResources_first_hospital(List<HospitalResource> resources_first_hospital) {
		this.resources_first_hospital = resources_first_hospital;
	}
	public List<HospitalResource> getResources_second_hospital() {
		return resources_second_hospital;
	}
	public void setResources_second_hospital(List<HospitalResource> resources_second_hospital) {
		this.resources_second_hospital = resources_second_hospital;
	}
}