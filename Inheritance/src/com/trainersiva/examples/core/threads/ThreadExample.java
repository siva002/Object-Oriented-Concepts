package com.trainersiva.examples.core.threads;

public class ThreadExample {


	public static void main(String[] args) {
		
		StartTalking john = new StartTalking( "John" );
		
		StartTalking mary = new StartTalking( "Mary" );
		
//		john.start(); 
//		mary.start();
		
		/*
		 * Observe the way in which john objects works independently from 
		 * the mary object.
		 */
		
		/*
		 * Another way to implement the thread class - via implementing Runnable Interface
		 * Explain the advantages with this approach - over extending the Thread Class
		 */

		StartTalking adam = new StartTalking( "Adam" );
		StartTalking eve = new StartTalking( "Eve" );
		
		Thread t1 = new Thread (adam);
		Thread t2 = new Thread (eve);
	
//		t1.start();
//		t2.start();
		
		/*
		 * Lets give threads names this time , instead of using a constructor or objects
		 */
		
		
		ThreadName noname = new ThreadName( );
		
		Thread t3 = new Thread (noname);
		Thread t4 = new Thread (noname);
	
		t3.setName("Morgan");
		t4.setName("Stanley");
		
//		t3.start();
//		t4.start();
		
		
		/*
		 *  Threads also have priority. Let's see how to set thread priority
		 *  This is very difficult to observe in normal case.
		 */
		
		ThreadName priority = new ThreadName( );
		
		Thread t5 = new Thread (priority);
		Thread t6 = new Thread (priority);
	
		t5.setName("First");
		t6.setName("Second");
		
		t5.setPriority (10);
		t6.setPriority (1);
		
//		t5.start();
//		t6.start();
		
		/*
		 * Experiment with Thread Synchronization issues. Explain this scenario to the 
		 * Java Training students
		 */
		
		stock st = new stock();
		st.count = 100;
		
		cust customer = new cust ();
		vend vendor = new vend ();
		
		Thread t7 = new Thread (customer);
		Thread t8 = new Thread (vendor);
		Thread t9 = new Thread (customer);
		
		t7.start ();
		t8.start ();
		t9.start ();
		
		
		

		

	}

}

class cust implements Runnable {
	
	public void run ()
	{
		buy ();
	}
	
	public void buy ()
	{
		
		stock st = new stock ();
		
		while ( true )
		{
			
			
			int count = st.getStock() ; 
			
			try {
				
				Thread.sleep(2000);					
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
			if  ( count != st.getStock())
			{
				
				System.out.println( " Customer thought the stock is " + count + " But actual stock is " + st.getStock () + "-- BAD BAD Customer Reviews" );
			}
			else
			{
				System.out.println( " Customer thought the stock is " + count + " And actual stock is " + st.getStock () + "-- GOOD GOOD Customer Reviews" );
				st.count = count - 1 ;
			}
		}
		
		
	}

	
	
}


class vend implements Runnable {
	
	public void run ()
	{
		sell ();
	}
	
	public void sell ()
	{
		
		stock st = new stock ();
		
		while ( true )
		{
			
			
			if ( st.count < 50)
			{
				st.putStock();
				
				if (st.count < 1)
				{
					System.out.println( " Stock count went to 0.");
				}
			}
			
			try {
				
				Thread.sleep(2000);					
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}

	
	
}

class stock {
	
	public static int count;
	
	
	/*
	 * Returns the stock count if stock 
	 */

	
	public int getStock ()
	{
		
		return count;
		
	}
	
	/* Reduces the stock count
	 * 
	 */
	
	public int buyStock ()
	{
		
		count = count -1;
		return count;
		
	}
	
	/* 
	 * Increase the stock count
	 */
	
	public int putStock()
	{
		
		count = count + 1;
		
		return count;
	}
	
	
	
}

class ThreadName implements Runnable {
	
	public void run()
	{
		talk();
	}
	
	public void talk ()
	{
		
		for ( int i = 0 ; i < 100 ; i ++)
		{

			try {
				
				System.out.println("My name is " + Thread.currentThread().getName());
				Thread.sleep(2000);					
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}

		
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
