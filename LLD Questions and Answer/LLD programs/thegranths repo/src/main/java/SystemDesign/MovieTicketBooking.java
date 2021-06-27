package SystemDesign;

import java.time.LocalDate;
import java.util.List;

public class MovieTicketBooking {
    class User {
        int userId;
        String name;
        LocalDate dateOfBirth;
        String mobNo;
        String emailId;
        String sex;
    }

    class Movie {
        int movieId;
        String movieName;
        String movieLanguage;
        String movieGenre;
        int theaterId;
        boolean movieAvailability;
    }

    class Theater {
        int theaterId;
        String theaterName;
        String address;
        List<Movie> movies;
    }

    class Booking {
        int bookingId;
        int userId;
        int movieId;
        List<Movie> bookedSeats;
        int amount;
        boolean status_of_payment;
        LocalDate booked_date;
        LocalDate movie_timing;
    }

    class Address {

        String city;
        String pinCode;
        String state;
        String streetNo;
        String landmark;
    }
}
