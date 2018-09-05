package com.vibhor.testing.unittesting.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {

	@Id
	int id;
	String name;
	int price;
	int quantity;

	@Transient
	private int value;
	
	public Item(int i, String string, int j, int k) {
		this.id = i;
		this.name = string;
		this.price = j;
		this.quantity = k;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
	}
}
