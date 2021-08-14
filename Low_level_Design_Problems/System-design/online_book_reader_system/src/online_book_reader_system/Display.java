package online_book_reader_system;

/* 
* This class represents the Display, which is responsible  
* for displaying the book, it's pages and contents. It also  
* shows the current user. * It provides the method 
* turnPageForward, turnPageBackward, refreshPage etc. 
*/

public class Display {
	private User activeUser;
	private Book activeBook;
	private int pageNumber = 0;
	
	public void displayUser(User user) { 
        activeUser = user; 
        refreshUsername(); 
    } 
  
    public void displayBook(Book book) { 
        pageNumber = 0; 
        activeBook = book; 
  
        refreshTitle(); 
        refreshDetails(); 
        refreshPage(); 
    }
    
    public void turnPageForward() { 
        pageNumber++; 
        System.out.println("Turning forward to page no " + 
                   pageNumber + " of book having title " + 
                                     activeBook.getTitle()); 
        refreshPage(); 
    } 
  
    public void turnPageBackward() { 
        pageNumber--; 
        System.out.println("Turning backward to page no " + 
                    pageNumber + " of book having title " +  
                                    activeBook.getTitle()); 
        refreshPage(); 
    }
    
    public void refreshUsername() { 
        /* updates user name display */
        System.out.println("User name " + activeUser.getName() +  
                                             " is refreshed"); 
    } 
  
    public void refreshTitle() { 
        /* updates title display */
        System.out.println("Title of the book " + 
                        activeBook.getTitle() + " refreshed"); 
    } 
  
    public void refreshDetails() { 
        /* updates details display */
        System.out.println("Details of the book " + 
                        activeBook.getTitle() + " refreshed"); 
    } 
  
    public void refreshPage() { 
        /* updated page display */
        System.out.println("Page no " + pageNumber + " refreshed"); 
    } 

}
