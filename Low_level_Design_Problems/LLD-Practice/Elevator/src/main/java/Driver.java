import model.Elevator;
import model.FloorSwitch;
import service.ElevatorManager;

public class Driver {
    public static void main(String[] args) {
        Elevator elevators[] = {
                new Elevator(1),
                new Elevator(2),
                new Elevator(3),
                new Elevator(4),
                new Elevator(5),
        };

        FloorSwitch floorSwitch[]={
                new FloorSwitch(1),
                new FloorSwitch(2),
                new FloorSwitch(3),
                new FloorSwitch(4),
                new FloorSwitch(5),
        };

        ElevatorManager elevatorManager= new ElevatorManager(elevators);

        //TODO: add functionality for stoping


        //TODO: Use threads
    }
}
