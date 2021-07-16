package parkingLot;

public class ParkingSpace {
    int id;
    int floorId;
    ParkingSpaceType spaceType;
    Vehicle vehicle;            // parking space has a vehicle 
    double costPerHour;
    public boolean isFree() {
        return false;
    }
    
    public Vehicle getVehicle() {
        return null;
    }
}