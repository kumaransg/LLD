package domain;

public class SmartHomeDevice extends AbstractSmartHomeDevice {

    private int id;

    private SmartHomeDeviceCategory smartHomeDeviceType;

    private String name;

    private int connectedToDeviceId;

    private int usageSoFar;

    private boolean state;

    private StateProperty stateProperty;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SmartHomeDeviceCategory getSmartHomeDeviceType() {
        return this.smartHomeDeviceType;
    }

    public void setSmartHomeDeviceType(SmartHomeDeviceCategory smartHomeDeviceType) {
        this.smartHomeDeviceType = smartHomeDeviceType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConnectedToDeviceId() {
        return this.connectedToDeviceId;
    }

    public void setConnectedToDeviceId(int connectedToDeviceId) {
        this.connectedToDeviceId = connectedToDeviceId;
    }

    public int getUsageSoFar() {
        return this.usageSoFar;
    }

    public void setUsageSoFar(int usageSoFar) {
        this.usageSoFar = usageSoFar;
    }

    public boolean isState() {
        return this.state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public StateProperty getStateProperty() {
        return this.stateProperty;
    }

    public void setStateProperty(StateProperty stateProperty) {
        this.stateProperty = stateProperty;
    }
}
