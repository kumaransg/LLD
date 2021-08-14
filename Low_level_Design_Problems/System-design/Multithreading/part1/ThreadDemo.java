package part1;

public class ThreadDemo {
	public static void main(String args[]) {
		Hi obj1 = new Hi();
		Hello obj2 = new Hello();
		obj1.start();
		obj2.start();
	}
}
