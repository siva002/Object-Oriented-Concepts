package com.mt;

public class laptop extends material {

	public String processor;
	public String model_number;
	public String hdd;
	public String connectivity;
	public String display;
	public float weight;
	
	public float calculate_freight()
	{
		return weight * 1.2f;
	}
	
}
