package dao;

import domain.SmartHomeDevice;

import java.util.List;

public interface SmartHomeDeviceDao {

    public void addSmartHomeDevice(SmartHomeDevice smartHomeDevice);

    public void updateSmartHomeDeviceStatus(int smartHomeDeviceId, boolean state, int currentLevel);

    public int getUsageStatus(int smartHomeDeviceId);

    List<SmartHomeDevice> getSmartDevices();
}
