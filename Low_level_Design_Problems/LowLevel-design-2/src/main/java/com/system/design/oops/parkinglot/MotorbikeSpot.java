package com.system.design.oops.parkinglot;

public class MotorbikeSpot extends ParkingSpot {
    public MotorbikeSpot() {
        super(ParkingSpotType.MOTORBIKE);
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
