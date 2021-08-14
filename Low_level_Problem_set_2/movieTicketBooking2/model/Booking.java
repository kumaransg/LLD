package movieTicketBooking2.model;

import java.util.List;

/**
 * @author priyamvora
 * @created 25/05/2021
 */
public class Booking {
    private String bookingId;
    private Show show;
    private List<Seat> bookedSeats;
    private String userId;
}
