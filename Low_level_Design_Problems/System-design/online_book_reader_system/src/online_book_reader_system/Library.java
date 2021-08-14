package online_book_reader_system;

import java.util.HashMap;

// This class is responsible for storing and searching of books

public class Library {
	private HashMap<Integer,Book> books;

	public Library() {                          // Default Constructor to initialize the Hash map
		books = new HashMap<Integer,Book> ();
	}
	
	public Boolean addBook(int id, String details, String title) {
		if(books.containsKey(id))
			return false;
		Book book = new Book(id, details, title);
		books.put(id, book);
		return true;
	}
	
	public Boolean addBook(Book book) {
		if(books.containsKey(book.getID())) 
			return false;
		books.put(book.getID(), book);
		return true;
	}
	
	public Boolean remove(Book b) {
		return remove(b.getID());
	}
	
	public Boolean remove(int id) {
		if(!books.containsKey(id))
			return false;
		books.remove(id);
		return true;
	}
	
	public Book find(int id) {
		return books.get(id);
	}
}
