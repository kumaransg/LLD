package ParkingLot.domain.Parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    Address address;
    List<ParkingFloor> parkingFloors;

    public ParkingLot(Address address, int floors, int capacityInEachFloor) {
        this.address = address;
        this.parkingFloors = new ArrayList<>(floors);

        initializeParkingLot(floors, capacityInEachFloor);
    }

    private void initializeParkingLot(int floors, int capacityInEachFloor) {
        for (int f = 1; f <= floors; f++) {
            ParkingFloor parkingFloor = new ParkingFloor(f, capacityInEachFloor);
            parkingFloors.add(parkingFloor);
        }
    }
}
