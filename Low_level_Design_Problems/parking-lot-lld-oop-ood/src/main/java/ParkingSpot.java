import java.util.Objects;

class ParkingSpot {
    public Double getId() {
        return id;
    }

    private final Double id;
    private final ParkingSpotType type;
    private Vehicle vehicle;

    ParkingSpot(ParkingSpotType type) {
        this.id = Math.random();
        this.type = type;
    }

    public ParkingSpotType getType() {
        return type;
    }

    void parkVehicle(Vehicle vehicle) throws RuntimeException {
        if (Objects.nonNull(this.vehicle)) {
            return;
        }
        this.vehicle = vehicle;
        throw new RuntimeException("Parking spot is already full");
    }

    Vehicle unParkVehicle() throws RuntimeException {
        if (Objects.nonNull(this.vehicle)) {
            Vehicle vehicle = this.vehicle;
            this.vehicle = null;
            return vehicle;
        }
        throw new RuntimeException("Vehicle doesn't exist in parking spot");
    }

    @Override
    public String toString() {
        return "{id= " + id + ", type= " + type + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return id.equals(that.id) &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}