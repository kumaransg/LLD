package service;

import dao.DeviceDaoImpl;
import dao.SmartHomeDeviceDaoImpl;
import domain.*;

public class HomeServiceImplTest {

    public static void main(String[] args) {
        DeviceDaoImpl deviceDao = new DeviceDaoImpl();
        SmartHomeDeviceDaoImpl smartHomeDeviceDao = new SmartHomeDeviceDaoImpl();

        HomeServiceImpl homeService = new HomeServiceImpl(deviceDao, smartHomeDeviceDao);

        final Device device = new Device();
        device.setDeviceType(DeviceType.GOOGLE);
        device.setActivationType(ActivationType.OK_GOOGLE);

        final Device device2 = new Device();
        device2.setDeviceType(DeviceType.ALEXA);
        device2.setActivationType(ActivationType.ALEXA);

        homeService.addDevice(device);
        homeService.addDevice(device2);

        final SmartHomeDevice smartHomeDevice = new SmartHomeDevice();
        smartHomeDevice.setConnectedToDeviceId(2);
        smartHomeDevice.setSmartHomeDeviceType(SmartHomeDeviceCategory.DRAWING_ROOM_LIGHT);

        homeService.addSmartHomeDevice(smartHomeDevice);

        final SmartHomeDevice smartHomeDevice2 = new SmartHomeDevice();
        smartHomeDevice2.setConnectedToDeviceId(1);
        smartHomeDevice2.setSmartHomeDeviceType(SmartHomeDeviceCategory.LIVING_ROOM_FAN);
        final StateProperty stateProperty = new StateProperty();
        stateProperty.setCurrentLevel(2);
        stateProperty.setMinLevel(1);
        stateProperty.setMaxLevel(5);
        smartHomeDevice2.setStateProperty(stateProperty);

        homeService.addSmartHomeDevice(smartHomeDevice2);

        final SmartHomeDevice smartHomeDevice3 = new SmartHomeDevice();
        smartHomeDevice3.setSmartHomeDeviceType(SmartHomeDeviceCategory.SMART_CHARGER);
        smartHomeDevice3.setConnectedToDeviceId(2);

        homeService.addSmartHomeDevice(smartHomeDevice3);

        Command command = new Command();
        command.setDevicedId(2);
        command.setChangeState(true);
        // command.setSmartHomeDevice();






    }
}
