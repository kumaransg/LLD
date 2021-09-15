package dao;

import model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleDAO implements IVehicleDAO{
    private Map<String, Vehicle> vehicleMapper= new HashMap<>();

    @Override
    public Vehicle addVehicle(String name,String vehicleNumber) {
        Vehicle newvehicle= new Vehicle(name, vehicleNumber);
        return newvehicle;
    }

    @Override
    public Vehicle getVehicle(String name) {
        return vehicleMapper.getOrDefault(name,null);
    }
}
