package cabBooking.model;

import cabBooking.constants.CabStatus;
import cabBooking.constants.CabType;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 01/05/2021
 */
public class Cab {
    private String cabId;
    private final Vehicle vehicle;
    private final Driver driver;
    private final CabType cabType;
    private final Integer capacity;
    private CabStatus cabStatus;

    public Cab(Vehicle vehicle, Driver driver, CabType cabType, Integer capacity) {
        this.cabId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.driver = driver;
        this.cabType = cabType;
        this.capacity = capacity;
        this.cabStatus = CabStatus.AVAILABLE;
    }

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public CabType getCabType() {
        return cabType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public CabStatus getCabStatus() {
        return cabStatus;
    }

    public void setCabStatus(CabStatus cabStatus) {
        this.cabStatus = cabStatus;
    }
}
