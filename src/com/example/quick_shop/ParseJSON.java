package com.example.quick_shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON
{	
	public static void getProducts(InputStream fpath, Store store, Category category) {
		//Read the input file
		String source = ParseJSON.readFile(fpath);
		
		JSONObject json;
		try {
			json = new JSONObject(source);
		}
		catch (JSONException e) {
			e.printStackTrace();
			return;
		}
		
		JSONArray results = null;
		try {
			results = (JSONArray) json.get("results");
		} catch (JSONException e) {
			System.out.println("Something went wrong parsing JSON");
			e.printStackTrace();
		}
		
		try {
			JSONObject o = null;
			for(int i = 0; i < results.length(); i++) {
				o = (JSONObject) results.get(i);
				String name = (String) o.get("consumer_product/topic:name");
				Product product = new Product(name);
				category.addProduct(product);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			System.out.println("Something went wrong parsing JSON");
		}
	}
	
	private static String readFile(InputStream in) {
		String line = null;
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		try {
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
		} catch(IOException e) {
			System.out.println("Something went wrong while reading");
			e.printStackTrace();
		}
		return buffer.toString();
	}
}
