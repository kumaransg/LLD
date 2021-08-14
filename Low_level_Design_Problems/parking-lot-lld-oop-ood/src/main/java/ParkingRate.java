public enum ParkingRate {
    SMALL(VehicleType.SMALL, 50),
    MEDIUM(VehicleType.MEDIUM, 100),
    BIG(VehicleType.BIG, 150);

    private final VehicleType vehicleType;
    private final Integer amount;

    ParkingRate(VehicleType vehicleType, Integer amount) {
        this.vehicleType = vehicleType;
        this.amount = amount;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public Integer getAmount() {
        return this.amount;
    }
}