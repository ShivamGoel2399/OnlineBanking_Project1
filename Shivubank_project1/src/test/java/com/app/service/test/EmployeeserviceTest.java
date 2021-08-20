package com.app.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.service.Employeeservice;
import com.app.service.impl.Employeeserviceimpl;

class EmployeeserviceTest {
	
	public static Employeeservice employeeservice;

	@BeforeAll
	public static void setupEmployeeservice() {
		employeeservice = new Employeeserviceimpl();

	}

	@Test
	void testGetPasswordByemployeeIdforValid() {

		try {
			assertTrue("admin123".equals(employeeservice.getPasswordByemployeeId(500000)));
		} catch (BusinessException e) {
			fail("testcase 1 fails");
		}

	}
	@Test
	void testGetPasswordByemployeeIdforInValid() {

		try {
			assertFalse("admin121".equals(employeeservice.getPasswordByemployeeId(500000)));
		} catch (BusinessException e) {
			fail("testcase 2 fails");
		}

	}

	@Test
	void testGetemployeeidforValid() {
		try {
			long id = 500000;
			assertTrue(500000 == employeeservice.getemployeeid(id));
		} catch (BusinessException e) {
			fail("Not yet implemented");
		}
	}
	
	@Test
	void testGetemployeeidforInValid() {
		try {
			long id = 500001;
			assertFalse(500000 == employeeservice.getemployeeid(id));
		} catch (BusinessException e) {
			fail("Not yet implemented");
		}
	}

}
