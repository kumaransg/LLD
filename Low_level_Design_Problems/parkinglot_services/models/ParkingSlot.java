/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package parkinglot_services.models;

/**
 * @author paras.chawla
 * @version $Id: ParkingSlot.java, v 0.1 2020-05-18 19:59 paras.chawla Exp $$
 */
public class ParkingSlot {
    private Vehicle          vehicle;
    private long             parkingSlotId;
    private ParkingSlotState state;
    private ParkingSlotType  slotType;

    public ParkingSlot(long parkingSlotId, ParkingSlotType slotType) {
        this.parkingSlotId = parkingSlotId;
        this.slotType = slotType;
    }

    private void assignSlot(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case CAR:
                this.slotType = ParkingSlotType.COMPACT;
                break;
            case TRUCK:
                this.slotType = ParkingSlotType.LARGE;
                break;
            case MOTORBIKE:
                this.slotType = ParkingSlotType.MOTORBIKE;
                break;
            default:
                this.slotType = ParkingSlotType.LARGE;
        }
    }

    public ParkingSlot(ParkingSlotType slotType) {
        this.slotType = slotType;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.state = ParkingSlotState.OCCUPIED;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.state = ParkingSlotState.UNOCCUPIED;
    }
}

class CompactSlot extends ParkingSlot {
    public CompactSlot() {
        super(ParkingSlotType.COMPACT);
    }
}

class LargeSlot extends ParkingSlot {
    public LargeSlot() {
        super(ParkingSlotType.LARGE);
    }
}

class MotorbikeSlot extends ParkingSlot {
    public MotorbikeSlot() {
        super(ParkingSlotType.MOTORBIKE);
    }
}