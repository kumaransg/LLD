package HotelManagmentSystem;

import java.util.Date;
import java.util.List;

public class AvailabilityRequest {

    Location location;
    int userCount;
    Date fromDate;
    Date toDate;
    PriceBudget priceBudget;
    List<Amenities> userRequestedAmenties;
}
