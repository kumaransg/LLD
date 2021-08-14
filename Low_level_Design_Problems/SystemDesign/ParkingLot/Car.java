package SystemDesign.ParkingLot;


public class Car extends Vehicle{
    public Car(String licensePlate, String Company){
        spotsNeeded = 1;
        size = VehicleSize.CarSize;
        this.licensePlate = licensePlate;
        this.Company = Company;
    }

    public boolean canFitInSpot(ParkingSpot spot){
        //checks if the spot is for a car
        return spot.getSize() == VehicleSize.CarSize;
    }
}
