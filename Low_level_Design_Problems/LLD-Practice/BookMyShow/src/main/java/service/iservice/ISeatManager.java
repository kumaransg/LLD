package service.iservice;

import exceptions.ShowNotFoundException;
import model.Seat;
import model.Show;

import java.util.List;
import java.util.Set;

public interface ISeatManager {
    Set<Seat> getAvailableSeats(Long showId) throws ShowNotFoundException;
    Set<Seat> getUnAvailableSeats(Long showId) throws ShowNotFoundException;
}
