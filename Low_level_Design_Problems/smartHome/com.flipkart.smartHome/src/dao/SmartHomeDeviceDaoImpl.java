package dao;

import dbobjects.LocalDbHashMap;
import domain.SmartHomeDevice;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeDeviceDaoImpl implements SmartHomeDeviceDao {

    @Override
    public void addSmartHomeDevice(SmartHomeDevice smartHomeDevice) {
        int smartHomeDeviceId = LocalDbHashMap.getSmartHomeDeviceSize() + 1;
        LocalDbHashMap.getSmartHomeDeviceMap().put(smartHomeDeviceId, smartHomeDevice);
    }

    @Override
    public void updateSmartHomeDeviceStatus(int smartHomeDeviceId, boolean state, int currentLevel) {
        SmartHomeDevice smartHomeDevice = LocalDbHashMap.getSmartHomeDeviceMap().get(smartHomeDeviceId);
        smartHomeDevice.setState(state);
        smartHomeDevice.getStateProperty().setCurrentLevel(currentLevel);
    }

    @Override
    public int getUsageStatus(int smartHomeDeviceId) {
        SmartHomeDevice smartHomeDevice = LocalDbHashMap.getSmartHomeDeviceMap().get(smartHomeDeviceId);
        return smartHomeDevice.getUsageSoFar();
    }

    @Override
    public List<SmartHomeDevice> getSmartDevices() {
        List<SmartHomeDevice> smartHomeDevices = new ArrayList<>();
        LocalDbHashMap.getSmartHomeDeviceMap().forEach((integer, smartHomeDevice) -> {
            smartHomeDevices.add(smartHomeDevice);
        });

        return smartHomeDevices;
    }
}
