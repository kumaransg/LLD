package online_book_reader_system;

/*  
* The classes for User and Book simply hold data and  
* provide little functionality. 
* This class represents the User which is a simple POJO (Plain Old Java Object)
*/

public class User {
	private int UserId;
	private String details;
	private String name;
	
	public User(int id, String details, String name) {
		this.UserId = id;
		this.details = details;
		this.name = name;
	}
	
	public int getID() {
		return UserId;
	}
	
	public void setID(int id) {
		UserId = id;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String det) {
		details = det;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
}
