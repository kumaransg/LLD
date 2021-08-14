package cabBooking2.model;

import cabBooking2.constants.BookingStatus;
import cabBooking2.constants.PaymentStatus;

/**
 * @author priyamvora
 * @created 23/05/2021
 */
public class Booking {
    private final String bookingId;
    private final User user;
    private final Cab cab;
    private Location startLocation;
    private Location endLocation;
    private BookingStatus bookingStatus;
    private final PaymentStatus paymentStatus;
    private final Long bookingTime;

    public Booking(String bookingId, User user, Cab cab, Location startLocation, Location endLocation, BookingStatus bookingStatus, PaymentStatus paymentStatus) {
        this.bookingId = bookingId;
        this.user = user;
        this.cab = cab;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.bookingStatus = bookingStatus;
        this.paymentStatus = paymentStatus;
        this.bookingTime = System.currentTimeMillis();
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

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }
}
