package ParkingLot.domain.Vehicle;

import static ParkingLot.domain.Vehicle.VehicleSize.*;

public class Car extends Vehicle {

    public Car(String plateNumber, VehicleType vehicleType) {
        super(FOUR_VEHICLER_MEDIUM, plateNumber, vehicleType);
    }
}
