package parkingLot.models.parking;

import parkingLot.constants.VehicleType;

/**
 * @author priyamvora
 * @created 18/04/2021
 */
public class Vehicle {
    private String regNo;
    private String color;
    private VehicleType vehicleType;

    public Vehicle(String regNo, String color, VehicleType vehicleType) {
        this.regNo = regNo;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
