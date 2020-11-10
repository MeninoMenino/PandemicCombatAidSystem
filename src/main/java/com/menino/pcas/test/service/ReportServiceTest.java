package com.menino.pcas.test.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.menino.pcas.api.service.ReportService;
import com.menino.pcas.domain.model.Hospital;
import com.menino.pcas.domain.model.HospitalResource;

public class ReportServiceTest {

	ReportService reportService;
	List<Hospital> hospitalList;

	@Before
	public void setUp() {
		HospitalResource res1, res2;
		res1 = new HospitalResource("Resource 1", 1);
		res2 = new HospitalResource("Resource 2", 2);

		List<HospitalResource> resources = new ArrayList<>();
		resources.add(res1);
		resources.add(res2);

		hospitalList = new ArrayList<Hospital>();
		hospitalList.add(new Hospital(1L, "TestName1", "TestAddress1", "TestCnpj1", "TestLocalization1", 1F, resources));
		hospitalList.add(new Hospital(2L, "TestName2", "TestAddress2", "TestCnpj2", "TestLocalization2", 99F, resources));
	
		reportService = new ReportService();
	}

	@Test
	public void testCalculateOccupancyPercentage() {
		float[] insert = {50F, 50F};
		float[] valueReturned = reportService.calculateOccupancyPercentage(hospitalList);
		System.out.println(valueReturned[0]);
		System.out.println(valueReturned[1]);
		assertArrayEquals(insert, valueReturned);
	}
}