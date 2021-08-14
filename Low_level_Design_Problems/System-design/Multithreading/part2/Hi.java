package part2;

public class Hi implements Runnable{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Number : "+(i+1) +"  Hi");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}
