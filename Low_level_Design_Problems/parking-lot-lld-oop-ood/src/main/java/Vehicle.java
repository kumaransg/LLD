public class Vehicle {
    private final Double id;
    private final VehicleType type;

    public Vehicle(VehicleType type) {
        this.id = Math.random();
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}