class BookLanding{
	BookItem book;
	SystemUser user;
	Date issueDate;
}

class BookReservationDetails extends BookLanding{
	ReservationStatus reservationStatus;
}

class BookIssueDetails extends BookLanding{
	Date dueDate;
}