package com.menino.pcas.test.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.menino.pcas.domain.dto.Report;
import com.menino.pcas.domain.model.Negotiation;

public class ReportTest {

	Report report;
	
	@Before
	public void setUp() {
		report = new Report();
	}
	
	@Test
	public void testGetHighOccupancyRate() {
		float insert = 1.1F;
		report.setHighOccupancyRate(insert);
		float valueReturned = report.getHighOccupancyRate();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetLowOccupancyRate() {
		float insert = 1.1F;
		report.setLowOccupancyRate(insert);
		float valueReturned = report.getLowOccupancyRate();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetNegotiationHistory() {
		List<Negotiation> insert = new ArrayList<>();
		report.setNegotiationHistory(insert);
		List<Negotiation> valueReturned = report.getNegotiationHistory();
		assertEquals(insert, valueReturned);
	}
	
}