package com.example.quick_shop;

import java.util.ArrayList;
import java.util.List;

public enum Category {	
	bread("Bread"), 
	milk("Milk"),
	pork("Pork"),
	eggs("Eggs");
	
	private String name;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	private Category (String name) {
		this.name = name;
	}
	
	public void addProduct(Product prod) {
		if (products.contains(prod))
			return;
		products.add(prod);
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public String getName() { 
		return name;
	}
}
