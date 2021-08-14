package SaL;

public class Snake {
	private int start;
	private int end;
	
	public Snake(int sp,int ep) {
		this.start = sp;
		this.end   = ep;
	}
	
	public int getStartPoint() {
		return start;
	}
	
	public int getEndPoint() {
		return end;
	}
}
