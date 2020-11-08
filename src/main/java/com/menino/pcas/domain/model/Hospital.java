package com.menino.pcas.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hospitalId;
	@NotBlank
	private String name;
	@NotBlank
	private String address;
	@NotBlank
	private String cnpj;
	@NotBlank
	private String localization;
	@NotNull
	private float occupancyRate;
	@NotNull
	@OneToMany(mappedBy = "hospital")
	private List<Resource> resources;
	
	
	//Getters and Setters
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	public float getOccupancyRate() {
		return occupancyRate;
	}
	public void setOccupancyRate(float occupancyRate) {
		this.occupancyRate = occupancyRate;
	}
}
