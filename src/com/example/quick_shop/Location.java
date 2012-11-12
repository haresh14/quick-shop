package com.example.quick_shop;

public class Location
{
	/** Radius of the Earth in miles */
	public static double R = 3959;
	
	public double lat;
	public double lon;
	
	public Location(double la, double lo)
	{
		lat = la;
		lon = lo;
	}
	
//	public static void main(String args[])
//	{
//		Location loc1 = new Location(23.16, 24.38);
//		Location loc2 = new Location(58.21, 28.20);
//		
//		loc1.getDistance(loc2);
//		Location.getDistance(new Location(23.16, 24.38), new Location(58.21, 28.20));
//	}
	
	public double getLat()
	{
		return lat;
	}
	
	public double getLon()
	{
		return lon;
	}
	
	public double getDistance(Location loc2)
	{
		return Location.getDistance(this, loc2);
	}
	
	public static double getDistance(Location loc1, Location loc2)
	{
		//Implementing the haversine formula to get distance.
		
		double lat1 = loc1.getLat()/180*Math.PI;
		double lon1 = loc1.getLon()/180*Math.PI;
		double lat2 = loc2.getLat()/180*Math.PI;
		double lon2 = loc2.getLon()/180*Math.PI;
		
		double dLat = (lat2 - lat1); //The difference of latitudes in radians
		double dLon = (lon2 - lon1); //Ditto, but longitudes
		
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		        Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		double dist = Location.R * c;
		
		System.out.println("The distance between the locations is: " + dist);
		return Math.abs(dist);
	}
}