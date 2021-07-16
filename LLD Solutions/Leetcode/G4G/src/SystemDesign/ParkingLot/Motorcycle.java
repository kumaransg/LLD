
package SystemDesign.ParkingLot;

public class Motorcycle extends Vehicle{
    public Motorcycle(String licensePlate, String Company){
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
        this.licensePlate = licensePlate;
        this.Company = Company;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        //checks if the spot is a compact, motorcycle or a large

        return spot.getSize() == VehicleSize.CarSize || spot.getSize() == VehicleSize.Motorcycle;

    }
}

