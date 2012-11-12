package com.example.quick_shop;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	public static Category bread;
	public static Category milk;
	public static Category pork;
	public static Category eggs;
	
	private String name;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public static void instantiate() {
		bread = new Category("Bread");
		milk = new Category("Milk");
		pork = new Category("Pork");
		eggs = new Category("Eggs");
	}
	
	private Category (String name)
	{
		this.name = name;
	}
	
	public void addProduct(Product prod) {
		if (products.contains(prod))
			return;
		products.add(prod);
	}
	
		public Product getProduct(String name)
	{
		for(Product p : products)
		{
			if(p.getName().toUpperCase().equals(name.toUpperCase()))
				return p;
		}
		System.err.println("No object found");
		return null;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public String getName() { return name;}
}
