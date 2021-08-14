package service;

import model.Seat;
import model.Ticket;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.iservice.IBookingManager;
import service.iservice.IPaymentManager;
import service.iservice.ISeatManager;

import java.util.List;

public class BookingManager implements IBookingManager {
    @Autowired
    private ISeatManager seatManager;

    @Autowired
    private IPaymentManager paymentManager;

    public Ticket bookSeats(User user, List<Seat> seats) {
        //check all seats are available

        //lock all the seats

        //to payment

        //if unsuccessful payment release all the earlier locked seats and update Booking status

        return null;
    }
}
