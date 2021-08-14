package movieTicketBooking2.services;

import movieTicketBooking2.model.Booking;

import java.util.List;

/**
 * @author priyamvora
 * @created 25/05/2021
 */
public class BookingService {
    private List<Booking> bookingList;

    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }
}
