package FlightTrackingSystem;

import java.util.List;

import static FlightTrackingSystem.SearchCriteria.ARRIVAL_TIME;
import static FlightTrackingSystem.SearchCriteria.DEPARTURE_TIME;

public class TrackByArrivalTime implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCretiera) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return ARRIVAL_TIME;
    }
}
