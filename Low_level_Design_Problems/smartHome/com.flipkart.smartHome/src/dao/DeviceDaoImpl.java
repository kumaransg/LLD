package dao;

import dbobjects.LocalDbHashMap;
import domain.Device;
import domain.SmartHomeDevice;

import java.util.List;

public class DeviceDaoImpl implements DeviceDao {

    @Override
    public void addDevice(Device device) {
        int deviceId = LocalDbHashMap.getDeviceMapSize() + 1;
        LocalDbHashMap.getDeviceMap().put(deviceId, device);
    }

    @Override
    public List<SmartHomeDevice> getConnectedSmartHomeDeviceList(int deviceId) {
       Device device = LocalDbHashMap.getDeviceMap().get(deviceId);
       return device.getSmartHomeDevices();
    }

    @Override
    public Device getDevice(int deviceId) {
        return LocalDbHashMap.getDeviceMap().get(deviceId);
    }

    @Override
    public SmartHomeDevice getSmartHomeDevice(int deviceId, int smartDeviceId) {
        Device device = LocalDbHashMap.getDeviceMap().get(deviceId);

        // device.getSmartHomeDevices().stream().findFirst(smartDeviceId);

        List<SmartHomeDevice> smartHomeDevices = device.getSmartHomeDevices();

        for(SmartHomeDevice shd : smartHomeDevices) {
            if(shd.getId() == smartDeviceId) {
                return shd;
            }
        }

        return null;

    }
}
