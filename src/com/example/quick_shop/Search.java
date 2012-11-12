package com.example.quick_shop;

import java.util.ArrayList;
import java.util.List;

public class Search
{
	public static List<Product> inList(String str, List<Product> l)
	{
		ArrayList<Product> toReturn = new ArrayList<Product>();
		for(Product p : l)
		{
			if(p.getName().toUpperCase().contains(str.toUpperCase()))
				toReturn.add(p);
		}
		
		return toReturn;
	}
}
