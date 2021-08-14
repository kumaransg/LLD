package movieTicketBooking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class City {
    private final String cityId;
    private final String name;
    private final Double lat;
    private final Double lng;
    private List<Cinema> cinemas;

    public City(String name, Double lat, Double lng) {
        this.cityId= UUID.randomUUID().toString();
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.cinemas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public void addCinema(Cinema cinema){
        this.cinemas.add(cinema);
    }

    public String getCityId() {
        return cityId;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId='" + cityId + '\'' +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", cinemas=" + cinemas +
                '}';
    }
}
