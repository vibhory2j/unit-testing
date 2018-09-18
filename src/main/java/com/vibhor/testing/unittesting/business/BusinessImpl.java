package com.vibhor.testing.unittesting.business;

import com.vibhor.testing.unittesting.data.DataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class BusinessImpl {
	
	private DataService dataService;

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		
		for(int value: data) {
			sum += value;
		}
		
		return sum;
	}

	public int calculateSum_functional(int[] data) {
		//1,2,3,4 => 1+2+3+4
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = dataService.retrieveAllData();
		
		for(int value: data) {
			sum += value;
		}
		
		return sum;
	}
}
