package movieTicketBooking2.services;

import movieTicketBooking2.model.Show;

import java.util.List;

/**
 * @author priyamvora
 * @created 25/05/2021
 */
public class ShowService {
    private List<Show> showList;

    public void addShow(Show show) {
        showList.add(show);
    }
}
