package parkingLot2.dao;

import parkingLot2.constants.VehicleType;
import parkingLot2.model.*;

import java.util.List;

/**
 * @author priyamvora
 * @created 12/05/2021
 */
public class ParkingLotDao {
    private final ParkingLot parkingLot;

    public ParkingLotDao(String parkingLotId) {
        this.parkingLot = new ParkingLot(parkingLotId);
    }

    public void debug() {
        parkingLot.debug();
    }

    public ParkingFloor addParkingFloor(String floorId) {
        return parkingLot.addParkingFloor(floorId);
    }

    public void removeParkingFloor(String floorId) {
        parkingLot.removeParkingFloor(floorId);
    }

    public ParkingSpot addParkingSpot(String floorId, String spotId, VehicleType slotType) {
        ParkingFloor parkingFloor = parkingLot.getParkingFloor(floorId);
        return parkingFloor.addParkingSpot(spotId, slotType);
    }

    public void removeParkingSpot(String floorId, String spotId) {
        ParkingFloor parkingFloor = parkingLot.getParkingFloor(floorId);
        parkingFloor.removeParkingSpot(spotId);
    }

    public ParkingTicket assignSpotToVehicle(Vehicle vehicle) {
        List<ParkingFloor> parkingFloorList = parkingLot.getAllParkingFloors();
        for (ParkingFloor parkingFloor : parkingFloorList) {
            ParkingSpot parkingSpot = parkingFloor.getFreeParkingSpot(vehicle.getVehicleType());
            if (parkingSpot == null) {
                continue;
            }
            parkingSpot.addVehicleToParkingSpot(vehicle);
            parkingFloor.addToUsedParkingSpot(parkingSpot);
            return ParkingTicket.buildParkingTicket(vehicle, parkingFloor.getFloorId(), parkingSpot.getParkingSpotId());
        }
        return null;
    }

    public ParkingTicket unparkVehicle(ParkingTicket parkingTicket) {
        ParkingFloor parkingFloor = parkingLot.getParkingFloor(parkingTicket.getParkingFloorId());
        ParkingSpot parkingSpot = parkingFloor.getUsedParkingSpot(parkingTicket.getParkingSpotId());
        parkingSpot.leaveParkingSpot();
        parkingTicket.unparkVehicle();
        return parkingTicket;
    }
}
