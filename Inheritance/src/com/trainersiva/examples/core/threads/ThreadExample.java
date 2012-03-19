package com.trainersiva.examples.core.threads;

public class ThreadExample {


	public static void main(String[] args) {
		
		StartTalking john = new StartTalking( "John" );		
		StartTalking mary = new StartTalking( "Mary" );
		
		john.start(); 
		mary.start();
		
		/*
		 * Observe the way in which john objects works independently from 
		 * the mary object.
		 */
		
		/*
		 * Another way to implement the thread class - via implementing Runnable Interface
		 * Explain the advantages with this approach - over extending the Thread Class
		 */

		StartTalkingRunnable adam = new StartTalkingRunnable( "Adam" );
		StartTalkingRunnable eve = new StartTalkingRunnable( "Eve" );
		
		Thread t1 = new Thread (adam);
		Thread t2 = new Thread (eve);
	
		t1.start();
		t2.start();
		

	}

}


class StartTalkingRunnable implements Runnable {

	
	String name ;
	
	StartTalkingRunnable ( String name)
	{
		this.name = name;
	}
	
	public void run()
	{
		talk();
	}
	
	public void talk ()
	{
		
		for ( int i = 0 ; i < 100 ; i ++)
		{

			try {
				
				System.out.println("My name is " + this.name);
				Thread.sleep(2000);					
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}

		
	}
}

class StartTalking  extends Thread {
	
	
	String name ;
	
	StartTalking ( String name)
	{
		this.name = name;
	}
	
	public void talk ()
	{
		
		for ( int i = 0 ; i < 100 ; i ++)
		{

			try {
				
				System.out.println("My name is " + this.name);
				Thread.sleep(3000);					
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}

		
	}
	
	public void run () 
	{
		talk ();
	}
	
}
