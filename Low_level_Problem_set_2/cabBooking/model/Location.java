package cabBooking.model;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 01/05/2021
 */
public class Location {
    private final String locationId;
    private String cityName;

    public Location(String cityName) {
        this.locationId = UUID.randomUUID().toString();
        this.cityName = cityName;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
