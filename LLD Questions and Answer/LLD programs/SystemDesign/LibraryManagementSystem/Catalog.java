//package SystemDesign.LibraryManagementSystem;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//public class Catalog implements Search {
//    private HashMap<String, List<Book>> bookTitles;
//    private HashMap<String, List<Book>> bookAuthors;
//    private HashMap<String, List<Book>> bookSubjects;
//    private HashMap<String, List<Book>> bookPublicationDates;
//
//    public List<Book> searchByTitle(String query) {
//        // return all books containing the string query in their title.
//        return bookTitles.get(query);
//    }
//
//    public List<Book> searchByAuthor(String query) {
//        // return all books containing the string query in their author's name.
//        return bookAuthors.get(query);
//    }
//
////    @Override
////    public List<Book> searchBySubject(String subject) {
////        return null;
////    }
////
////    @Override
////    public List<Book> searchByPubDate(Date publishDate) {
////        return null;
////    }
//}
