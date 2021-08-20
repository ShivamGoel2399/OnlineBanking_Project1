package com.app.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.service.Customerservice;
import com.app.service.impl.Customerserviceimpl;

class CustomerserviceimplTest {
	
	public static Customerservice customerservice;
	
	@BeforeAll
	 public static void setupCustomerservice() {
		customerservice=new Customerserviceimpl();
	}

	/*
	 * @Test void testRegistercustomer() { fail("Not yet implemented"); }
	 */

	@Test
	void testGetpasswordbycustomeridforValidity() {
		try {
			assertEquals("asdfg", customerservice.getpasswordbycustomerid(100005));
		} catch (BusinessException e) {
			fail("testcase for get password by id check equals is failed");
		}
		
	}
	
	@Test
	void testGetpasswordbycustomeridforValid() {
		try {
			assertTrue("asdfg".equals( customerservice.getpasswordbycustomerid(100005)));
		} catch (BusinessException e) {
			fail("testcase for get password by id true is failed");
		}
		
	}
	
	@Test
	void testGetpasswordbycustomeridforInValid() {
		try {
			assertFalse("asdfg".equals( customerservice.getpasswordbycustomerid(100007)));
		} catch (BusinessException e) {
			fail("testcase for get password by id false is failed");
		}
		
	}
	
	@Test
	void testGetcustomeridforValidity() {
		try {
			assertEquals(100005, customerservice.getcustomerid(100005));
		} catch (BusinessException e) {
			fail("testcase for get id check equals is failed");
		}
	}
	
	@Test
	void testGetcustomeridforValid() {
		try {
			assertTrue(100005==customerservice.getcustomerid(100005));
		} catch (BusinessException e) {
			fail("testcase for get id check equals is failed");
		}
	}
	
	/*
	 * @Test void testCreateAccount() { fail("Not yet implemented"); }
	 * 
	 *
	 * 
	 * @Test void testGetaccountno() { fail("Not yet implemented"); }
	 * 
	 * @Test void testCheckbalancebyaccountno() { fail("Not yet implemented"); }
	 * 
	 * @Test void testWithdraw() { fail("Not yet implemented"); }
	 * 
	 * @Test void testGetcustomernamebyaccountno() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDeposit() { fail("Not yet implemented"); }
	 */

}
