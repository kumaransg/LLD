package dao;

import model.Vehicle;

public interface IVehicleDAO {
    Vehicle addVehicle(String name, String vehicleNumber);
    Vehicle getVehicle(String vehicleNumber);
}
