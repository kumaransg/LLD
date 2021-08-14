package cabBooking.model;

/**
 * @author priyamvora
 * @created 01/05/2021
 */
public abstract class Account {
    private final String accountId;
    private final String name;
    private final String phoneNumber;
    private final String email;

    public Account(String accountId, String name, String phoneNumber, String email) {
        this.accountId = accountId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
