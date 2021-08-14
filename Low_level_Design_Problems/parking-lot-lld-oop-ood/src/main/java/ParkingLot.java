import sun.security.krb5.internal.Ticket;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class ParkingLot {
    private final List<ParkingFloor> parkingFloors;
    private final List<EntryPoint> entryPoints;
    private final List<ExitPoint> exitPoints;
    private final EntrancePanel entrancePanel;

    public ParkingLot(List<ParkingFloor> parkingFloors, List<EntryPoint> entryPoints,
                      List<ExitPoint> exitPoints) {
        this.parkingFloors = parkingFloors;
        this.entryPoints = entryPoints;
        this.exitPoints = exitPoints;
        this.entrancePanel = new EntrancePanel();
    }

    ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            if (floor.hasSpace(vehicle)) {
                ParkingSpot parkingSpot = floor.parkVehicle(vehicle);
                return parkingSpot;
            }
        }

        throw new RuntimeException("All floors are already full");
    }

    Vehicle unParkVehicle(ParkingSpot parkingSpot) {
        for (ParkingFloor floor : parkingFloors) {
            if (floor.hasGivenParkingSpot(parkingSpot)) {
                return floor.unParkVehicle(parkingSpot);
            }
        }
        throw new RuntimeException("Either this parking spot doesn't exist or it's empty");
    }

    Boolean isNotFull() {
        for (ParkingFloor parkingFloor : this.parkingFloors) {
            if (parkingFloor.isNotFull())
                return true;
        }
        return false;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle){
        EntryPoint currentEntryPoint = entryPoints.get(0);
        ParkingTicket ticket = currentEntryPoint.generateTicket(vehicle);
        return  ticket;
    }

    public Transaction payAtExit(ParkingTicket ticket ,PaymemtMode mode){
        ExitPoint exitPoint = exitPoints.get(0);
        BigDecimal amount  = exitPoint.scanTicket(ticket);
        return  new Transaction(mode,amount);
    }
}