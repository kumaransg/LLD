package RideAlgorithm;

import model.Ride;
import model.RideStatus;

import java.util.HashMap;
import java.util.Map;

public class RideManager {
    private Map<Ride, RideStatus> rideDB;
    private RiderFactory riderFactory;

    public RideManager(){
        rideDB= new HashMap<>();
        riderFactory= new RiderFactory();
    }

    public void addRide(Ride ride, RideStatus rideStatus){
        rideDB.put(ride,rideStatus);
    }

    public void completeRide(Ride ride){
        rideDB.put(ride,RideStatus.Completed);
    }

    public Ride getRide(String src, String dest, int seats, String strategy){
        return riderFactory.getRideSelectionStrategy(src, dest, seats, strategy);
    }
}
