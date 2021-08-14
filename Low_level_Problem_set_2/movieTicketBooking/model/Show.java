package movieTicketBooking.model;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Show {
    private final String showId;
    private final Movie movie;
    private final Long startTimeTs;
    private final HashSet<Integer> bookedSeatNumber;

    public Show(Movie movie, Long startTimeTs) {
        this.showId = UUID.randomUUID().toString();
        this.bookedSeatNumber = new HashSet<>();
        this.movie = movie;
        this.startTimeTs = startTimeTs;
    }

    public String getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Long getStartTimeTs() {
        return startTimeTs;
    }

    public HashSet<Integer> getBookedSeatNumber() {
        return bookedSeatNumber;
    }

    public void addSeatNumberAsBooked(List<Integer> booked) {
        bookedSeatNumber.addAll(booked);
    }
}
