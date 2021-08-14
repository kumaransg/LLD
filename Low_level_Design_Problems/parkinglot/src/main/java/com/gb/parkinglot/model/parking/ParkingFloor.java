package com.gb.parkinglot.model.parking;

import com.gb.parkinglot.model.vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.BitSet;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

import static com.gb.parkinglot.model.parking.ParkingSpotType.*;


public class ParkingFloor {
    @Getter
    @Setter
    private String floorId;
    @Getter
    private Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots = new HashMap<>();
    private Map<String, ParkingSpot> usedParkingSpots = new HashMap<>();

    public ParkingFloor(String id) {
        this.floorId = id;
        parkingSpots.put(ABLED, new ConcurrentLinkedDeque());
        parkingSpots.put(CAR, new ConcurrentLinkedDeque());
        parkingSpots.put(LARGE, new ConcurrentLinkedDeque());
        parkingSpots.put(MOTORBIKE, new ConcurrentLinkedDeque());
        parkingSpots.put(ELECTRIC, new ConcurrentLinkedDeque());
    }

    public boolean isFloorFull() {
        BitSet fullBitSet = new BitSet();
        int bitIndex = 0;
        for (Map.Entry<ParkingSpotType, Deque<ParkingSpot>> entry : parkingSpots.entrySet()) {
            if (entry.getValue().size() == 0) {
                fullBitSet.set(bitIndex++);
            } else {
                break;
            }
        }
        return fullBitSet.cardinality() == fullBitSet.size();
    }

    public static ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return CAR;
            case ELECTRIC:
                return ELECTRIC;
            case MOTORBIKE:
                return MOTORBIKE;
            default:
                return LARGE;
        }
    }

    public boolean canPark(VehicleType vehicleType) {
        return canPark(getSpotTypeForVehicle(vehicleType));
    }

    public synchronized ParkingSpot getSpot(VehicleType vehicleType) {
        if (!canPark(getSpotTypeForVehicle(vehicleType)))
            return null;

        ParkingSpotType parkingSpotType = getSpotTypeForVehicle(vehicleType);
        ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType)
                .poll();

        usedParkingSpots.put(parkingSpot.getParkingSpotId(), parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot vacateSpot(String parkingSpotId) {
        ParkingSpot parkingSpot = usedParkingSpots.remove(parkingSpotId);
        if (parkingSpot != null) {
            parkingSpot.freeSpot();
            parkingSpots.get(parkingSpot.getParkingSpotType())
                    .addFirst(parkingSpot);
            return parkingSpot;
        }
        return null;
    }

    public boolean canPark(ParkingSpotType parkingSpotType) {
        return parkingSpots.get(parkingSpotType).size() > 0;
    }

}
