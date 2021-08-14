package domain;

import java.util.ArrayList;
import java.util.List;

public class Device extends AbstractDevice {

    private int id;

    private DeviceType deviceType;

    private List<SmartHomeDevice> smartHomeDevices = new ArrayList<>();

    private ActivationType activationType;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public List<SmartHomeDevice> getSmartHomeDevices() {
        return this.smartHomeDevices;
    }

    public void setSmartHomeDevices(List<SmartHomeDevice> smartHomeDevices) {
        this.smartHomeDevices = smartHomeDevices;
    }

    public ActivationType getActivationType() {
        return this.activationType;
    }

    public void setActivationType(ActivationType activationType) {
        this.activationType = activationType;
    }
}
