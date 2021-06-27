class BookIssueService{
	FineService fineService;

	public BookReservationDetails getReservationDetails(Book book);
	public void updateReservationDetails(Book book);
	public BookIssueDetails reserveBook(Book book, SystemUser user);
	public BookIssueDetails issueBook(Book book, SystemUser user); 
	public BookIssueDetails renewBook(Book book, SystemUser user);
	public void returnBook(Book book, SystemUser user);
}