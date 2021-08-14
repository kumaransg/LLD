package oops_basic;
class A {
	A() {
		System.out.println("inside A default constructor");
	}
	static {                                           // static blocks are loaded into the memory first. Code inside static block is executed only once: the first time the class is loaded into memory
		System.out.println("A class static block");   // Also static blocks are executed before constructors. but only once.	
	}
	void display() {
		System.out.println("A class display method");
	}
	public static void print() {
		System.out.println("A class print method");
	}
}

class B extends A {
	B() {
		// super();                                   <--- there is hidden super call here which will call the super class default constructor first.
		System.out.println("Inside B default constructor");
	}
	static {
		System.out.println("B class static block");
	}
	void display() {                                 // method overriding. Child class method will be called.
		System.out.println("B class display method");
	}
	public static void print() {                      // method hiding, static method are only inherited if they have been declared in exact same way.
		System.out.println("B class print method");   // So, child class method gets hide. That is why, parent class method is getting printed.
	}
}

public class Inheritance {
	public static void main(String args[]) {
		A a = new B();                                // Reference in created using A class but object is created of class B.
		a.display();
		a.print();				      // Call to static function depends upon the object reference not the type of object.	
	}							
}

/* OUTPUT 
A class static block
B class static block
inside A default constructor
Inside B default constructor
B class display method
A class print method
*/
