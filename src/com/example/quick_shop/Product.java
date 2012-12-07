package com.example.quick_shop;

/**
 * @author sebastian
 * Products only have names, as prices may differ from store to store.
 * Needs to override equals and hashCode for use in HashMaps, ArrayLists 
 * and other data structures.
 */
public class Product
{
	private String name;
	
	public Product(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Product))
			return false;
		Product prod = (Product) o;
		return prod.name.equals(name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
