package com.example.quick_shop;

import java.util.ArrayList;
import java.util.Collection;

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
	
	public ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		for (Product prod : cart.getProducts())
			products.add(prod);
		return products;
	}
	
	public void clear() {
		cart.clear();
	}
}