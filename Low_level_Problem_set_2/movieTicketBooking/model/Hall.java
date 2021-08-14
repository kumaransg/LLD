package movieTicketBooking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Hall {
    private final String hallId;
    private final List<Seat> seatMap;
    private final List<Show> showList;

    public Hall() {
        this.hallId = UUID.randomUUID().toString();
        this.seatMap = new ArrayList<>();
        this.showList = new ArrayList<>();
    }

    public void addShow(Show show) {
        showList.add(show);
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void addSeat(Seat seat) {
        seatMap.add(seat);
    }

    public String getHallId() {
        return hallId;
    }

    public List<Seat> getSeatMap() {
        return seatMap;
    }
}
