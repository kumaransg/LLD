package com.example.swiggy.model;

public class SwiggyCustomer {
    private Location location;

    public SwiggyCustomer(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SwiggyCustomer{" +
                "location=" + location +
                '}';
    }
}
