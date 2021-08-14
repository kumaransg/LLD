package parkingLot.models.parking;

import parkingLot.dao.ParkingLotDaoImpl;

/**
 * @author priyamvora
 * @created 18/04/2021
 */
public class ExitGate extends Gate {
    public ParkingTicket processExit(ParkingTicket parkingTicket) {
        return ParkingLotDaoImpl.getInstance().leaveParkingSpot(parkingTicket);
    }
}
