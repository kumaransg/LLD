class Librarian extends SystemUser{
	Search searchObj;
	BookIssueService bookIssueService;

	public void addBook(BookItem bookItem);
	public BookItem deleteBook(BookItem bookItem);
	public BookItem editBook(BookItem bookItem);
}