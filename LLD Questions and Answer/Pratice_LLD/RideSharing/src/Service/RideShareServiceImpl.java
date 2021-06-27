package Service;

import model.Driver;
import model.Rider;

import java.util.ArrayList;
import java.util.HashMap;

public class RideShareServiceImpl implements RideShareService {
    ArrayList<Driver> listOfDrivers;
    HashMap<String, Rider> listOfRiders;

    public RideShareServiceImpl() {
        this.listOfDrivers = new ArrayList<>();
        this.listOfRiders = new HashMap<>();
    }

    @Override
    public void createRide(String riderId, int id, int origin, int destination, int numberOfSeats) {
        listOfRiders.get(riderId).createRide(id, origin, destination, numberOfSeats);
    }

    @Override
    public void updateRide(String riderId, int id, int origin, int destination, int numberOfSeats) {
        listOfRiders.get(riderId).updateRide(id, origin, destination, numberOfSeats);
    }

    @Override
    public int closeRide(String riderId, int id) {
        return (int) listOfRiders.get(riderId).closeRide(id);
    }

    @Override
    public void withDrawRide(String riderId, int id) {
        listOfRiders.get(riderId).withDrawRide(id);
    }

    @Override
    public void addDrivers(Driver driver) {
        this.listOfDrivers.add(driver);
    }

    @Override
    public void addRiders(Rider rider) {
        this.listOfRiders.put(rider.getId(), rider);
    }
}
