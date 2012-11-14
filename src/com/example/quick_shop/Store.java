package com.example.quick_shop;

import java.util.HashMap;

public class Store
{
	private String name;
	private HashMap<Product, Integer> prices;
	
	public Store(String name) {
		this.name = name;
		prices = new HashMap<Product, Integer>();
	}
	
	public void addProduct(Product product, int price) {
		prices.put(product, price);
	}
	
	public String toString() {
		return name;
	}
}
