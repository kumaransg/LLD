package parkingLot2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author priyamvora
 * @created 12/05/2021
 */
public class ParkingLot {
    private final String parkingLotId;
    private final Map<String, ParkingFloor> floorList;

    public ParkingLot(String parkingLotId) {
        this.parkingLotId = parkingLotId;
        this.floorList = new HashMap<>();
    }

    public void debug() {
        System.out.println(toString());
    }

    public ParkingFloor addParkingFloor(String floorId) {
        ParkingFloor parkingFloor = new ParkingFloor(floorId);
        floorList.put(floorId, parkingFloor);
        return parkingFloor;
    }

    public void removeParkingFloor(String floorId) {
        this.floorList.remove(floorId);
    }

    public ParkingFloor getParkingFloor(String floorId) {
        return floorList.get(floorId);
    }

    public List<ParkingFloor> getAllParkingFloors() {
        return new ArrayList<>(floorList.values());
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingLotId='" + parkingLotId + '\'' +
                ", floorList=" + floorList +
                '}';
    }
}
