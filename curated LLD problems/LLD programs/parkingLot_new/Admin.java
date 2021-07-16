package parkingLot;

public class Admin extends Employee{
    public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor) {
        return false;
    }
    
    public boolean addParkingSpace(ParkingFloor parkingFloor, ParkingSpace parkingSpace) {
        return false;
    }
    
    public boolean addDisplayBoard(ParkingFloor parkingFloor, Display display) {
        return false;
    }
}