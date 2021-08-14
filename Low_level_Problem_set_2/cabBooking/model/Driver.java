package cabBooking.model;

/**
 * @author priyamvora
 * @created 01/05/2021
 */
public class Driver extends Account {
    private final String licenseId;

    public Driver(String accountId, String name, String phoneNumber, String email, String licenseId) {
        super(accountId, name, phoneNumber, email);
        this.licenseId = licenseId;
    }

    public String getLicenseId() {
        return licenseId;
    }
}
