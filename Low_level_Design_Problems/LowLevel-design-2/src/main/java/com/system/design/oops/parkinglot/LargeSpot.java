package com.system.design.oops.parkinglot;

public class LargeSpot extends ParkingSpot {
    public LargeSpot() {
        super(ParkingSpotType.LARGE);
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
