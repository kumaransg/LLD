package cabBooking2.model;

import cabBooking2.constants.CabStatus;
import cabBooking2.constants.CabType;

/**
 * @author priyamvora
 * @created 23/05/2021
 */
public class Cab {
    private final String cabId;
    private final Driver driver;
    private final Vehicle vehicle;
    private final CabType cabType;
    private CabStatus cabStatus;
    private final Integer capacity;

    public Cab(String cabId, Driver driver, Vehicle vehicle, CabType cabType, CabStatus cabStatus, Integer capacity) {
        this.cabId = cabId;
        this.driver = driver;
        this.vehicle = vehicle;
        this.cabType = cabType;
        this.cabStatus = cabStatus;
        this.capacity = capacity;
    }

    public String getCabId() {
        return cabId;
    }

    public Driver getDriver() {
        return driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public CabType getCabType() {
        return cabType;
    }

    public CabStatus getCabStatus() {
        return cabStatus;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCabStatus(CabStatus cabStatus) {
        this.cabStatus = cabStatus;
    }
}
