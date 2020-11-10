package com.menino.pcas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.menino.pcas.domain.model.Hospital;
import com.menino.pcas.domain.model.HospitalResource;

public class HospitalTest {
	
	private Hospital hospital;
	
	@Before
	public void setUp() {
		hospital = new Hospital();
	}
	
	@Test
	public void testGetHospitalId() {
		Long insert = 1L;
		hospital.setHospital_id(insert);
		Long valueReturned = hospital.getHospital_id();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetName() {
		String insert = "Name";
		hospital.setName(insert);
		String valueReturned = hospital.getName();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetAddress() {
		String insert = "Address";
		hospital.setAddress(insert);
		String valueReturned = hospital.getAddress();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetCnpj() {
		String insert = "Cnpj";
		hospital.setCnpj(insert);
		String valueReturned = hospital.getCnpj();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testGetLocalization() {
		String insert = "Localization";
		hospital.setLocalization(insert);
		String valueReturned = hospital.getLocalization();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testOccupancyRate() {
		float insert = 1.1F;
		hospital.setOccupancyRate(insert);
		float valueReturned = hospital.getOccupancyRate();
		assertEquals(insert, valueReturned);
	}
	
	@Test
	public void testResources() {
		List<HospitalResource> insert = new ArrayList<>();
		hospital.setResources(insert);
		List<HospitalResource> valueReturned = hospital.getResources();
		assertEquals(insert, valueReturned);
	}
}
