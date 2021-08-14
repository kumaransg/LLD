package SystemDesign.LibraryManagementSystem;

import java.util.List;

public abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;
}
