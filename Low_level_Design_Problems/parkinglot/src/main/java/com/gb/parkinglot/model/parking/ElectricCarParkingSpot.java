package com.gb.parkinglot.model.parking;

public class ElectricCarParkingSpot extends ParkingSpot {
    public ElectricCarParkingSpot(String id) {
        super(id, ParkingSpotType.ELECTRIC);
    }
}
