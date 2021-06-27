package SystemDesign.ParkingLot2;

public class Admin extends Account{
    public boolean addParkingFloor(ParkingFloor parkingFloor){
        return false;
    }
    public boolean addParkingSpot(String floorName, ParkingSpot parkingSpot){
        return false;
    }

    public boolean addEntryPanel(EntryPanel entryPanel){
        return false;
    }
    public boolean addExitPanel(ExitPanel exitPanel){
        return false;
    }
    public boolean addParkingDisplayPanel(String floorName, ParkingDisplayBoard displayBoard){
        return false;
    }

}
