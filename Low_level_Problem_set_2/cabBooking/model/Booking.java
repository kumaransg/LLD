package cabBooking.model;

import cabBooking.constants.BookingStatus;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 01/05/2021
 */
public class Booking {
    private final String bookingId;
    private final User user;
    private final Cab cab;
    private final Long bookingTime;
    private BookingStatus bookingStatus;
    private  Location start;
    private  Location end;

    public Booking(User user, Cab cab, Long bookingTime, Location start, Location end) {
        this.bookingId = UUID.randomUUID().toString();
        this.user = user;
        this.cab = cab;
        this.bookingTime = bookingTime;
        this.bookingStatus = BookingStatus.BOOKED;
        this.start = start;
        this.end = end;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Cab getCab() {
        return cab;
    }

    public Long getBookingTime() {
        return bookingTime;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public Location getStart() {
        return start;
    }

    public Location getEnd() {
        return end;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public void setEnd(Location end) {
        this.end = end;
    }
}
