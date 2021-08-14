package SystemDesign.LogisticsDesign;

public class Vehicle {
    int plateNo;
    int id;
    int capacity;
    private Location currentPosition;
    String vehicleStatus;

    public Vehicle(int plateNo, int id, int capacity) {
        this.plateNo = plateNo;
        this.id = id;
        this.capacity = capacity;
    }
}
