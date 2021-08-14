package SystemDesign.ParkingLot2;

import java.util.HashMap;

public class ParkingLot2 {
    private String name;
    //private Location location;
    //private Parkingrate parkingRate;
    private int compactSpotCount;
    private int electricSpotCount;
    private int largeSpotCount;
    private int handicappedSpotCount;
    private int motorbikeSpotCount;
    private int maxcompactSpotCount;
    private int maxelectricSpotCount;
    private int maxlargeSpotCount;
    private int maxhandicappedSpotCount;
    private int maxmotorbikeSpotCount;
    private HashMap<String,EntryPanel> entryPanelHashMap;
    private HashMap<String,ExitPanel> exitPanelHashMap;
    private HashMap<String,ParkingFloor> parkingFloorHashMap;
    private HashMap<String,Ticket> activeTickets;
    private static ParkingLot2 parkingLot2=null;

    public ParkingLot2() {

    }
    public static ParkingLot2 getInstance(){
        if(parkingLot2==null){
            parkingLot2=new ParkingLot2();
        }
        return parkingLot2;
    }
    public boolean isFull(){
        for(ParkingFloor parkingFloor: parkingFloorHashMap.values()){
            if(!parkingFloor.isFull()){
                return false;
            }
        }
        return true;
    }

    public synchronized Ticket getParkingTicket(Vehicle vehicle) throws ParkingFullException{

        if(this.isFull(vehicle.vehicleType)){
            throw new ParkingFullException();
        }
        Ticket ticket = new Ticket();
        increementCount(vehicle.vehicleType);
        vehicle.assignTicket(ticket);
        this.activeTickets.put(ticket.getNumber(),ticket);
        return ticket;

    }

    private boolean isFull(VehicleType vehicleType) {
        if(VehicleType.Car == vehicleType || VehicleType.Truck == vehicleType){
            return largeSpotCount<maxlargeSpotCount;
        }
        else if(VehicleType.MotorBike == vehicleType){
            return motorbikeSpotCount<maxmotorbikeSpotCount;
        }
        else if(VehicleType.Electric == vehicleType){
            return electricSpotCount<maxelectricSpotCount;
        }
        return false;
    }

    private void increementCount(VehicleType vehicletype){
        if(vehicletype==VehicleType.Car)
            largeSpotCount++;
        else if(vehicletype==VehicleType.Electric)
            electricSpotCount++;
        else if(vehicletype==VehicleType.Truck)
            largeSpotCount++;
        else if(vehicletype==VehicleType.MotorBike)
            motorbikeSpotCount++;

    }


    public void addParkingFloor(ParkingFloor parkingFloor){

    }

    public void addEntrancePanel(EntryPanel entryPanel){

    }

    public void addExitPanel(ExitPanel exitPanel){

    }
}
