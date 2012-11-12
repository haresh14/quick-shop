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
	
	public String getName()
	{
		return name;
	}
	
	public HashMap<Store, Integer> orderStores() {
		priceMap = new HashMap<Store, Integer>();
		
		for(Product p : shoppingList.keySet())
		{
			int amount = shoppingList.get(p);
			TreeMap<Integer, Store> map = p.getProdList();
			for(Integer s : map.keySet())
			{
				if (!priceMap.containsKey(map.get(s)))
					priceMap.put(map.get(s), amount * s);
				else priceMap.put(map.get(s), priceMap.get(map.get(s)) + amount * s);
			}
			
		}
		return priceMap;
	}
	
	public Pair<Store, Integer> cheapestStore()
	{
		int min = Integer.MAX_VALUE;
		Store minStore = null;
		
		HashMap<Store, Integer> list = this.orderStores();
		
		for(Store s: list.keySet())
		{
			if(list.get(s) < min)
			{
				min = list.get(s);
				minStore = s;
			}
		}
		
		return new Pair<Store, Integer>(minStore, min);
	}
	
	public void printProducts()
	{
		for(Product p : shoppingList.keySet())
			System.out.print(shoppingList.get(p) + " * " + p + " ");
		System.out.println();
	}
}
