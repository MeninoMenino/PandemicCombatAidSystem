package com.menino.pcas.test.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.menino.pcas.domain.dto.HospitalOccupancyDto;

public class HospitalOccupancyDtoTest {

	HospitalOccupancyDto hospitalOccupancyDto;
	
	@Before
	public void setUp() {
		hospitalOccupancyDto = new HospitalOccupancyDto();
	}
	
	@Test
	public void testGetOccupancy() {
		float insert = 1.1F;
		hospitalOccupancyDto.setOccupancy(insert);
		float valueReturned = hospitalOccupancyDto.getOccupancy();
		assertEquals(insert, valueReturned);
	}
	
}
