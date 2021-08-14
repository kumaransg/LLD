package cabBooking2.daao;

import cabBooking2.constants.BookingStatus;
import cabBooking2.constants.CabStatus;
import cabBooking2.model.Booking;
import cabBooking2.model.Cab;
import cabBooking2.model.Location;
import cabBooking2.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author priyamvora
 * @created 23/05/2021
 */
public class CabBooking2Dao {
    private Map<String, List<Booking>> userIdToBookingsMap;
    private Map<String, List<Booking>> cabIdToBookingsMap;
    private Map<String, Booking> bookingMap;
    private List<Location> locationList;
    private List<Cab> cabList;
    private List<User> userList;

    public void addUser(User user) {
        userList.add(user);
    }

    public void addCab(Cab cab) {
        cabList.add(cab);
    }

    public void addLocation(Location location) {
        locationList.add(location);
    }

    public void addBooking(Booking booking) {
        booking.getCab().setCabStatus(CabStatus.BOOKED);
        bookingMap.put(booking.getBookingId(), booking);
        List<Booking> bookingsForUser = userIdToBookingsMap.getOrDefault(booking.getUser().getAccountId(), new ArrayList<>());
        bookingsForUser.add(booking);
        userIdToBookingsMap.put(booking.getUser().getAccountId(), bookingsForUser);

        List<Booking> bookingsForCab = cabIdToBookingsMap.getOrDefault(booking.getUser().getAccountId(), new ArrayList<>());
        bookingsForCab.add(booking);
        cabIdToBookingsMap.put(booking.getUser().getAccountId(), bookingsForCab);
    }

    public void startTrip(String bookingId) {
        Booking booking = bookingMap.getOrDefault(bookingId, null);
        if (booking != null) {
            booking.setBookingStatus(BookingStatus.ACTIVE);
        }
    }

    public void endTrip(String bookingId) {
        Booking booking = bookingMap.getOrDefault(bookingId, null);
        if (booking != null) {
            booking.setBookingStatus(BookingStatus.COMPLETED);
            booking.getCab().setCabStatus(CabStatus.AVAILABLE);
        }
    }

    public void cancelBooking(String bookingId) {
        Booking booking = bookingMap.getOrDefault(bookingId, null);
        if (booking != null) {
            booking.setBookingStatus(BookingStatus.CANCELLED);
            booking.getCab().setCabStatus(CabStatus.AVAILABLE);
        }
    }

    public List<Cab> getAllFreeCabs() {
        return cabList.stream().filter(cab -> cab.getCabStatus().equals(CabStatus.AVAILABLE)).collect(Collectors.toList());
    }

    public void editBooking(String bookingId, Location startLocation, Location endLocation) {
        Booking booking = bookingMap.getOrDefault(bookingId, null);
        if (booking != null && booking.getBookingStatus().equals(BookingStatus.ACTIVE)) {
            booking.setStartLocation(startLocation);
            booking.setEndLocation(endLocation);
        }
    }

    public List<Booking> getAllBookingsForUser(String userId) {
        return userIdToBookingsMap.getOrDefault(userId, new ArrayList<>());
    }

    public List<Booking> getAllBookingsForCab(String cabId) {
        return cabIdToBookingsMap.getOrDefault(cabId, new ArrayList<>());
    }
}
