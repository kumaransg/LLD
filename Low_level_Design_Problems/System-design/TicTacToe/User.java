package Game;


public class User {
	private String name;
	private int id;
	
	User(String n,int id) {
		this.name = n;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
}
