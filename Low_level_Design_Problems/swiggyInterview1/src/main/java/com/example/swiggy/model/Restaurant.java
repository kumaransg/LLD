package com.example.swiggy.model;

public class Restaurant {
    private Location location;

    public Restaurant(Location location) {
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
        return "Restaurant{" +
                "location=" + location +
                '}';
    }
}
