package SystemDesign.OnlineBookReaderSystem;

import java.util.HashMap;

/*
 * This class represents the system
 */

class OnlineReaderSystem {
    private Library library;
    private UserManager userManager;
    private Display display;
    private Book activeBook;
    private User activeUser;

    public OnlineReaderSystem()
    {
        userManager = new UserManager();
        library = new Library();
        display = new Display();
    }

    public Library getLibrary()
    {
        return library;
    }

    public UserManager getUserManager()
    {
        return userManager;
    }

    public Display getDisplay()
    {
        return display;
    }

    public Book getActiveBook()
    {
        return activeBook;
    }

    public void setActiveBook(Book book)
    {
        activeBook = book;
        display.displayBook(book);
    }

    public User getActiveUser()
    {
        return activeUser;
    }

    public void setActiveUser(User user)
    {
        activeUser = user;
        display.displayUser(user);
    }
}

/*
 * We then implement separate classes to handle the user
 * manager, the library, and the display components
 */

/*
 * This class represents the Library which is responsible
 * for storing and searching the books.
 */
class Library {
    private HashMap<Integer, Book> books;

    public Library()
    {
        books = new HashMap<Integer, Book>();
    }

    public Boolean addBook(int id, String details, String title)
    {
        if (books.containsKey(id)) {
            return false;
        }
        Book book = new Book(id, details, title);
        books.put(id, book);
        return true;
    }

    public Boolean addBook(Book book)
    {
        if (books.containsKey(book.getId())) {
            return false;
        }

        books.put(book.getId(), book);
        return true;
    }

    public boolean remove(Book b)
    {
        return remove(b.getId());
    }

    public boolean remove(int id)
    {
        if (!books.containsKey(id)) {
            return false;
        }
        books.remove(id);
        return true;
    }

    public Book find(int id)
    {
        return books.get(id);
    }
}

/*
 * This class represents the UserManager which is responsible
 * for managing the users, their membership etc.
 */

class UserManager {
    private HashMap<Integer, User> users;

    public UserManager()
    {
        users = new HashMap<Integer, User>();
    }
    public Boolean addUser(int id, String details, String name)
    {
        if (users.containsKey(id)) {
            return false;
        }
        User user = new User(id, details, name);
        users.put(id, user);
        return true;
    }

    public Boolean addUser(User user)
    {
        if (users.containsKey(user.getId())) {
            return false;
        }

        users.put(user.getId(), user);
        return true;
    }

    public boolean remove(User u)
    {
        return remove(u.getId());
    }

    public boolean remove(int id)
    {
        if (users.containsKey(id)) {
            return false;
        }
        users.remove(id);
        return true;
    }

    public User find(int id)
    {
        return users.get(id);
    }
}

/*
 * This class represents the Display, which is responsible
 * for displaying the book, it's pages and contents. It also
 * shows the current user. * It provides the method
 * turnPageForward, turnPageBackward, refreshPage etc.
 */

class Display {
    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;

    public void displayUser(User user)
    {
        activeUser = user;
        refreshUsername();
    }

    public void displayBook(Book book)
    {
        pageNumber = 0;
        activeBook = book;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void turnPageForward()
    {
        pageNumber++;
        System.out.println("Turning forward to page no " +
                pageNumber + " of book having title " +
                activeBook.getTitle());
        refreshPage();
    }

    public void turnPageBackward()
    {
        pageNumber--;
        System.out.println("Turning backward to page no " +
                pageNumber + " of book having title " +
                activeBook.getTitle());
        refreshPage();
    }

    public void refreshUsername()
    {
        /* updates username display */
        System.out.println("User name " + activeUser.getName() +
                " is refreshed");
    }

    public void refreshTitle()
    {
        /* updates title display */
        System.out.println("Title of the book " +
                activeBook.getTitle() + " refreshed");
    }

    public void refreshDetails()
    {
        /* updates details display */
        System.out.println("Details of the book " +
                activeBook.getTitle() + " refreshed");
    }

    public void refreshPage()
    {
        /* updated page display */
        System.out.println("Page no " + pageNumber + " refreshed");
    }
}

/*
 * The classes for User and Book simply hold data and
 * provide little functionality.
 * This class represents the Book which is a simple POJO
 */

class Book {
    private int bookId;
    private String details;
    private String title;

    public Book(int id, String details, String title)
    {
        bookId = id;
        this.details = details;
        this.title = title;
    }

    public int getId()
    {
        return bookId;
    }

    public void setId(int id)
    {
        bookId = id;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}

/*
 * This class represents the User which is a simple POJO
 */

class User {
    private int userId;
    private String name;
    private String details;

    public void renewMembership()
    {
    }

    public User(int id, String details, String name)
    {
        this.userId = id;
        this.details = details;
        this.name = name;
    }

    public int getId()
    {
        return userId;
    }

    public void setId(int id)
    {
        userId = id;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

// This class is used to test the Application

public class AppTest {

    public static void main(String[] args)
    {

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
