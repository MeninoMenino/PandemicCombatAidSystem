package com.menino.pcas.domain.dto;

import java.util.List;

import com.menino.pcas.domain.model.Negotiation;

public class Report {

	private float highOccupancyRate;
	private float lowOccupancyRate;
	private List<Negotiation> negotiationHistory;

	public Report(float highRate, float lowRate, List<Negotiation> negotiationHistory) {
		setHighOccupancyRate(highRate);
		setLowOccupancyRate(lowRate);
		setNegotiationHistory(negotiationHistory);
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
	public List<Negotiation> getNegotiationHistory() {
		return negotiationHistory;
	}
	public void setNegotiationHistory(List<Negotiation> negotiationHistory) {
		this.negotiationHistory = negotiationHistory;
	}
}
