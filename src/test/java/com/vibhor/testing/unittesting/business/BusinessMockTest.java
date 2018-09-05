package com.vibhor.testing.unittesting.business;

import com.vibhor.testing.unittesting.data.DataService;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BusinessMockTest {
	
	BusinessImpl business = new BusinessImpl();
	DataService dataServiceMock = mock(DataService.class);
	
	@Before
	public void before() {
		business.setDataService(dataServiceMock);
	}

	@Test
	public void calculateSum_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3,4});
		assertEquals(10, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSum_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSum_one() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1});
		assertEquals(1, business.calculateSumUsingDataService());
	}

}
