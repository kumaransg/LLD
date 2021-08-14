package ParkingLot.domain.Vehicle;

public abstract class Vehicle {
    private VehicleSize vehicleSize;
    private String plateNumber;
    VehicleType vehicleType;

    public Vehicle(VehicleSize vehicleSize, String plateNumber, VehicleType vehicleType) {
        this.vehicleSize = vehicleSize;
        this.plateNumber = plateNumber;
        this.vehicleType = vehicleType;
    }
}
