package part3;
// Lambda expression can help in simplifying the code and reduces its length
// Like Runnable is an functional interface has one abstract function run()
// We can use lambda expression to implement the abstract function.
// A functional interface is an interface with a single abstract method.
public class ThreadLambdaExpression {
	public static void main(String args[]) throws Exception {
		
		Runnable obj1 = () -> {            // lambda expression, removes the call to run() function as Runnable is an functional interface
				for(int i=0;i<5;i++) {
					System.out.println("Hi");
					try {
						Thread.sleep(1000);
					} catch(Exception e) {}
				}
			} ;
		
		Runnable obj2 = () -> {            // lambda expression, removes the call to run() function as Runnable is an functional interface  
				for(int i=0;i<5;i++) {
					System.out.println("Hello");
					try {
						Thread.sleep(1000);
					} catch(Exception e) {}
				}
			};
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start();
		try {
			Thread.sleep(1000);
		}  catch(Exception e) {}
		t2.start();
		
		// isAlive() method returns true if the thread is active or not.
		System.out.println("Thread t1 is alive : " +t1.isAlive());
		System.out.println("Thread t2 is alive : " +t2.isAlive());
		t1.join();
		t2.join();
		//After join both thread are not dead or joined with the main thread and isAlive() will return false 
		System.out.println("Thread t1 is alive : " +t1.isAlive());
		System.out.println("Thread t2 is alive : " +t2.isAlive());
		System.out.println("Bye");
	}
}
/*
 
 // Diagram from join method
  
  					main thread
  						  |
 						    |	
 	t1 thread		  |						t2 thread
 	   ------------------------
 	   |				  |						|	
 		 |				  |						|
 		 |				  |						|
 		 |				  |						|
 		 |				  |						| t1 and t2 is Alive during this period
 		 |				  |						|	
 		 | 				  |						|
 		 |				  |						|
 		 |				  |						|		
 		 |	        |		        |
 		 ------------------------    <--- t1.join() and t2.join() meets with main thead here and they are both dead afterwards
 						   |
 						   |
 						   |
 						main thread
*/
