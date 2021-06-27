package service;

import model.Elevator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ElevatorManager {
    private Elevator[] elevators;
    private CallElevatorStrategy callElevatorStrategy;
    private Logger logger= LoggerFactory.getLogger(ElevatorManager.class);

    public ElevatorManager(Elevator[] elevators) {
        this.elevators = elevators;
        this.callElevatorStrategy= new NearestCallElevatorStrategy();
    }

    public void callElevator(Integer currentFloor, Integer direction){
        Elevator elevator= null;

        while (elevator!=null){//syaapaa logic
            callElevatorStrategy.getElevator(elevators,currentFloor, direction);
        }

        logger.info("Elevator: ",elevator.getId()," is coming to rescue you!");
        elevator.getState().getIsPressed().add(currentFloor);
    }
}
