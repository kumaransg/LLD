package cabBooking.model;

import cabBooking.constants.CarType;

/**
 * @author priyamvora
 * @created 01/05/2021
 */
public class Car extends Vehicle {
    private final CarType carType;

    public Car(String registrationNumber, String color, String model, String brand, CarType carType) {
        super(registrationNumber, color, model, brand);
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }
}
