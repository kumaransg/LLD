package cabBooking2.model;

/**
 * @author priyamvora
 * @created 23/05/2021
 */
public abstract class Vehicle {
    private String registrationNo;
    private String color;
    private String model;

    public Vehicle(String registrationNo, String color, String model) {
        this.registrationNo = registrationNo;
        this.color = color;
        this.model = model;
    }
}
