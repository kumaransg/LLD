package online_book_reader_system;

/*  
* The classes for User and Book simply hold data and  
* provide little functionality. 
* This class represents the Book which is a simple POJO (Plain Old Java Object)
*/

public class Book {
	private int bookId;
	private String details;
	private String title;
	
	public Book(int id, String details, String title) {
		// TODO Auto-generated constructor stub
		this.bookId = id;
		this.details = details;
		this.title = title;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return bookId;
	}
	
	public void setID(int id) {
		bookId = id;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) { 
        this.details = details; 
    }
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) { 
	        this.title = title; 
	}
}
