package com.example.quick_shop;

import java.util.HashMap;

public class Store
{
	private String name;
	private HashMap<Product, Integer> prices;
	
	public Store(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
