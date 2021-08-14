package parkingLot.dao;

import parkingLot.constants.VehicleType;
import parkingLot.models.parking.EntryGate;
import parkingLot.models.parking.ParkingSpot;
import parkingLot.models.parking.ParkingTicket;
import parkingLot.models.parking.Vehicle;

/**
 * @author priyamvora
 * @created 18/04/2021
 */
public interface ParkingLotDao {
    void addFloor(String floorId);
    void addParkingSpot(String parkingFloorId, String parkingSpotId, VehicleType slotType);
    void addEntryGate(Integer gateNumber);
    void addExitGate(Integer gateNumber);
    ParkingTicket getParkingTicket(Integer gateNumber, Vehicle vehicle);
    ParkingSpot getParkingSpot(Vehicle vehicle);
    ParkingTicket leaveParkingSpot(ParkingTicket parkingTicket);
}
