package cabBooking.model;

/**
 * @author priyamvora
 * @created 01/05/2021
 */
public class User extends Account {
    public User(String accountId, String name, String phoneNumber, String email) {
        super(accountId, name, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "User{" + super.toString() + "}";
    }
}
