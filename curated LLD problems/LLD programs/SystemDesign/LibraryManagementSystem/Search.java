package SystemDesign.LibraryManagementSystem;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface Search {
    public List<Book> searchByTitle(String title);
    public List<Book> searchByAuthor(String author);
    public List<Book> searchByPubDate(Date publishDate);
}

