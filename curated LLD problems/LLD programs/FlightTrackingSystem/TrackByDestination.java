package FlightTrackingSystem;

import java.util.List;

import static FlightTrackingSystem.SearchCriteria.DESTINATION;
import static FlightTrackingSystem.SearchCriteria.SOURCE;

public class TrackByDestination implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCretiera) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return DESTINATION;
    }
}
