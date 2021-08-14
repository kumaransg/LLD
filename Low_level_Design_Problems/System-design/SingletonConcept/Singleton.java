package SingletonPractise;
/*
  Simplest of all the design patterns.
  It is characterized by single object class (private constructor)
  It is used where only a single instance of a class is required to control the action throughout the execution.
  An implementation of singleton class should have following properties:
  1) It should have only one instance
  2) Instance should be globally accessible (In Java, it is done by making the access-specifier of instance public.)
 */
public class Singleton {
	private static Singleton obj = null;
	public String str;
	
	private Singleton() {
		str = "Hello I am a string part of Singleton class"; 
	}
	
	public synchronized static Singleton getInstance() {           // Lazy initialization (calling getinstance method only when it is needed to create object.
		if(obj == null)
			obj = new Singleton();
		return obj;                              // If the object is created once, return the same object again.
	}
}
