package ParkingLot.domain.Parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private int floorNumber;
    private List<Integer> entryGate;
    private List<Integer> exitGate;
    List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, int capacity) {
        this.floorNumber = floorNumber;
        parkingSpots = new ArrayList<>(capacity);
        entryGate = new ArrayList<>();
        exitGate = new ArrayList<>();
    }

}
