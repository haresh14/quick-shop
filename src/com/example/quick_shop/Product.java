package com.example.quick_shop;

public class Product
{
	private String name;
	
	public Product(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Product))
			return false;
		Product prod = (Product) o;
		return prod.name.equals(name);
	}
}
