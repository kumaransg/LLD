interface Search{
	public List<Book> getBookByTitle(String title);
	public List<Book> getBookByAuthor(String author);
	public List<Book> getBookByType(BookType type);
}