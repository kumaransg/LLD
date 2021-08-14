package com.gb.parkinglot.model.vehicle;

public class ElectricCar extends Vehicle {
    public ElectricCar(String licenseNumber, VehicleType type) {
        super(licenseNumber, VehicleType.ELECTRIC);
    }
}
