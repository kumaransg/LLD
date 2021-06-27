package model;

import constants.RideStatus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Rider {
    String id;
    String name;
    HashSet<Ride> completedRides;
    HashMap<Integer, Ride> currentOnGoingRides;

    public Rider(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.completedRides = new HashSet<>();
        this.currentOnGoingRides = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void createRide(int id, int origin, int destination, int numberOfSeats) {
        Ride  currentRide = new Ride(id, origin, destination, numberOfSeats);
        currentRide.setRideStatus(RideStatus.CREATED);
        this.currentOnGoingRides.put(id,currentRide);
    }

    public void updateRide(int id, int origin, int destination, int numberOfSeats) {
        if(!currentOnGoingRides.containsKey(id)){
            System.out.println("can't update hence creating");
            createRide(id,origin,destination,numberOfSeats);
        } else {
            Ride currentRide = currentOnGoingRides.get(id);
            currentRide.setDestination(destination);
            currentRide.setNumberOfSeats(numberOfSeats);
        }
    }

    public double closeRide(int id) {
        if(!currentOnGoingRides.containsKey(id)){
            System.out.println("ride not present");
            return 0;
        }
        Ride ride = currentOnGoingRides.get(id);
        ride.setRideStatus(RideStatus.COMPLETED);
        completedRides.add(ride);
        currentOnGoingRides.remove(ride.id);
        return ride.calculateFare(false);
    }

    public void withDrawRide(int id) {
        if(!currentOnGoingRides.containsKey(id)){
            System.out.println("error");
            return;
        }
        Ride withDrawnRide = currentOnGoingRides.get(id);
        currentOnGoingRides.remove(id);
        completedRides.add(withDrawnRide);
    }
}
