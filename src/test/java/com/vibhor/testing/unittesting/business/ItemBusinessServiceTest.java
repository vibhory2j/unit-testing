package com.vibhor.testing.unittesting.business;

import com.vibhor.testing.unittesting.data.ItemRepository;
import com.vibhor.testing.unittesting.modal.Item;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService business;
	
	@Mock
	private ItemRepository repository;
	
	@Test
	public void calculateSum_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Bat", 10, 10),
				new Item(3, "Bat", 20, 20)));
		List<Item> items = business.retrieveAllItems();
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
	}

}
