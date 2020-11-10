package com.menino.pcas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.menino.pcas.domain.model.HospitalResource;

public class HospitalResourceTest {

	HospitalResource hospitalResource;
	
	@Before
	public void setUp() {
		hospitalResource = new HospitalResource();
	}

	@Test
	public void testGetResourceId() {
		Long insert = 1L;
		hospitalResource.setResourceId(insert);
		Long valueReturned = hospitalResource.getResourceId();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetName() {
		String insert = "Name";
		hospitalResource.setName(insert);
		String valueReturned = hospitalResource.getName();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetQuantity() {
		int insert = 1;
		hospitalResource.setQuantity(insert);
		int valueReturned = hospitalResource.getQuantity();
		assertEquals(insert, valueReturned);
	}
	
}