package com.example.quick_shop;

import java.io.Serializable;

public class Store implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7142914301630027254L;
	private String name;
	private Location loc;
	
	public Store(String name, Location loc) {
		this.loc = loc;
		this.name = name;
	}
	
	public Store(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public double getDistance(Location myLoc) {
		return Location.getDistance(myLoc, loc);
	}
	
	public String toString() {
		return name;
	}
}
