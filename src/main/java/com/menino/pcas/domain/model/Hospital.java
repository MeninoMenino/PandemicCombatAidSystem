package com.menino.pcas.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Hospital{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hospital_id;
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
	@OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<HospitalResource> resources;
	
	
	//Getters and Setters
	public Long getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(Long hospital_id) {
		this.hospital_id = hospital_id;
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
	public List<HospitalResource> getResources() {
		return resources;
	}
	public void setResources(List<HospitalResource> resources) {
		this.resources = resources;
	}
}
