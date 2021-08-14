package cabBooking.model;

/**
 * @author priyamvora
 * @created 01/05/2021
 */
public abstract class Vehicle {
    private String registrationNumber;
    private String color;
    private String model;
    private String brand;

    public Vehicle(String registrationNumber, String color, String model, String brand) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.model = model;
        this.brand = brand;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }
}
