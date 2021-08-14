package movieTicketBooking2.services;

import movieTicketBooking2.model.Screen;
import movieTicketBooking2.model.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author priyamvora
 * @created 25/05/2021
 */
public class TheatreService {
    private List<Screen> screens;
    private Map<String, List<Seat>> screenIdToSeatsMap;

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public void addSeat(String screenId, Seat seat) {
        List<Seat> seatList = screenIdToSeatsMap.getOrDefault(screenId, new ArrayList<>());
        seatList.add(seat);
        screenIdToSeatsMap.put(screenId, seatList);
    }


}
