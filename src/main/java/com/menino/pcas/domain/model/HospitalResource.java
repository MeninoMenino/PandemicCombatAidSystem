package com.menino.pcas.domain.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class HospitalResource{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resource_id;
	@NotBlank
	private String name;
	@NotNull
	private int quantity;
	/*
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "hospital_id", insertable = false)
	public Hospital hospital;*/
	
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getResourceId() {
		return resource_id;
	}
	public void setResourceId(Long resourceId) {
		this.resource_id = resourceId;
	}
	/*public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}*/
}