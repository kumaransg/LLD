package movieTicketBooking.dao;

import movieTicketBooking.SeatType;
import movieTicketBooking.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class MovieTicketBookingDao {
    private final Map<String, City> cityIdToCityMap;
    private final Map<String, Cinema> cinemaIdToCinemaMap;
    private final Map<String, Hall> hallIdToHallMap;
    private final Map<String, Show> showIdToShowMap;
    private final List<User> users;
    private final Map<String, List<Booking>> userToBookingMap;
    private final Map<String, String> showIdToHallIdMapping;

    public MovieTicketBookingDao() {
        this.cinemaIdToCinemaMap = new HashMap<>();
        this.cityIdToCityMap = new HashMap<>();
        this.hallIdToHallMap = new HashMap<>();
        users = new ArrayList<>();
        this.userToBookingMap = new HashMap<>();
        this.showIdToHallIdMapping = new HashMap<>();
        this.showIdToShowMap = new HashMap<>();
    }

    public void addCity(String name, Double lat, Double lng) {
        City city = new City(name, lat, lng);
        cityIdToCityMap.put(city.getCityId(), city);
    }

    public void addCinema(String cityId, String name, String address) {
        Cinema cinema = new Cinema(name, address);
        City city = cityIdToCityMap.get(cityId);
        if (city != null) {
            city.addCinema(cinema);
            cinemaIdToCinemaMap.put(cinema.getCinemaId(), cinema);
        }
    }

    public void addHall(String cinemaId) {
        Hall hall = new Hall();
        Cinema cinema = cinemaIdToCinemaMap.get(cinemaId);
        if (cinema == null) {
            return;
        }
        cinema.addHall(hall);
        hallIdToHallMap.put(hall.getHallId(), hall);
    }

    public void addSeat(String hallId, Integer seatNumber, SeatType seatType, Integer price) {
        Seat seat = new Seat(seatNumber, price, seatType);
        Hall hall = hallIdToHallMap.get(hallId);
        if (hall == null) {
            return;
        }
        hall.addSeat(seat);
    }

    public void addShow(String hallId, Movie movie, Long startTimeTs) {
        Show show = new Show(movie, startTimeTs);
        hallIdToHallMap.get(hallId).addShow(show);
        showIdToHallIdMapping.put(show.getShowId(), hallId);
        showIdToShowMap.put(show.getShowId(), show);
    }

    public List<City> getAllCities() {
        return new ArrayList<>(cityIdToCityMap.values());
    }

    public List<Cinema> getCinemaForCity(String cityId) {
        return cityIdToCityMap.get(cityId).getCinemas();
    }

    public List<Show> getShowsForCinema(String cinemaId) {
        List<Show> shows = new ArrayList<>();
        Cinema cinema = cinemaIdToCinemaMap.get(cinemaId);
        for (Hall hall : cinema.getHallList()) {
            shows.addAll(hall.getShowList());
        }
        return shows;
    }

    public void addUser(String name, String email) {
        User user = new User(name, email);
        users.add(user);
    }

    public void getAvailableSeatsForShow(String showId) {
        Show show = showIdToShowMap.get(showId);
        Hall hall = hallIdToHallMap.get(showIdToHallIdMapping.get(showId));


    }

}
