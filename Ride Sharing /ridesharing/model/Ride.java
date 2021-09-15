package com.github.akshay.ridesharing.model;

import java.util.Date;

public class Ride {

    private String id;
    private User user;
    private Vehicle vehicle;
    private City origin;
    private City destination;
    private int availableSeats;
    private Date startTime;
    private int durationInHours;

    public Ride(String id, User user, Vehicle vehicle, City origin, City destination, int availableSeats, Date startTime, int durationInHours) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.startTime = startTime;
        this.durationInHours = durationInHours;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public City getOrigin() {
        return origin;
    }

    public City getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", vehicle=" + vehicle +
                ", origin=" + origin +
                ", destination=" + destination +
                ", availableSeats=" + availableSeats +
                ", startTime=" + startTime +
                ", durationInHours=" + durationInHours +
                '}';
    }
}
