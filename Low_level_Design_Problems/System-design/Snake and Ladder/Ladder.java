package SaL;

public class Ladder {
	private int startpoint;
	private int endpoint;
	
	public Ladder(int sp,int ep) {
		this.startpoint = sp;
		this.endpoint   = ep;
	}
	
	public int getStart() {
		return startpoint;
	}
	
	public int getEnd() {
		return endpoint;
	}
}
