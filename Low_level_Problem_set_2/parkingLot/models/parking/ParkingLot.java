package parkingLot.models.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author priyamvora
 * @created 18/04/2021
 */
public class ParkingLot {
    private String id;
    private final List<ParkingFloor> parkingFloorList;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;

    public ParkingLot(String id) {
        this.id = id;
        this.parkingFloorList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addNewFloor(ParkingFloor parkingFloor) {
        parkingFloorList.add(parkingFloor);
    }

    public List<ParkingFloor> getFloorList() {
        return parkingFloorList;
    }

    public void addEntryGate(EntryGate gate) {
        entryGates.add(gate);
    }

    public void addExitGate(ExitGate gate) {
        exitGates.add(gate);
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }
}
