package online_book_reader_system;

//This class is used to test the Application 

public class AppTest {
	public static void main(String args[]) {
		OnlineReaderSystem onlineReaderSystem = new OnlineReaderSystem(); 
		  
        Book dsBook = new Book(1, "It contains Data Structures", "Ds"); 
        Book algoBook = new Book(2, "It contains Algorithms", "Algo"); 
  
        onlineReaderSystem.getLibrary().addBook(dsBook); 
        onlineReaderSystem.getLibrary().addBook(algoBook); 
  
        User user1 = new User(1, " ", "Ram"); 
        User user2 = new User(2, " ", "Gopal"); 
  
        onlineReaderSystem.getUserManager().addUser(user1); 
        onlineReaderSystem.getUserManager().addUser(user2); 
  
        onlineReaderSystem.setActiveBook(algoBook); 
        onlineReaderSystem.setActiveUser(user1); 
  
        onlineReaderSystem.getDisplay().turnPageForward(); 
        onlineReaderSystem.getDisplay().turnPageForward(); 
        onlineReaderSystem.getDisplay().turnPageBackward();
	}
}
