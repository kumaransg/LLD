package parkingLot2.model;

import parkingLot2.constants.VehicleType;

/**
 * @author priyamvora
 * @created 12/05/2021
 */
public class ParkingSpot {
    private final String parkingSpotId;
    private final VehicleType slotType;
    private Vehicle vehicle;
    private boolean isFree;

    public ParkingSpot(String parkingSpotId, VehicleType slotType) {
        this.parkingSpotId = parkingSpotId;
        this.slotType = slotType;
        this.isFree = true;
    }

    public void addVehicleToParkingSpot(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void leaveParkingSpot() {
        this.vehicle = null;
        this.isFree = true;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isFree() {
        return isFree;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingSpotId='" + parkingSpotId + '\'' +
                ", slotType=" + slotType +
                ", vehicle=" + vehicle +
                ", isFree=" + isFree +
                '}';
    }
}
