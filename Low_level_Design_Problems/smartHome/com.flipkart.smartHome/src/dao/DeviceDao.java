package dao;

import domain.Device;
import domain.SmartHomeDevice;

import java.util.List;

public interface DeviceDao {

    public void addDevice(Device device);


    public List<SmartHomeDevice> getConnectedSmartHomeDeviceList(int deviceId);

    Device getDevice(int deviceId);

    SmartHomeDevice getSmartHomeDevice(int deviceId, int smartDeviceId);
}
