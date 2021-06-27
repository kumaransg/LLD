package service;

import exceptions.ShowNotFoundException;
import model.BookingStatus;
import model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import service.iservice.ISeatManager;
import service.iservice.IShowService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class SeatManager implements ISeatManager {
    @Autowired
    private IShowService showService;

    public Set<Seat> getAvailableSeats(Long showId) throws ShowNotFoundException {
        return showService.getShowById(showId)
                    .getSeats()
                    .entrySet()
                    .stream()
                    .filter(e-> e.getValue().equals(BookingStatus.NOT_BOOKED))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());


    }

    public Set<Seat> getUnAvailableSeats(Long showId) throws ShowNotFoundException {
        return showService.getShowById(showId)
                .getSeats()
                .entrySet()
                .stream()
                .filter(e-> !e.getValue().equals(BookingStatus.NOT_BOOKED))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
