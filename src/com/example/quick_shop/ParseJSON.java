package com.example.quick_shop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON
{
	
	public static void getProducts(InputStream fpath, Store store, Category cat)
	{
		//Read the input file
		String source = "";
		try
		{
			source = readFile(fpath);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
		
		//Write the string to a JSONObject
		JSONObject json;
		try
		{
			json = new JSONObject(source);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return;
		}
		
		
		//Create a JSONArray of results
		JSONArray results = null;
		
		try {
			results = (JSONArray) json.get("results");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Add products to the category, and then add stores/prices to products.
		try {
			JSONObject o = null;
			for(int i = 0; i < results.length(); i++)
			{
				o = (JSONObject) results.get(i);
				//System.out.println(o.get("consumer_product/topic:name") + " " + (int) ((Double) o.get("consumer_product/msrp/amount")*100));
				String name = (String) o.get("consumer_product/topic:name");
				name = normaliseBreadName(name);
				Product prod = new Product(name);
				cat.addProduct(prod); //add prod
				String symbol = "";
				try
				{
					symbol = (String) o.get("consumer_product/msrp/currency/prefix_symbol");
				}
				catch (JSONException e) {}
				int amount = 0;
				if(symbol.contains("£")) {
					if (o.get("consumer_product/msrp/amount") instanceof Double)
						amount = new Double(((Double) o.get("consumer_product/msrp/amount")) * 100).intValue();
					if (o.get("consumer_product/msrp/amount") instanceof Integer)
						amount =((Integer) o.get("consumer_product/msrp/amount")) * 100;
				} else
					amount = (Integer)o.get("consumer_product/msrp/amount");
					
				cat.getProduct(prod.getName()).addItem(store, amount); //add store/price pair to prod
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Print out the category's contents
		for(Product p : cat.getProducts())
			try{
			System.out.println(p.getName() + " " + p.getCheapest().getFirst() + " " + p.getCheapest().getSecond());
			} catch(NoSuchElementException ex){}
	}
	
	private static String normaliseBreadName(String name)
	{
		String newname = name.toLowerCase();
		if(newname.contains("0g"))
		{
			String nameStuff[] = newname.split("0g");
			//System.out.println(nameStuff[0] + "0G");
			newname = nameStuff[0] + "0g";
		}
		newname = capitalizeString(newname);
		return newname;
	}
	
	private static String readFile(InputStream filePath) throws java.io.IOException
	{
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new InputStreamReader(filePath));
		char[] buf = new char[1024];
		int numRead=0;
		while((numRead=reader.read(buf)) != -1)
		{
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}
	
	public static String capitalizeString(String string)
	{
		  char[] chars = string.toLowerCase().toCharArray();
		  boolean found = false;
		  for (int i = 0; i < chars.length; i++)
		  {
		    if (!found && Character.isLetter(chars[i]))
		    {
		      chars[i] = Character.toUpperCase(chars[i]);
		      found = true;
		    }
		    else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'')
		    {
		      found = false;
		    }
		  }
		  return String.valueOf(chars);
	}
}
