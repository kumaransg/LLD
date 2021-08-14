package SystemDesign.Elevator;

public class FloorCallingUnit {
    int currentFloor;
    CallingUnit callingUnit;

    public FloorCallingUnit(int currentFloor, CallingUnit callingUnit) {
        this.currentFloor = currentFloor;
        this.callingUnit = callingUnit;
    }

    public void callElevator(int destinationFloor){
        callingUnit.moveElevator(currentFloor,destinationFloor);
    }
}
