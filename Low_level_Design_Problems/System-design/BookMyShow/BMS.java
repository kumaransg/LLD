public class BMS {
	public static void main(String args[]) {
		List<CinemaHall> cinemas;
		/*
		API for class BMS
		@return : List of movies on the basis of selected date and city
		@return : List of halls affiliated with particular city.
		*/
		public List<Movies> getMovies(String city, Date date);     // will return list of movies searched using date and city
		public List<CinemaHall> getHalls(String city);  		   // will return the list of affiliated cinema halls in a particular city.	
	}
}

public class CinemaHall {
	int cinemahallId;
	String cinemahallName;

	Address address;
	List<Audi> audilist;
	/*
	API for cinemaHall classs
	@return : Map of movies with its realease date
	@return : Map of all the shows on that particular dates 
	*/
	public Map<Date,Movie> getMovies(List<Date> datelist);
	public Map<Date,Show> getShow(List<Date> datelist);
}

public class Address {
	int pincode;
	String city;
	String state;
	String country;
}

public class Audi {
	int audiId;
	String audiName;
	int totalseats;

	List<Show> shows;
}

public class Show {
	int showID;
	Movie movie;
	Date startTime;
	Date endTime;
	List<Seat> seats;
}

public class Seat {
	int seatId;
	Seattype seattype;
	Double price;
	SeatStatus seatstatus;
}
public enum Seattype {
	DELUXE,
	VIP,
	ECONOMY,
	OTHER;
}
public enum SeatStatus {
	AVAILABLE,
	BOOKED,
	RESERVED,
	NOT_AVAILABLE;
}
public class Movie {
	int movieID;
	String name;
	int durationinmins;
	String language;
	Genre genre;
}
public enum Genre {
	SCI_FI,
	ROMANTIC,
	THRILLER,
	FANATSY;
}

public class Search {
	/*
	APIs for searching movies by name, title, genre and releasedate
	@return list of movies depending upon query
	*/
	public List<Movies> serachMoviewByName(String name);
	public List<Movies> searchMovieByTitle(String title);
	public List<Movies> searchMovieByGenre(String genre);
	public List<Movies> searchMovieByDate(Date releasedate);
}
public class Booking {
	int bookingID;
	BookingStatus status;
	Date bookingDate;
	Audi audi;
	Show show;
	double Amount;
	Movie movie;
	List<Seats> seats;

	/*
	API for making payment
	@param : payment
	@return : true if payment is successful otherwise false;
	*/
	public boolean makepayment(Payment p);
}
public enum BookingStatus {
	REQUESTED,
	PENIND,
	CONFIRMED,
	CANCELED;
}
public class Payment {
	double amount;
	int transactionID;
	Date transactionDate;
	PaymentStatus status;
}

public enum PaymentStatus {
	UNPAID,
	PENDING,
	PAYED,
	DECLINED,
	CANCELED,
	REFUNDED;
}
