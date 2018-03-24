package com.terry.zipkindemo.model;

import java.util.List;

public class User {
	String name;
	String email;
	List<Item> itemList;
	
	public User() {}
	public User(String name,String email,List<Item> itemList) {
		this.name = name;
		this.email= email;
		this.itemList = itemList;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
