package service;

public interface IElevatorService {
    public void toggleFan();
    public void toggleLights();
    public void toggleAlarm();
    public void goToFloor(Integer Long);
    public void stopImmediately();
}
