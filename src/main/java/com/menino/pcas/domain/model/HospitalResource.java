package com.menino.pcas.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	//Constructor
	public HospitalResource() {}
	
	public HospitalResource(String name, int quantity) {
		setName(name);
		setQuantity(quantity);
	}
	
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
}