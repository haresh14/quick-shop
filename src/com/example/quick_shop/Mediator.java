package com.example.quick_shop;

import java.util.Collection;
import java.util.Set;

public class Mediator {

	private ShoppingCart cart;
	private int[] counts;
	
	private static Mediator singleInstance = null;
	
	private Mediator() {
		cart = ShoppingCart.CART;
	}
	
	public static Mediator getInstance() {
		if (singleInstance == null) 
			singleInstance = new Mediator();
		return singleInstance;
	}
	
	public void set(Product prod, int index) {
		if (counts[index] > 0)
			cart.addProduct(prod, counts[index]);
	}
	
	public void setCount(int[] counts) {
		this.counts = counts;
	}
	
	public Collection<Integer> getCount() {
		return cart.getCount();
	}
	
	public Set<Product> getProducts() {
		return cart.getProducts();
	}
}