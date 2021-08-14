package movieTicketBooking.model;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class User {
    private final String userId;
    private final String name;
    private final String email;

    public User(String name, String email) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
