package SystemDesign.ParkingLot2;

public class Vehicle {
    VehicleType vehicleType;
    String VehicleNumber;
    Ticket ticket;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public void assignTicket(Ticket ticket){
        this.ticket=ticket;
    }
}

