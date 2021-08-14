package domain;

public class DeviceUsageDetails {

    private String deviceName;

    private int utilization;

    public DeviceUsageDetails(String deviceName, int utilization) {
        this.deviceName = deviceName;
        this.utilization = utilization;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getUtilization() {
        return this.utilization;
    }

    public void setUtilization(int utilization) {
        this.utilization = utilization;
    }
}
