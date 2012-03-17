package com.mt;

import java.io.*;

public class Serialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		apple app1 = new apple();
		app1.color = "Red";
		app1.type = "Red Delicious";
		
		
		try {
			
			FileOutputStream fos = new FileOutputStream("/Users/workshop/app1.dat");
			ObjectOutputStream os = new ObjectOutputStream (fos);
			os.writeObject(app1);
			System.out.println (" Apple Object wrote to the file app1.dat" );
			os.close();
			
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		}
		
	/* Look at the content of the file. 
	 * It will contain some characters that will not make sense. 
	 * Now, let's try to read it back. 
	 */
		
		apple app2 = new apple(); 
		
		try {
			FileInputStream fis = new FileInputStream ("/Users/workshop/app1.dat");
			ObjectInputStream is = new ObjectInputStream (fis);
			
			/* If you try to read the object, it will give you an error saying 
			 * "Cannot convert from object to apple. 
			 * apple app2 = is.readObject();
			 * So, cast the object into an apple as follows
			 */
			app2 = (apple)is.readObject();
			System.out.println(" Read the apple object back");
			
			/* Print out the values in the apple object and see if they are correct
			 * 
			 */
			
			System.out.println( " The color of the apple is " + app2.color + 
					" and the type of the apple is " + app2.type );
			
			
		} catch ( Exception e)
		{
			e.printStackTrace();
		}
		
	/*
	 * What is you want to serialize more than one object, say 10 objects
	 * Can you do that to a single file ?  - YES
	 * Let's see it now
	 */
		
		app1.color = "Red";
		app1.type = "Red Delicious";
		
		app2.color = "Green";
		app2.type = "Granny Smith";
		
		try {
			
			FileOutputStream fos = new FileOutputStream ("/Users/workshop/apples.dat");
			ObjectOutputStream os = new ObjectOutputStream ( fos ) ;
			os.writeObject ( app1 ) ;
			os.writeObject ( app2 ) ;
			
			System.out.println( " Apple 1 and Apple 2 written to apples.dat file " );
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			
			FileInputStream fis = new FileInputStream ("/Users/workshop/apples.dat");
			ObjectInputStream os = new ObjectInputStream ( fis ) ;
			
			apple temp ;
			while ( ( temp = (apple) os.readObject() )  != null )
			{
				
				System.out.println( " The color of the apple is " + temp.color + 
						" and the type of the apple is " + temp.type );
			}

		} catch (EOFException eof)
		{
			System.out.println( " The file has been fully read" );
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		/*
		 * What if there is a static variable/method in your class ? 
		 * Can you serialize it ? 
		 * Let's see it in action. We have defined a new apple_static class with a 
		 * static variable - shape - remember the shape of all apples is always round
		 */
		
		// Serializing apple_static
		
		apple_static as = new apple_static ();
		as.color = "Red";
		as.type = "Red Delicious";
		
		// Look at the way in which we are setting the static variable's value
		// without using the object - but rather using the class.
		apple_static.shape = "Round";
		try {
			
			FileOutputStream fos = new FileOutputStream("/Users/workshop/app_static.dat");
			ObjectOutputStream os = new ObjectOutputStream (fos);
			os.writeObject(as);
			System.out.println (" Apple Object wrote to the file app_static.dat" );
			os.close();
			
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		}
		
		// Deserializing apple_static
		
		apple_static as2 = new apple_static(); 
		apple_static.shape = "Not so Round anymore";
		
		try {
			FileInputStream fis = new FileInputStream ("/Users/workshop/app_static.dat");
			ObjectInputStream is = new ObjectInputStream (fis);
			
			/* If you try to read the object, it will give you an error saying 
			 * "Cannot convert from object to apple. 
			 * apple app2 = is.readObject();
			 * So, cast the object into an apple as follows
			 */
			as2 = (apple_static)is.readObject();
			System.out.println(" Read the static apple object back");
			
			/* Print out the values in the apple object and see if they are correct
			 * 
			 */
			
			System.out.println( " The color of the apple is " + as2.color + 
					" and the type of the apple is " + as2.type + 
					" and the shape of the apple is " + as2.shape );
			
			
		} catch ( Exception e)
		{
			e.printStackTrace();
		}
		
		/*
		 * What's the result ? The value of the shape parameter is 'Not so Round anymore'. Isn't it  ?
		 * Explain the reason why to the Java Training students
		 */
		
		/*
		 * Use of the keyword 'transient'
		 * Go to the apple_transient class and explain why you would want to use
		 * the transient keyword . Here is the example.
		 */
		apple_transient at = new apple_transient ();
		at.color = "Red";
		at.type = "Red Delicious";
		try {
			
			FileOutputStream fos = new FileOutputStream("/Users/workshop/app_transient.dat");
			ObjectOutputStream os = new ObjectOutputStream (fos);
			os.writeObject(at);
			System.out.println (" Apple Object wrote to the file app_transient.dat" );
			os.close();
			
			// Read the Object back and see what is the value of the transient variable
			
			FileInputStream fis = new FileInputStream ("/Users/workshop/app_transient.dat");
			ObjectInputStream is = new ObjectInputStream (fis);
			
			at = (apple_transient)is.readObject();
			System.out.println(" Read the transient apple object back");
			
			System.out.println( " The color of the apple is " + at.color + 
					" and the type of the apple is " + at.type );
			
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		}
		


		
	}

}

/* The class that you wish to serialize SHOULD implement Serializable interface
 * If a superclass implements Serializable, then you do NOT need to 
 * implement it again.
 */
class apple implements Serializable {
	
	public String color ; 
	public String type ;
	
}

class apple_static implements Serializable {
	
	public String color ; 
	public String type ;
	public static String shape;
	
}

class apple_transient implements Serializable {
	
	/* 
	 * Let's say the color of the apple could change and it doesnt 
	 * really make any sense to serialize it. 
	 * A more realistic example is OS/Network resources like
	 * 1. FileHandlers
	 * 2. Network Socket Connections
	 * etc..
	 * So, if you mark the variable as 'transient' , Java does NOT serialize it. 
	 * When it brings back ( de-serializes it ), it brings a null value for transient variables
	 */
	
	public transient String color ; 
	public String type ;
	
}

class grape_apple implements Serializable {
	
	public String color ; 
	public String type ;
	
	/*
	 * Any classes that are referenced in a class that is meant to be serializable 
	 * should be serializable as well. 
	 * So, in this case, grape should implement Serializable as well
	 * If you don't do it, it will throw a java.io.NotSerializableException
	 * 
	 * Also, apple, refers to the grape object, grape can refer to another object.
	 * This way of one object referring another is called 'Object Graph' in Java
	 * This is used by JVM for GC and other system activities.
	 * If any object referred in the current class ( NOT inherited, just referred )
	 * then, ALL of them should have implemented Serializable. 
	 * If not, make them transient. Otherwise you get the java.io.NotSerializableException
	 */
	
	public grape  gr;
	
}

class grape implements Serializable {
	
	public String color ; 
	public String type ;

	
}

class apple_fruit extends fruit implements Serializable {
	
	 /* If a class apple extends a generic class 'fruit' which did not implement Serializable
	  * thats not a problem.
	  */
	
	public String color ; 
	public String type ;
	
}

class fruit  {
	
	public String tropic ; 
	public String edible ;

	
}
