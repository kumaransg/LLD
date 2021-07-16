package SystemDesign.ParkingLot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

//Creates a Parking Lot with Number of levels and the spots in each level given.
public class ParkingLot{
    private Level[] levels;
    private final int NUM_LEVELS = 2;
    private int numberSpots;

    Map<String, ArrayList<String>> CompanytoVehicle;
    public ParkingLot( int numberSpots){
        this.numberSpots = numberSpots;
        this.CompanytoVehicle = new HashMap<String, ArrayList<String>>();
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++){
            levels[i] = new Level(i, numberSpots);
            System.out.println("Level " + i + " created with " + numberSpots + " " +  "spots");
        }

    }

    public boolean parkVehicle(Vehicle vehicle){
        System.out.println(" ------------------------------------ ");

        for (int i = 0; i < levels.length; i++){
            if (levels[i].parkVehicle(vehicle)) {
                System.out.println(" Level " + i + " with Vehicle Number " + vehicle.licensePlate + " from " + vehicle.Company);
                if (this.CompanytoVehicle.containsKey(vehicle.Company)) {
                    ArrayList<String> regNoList = this.CompanytoVehicle.get(vehicle.Company);
                    this.CompanytoVehicle.remove(vehicle.Company);
                    regNoList.add(vehicle.licensePlate);
                    this.CompanytoVehicle.put(vehicle.Company, regNoList);
                } else {
                    ArrayList<String> regNoList = new ArrayList<String>();
                    regNoList.add(vehicle.licensePlate);
                    this.CompanytoVehicle.put(vehicle.Company, regNoList);
                }
                return true;
            }
        }
        System.out.println("PARKING FULL");
        return false;
    }

    public boolean leave(Vehicle vehicle,int lvl){
        System.out.println(" ------------------------------------------ ");
        levels[lvl].spotFreed();
        System.out.println("Spot freed from  Level " + 0 + " and exited  " + vehicle.licensePlate + " of " + vehicle.Company);
        ArrayList<String> VehicleList = this.CompanytoVehicle.get(vehicle.Company);
        if (VehicleList.contains(vehicle.licensePlate)) {
            VehicleList.remove(vehicle.licensePlate);
        }
        return true;
    }
    public void ComapnyParked(String Company){
        System.out.println(" ------------------------------------------ ");
        ArrayList<String> VehicleList = this.CompanytoVehicle.get(Company);
        System.out.print("The vehicles of " + Company + " : ");
        for(String el : VehicleList){
            System.out.print(el + "\t");
        }
        System.out.println();
    }
}
