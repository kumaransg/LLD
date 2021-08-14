package SystemDesign.Elevator;

public class CallingUnit {
    DispatcherUnit dispatcherUnit;

    public CallingUnit(DispatcherUnit dispatcherUnit) {
        this.dispatcherUnit = dispatcherUnit;
    }

    void moveElevator(int currentFloor, int destinationFloor){
        dispatcherUnit.getNextFloorForElevator(currentFloor, destinationFloor);
    };
}
