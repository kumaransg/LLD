package stackoverflow.model;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Account {
    private final String name;
    private final String email;

    public Account(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
