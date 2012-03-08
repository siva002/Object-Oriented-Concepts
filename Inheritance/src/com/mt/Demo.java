package com.mt;

public class Demo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Instantiate a new Book Class
		Book b = new Book();
		b.weight = 1.0f;
		
		Phone p = new Phone ();
		p.weight = 1.0f;
		
		laptop l = new laptop ();
		l.weight = 1.0f;
		
		System.out.println ("The frieght per KG of this book is "+ b.calculate_freight() );
		System.out.println ("The frieght per KG of this Phone is "+ p.calculate_freight() );
		System.out.println ("The frieght per KG of this Laptop is "+ l.calculate_freight() );
		
		material m1 = new Book();
		m1.weight = 1.0f;
		
		material m2 = new Phone ();
		m2.weight = 1.0f;
		
		material m3 = new laptop ();
		m3.weight = 1.0f;
		
		System.out.println (m1.weight);
		System.out.println ("The frieght per KG of this book is "+ m1.calculate_freight() );
		System.out.println ("The frieght per KG of this Phone is "+ m2.calculate_freight() );
		System.out.println ("The frieght per KG of this Laptop is "+ m3.calculate_freight() );
		
		
	}


}
