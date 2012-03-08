package com.mt;

public abstract class material {
	
	public String material_number;
	public String description;
	private float price;
	private float discount;
	private float net_price;
	public float weight;
	public String avg_customer_review;
	public String dimensions;
	
	public abstract float calculate_freight ();


}
