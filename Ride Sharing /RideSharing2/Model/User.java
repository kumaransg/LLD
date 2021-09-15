/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridesharing.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ridesharing.Exceptions.VehicleAlreadyExists;

/**
 *
 * @author paragkanodia
 */
public class User {
    private String name;
    private char gender;
    private int  age;
    private List<Vehicle> vehicles;
    private List<Ride> sharedRides;
    private List<Ride> consumedRides;

    public User(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicles = new ArrayList<>();
        this.consumedRides=new ArrayList<>();
        this.sharedRides=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }    
    
    public void addVehicle(Vehicle vehicle)
    {
        if(vehicles.contains(vehicle))
            throw new VehicleAlreadyExists();
        vehicles.add(vehicle);
    }
    
    public boolean checkVehicle(String vehicleNumber)
    {
        boolean flag=false;
        for(Vehicle vehicle: vehicles)
        {
            if(vehicle.getVehicleNumber().equals(vehicleNumber))
            {
                flag=true;
                break;
            }
        }
        return flag;
    }

    public List<Ride> getSharedRides() {
        return sharedRides;
    }

    public List<Ride> getConsumedRides() {
        return consumedRides;
    }
    
    public void addConsumedRide(Ride ride)
    {
        consumedRides.add(ride);
    }
    public void addSharedRide(Ride ride)
    {
        sharedRides.add(ride);
    }
}
