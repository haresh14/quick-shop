package com.example.quick_shop;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * @author sebastian
 * There is only one shopping cart at any instant in time. A singleton
 * pattern just seemed to be the easiest way to ensure that, and an enum
 * enforces noninstantiability.
 */
public enum ShoppingCart {
	CART;
	
	// Product and amount to buy
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
