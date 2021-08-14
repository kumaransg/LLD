package parkingLot;

import java.util.Date;

public class ParkingTicket {
    int id;
    Date entryTime, exitTime;
    Vehicle vehicle;
    ParkingSpace parkingSpace;
    double totalCost;
    PaymentStatus paymentStatus;
    public boolean updateCost() {
        return false;
    }
    
    public boolean updateExitTime(Date exitTime) {
        return false;
    }
}
