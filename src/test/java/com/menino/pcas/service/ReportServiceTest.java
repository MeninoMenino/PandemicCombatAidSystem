package com.menino.pcas.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.menino.pcas.api.service.ReportService;
import com.menino.pcas.domain.dto.ResourceAverageDto;
import com.menino.pcas.domain.model.Hospital;
import com.menino.pcas.domain.model.HospitalResource;

public class ReportServiceTest {

	ReportService reportService;
	List<Hospital> hospitalList;
	List<HospitalResource> resourcesList;
	List<ResourceAverageDto> resourceAverageTest;

	@Before
	public void setUp() {
		HospitalResource res1, res2;
		res1 = new HospitalResource("Médico", 1);
		res2 = new HospitalResource("Enfermeiro", 2);

		//Resource list
		resourcesList = new ArrayList<>();
		resourcesList.add(res1);
		resourcesList.add(res2);

		//Hospital list
		hospitalList = new ArrayList<Hospital>();
		hospitalList.add(new Hospital(1L, "TestName1", "TestAddress1", "TestCnpj1", "TestLocalization1", 1F, resourcesList));
		hospitalList.add(new Hospital(2L, "TestName2", "TestAddress2", "TestCnpj2", "TestLocalization2", 99F, resourcesList));

		//Resource average
		resourceAverageTest = new ArrayList<>();
		resourceAverageTest.add(new ResourceAverageDto("Médico", 1));
		resourceAverageTest.add(new ResourceAverageDto("Enfermeiro", 2));
		resourceAverageTest.add(new ResourceAverageDto("Respirador", 0));
		resourceAverageTest.add(new ResourceAverageDto("Tomógrafo", 0));
		resourceAverageTest.add(new ResourceAverageDto("Ambulância", 0));

		reportService = new ReportService();
	}

	@Test
	public void testCalculateOccupancyPercentage() {
		float[] insert = {50F, 50F};
		float[] valueReturned = reportService.calculateOccupancyPercentage(hospitalList);
		assertArrayEquals(insert, valueReturned);
	}

	@Test
	public void testCalculateResourcesAverage() {
		List<ResourceAverageDto> valueReturned = reportService.calculateResourcesAverage(resourcesList, 1);
		for(int i = 0; i < valueReturned.size(); i++) {
			assertEquals(resourceAverageTest.get(i).getName(), valueReturned.get(i).getName());
			assertEquals(resourceAverageTest.get(i).getAverage(), valueReturned.get(i).getAverage());
		}
	}
}