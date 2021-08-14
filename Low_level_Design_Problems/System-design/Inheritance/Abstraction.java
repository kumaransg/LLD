abstract class Shape {
   String color;
   public Shape(String clr) {
       System.out.println("In Shape setting color");
       this.color = clr;
   }
   public String getColor() {
       return color;
   }
   abstract void area();
}
class Square extends Shape {
    double length;
    double breadth;
    public Square(double l,double b, String clr) {
        super(clr);
        this.length = l;
        this.breadth = b;
    }
    void area() {
        System.out.println("Area of rectangle is : " +(length*breadth));
        System.out.println("Color of rectangle is : "+super.getColor());
    }
}
class Circle extends Shape {
    int radius;
    public Circle(int r,String clr) {
        super(clr);
        this.radius = r;
    }
    void area() {
        System.out.println("Area of Circle is : ");
        System.out.println("Color of circle is : "+super.getColor());
    }
}
public class MyClass {
    public static void main(String args[]) {
        Square obj1 = new Square(1.5,2.0,"Red");
        obj1.area();
        Circle obj2 = new Circle(5,"Orange");
        obj2.area();
    }
}
