package com.trainersiva.examples.core.threads;

public class ThreadSynchronizationIssues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
	
	/* Reduces the stock count in a synchronized way
	 * 
	 */
	
	public synchronized int buyStockSynchronized ()
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

