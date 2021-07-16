package service;

import model.Elevator;
import model.FloorSwitch;

public interface CallElevatorStrategy {
    public Elevator getElevator(Elevator[] elevators, Integer currentFloor, Integer direction);
}
