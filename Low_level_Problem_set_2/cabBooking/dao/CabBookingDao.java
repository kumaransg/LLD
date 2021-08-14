package cabBooking.dao;

import cabBooking.constants.BookingStatus;
import cabBooking.constants.CabStatus;
import cabBooking.model.Booking;
import cabBooking.model.Cab;
import cabBooking.model.Location;
import cabBooking.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author priyamvora
 * @created 01/05/2021
 */
public class CabBookingDao {
    private final Map<String, User> userMap;
    private final Map<String, Cab> cabMap;
    private final Map<String, Booking> bookingMap;
    private final Map<String, List<Booking>> userIdToBookingMap;

    public CabBookingDao() {
        this.userMap = new HashMap<>();
        this.cabMap = new HashMap<>();
        this.bookingMap = new HashMap<>();
        this.userIdToBookingMap = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getAccountId(), user);
    }

    public void addCab(Cab cab) {
        cabMap.put(cab.getCabId(), cab);
    }

    public Booking addBooking(Booking booking) {
        booking.getCab().setCabStatus(CabStatus.BOOKED);
        bookingMap.put(booking.getBookingId(), booking);
        List<Booking> bookings = userIdToBookingMap.getOrDefault(booking.getUser().getAccountId(), new ArrayList<>());
        bookings.add(booking);
        return booking;
    }

    public Booking editBooking(String bookingId, Location start, Location end) {
        Booking booking = bookingMap.getOrDefault(bookingId, null);
        if (booking != null) {
            booking.setStart(start);
            booking.setEnd(end);
        }
        return booking;
    }

    public Booking cancelBooking(String bookingId) {
        Booking booking = bookingMap.getOrDefault(bookingId, null);
        if (booking != null) {
            booking.setBookingStatus(BookingStatus.CANCELLED);
            booking.getCab().setCabStatus(CabStatus.AVAILABLE);
        }
        return booking;
    }

    public Booking startBooking(String bookingId) {
        Booking booking = bookingMap.getOrDefault(bookingId, null);
        if (booking != null) {
            booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        }
        return booking;
    }

    public Booking markBookingComplete(String bookingId) {
        Booking booking = bookingMap.getOrDefault(bookingId, null);
        if (booking != null) {
            booking.setBookingStatus(BookingStatus.COMPLETE);
            booking.getCab().setCabStatus(CabStatus.AVAILABLE);
        }
        return booking;
    }

    public List<Cab> getAllAvailableCabs() {
        return cabMap.values().stream().filter(cab -> cab.getCabStatus().equals(CabStatus.AVAILABLE)).collect(Collectors.toList());
    }

    public List<Booking> getAllBookingsForUser(String userId) {
        return userIdToBookingMap.getOrDefault(userId, new ArrayList<>());
    }
}
