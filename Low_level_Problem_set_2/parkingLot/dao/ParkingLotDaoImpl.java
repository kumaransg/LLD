package parkingLot.dao;

import parkingLot.constants.VehicleType;
import parkingLot.models.parking.*;

import java.util.Optional;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 18/04/2021
 */
public class ParkingLotDaoImpl implements ParkingLotDao {
    private final ParkingLot parkingLot;

    private static ParkingLotDao parkingLotDao;

    private ParkingLotDaoImpl() {
        parkingLot = new ParkingLot(UUID.randomUUID().toString());
    }

    public static ParkingLotDao getInstance() {
        if (parkingLotDao == null) {
            parkingLotDao = new ParkingLotDaoImpl();
        }
        return parkingLotDao;
    }

    @Override
    public void addFloor(String floorId) {
        ParkingFloor parkingFloor = new ParkingFloor(floorId);
        parkingLot.addNewFloor(parkingFloor);
    }

    @Override
    public void addParkingSpot(String parkingFloorId, String parkingSpotId, VehicleType slotType) {
        ParkingSpot parkingSpot = new ParkingSpot(parkingSpotId, slotType);
        Optional<ParkingFloor> parkingFloor = parkingLot.getFloorList().stream().filter(floor -> floor.getFloorId().equals(parkingFloorId)).findFirst();
        if (!parkingFloor.isPresent()) {
            return;
        }
        parkingFloor.get().addParkingSpot(slotType, parkingSpot);
    }

    @Override
    public void addEntryGate(Integer gateNumber) {
        EntryGate entryGate = new EntryGate();
        entryGate.setGateNumber(gateNumber);
        parkingLot.addEntryGate(entryGate);
    }

    @Override
    public void addExitGate(Integer gateNumber) {
        ExitGate exitGate = new ExitGate();
        exitGate.setGateNumber(gateNumber);
        parkingLot.addExitGate(exitGate);
    }

    @Override
    public ParkingTicket getParkingTicket(Integer gateNumber, Vehicle vehicle) {
        Optional<EntryGate> entryGate = parkingLot.getEntryGates().stream().filter(value -> value.getGateNumber().equals(gateNumber)).findFirst();
        if (!entryGate.isPresent()) {
            return null;
        }
        return entryGate.get().getParkingTicket(vehicle);
    }

    @Override
    public ParkingSpot getParkingSpot(Vehicle vehicle) {
        for (ParkingFloor floor : parkingLot.getFloorList()) {
            if (!floor.isFloorFull(vehicle.getVehicleType())) {
                ParkingSpot parkingSpot = floor.getSpot(vehicle.getVehicleType());
                parkingSpot.assignSlotToVehicle(vehicle);
                floor.addToUsedParkingSpots(parkingSpot);
                return parkingSpot;
            }
        }
        return null;
    }

    @Override
    public ParkingTicket leaveParkingSpot(ParkingTicket parkingTicket) {
        for (ParkingFloor parkingFloor : parkingLot.getFloorList()) {
            ParkingSpot parkingSpot = parkingFloor.unpark(parkingTicket.getParkingSpotId());
            if (parkingSpot != null) {
                parkingTicket.setExitTime(System.currentTimeMillis());
                parkingTicket.setCharges((double) (parkingTicket.getExitTime() - parkingTicket.getEnterTime()));
                return parkingTicket;
            }
        }
        return null;
    }

}
