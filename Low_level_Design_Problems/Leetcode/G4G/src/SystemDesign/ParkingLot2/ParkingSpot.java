package SystemDesign.ParkingLot2;

public abstract class ParkingSpot {
    int number;
    SpotType spotType;
    boolean available;
    Vehicle vehicle;

    public ParkingSpot(SpotType spotType) {
        this.spotType = spotType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public boolean assignVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        return true;
    }
}

