package parkingLot.models.parking;

import parkingLot.constants.TicketStatus;
import parkingLot.dao.ParkingLotDaoImpl;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 18/04/2021
 */
public class EntryGate extends Gate {
    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        ParkingSpot parkingSpot = ParkingLotDaoImpl.getInstance().getParkingSpot(vehicle);
        return buildParkingTicket(parkingSpot);
    }

    public ParkingTicket buildParkingTicket(ParkingSpot parkingSpot) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setRegNo(parkingSpot.getVehicle().getRegNo());
        parkingTicket.setParkingSpotId(parkingSpot.getParkingSpotId());
        parkingTicket.setTicketNumber(UUID.randomUUID().toString());
        parkingTicket.setTicketStatus(TicketStatus.ACTIVE);
        parkingTicket.setEnterTime(System.currentTimeMillis());
        return parkingTicket;
    }
}
