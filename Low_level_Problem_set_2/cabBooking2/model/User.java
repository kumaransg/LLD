package cabBooking2.model;

/**
 * @author priyamvora
 * @created 23/05/2021
 */
public class User extends Account{
    public User(String accountId, String email, String mobileNumber, String name) {
        super(accountId, email, mobileNumber, name);
    }
}
