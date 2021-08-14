package stackoverflow.model;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Badge {
    private final String name;

    public Badge(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "name='" + name + '\'' +
                '}';
    }
}
