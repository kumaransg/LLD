package service;

import dao.DeviceDao;
import dao.SmartHomeDeviceDao;
import domain.*;
import exception.DeviceNotExistsException;
import exception.WrongStateException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class HomeServiceImpl implements HomeService {

    // TODO Autowire.
    private DeviceDao deviceDao;

    private SmartHomeDeviceDao smartHomeDeviceDao;

    public HomeServiceImpl(DeviceDao deviceDao, SmartHomeDeviceDao smartHomeDeviceDao) {
        this.deviceDao = deviceDao;
        this.smartHomeDeviceDao = smartHomeDeviceDao;
    }

    @Override
    public void addDevice(Device device) {
        this.deviceDao.addDevice(device);
    }

    @Override
    public void addSmartHomeDevice(SmartHomeDevice smartHomeDevice) {
        this.smartHomeDeviceDao.addSmartHomeDevice(smartHomeDevice);
    }

    @Override
    public void sendCommand(Command command) {
        final int deviceId = command.getDevicedId();
        final Device device = this.deviceDao.getDevice(deviceId);

        //TODO replace all null check with assert.
        if (Objects.isNull(device)) {
            throw new DeviceNotExistsException("Device with id " + deviceId + "doesn't exist");
        }

        final SmartHomeDevice smartHomeDevice = command.getSmartHomeDevice();

        if (smartHomeDeviceExists(device, smartHomeDevice)) {
            SmartHomeDevice shd = this.deviceDao.getSmartHomeDevice(device.getId(), smartHomeDevice.getId());
            if (Objects.isNull(shd)) {
                throw new DeviceNotExistsException("Device with id " + smartHomeDevice.getId() + "doesn't exist");
            }
            // increment usage property if state change is from on to off.
            if (command.isChangeState() == false && shd.isState() == true) {
                // Requirement was given if the smart home device is switched off just increment usage so far to 1.
                shd.setUsageSoFar(shd.getUsageSoFar() + 1);
                shd.setState(false);
            } else if (command.isChangeState() == true && shd.isState() == false) {
                shd.setState(true);
            }
            // check state and throw exception if required.
            StateProperty stateProperty = command.getStateProperty();
            StateProperty statePropertyDevice = shd.getStateProperty();

            if (stateProperty.getState() != statePropertyDevice.getState()) {
                throw new WrongStateException("Given state is not applicable.");
            }

            if (stateProperty.getCurrentLevel() > statePropertyDevice.getMaxLevel() || stateProperty.getCurrentLevel() < statePropertyDevice.getMinLevel()) {
                throw new WrongStateException("State change is not in range");
            }

            shd.getStateProperty().setCurrentLevel(stateProperty.getCurrentLevel());

        } else {
            throw new DeviceNotExistsException("Smarthome device with id " + smartHomeDevice.getId() + "doesn't exist");
        }


        return;
    }

    private boolean smartHomeDeviceExists(Device device, SmartHomeDevice smartHomeDevice) {
        List<SmartHomeDevice> smartHomeDevices = device.getSmartHomeDevices();
        Iterator iterator = smartHomeDevices.iterator();
        while (iterator.hasNext()) {
            SmartHomeDevice shd = (SmartHomeDevice) iterator.next();
            if (shd.getId() == smartHomeDevice.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<SmartHomeDevice> getConnectedSmartHomeDeviceList(int deviceId) {
        return this.deviceDao.getConnectedSmartHomeDeviceList(deviceId);
    }

    @Override
    public List<DeviceUsageDetails> getDeviceUsageDetails() {
        List<SmartHomeDevice> smartHomeDevices = this.smartHomeDeviceDao.getSmartDevices();
        List<DeviceUsageDetails> deviceUsageDetails = new ArrayList<>();

        smartHomeDevices.forEach(smartHomeDevice -> {
            deviceUsageDetails.add(new DeviceUsageDetails(smartHomeDevice.getName(), smartHomeDevice.getUsageSoFar()));
        });

        return deviceUsageDetails;
    }
}
