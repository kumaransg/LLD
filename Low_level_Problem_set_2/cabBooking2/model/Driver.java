package cabBooking2.model;

/**
 * @author priyamvora
 * @created 23/05/2021
 */
public class Driver extends Account {
    private final String DLNumber;

    public Driver(String accountId, String email, String mobileNumber, String name, String DLNumber) {
        super(accountId, email, mobileNumber, name);
        this.DLNumber = DLNumber;
    }
}
