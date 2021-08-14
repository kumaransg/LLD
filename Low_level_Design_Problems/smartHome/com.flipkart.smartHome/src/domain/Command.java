package domain;

public class Command extends AbstractCommand {

    private int devicedId;

    private SmartHomeDevice smartHomeDevice;

    private boolean changeState;

    private StateProperty stateProperty;

    public int getDevicedId() {
        return this.devicedId;
    }

    public void setDevicedId(int devicedId) {
        this.devicedId = devicedId;
    }

    public SmartHomeDevice getSmartHomeDevice() {
        return this.smartHomeDevice;
    }

    public void setSmartHomeDevice(SmartHomeDevice smartHomeDevice) {
        this.smartHomeDevice = smartHomeDevice;
    }

    public boolean isChangeState() {
        return this.changeState;
    }

    public void setChangeState(boolean changeState) {
        this.changeState = changeState;
    }

    public StateProperty getStateProperty() {
        return this.stateProperty;
    }

    public void setStateProperty(StateProperty stateProperty) {
        this.stateProperty = stateProperty;
    }
}
