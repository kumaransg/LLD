package movieTicketBooking.model;

import movieTicketBooking.SeatType;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Seat {
    private final Integer seatNumber;
    private final Integer price;
    private final SeatType seatType;

    public Seat(Integer seatNumber, Integer price, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.seatType = seatType;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
