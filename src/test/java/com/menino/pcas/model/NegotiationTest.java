package com.menino.pcas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.menino.pcas.domain.model.HospitalResource;
import com.menino.pcas.domain.model.Negotiation;

public class NegotiationTest {
	
	Negotiation negotiation;
	
	@Before
	public void setUp() {
		negotiation = new Negotiation();
	}
	
	@Test
	public void testGetNegotiationId() {
		Long insert = 1L;
		negotiation.setNegotiation_id(insert);
		Long valueReturned = negotiation.getNegotiation_id();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetId_first_hospital() {
		Long insert = 1L;
		negotiation.setId_first_hospital(insert);
		Long valueReturned = negotiation.getId_first_hospital();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetId_second_hospital() {
		Long insert = 1L;
		negotiation.setId_second_hospital(insert);
		Long valueReturned = negotiation.getId_second_hospital();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetNegotiation_date_time() {
		LocalDateTime insert = LocalDateTime.now();
		negotiation.setNegotiation_date_time(insert);
		LocalDateTime valueReturned = negotiation.getNegotiation_date_time();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetResources_first_hospital() {
		List<HospitalResource> insert = new ArrayList<>();
		negotiation.setResources_first_hospital(insert);
		List<HospitalResource> valueReturned = negotiation.getResources_first_hospital();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetResources_second_hospital() {
		List<HospitalResource> insert = new ArrayList<>();
		negotiation.setResources_second_hospital(insert);
		List<HospitalResource> valueReturned = negotiation.getResources_second_hospital();
		assertEquals(insert, valueReturned);
	}
	
}