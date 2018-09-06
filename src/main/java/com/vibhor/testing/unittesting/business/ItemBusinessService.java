package com.vibhor.testing.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vibhor.testing.unittesting.data.ItemRepository;
import com.vibhor.testing.unittesting.modal.Item;

@Component
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item retrieveHardCodedtem() {
		// TODO Auto-generated method stub
		return new Item(2, "Bat", 2, 300);
	}
	
	public List<Item> retrieveAllItems() {
		
		List<Item> items = itemRepository.findAll();
		
		for(Item item : items) {
			item.setValue(item.getPrice()*item.getQuantity());
		}
		
		return items;
	}

}
