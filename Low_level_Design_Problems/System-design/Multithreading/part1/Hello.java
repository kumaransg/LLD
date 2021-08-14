package part1;

public class Hello extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Number : "+(i+1) +"  Hello");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}
