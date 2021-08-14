package Nav;

public class User {
	
	private String name;
	private int uid;
	private long balance;
	
	User(String name,int id,long balance) {
		this.name = name;
		this.uid = id;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return uid;
	}
	
	public long getBalance() {
		return balance;
	}
}
