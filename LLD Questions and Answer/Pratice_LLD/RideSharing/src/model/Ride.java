package model;

import constants.RideStatus;

public class Ride {
    int id;
    Integer origin;
    Integer destination;
    Integer numberOfSeats;
    RideStatus rideStatus;
    private static final int AMT_PER_KM = 20;

    public Ride(int id, int origin, int destination, int numberOfSeats) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.numberOfSeats = numberOfSeats;
        this.rideStatus = RideStatus.IDEAL;
    }

    public int getUuid() {
        return id;
    }

    public void setUuid(int id) {
        this.id = id;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public double calculateFare(boolean isPrivilegedRider) {
        int dist = destination - origin;
        if (this.numberOfSeats < 2) {
            return dist * AMT_PER_KM * (isPrivilegedRider ? 0.75 : 1);
        }
        return dist * this.numberOfSeats * AMT_PER_KM * (isPrivilegedRider ? 0.5 : 0.75);
    }
}
