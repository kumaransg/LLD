package SystemDesign.ElevatorDesign2.ecs;

import SystemDesign.ElevatorDesign2.ecs.enums.ElevatorDirection;
import SystemDesign.ElevatorDesign2.ecs.enums.ElevatorStatus;

/**
 * Created by Arun Singh on 4/3/16.
 */
public interface IElevator {
    /*
    Update the status of elevator. Valid states - ELEVATOR_FUNCTIONAL or ELEVATOR_MAINTENANCE.
     */
    public boolean updateStatus(ElevatorStatus elevatorStatus);

    /*
    Get the elevator's status. Response - ELEVATOR_FUNCTIONAL or ELEVATOR_MAINTENANCE.
     */
    public ElevatorStatus getElevatorStatus();

    /*
    Get the next destination floor which will be served by elevator based on pickUp requests.
     */
    public int getNextDestionationFloor();

    /*
    get the current floor of elevator
     */
    public int getCurrentFloor();

    /*
    Add a new pickUpDestination to elevator
     */
    public void addNewDestinatoin(Integer destination);

    /*
    moves the elevator 1 floor at a time based on pickUp request and Elevator Service Algorithm.
     */
    public boolean moveAndCheckIfServed();

    /*
    Get the direction of elevator's movement. Response - ELEVATOR_UP or ELEVATOR_DOWN or ELEVATOR_NONE
     */
    public ElevatorDirection getDirection();

    /*
    Get the total number of pickUpRequests queued for this elevator
     */
    public int getTotalRequests();
    public int getId();
}
