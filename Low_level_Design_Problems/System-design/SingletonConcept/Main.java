package SingletonPractise;

public class Main {
	public static void main(String args[]) {
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();
		Singleton z = Singleton.getInstance();
		
		x.str = (x.str).toUpperCase();
		
		System.out.println("String from x is " + x.str); 
        System.out.println("String from y is " + y.str); 
        System.out.println("String from z is " + z.str); 
        System.out.println("\n"); 
        
        z.str = (z.str).toLowerCase();
        
        System.out.println("String from x is " + x.str); 
        System.out.println("String from y is " + y.str); 
        System.out.println("String from z is " + z.str); 
        System.out.println("\n"); 
	}
}

/*
OUTPUT
String from x is HELLO I AM A STRING PART OF SINGLETON CLASS
String from y is HELLO I AM A STRING PART OF SINGLETON CLASS
String from z is HELLO I AM A STRING PART OF SINGLETON CLASS


String from x is hello i am a string part of singleton class
String from y is hello i am a string part of singleton class
String from z is hello i am a string part of singleton class

*/
