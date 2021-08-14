package movieTicketBooking.model;

import java.util.List;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Booking {
    private final String bookingId;
    private final String showId;
    private final Double totalAmount;
    private final List<Integer> bookedSeats;
    private final PaymentInfo paymentInfo;

    public Booking(String showId, Double totalAmount, List<Integer> bookedSeats, PaymentInfo paymentInfo) {
        this.bookingId = UUID.randomUUID().toString();
        this.showId = showId;
        this.totalAmount = totalAmount;
        this.bookedSeats = bookedSeats;
        this.paymentInfo = paymentInfo;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getShowId() {
        return showId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }
}
