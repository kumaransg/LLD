import java.time.LocalDateTime;

public class EntryPoint {
    private final Double id;

    public EntryPoint(ParkingRate rate) {
        this.id = Math.random();
    }

    ParkingTicket generateTicket(Vehicle vehicle) {
        VehicleType type = vehicle.getType();
        ParkingRate rate = ParkingRate.valueOf(type.toString());

        return new ParkingTicket(LocalDateTime.now(), rate);
    }
}