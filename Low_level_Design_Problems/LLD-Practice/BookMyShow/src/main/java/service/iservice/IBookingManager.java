package service.iservice;

import model.Seat;
import model.Ticket;
import model.User;

import java.util.List;

public interface IBookingManager {
    Ticket bookSeats(User user, List<Seat> seats);
}
