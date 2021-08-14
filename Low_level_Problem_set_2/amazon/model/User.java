package amazon.model;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public abstract class User {
    private final String userId;

    public User() {
        this.userId = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
