package cabBooking2.model;

/**
 * @author priyamvora
 * @created 23/05/2021
 */
public abstract class Account {
    private final String accountId;
    private final String email;
    private final String mobileNumber;
    private final String name;

    public Account(String accountId, String email, String mobileNumber, String name) {
        this.accountId = accountId;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.name = name;
    }


    public String getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getName() {
        return name;
    }


}
