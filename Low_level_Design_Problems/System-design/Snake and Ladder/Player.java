package SaL;

import java.util.UUID;

public class Player {
	private String name;
	private String id;
	
	public Player(String n) {
		this.name = n;
		this.id   = UUID.randomUUID().toString();
	}
	
	public String getName() {
		return name;
	}	
	
	public String getId() {
		return id;
	}
}
