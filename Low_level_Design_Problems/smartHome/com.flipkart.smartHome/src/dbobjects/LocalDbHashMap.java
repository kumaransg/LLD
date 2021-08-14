package dbobjects;

import domain.Device;
import domain.SmartHomeDevice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LocalDbHashMap {

    static Map<Integer, Device> deviceMap;

    static Map<Integer, SmartHomeDevice> smartHomeDeviceMap;

    public static Map<Integer, Device> getDeviceMap() {
        if (Objects.isNull(deviceMap)) {
            deviceMap = new HashMap<>();
            return deviceMap;
        }
        return deviceMap;
    }

    public static int getDeviceMapSize() {
        if (Objects.isNull(deviceMap)) {
            return 0;
        }
        return deviceMap.size();
    }

    public static Map<Integer, SmartHomeDevice> getSmartHomeDeviceMap() {
        if (Objects.isNull(smartHomeDeviceMap)) {
            smartHomeDeviceMap = new HashMap<>();
            return smartHomeDeviceMap;
        }
        return smartHomeDeviceMap;
    }

    public static int getSmartHomeDeviceSize() {
        if (Objects.isNull(smartHomeDeviceMap)) {
            return 0;
        }
        return smartHomeDeviceMap.size();
    }
}
