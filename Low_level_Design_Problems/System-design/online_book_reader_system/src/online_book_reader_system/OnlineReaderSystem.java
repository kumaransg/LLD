package online_book_reader_system;

/* 
* This class represents the system 
*/
  
public class OnlineReaderSystem {
	private Library library; 
    private UserManager userManager; 
    private Display display; 
    private Book activeBook; 
    private User activeUser; 
  
    public OnlineReaderSystem() { 
        userManager = new UserManager(); 
        library = new Library(); 
        display = new Display(); 
    } 
  
    public Library getLibrary() { 
        return library; 
    } 
  
    public UserManager getUserManager() { 
        return userManager; 
    } 
  
    public Display getDisplay() { 
        return display; 
    } 
  
    public Book getActiveBook() { 
        return activeBook; 
    } 
  
    public void setActiveBook(Book book) { 
        activeBook = book; 
        display.displayBook(book); 
    } 
  
    public User getActiveUser() { 
        return activeUser; 
    } 
  
    public void setActiveUser(User user) { 
        activeUser = user; 
        display.displayUser(user); 
    } 

}
