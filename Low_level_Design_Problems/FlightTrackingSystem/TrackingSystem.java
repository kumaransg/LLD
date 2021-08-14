package FlightTrackingSystem;

import java.util.List;

// This class fulfills 3 API contract
public interface TrackingSystem {

    public List<Flight> search(SearchCriteria searchCretiera);

    public SearchCriteria searchAttribute();
}
