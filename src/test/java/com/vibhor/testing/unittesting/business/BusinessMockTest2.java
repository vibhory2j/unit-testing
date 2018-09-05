package com.vibhor.testing.unittesting.business;

import com.vibhor.testing.unittesting.data.DataService;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusinessMockTest2 {
	
	@InjectMocks
	BusinessImpl business;
	
	@Mock
	DataService dataServiceMock;

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
