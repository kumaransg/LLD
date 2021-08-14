class A {
    A() {
        System.out.println("In A's Constructor");
    }
    public static void print() {
        System.out.println("A's static print method");
    }
    public void print2() {
        System.out.println("A's normal print function");
    }
}

class B extends A {
    B() {
        System.out.println("B's Constructror called");
    }
    public static void print() {
        System.out.println("B's static print method");
    }
    public void print2() {
        System.out.println("B's normal print method");
    }
}
public class Overriding {
    public static void main(String args[]) {
        B obj1 = new B();
        obj1.print();
        obj1.print2();
        
        System.out.println("After changing references");
        
        A obj2 = new B();
        obj2.print();
        obj2.print2();
    }
}
/* OUTPUT 
In A's Constructor
B's Constructror called
B's static print method
B's normal print method
After changing references
In A's Constructor
B's Constructror called
A's static print method
B's normal print method
*/
