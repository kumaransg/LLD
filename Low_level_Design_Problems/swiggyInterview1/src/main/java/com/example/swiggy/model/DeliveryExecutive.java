package com.example.swiggy.model;

public class DeliveryExecutive {
    private int id;
    private Location location;
    private boolean available;
    private long lastOrderDeliveredTime;

    public DeliveryExecutive(int id, Location location, long lastOrderDeliveredTime) {
        this.id = id;
        this.location = location;
        this.available = true;
        this.lastOrderDeliveredTime = lastOrderDeliveredTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getLastOrderDeliveredTime() {
        return lastOrderDeliveredTime;
    }

    public void setLastOrderDeliveredTime(long lastOrderDeliveredTime) {
        this.lastOrderDeliveredTime = lastOrderDeliveredTime;
    }
}
