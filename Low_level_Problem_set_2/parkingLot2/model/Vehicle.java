package parkingLot2.model;

import parkingLot2.constants.VehicleType;

/**
 * @author priyamvora
 * @created 12/05/2021
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "regNo='" + regNo + '\'' +
                ", color='" + color + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
