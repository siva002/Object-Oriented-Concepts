package com.trainersiva.examples.core.threads;

import com.trainersiva.examples.core.threads.ThreadName;

public class ThreadPriority {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadName priority = new ThreadName( );
		
		Thread t5 = new Thread (priority);
		Thread t6 = new Thread (priority);
	
		t5.setName("First");
		t6.setName("Second");
		
		t5.setPriority (10);
		t6.setPriority (1);
	
		t5.start();
		t6.start();

	}

}

