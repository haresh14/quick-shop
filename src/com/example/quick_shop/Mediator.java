package com.example.quick_shop;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author sebastian
 * Singleton Mediator (possible change to enum type). Responsible for dispatching various tasks
 * to other classes. Needs to keep a copy of the cart, as well as the counts for products in the ListViews.
 */
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