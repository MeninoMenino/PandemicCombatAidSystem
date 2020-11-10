package com.menino.pcas.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({HospitalTest.class, HospitalResourceTest.class,
			   NegotiationTest.class, ResourcesTest.class})
public class ModelSuite {}