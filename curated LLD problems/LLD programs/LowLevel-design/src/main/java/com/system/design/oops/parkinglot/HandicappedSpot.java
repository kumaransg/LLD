package com.system.design.oops.parkinglot;

public class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot() {
        super(ParkingSpotType.HANDICAPPED);
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
