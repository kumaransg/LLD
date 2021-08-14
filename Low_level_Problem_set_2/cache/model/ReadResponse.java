package cache.model;

/**
 * @author priyamvora
 * @created 03/05/2021
 */
public class ReadResponse<Value> {
    private final Value value;
    private final Integer timeTaken;

    public ReadResponse(Value value, Integer timeTaken) {
        this.value = value;
        this.timeTaken = timeTaken;
    }

    public Value getValue() {
        return value;
    }

    public Integer getTimeTaken() {
        return timeTaken;
    }

    @Override
    public String toString() {
        return "ReadResponse{" +
                "value=" + value +
                ", timeTaken=" + timeTaken +
                '}';
    }
}
