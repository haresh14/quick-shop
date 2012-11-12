package com.example.quick_shop;

import java.io.File;
import java.io.Serializable;
import java.util.TreeMap;


public class Product implements Serializable
{
	private static final long serialVersionUID = -3614099822019757625L;
	private String name;
	private TreeMap<Integer, Store>	 productList;
	private File picture; 
	
	public Product(String name, String path)
	{
		this.name = name;
		this.picture = new File (path);
		productList = new TreeMap<Integer, Store>();
	}
	
	public Product(String name)
	{
		this.name = name;
		productList = new TreeMap<Integer, Store>();
	}
	
	public String getName()
	{ 
		return name;
	}
	
	public File getPicture()
	{ 
		return picture; 
	}
	
	public void addItem(Store store, int price)
	{
		productList.put(price, store);
	}
	
	public TreeMap<Integer, Store> getProdList()
	{
		return productList;
	}
	
	public Pair<Store, Integer> getCheapest()
	{
		int minimum = productList.firstKey();
		return new Pair<Store, Integer>(productList.get(minimum), minimum);
	}
	
	public String toString()
	{
		return name;
	}
}
