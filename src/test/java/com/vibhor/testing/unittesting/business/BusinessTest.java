package com.vibhor.testing.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class BusinessTest {

	@Test
	public void calculateSum_basic() {
		BusinessImpl business = new BusinessImpl();
		int actualResult = business.calculateSum(new int[] {1,2,3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

}
