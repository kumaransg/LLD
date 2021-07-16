package com.system.design.oops.parkinglot;

public class CompactSpot extends ParkingSpot {
    public CompactSpot() {
        super(ParkingSpotType.COMPACT);
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
