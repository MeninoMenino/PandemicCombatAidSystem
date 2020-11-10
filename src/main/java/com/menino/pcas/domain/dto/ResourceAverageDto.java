package com.menino.pcas.domain.dto;

public class ResourceAverageDto {
	private String name;
	private float average;
	
	
	//Constructor
	public ResourceAverageDto(){}
	
	public ResourceAverageDto(String name, float average){
		setName(name);
		setAverage(average);
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
}
