package movieTicketBooking2.providers;

import movieTicketBooking2.model.Seat;
import movieTicketBooking2.model.SeatLock;
import movieTicketBooking2.model.Show;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author priyamvora
 * @created 26/05/2021
 */
public class InMemorySeatLockProvider implements SeatLockProvider {
    Map<Show, Map<Seat, SeatLock>> locks;

    public InMemorySeatLockProvider() {
        this.locks = new HashMap<>();
    }

    @Override
    public void lockSeats(List<Seat> seatList, Show show, String user) {

    }

    @Override
    public void unlockSeats(List<Seat> seatList, Show show, String user) {

    }

    @Override
    public void validateLock(Seat seat, Show show, String user) {

    }

    private void unlockSeat(final Show show, final Seat seat) {
        if (!locks.containsKey(show)) {
            return;
        }
        locks.get(show).remove(seat);
    }

    private void lockSeat(final Show show, final Seat seat, final String user, final Integer timeoutInSeconds) {
        if (!locks.containsKey(show)) {
            locks.put(show, new HashMap<>());
        }
    }

    private boolean isSeatLocked(Seat seat, Show show, String user) {
        Map<Seat, SeatLock> showToSeatLockMap = locks.getOrDefault(show, null);
        if (showToSeatLockMap != null) {
            SeatLock seatLock = showToSeatLockMap.getOrDefault(seat, null);
            return seatLock != null && seatLock.getLockedBy().equals(user) && !seatLock.isExpired();
        }
        return false;
    }
}
