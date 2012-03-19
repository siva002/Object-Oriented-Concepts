package com.trainersiva.examples.core.threads;


public class ThreadNames {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadName noname = new ThreadName( );
		
		Thread t3 = new Thread (noname);
		Thread t4 = new Thread (noname);
	
		t3.setName("Morgan");
		t4.setName("Stanley");
		
		t3.start();
		t4.start();

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
