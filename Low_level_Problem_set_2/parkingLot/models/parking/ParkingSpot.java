package parkingLot.models.parking;

import parkingLot.constants.VehicleType;

/**
 * @author priyamvora
 * @created 18/04/2021
 */
public class ParkingSpot {
    private final String parkingSpotId;
    private VehicleType slotType;
    private Boolean isFree;
    private Vehicle vehicle;

    public ParkingSpot(String parkingSpotId, VehicleType slotType) {
        this.parkingSpotId = parkingSpotId;
        this.slotType = slotType;
        this.isFree = true;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public void setSlotType(VehicleType slotType) {
        this.slotType = slotType;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void assignSlotToVehicle(Vehicle vehicle) {
        this.isFree = false;
        this.vehicle = vehicle;
    }

    public void freeSpot() {
        this.isFree = true;
        this.vehicle = null;
    }
}
