package SystemDesign.ParkingLot2;

import java.util.HashMap;
import java.util.List;

public class ParkingFloor {
    String name;
    private HashMap<Integer,HandicappedSpot> handicappedSpotHashMap;
    private HashMap<Integer,MotorBikeSpot> motorBikeSpotHashMap;
    private HashMap<Integer,ElectricSpot> electricSpotHashMap;
    private HashMap<Integer,LargeSpot> largeSpotHashMap;
    private HashMap<Integer,CompactSpot> compactSpotHashMap;

    ParkingDisplayBoard parkingDisplayBoard;

    public ParkingFloor(String name) {
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        switch(parkingSpot.getSpotType()){
            case MotorBike:
                motorBikeSpotHashMap.put(parkingSpot.number, (MotorBikeSpot) parkingSpot);
                break;
            case Compact:
                compactSpotHashMap.put(parkingSpot.number, (CompactSpot) parkingSpot);
                break;
            case Large:
                largeSpotHashMap.put(parkingSpot.number, (LargeSpot) parkingSpot);
                break;
            case Electric:
                electricSpotHashMap.put(parkingSpot.number, (ElectricSpot) parkingSpot);
                break;
            case Handicapped:
                handicappedSpotHashMap.put(parkingSpot.number, (HandicappedSpot) parkingSpot);
                break;
            default: System.out.println("Wrong Parking spot");
        }
    }

    public void assignVehicle(Vehicle vehicle, ParkingSpot spot){
        spot.assignVehicle(vehicle);
        switch(spot.getSpotType()){
            case MotorBike:
                updateMotorBoard(spot);
                break;
            case Compact:
                updateCompactBoard(spot);
                break;
            case Large:
                updateLargeBoard(spot);
                break;
            case Electric:
                updateElectricBoard(spot);
                break;
            case Handicapped:
                updateHandicappedBoard(spot);
                break;
            default: System.out.println("Wrong Parking spot");
        }

    }

    private void updateElectricBoard(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getElectricFreeSpot().number== spot.getNumber()){
            for(int key:electricSpotHashMap.keySet()){
                if(electricSpotHashMap.get(key).available){
                    parkingDisplayBoard.setElectricFreeSpot(electricSpotHashMap.get(key));
                }
            }
            this.parkingDisplayBoard.ShowSpotNumber();
        }
    }

    private void updateLargeBoard(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getLargeFreeSpot().number== spot.getNumber()){
            for(int key:largeSpotHashMap.keySet()){
                if(largeSpotHashMap.get(key).available){
                    parkingDisplayBoard.setLargeFreeSpot(largeSpotHashMap.get(key));
                }
            }
            this.parkingDisplayBoard.ShowSpotNumber();
        }
    }

    private void updateCompactBoard(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getCompactFreeSpot().number== spot.getNumber()){
            for(int key:compactSpotHashMap.keySet()){
                if(compactSpotHashMap.get(key).available){
                    parkingDisplayBoard.setCompactFreeSpot(compactSpotHashMap.get(key));
                }
            }
            this.parkingDisplayBoard.ShowSpotNumber();
        }
    }

    private void updateMotorBoard(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getMotorbikeFreeSpot().number== spot.getNumber()){
            for(int key:motorBikeSpotHashMap.keySet()){
                if(motorBikeSpotHashMap.get(key).available){
                    parkingDisplayBoard.setMotorbikeFreeSpot(motorBikeSpotHashMap.get(key));
                }
            }
            this.parkingDisplayBoard.ShowSpotNumber();
        }
    }

    private void updateHandicappedBoard(ParkingSpot spot) {
        if(this.parkingDisplayBoard.getHandicappedFreeSpot().number== spot.getNumber()){
            for(int key:handicappedSpotHashMap.keySet()){
                if(handicappedSpotHashMap.get(key).available){
                    parkingDisplayBoard.setHandicappedFreeSpot(handicappedSpotHashMap.get(key));
                }
            }
            this.parkingDisplayBoard.ShowSpotNumber();
        }
    }

    public boolean isFull(){
        return false;
    }

}
