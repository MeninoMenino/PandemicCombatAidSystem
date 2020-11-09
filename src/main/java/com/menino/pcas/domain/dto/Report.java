package com.menino.pcas.domain.dto;

public class Report {

	private float highOccupancyRate;
	private float lowOccupancyRate;

	public Report(float highRate, float lowRate) {
		setHighOccupancyRate(highRate);
		setLowOccupancyRate(lowRate);
	}


	//Getters and Setters
	public float getHighOccupancyRate() {
		return highOccupancyRate;
	}
	public void setHighOccupancyRate(float highOccupancyRate) {
		this.highOccupancyRate = highOccupancyRate;
	}
	public float getLowOccupancyRate() {
		return lowOccupancyRate;
	}
	public void setLowOccupancyRate(float lowOccupancyRate) {
		this.lowOccupancyRate = lowOccupancyRate;
	}
}
