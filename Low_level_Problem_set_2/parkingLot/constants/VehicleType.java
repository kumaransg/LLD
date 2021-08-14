package parkingLot.constants;

/**
 * @author priyamvora
 * @created 18/04/2021
 */
public enum VehicleType {
    UNKNOWN,
    CAR,
    BIKE,
    TRUCK;

    public int getValue() {
        return this.ordinal();
    }

    public static VehicleType fromValue(Integer value) {
        if (value == null || value < 0 || value >= VehicleType.values().length) {
            return UNKNOWN;
        }
        return VehicleType.values()[value];
    }
}
