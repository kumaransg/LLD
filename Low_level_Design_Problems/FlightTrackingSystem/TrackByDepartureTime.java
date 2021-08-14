package FlightTrackingSystem;

import java.util.List;

import static FlightTrackingSystem.SearchCriteria.DEPARTURE_TIME;

public class TrackByDepartureTime implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCretiera) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return DEPARTURE_TIME;
    }
}
