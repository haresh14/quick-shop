package com.example.quick_shop;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public enum ShoppingCart {
	CART;
	
	private HashMap<Product, Integer> products;
	
	private ShoppingCart() {
		products = new HashMap<Product, Integer>();
	}
	
	public void addProduct(Product product, int amount) {
		products.put(product, amount);
	}
	
	public void clear() {
		products.clear();
	}
	
	public Set<Product> getProducts() {
		return products.keySet();
	}
	
	public Collection<Integer> getCount() {
		return products.values();
	}
}
