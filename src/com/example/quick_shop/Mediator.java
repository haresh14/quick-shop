package com.example.quick_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Mediator {

	private ShoppingCart cart;
	private int[] counts;
	
	private static Mediator singleInstance = null;
	
	private Mediator() {
		instantiateCart();
	}
	
	public static Mediator getInstance() {
		if (singleInstance == null) 
			singleInstance = new Mediator();
		return singleInstance;
	}
	
	public void instantiateCart() {
		cart = new ShoppingCart("Cart");
	}
	
	public void add(Product product) {
		cart.addProduct(product);
	}
	
	public void add(Product product, int number) {
		cart.addProduct(product, number);
	}
	
	public void remove(Product product) {
		cart.removeProduct(product);
	}
	
	public void remove(Product product, int number) {
		cart.decreaseAmount(product, number);
	}
	
	public void set(Product prod, int index) {
		System.out.println("Set product " + prod.getName() + " to " + counts[index]);
		cart.setAmount(prod, counts[index]);
	}
	
	public void setCount(int[] counts) {
		this.counts = counts;
	}
	
	public Integer[] getCounts() {
		ArrayList<Integer> ccs = new ArrayList<Integer>();
		for (int i = 0; i < counts.length; ++i)
			if (counts[i] > 0)
				ccs.add(counts[i]);
		Integer[] retcounts = new Integer[ccs.size()]; 
		return ccs.toArray(retcounts);
	}
	
	public List<Product> getProducts() {
		ArrayList<Product> list = new ArrayList<Product>();
		int i = 0;
		for (Product prod : cart.getProducts()) {
			if (counts[i++] > 0)
				list.add(prod);
		}
		
		return list;
	}
}