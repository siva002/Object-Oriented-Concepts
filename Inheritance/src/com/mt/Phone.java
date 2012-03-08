package com.mt;

public class Phone extends material{
	
	public String material_class;
	public String model_number;
	public String battery;
	public String connectivity;
	public String display;
	public float weight;
	
	public float calculate_freight()
	{
		return weight * 1.4f;
	}

}
