package parkingLot2.model;

import parkingLot2.constants.VehicleType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author priyamvora
 * @created 12/05/2021
 */
public class ParkingFloor {
    private final String floorId;
    private final Map<VehicleType, List<ParkingSpot>> parkingSpotsForVehicle;
    private final Map<String, ParkingSpot> usedParkingSpots;

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        this.parkingSpotsForVehicle = new HashMap<>();
        this.usedParkingSpots = new HashMap<>();
    }

    public String getFloorId() {
        return floorId;
    }

    public Map<VehicleType, List<ParkingSpot>> getParkingSpotsForVehicle() {
        return parkingSpotsForVehicle;
    }

    public ParkingSpot addParkingSpot(String parkingSpotId, VehicleType slotType) {
        ParkingSpot parkingSpot = new ParkingSpot(parkingSpotId, slotType);
        List<ParkingSpot> parkingSpots = parkingSpotsForVehicle.getOrDefault(slotType, new ArrayList<>());
        parkingSpots.add(parkingSpot);
        parkingSpotsForVehicle.put(slotType, parkingSpots);
        return parkingSpot;
    }

    public void removeParkingSpot(String parkingSpotId) {
        for (VehicleType vehicleType : parkingSpotsForVehicle.keySet()) {
            List<ParkingSpot> parkingSpots = parkingSpotsForVehicle.get(vehicleType).stream().filter(parkingSpot -> !parkingSpot.getParkingSpotId().equals(parkingSpotId)).collect(Collectors.toList());
            parkingSpotsForVehicle.put(vehicleType, parkingSpots);
        }
    }

    public ParkingSpot getFreeParkingSpot(VehicleType vehicleType) {
        if (!parkingSpotsForVehicle.containsKey(vehicleType)) {
            return null;
        }
        Optional<ParkingSpot> emptyParkingSpot = parkingSpotsForVehicle.get(vehicleType).stream().filter(ParkingSpot::isFree).findFirst();
        return emptyParkingSpot.orElse(null);
    }

    public void addToUsedParkingSpot(ParkingSpot parkingSpot) {
        usedParkingSpots.put(parkingSpot.getParkingSpotId(), parkingSpot);
    }

    public ParkingSpot getUsedParkingSpot(String parkingSpotId) {
        return usedParkingSpots.get(parkingSpotId);
    }

    public List<ParkingSpot> getAllFreeParkingSpots(VehicleType vehicleType) {
        if (!parkingSpotsForVehicle.containsKey(vehicleType)) {
            return new ArrayList<>();
        }
        return parkingSpotsForVehicle.get(vehicleType).stream().filter(parkingSpot -> parkingSpot.getSlotType().equals(vehicleType) && parkingSpot.isFree()).collect(Collectors.toList());
    }

    public List<ParkingSpot> getAllUsedParkingSpots(VehicleType vehicleType) {
        if (!parkingSpotsForVehicle.containsKey(vehicleType)) {
            return new ArrayList<>();
        }
        return parkingSpotsForVehicle.get(vehicleType).stream().filter(parkingSpot -> parkingSpot.getSlotType().equals(vehicleType) && !parkingSpot.isFree()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ParkingFloor{" +
                "floorId='" + floorId + '\'' +
                ", parkingSpotsForVehicle=" + parkingSpotsForVehicle +
                '}';
    }
}
