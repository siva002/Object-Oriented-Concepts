package com.mt;

import java.util.*;

public class DateExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Explain the use of getInstance() method in the abstract class Calendar
		 */
		
		Date date1 = Calendar.getInstance().getTime();
		System.out.println( date1);
		
		/*
		 * Add a day to the Calendar Object using add function
		 */
		
		Calendar cal = Calendar.getInstance();

		/*
		 * Prints out the full Calendar Object
		 */
		
		System.out.println(cal);

		// Get the current day of the month - For example, 18th march 2012 would be 18
		System.out.println( " day is " + cal.get(Calendar.DAY_OF_MONTH));
		
		// Set the Calendar to tomorrow.
		cal.add(Calendar.DAY_OF_MONTH,1);
		System.out.println( " day is " + cal.get(Calendar.DAY_OF_MONTH));		
		
		// What would be the day, 1 year from now ?
		System.out.println( "Today's DAY is " + cal.get (Calendar.DAY_OF_WEEK));
		cal.add(Calendar.YEAR , 1);
		System.out.println("This day next year would be a " + cal.get (Calendar.DAY_OF_WEEK)  );
		System.out.println(" And next year is " + cal.get(Calendar.YEAR));
		

	}

}
