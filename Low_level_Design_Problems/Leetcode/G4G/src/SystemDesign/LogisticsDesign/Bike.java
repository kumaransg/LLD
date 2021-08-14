package SystemDesign.LogisticsDesign;

public class Bike extends Vehicle {
    private static final int size = 10;

    public Bike(int plateNo, int id, int capacity) {
        super(plateNo, id, size);
    }
}
