/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package parkinglot_services.models;

import parkinglot_services.controller.ParkingLot;

/**
 * @author paras.chawla
 * @version $Id: Vehicle.java, v 0.1 2020-05-18 21:26 paras.chawla Exp $$
 */
public class Vehicle {

    private       int         licenseNumber;
    private final VehicleType vehicleType;
    private       int         size;
    private       boolean     status;
    private       ParkingLot  lot;

    public Vehicle(VehicleType vehicleType, int size) {
        this.vehicleType = vehicleType;
        this.size = size;
        this.licenseNumber = this.hashCode();
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    private ParkingSlot findSlot() {
        ParkingSlot slot = null;

        switch (this.getVehicleType()) {
            case MOTORBIKE:
                slot = lot.getSmallSlots().remove(0);
                break;
            case CAR:
                slot = lot.getCompactSlots().remove(0);
                break;
            case TRUCK:
                slot = lot.getLargeSlots().remove(0);
                break;
        }
        return slot;
    }

    public void parkVehicle() {

        ParkingSlot slot = findSlot();
        if (slot != null) {
            lot.getOccupiedSlots().put(this.licenseNumber, slot);
            slot.assignVehicle(this);
        }

    }

    public void leave() {
        ParkingSlot slot = lot.getOccupiedSlots().remove(this.licenseNumber);
        slot.removeVehicle();

        switch (this.getVehicleType()) {
            case MOTORBIKE:
                lot.getSmallSlots().add(slot);
                break;
            case CAR:
                lot.getCompactSlots().add(slot);
                break;
            case TRUCK:
                lot.getLargeSlots().add(slot);
                break;
        }

    }
}

class Car extends Vehicle {
    public Car() {
        super(VehicleType.CAR, 2);
    }
}

class Truck extends Vehicle {
    public Truck() {
        super(VehicleType.TRUCK, 5);
    }
}

class Motorbike extends Vehicle {
    public Motorbike() {
        super(VehicleType.MOTORBIKE, 1);
    }
}