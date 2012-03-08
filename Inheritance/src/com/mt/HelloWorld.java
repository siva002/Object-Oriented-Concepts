package com.mt;

public class HelloWorld {

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
		
		System.out.println ("The frieght per KG of this book is "+ Float.toString(b.calculate_freight()));
		System.out.println ("The frieght per KG of this Phone is "+ Float.toString(p.calculate_freight()));
		System.out.println ("The frieght per KG of this Laptop is "+ Float.toString(l.calculate_freight()));
		
		material m1 = new Book();
		m1.weight = 1.0f;
		
		material m2 = new Phone ();
		m2.weight = 1.0f;
		
		material m3 = new laptop ();
		m3.weight = 1.0f;
		
		System.out.println (m1.weight);
		System.out.println ("The frieght per KG of this book is "+ Float.toString(m1.calculate_freight()));
		System.out.println ("The frieght per KG of this Phone is "+ Float.toString(m2.calculate_freight()));
		System.out.println ("The frieght per KG of this Laptop is "+ Float.toString(m3.calculate_freight()));
		
		
	}

}
