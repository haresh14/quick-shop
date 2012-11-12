package com.example.quick_shop;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;


public class ShoppingCart implements Serializable
{
	private static final long serialVersionUID = -4127131424232845615L;
	private HashMap<Product, Integer> shoppingList; 
	private String name;
	private HashMap<Store, Integer> priceMap;
	
	public ShoppingCart(String name) {
		this.name = name;
		shoppingList = new HashMap<Product, Integer>();
	}
	
	public void addProduct(Product prod) {
		addProduct(prod, 1);
	}
	
	public void addProduct(Product prod, int number) {
		if (!shoppingList.containsKey(prod))
			shoppingList.put(prod, number);
		else shoppingList.put(prod, shoppingList.get(prod) + number);
	}
	
	public void removeProduct(Product prod) {
		shoppingList.remove(prod);
	}
	
	public Set<Product> getProducts() {
		return shoppingList.keySet();
	}
	
	public void decreaseAmount(Product prod, int number) {
		if (!shoppingList.containsKey(prod))
			throw new IllegalArgumentException("Product not part of the shopping list.");
		else if (shoppingList.get(prod) > number)
			shoppingList.put(prod, shoppingList.get(prod) - number);
		else removeProduct(prod);
	}

	public void setAmount(Product prod, int number) {
		shoppingList.put(prod, number);
	}
	
	public String toString() {
		return name;
	}
}
