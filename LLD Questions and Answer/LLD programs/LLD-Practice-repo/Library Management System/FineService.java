class FineService{
	public Fine calculateFine(BookItem bookItem, SystemUser user, int days);
}

class Fine{
	Data fineDate;
	BookItem book;
	SystemUser user;
	Double fineValue;
}