package com.vibhor.testing.unittesting.business;

import org.springframework.stereotype.Component;

import com.vibhor.testing.unittesting.modal.Item;

@Component
public class ItemBusinessService {

	public Item retrieveHardCodedtem() {
		// TODO Auto-generated method stub
		return new Item(2, "Bat", 2, 300);
	}

}
