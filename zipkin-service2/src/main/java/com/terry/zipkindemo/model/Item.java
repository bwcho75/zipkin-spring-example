package com.terry.zipkindemo.model;

public class Item {
	String name;
	int quantity;
	
	public Item(String name,int quantity) {
		this.name = name;
		this.quantity= quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
