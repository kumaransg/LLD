package parkingLot2.model;

/**
 * @author priyamvora
 * @created 12/05/2021
 */
public abstract class Gate {
    private final String gateId;

    public Gate(String gateId) {
        this.gateId = gateId;
    }

    public String getGateId() {
        return gateId;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "gateId='" + gateId + '\'' +
                '}';
    }
}
