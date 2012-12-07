package com.example.quick_shop;

import java.util.HashMap;

public class Store
{
	private String name;
	private HashMap<Product, Integer> prices;
	private int[] resources;
	
	public Store(String name) {
		this.name = name;
		prices = new HashMap<Product, Integer>();
	}
	
	public void addProduct(Product product, int price) {
		prices.put(product, price);
	}

	public void setResources(int[] resources) {
		this.resources = resources;
	}
	
	public int[] getResources() {
		return resources;
	}
	
	public String toString() {
		return name;
	}
}
