package parkingLot.models.parking;

import parkingLot.constants.VehicleType;

import java.util.*;

/**
 * @author priyamvora
 * @created 18/04/2021
 */
public class ParkingFloor {
    private String floorId;
    public Map<VehicleType, List<ParkingSpot>> parkingSpots = new HashMap<>();
    public Map<String, ParkingSpot> usedParkingSpots = new HashMap<>();


    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        parkingSpots.put(VehicleType.BIKE, new ArrayList<>());
        parkingSpots.put(VehicleType.CAR, new ArrayList<>());
        parkingSpots.put(VehicleType.TRUCK, new ArrayList<>());
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public Map<VehicleType, List<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    public void addParkingSpot(VehicleType vehicleType, ParkingSpot parkingSpot) {
        parkingSpots.get(vehicleType).add(parkingSpot);
    }

    public boolean isFloorFull(VehicleType vehicleType) {
        Optional<ParkingSpot> parkingSpot = parkingSpots.get(vehicleType).stream().filter(ParkingSpot::getFree).findFirst();
        return !parkingSpot.isPresent();
    }

    public ParkingSpot getSpot(VehicleType vehicleType) {
        for (ParkingSpot parkingSpot : parkingSpots.get(vehicleType)) {
            if (parkingSpot.getFree()) {
                return parkingSpot;
            }
        }
        return null;
    }

    public void addToUsedParkingSpots(ParkingSpot parkingSpot) {
        usedParkingSpots.put(parkingSpot.getParkingSpotId(), parkingSpot);
    }

    public ParkingSpot unpark(String parkingSpotId) {
        ParkingSpot parkingSpot = usedParkingSpots.remove(parkingSpotId);
        if (parkingSpot != null) {
            parkingSpot.freeSpot();
            return parkingSpot;
        }
        return null;

    }
}
