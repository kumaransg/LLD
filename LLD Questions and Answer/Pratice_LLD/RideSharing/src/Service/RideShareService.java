package Service;

import model.Driver;
import model.Rider;

public interface RideShareService {
    void createRide(String rideID, int id, int origin, int destination, int numberOfSeats);

    void updateRide(String rideID, int id, int origin, int destination, int numberOfSeats);

    int closeRide(String rideID, int id);

    void withDrawRide(String rideID, int id);

    void addDrivers(Driver driver);

    void addRiders(Rider rider);
}
