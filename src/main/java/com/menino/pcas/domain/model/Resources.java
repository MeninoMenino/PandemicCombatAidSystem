package com.menino.pcas.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resources {
	@Id
	private String name;
	private int value;
	
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
