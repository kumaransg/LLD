
package oops_basic;

public class Human {
	String name;
	int age;
	String eyeColor;
	
	public Human() {
		System.out.println("Constructor call");
	}
	public void speak() {
		System.out.println("My name is : "+name);
		System.out.println("My age is : "+age);
		System.out.println("My eye color is : "+eyeColor);
	}
