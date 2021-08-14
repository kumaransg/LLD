package movieTicketBooking2.providers;

import cabBooking2.model.User;
import movieTicketBooking2.model.Seat;
import movieTicketBooking2.model.Show;

import java.util.List;

/**
 * @author priyamvora
 * @created 26/05/2021
 */
public interface SeatLockProvider {
    void lockSeats(List<Seat> seatList, Show show, String user);
    void unlockSeats(List<Seat> seatList, Show show, String user);
    void validateLock(Seat seat, Show show, String user);
}
