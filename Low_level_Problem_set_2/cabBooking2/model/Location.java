package cabBooking2.model;

/**
 * @author priyamvora
 * @created 23/05/2021
 */
public class Location {
    private final String locationId;
    private final String cityName;

    public Location(String locationId, String cityName) {
        this.locationId = locationId;
        this.cityName = cityName;
    }
}
