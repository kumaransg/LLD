package com.system.design.oops.bookmyshow2;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Booking {
    private String bookingNumber;
    private int numberOfSeats;
    private Date createdOn;
    private BookingStatus status;

    private Show show;
    private List<ShowSeat> seats;
    private Payment payment;

    public boolean makePayment(Payment payment){ return true;}
    public boolean cancel(){ return true;}
    public boolean assignSeats(List<ShowSeat> seats) { return true;};
}
