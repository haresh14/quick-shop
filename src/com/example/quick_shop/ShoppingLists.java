package com.example.quick_shop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class ShoppingLists
{
	public static ArrayList<ShoppingCart> shoppingLists = new ArrayList<ShoppingCart>();
	
	public static void save(File f)
	{
		try
		{
		    OutputStream file = new FileOutputStream(f);
		    OutputStream buffer = new BufferedOutputStream(file);
		    ObjectOutput output = new ObjectOutputStream(buffer);
		    try
		    {
		    	output.writeObject(shoppingLists);
		    }
		    finally
		    {
		    	output.close();
		    }
		}  
		    catch(IOException ex)
		    {
		      System.err.println("Saving failed because of reasons.");
		      ex.printStackTrace();
		    }
	}
	
	@SuppressWarnings("unchecked") //lol warnings, who needs those?
	public static void load(File f)
	{
	    try
	    {
	        InputStream file = new FileInputStream(f);
	        InputStream buffer = new BufferedInputStream( file );
	        ObjectInput input = new ObjectInputStream ( buffer );
	        try
	        {
	        	shoppingLists = (ArrayList<ShoppingCart>)input.readObject();
	        }
	        finally
	        {
	          input.close();
	        }
	      }
	      catch(ClassNotFoundException ex)
	      {
	    	  System.err.println("Loading failed because of reasons.");
	      }
	      catch(IOException ex)
	      {
	    	  System.err.println("Loading failed because of reasons.");
	      }
	}

	
	public static void add(ShoppingCart c)
	{
		shoppingLists.add(c);
	}
	
	public static void remove(ShoppingCart c)
	{
		shoppingLists.remove(c);
	}
	
	public static void clear()
	{
		shoppingLists = new ArrayList<ShoppingCart>();
	}
	
	public static ShoppingCart get(int index)
	{
		return shoppingLists.get(index);
	}
}
