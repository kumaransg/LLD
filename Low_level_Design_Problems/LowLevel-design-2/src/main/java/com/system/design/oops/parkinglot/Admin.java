package com.system.design.oops.parkinglot;

public class Admin extends Account {
    public boolean addParkingFloor(ParkingFloor floor){ return true;}
    public boolean addParkingSpot(String floorName, ParkingSpot spot){ return true;}
    public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard){ return true;}
    public boolean addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel){ return true;}

    public boolean addEntrancePanel(EntrancePanel entrancePanel){ return true;}
    public boolean addExitPanel(ExitPanel exitPanel){ return true;}
}
