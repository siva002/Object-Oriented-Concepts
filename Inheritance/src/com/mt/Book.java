package com.mt;
public class Book extends material{
	
	public String author;
	public String genre;
	public String isbn_number;
	public String publisher;
	public String language;
	public float weight;
	
	public float calculate_freight()
	{
		return weight * 1.8f;
	}
	
	public float getNet_price ()
	{
		float net_price = 200.00f;
		System.out.println ("The value of the local variable net_price is " + Float.toString (net_price));

		return net_price;
	}
	
	Book( String material_number, String description, String publisher)
	{
		this.material_number = material_number;
		this.description = description;
		this.publisher = publisher;
	}

	Book ()
	{
		
	}
	

}