package com.vibhor.testing.unittesting.business;

import com.vibhor.testing.unittesting.data.DataService;

import static org.junit.Assert.*;

import org.junit.Test;

class DataServiceStub implements DataService {
	
	@Override
	public int[] retrieveAllData() {
		
		return new int[] {1,2,3,4};
	}
}

public class BusinessStubTest {
	@Test
	public void calculateSum_basic() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 10;
		assertEquals(expectedResult, actualResult);
	}
}
