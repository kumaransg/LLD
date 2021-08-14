package SystemDesign.ElevatorDesign2.ecs.impl;

import SystemDesign.ElevatorDesign2.ecs.IElevatorControlSystem;
import SystemDesign.ElevatorDesign2.ecs.enums.ElevatorDirection;
import SystemDesign.ElevatorDesign2.ecs.enums.ElevatorStatus;
//import ecs.enums.ElevatorDirection;
//import ecs.enums.ElevatorStatus;

/**
 * Created by Arun Singh on 4/3/16.
 */

/*
    Scheduling Algorithm:
    ---------------------------
    -> Upper bound of active requests per elevator (Average per elevator) = activeRequests/elevatorCount + 1
    -> Do not assign the request to an elevator if it is under MAINTENANCE or is already serving more than average number of active requests in the system.
    -> Now, among all elevators excluding above ones, find the closest elevator moving in direction of request or is IDLE.
        -> Case I -     There are 2 elevators - 1 above the requestFloor coming down and 1 below the requestFloor which is coming up:
                        Assign the request to the closest of these 2.
                        return true
        -> Case II -    There is only 1 elevator moving towards the requestFloor:
                        Assign the request to the given elevator.
                        return true
        -> Case III -   No elevators were found eligible to serve the request. Can happen if all the elevators are under MAINTENANCE
                        return false as we could not schedule the request to any of the elevators in the system.
 */


public class ElevatorControlSystem implements IElevatorControlSystem {

    private static final int MAX_ELEVATORS = 16;
    private Elevator[] elevators;
    private final int elevatorCount;
    /*
    activeRequests is used to maintain the maintain the active requests count in system which are not served.
    Used to balance the number of requests between elevators.
     */
    private int activeRequests;

    /*
    Get the number of elevator as argument to the constructor.
        If it is greator than MAX_ELEVATORS,
            then number of elevator = MAX_ELEVATORS
            else number of elevator = input
    Initialize all elevators at floor 0.
     */
    public ElevatorControlSystem(int elevatorCount){
        this.elevatorCount = elevatorCount > MAX_ELEVATORS ? MAX_ELEVATORS : elevatorCount;
        this.elevators = new Elevator[elevatorCount];
        for(int elevator = 0; elevator < elevatorCount; elevator++){
            elevators[elevator] = new Elevator(0, elevator);
        }
    }

    public boolean updateStatus(ElevatorStatus elevatorStatus, int elevatorId) {
        if(elevatorId < 0 || elevatorId > elevatorCount-1){
            return false;
        }
        return elevators[elevatorId].updateStatus(elevatorStatus);
    }


    /*
        Schedules the pickUpRequest based on above ***SCHEDULING ALGORITHM***
         */
    public boolean pickUpRequest(int fromFloor) {
        int maxRequestPerElevator = activeRequests/elevatorCount+1;
        int minUp = Integer.MAX_VALUE;
        Elevator minUpElevator = null;
        int minDown = Integer.MAX_VALUE;
        Elevator minDownElevator = null;
        for(Elevator elevator : elevators){
            /*
            Don't schedule anything for given under maintenance or if elevator is already servicing more than average load on system
             */
            if(elevator.getElevatorStatus() == ElevatorStatus.ELEVATOR_MAINTENANCE || elevator.getTotalRequests() >= maxRequestPerElevator){
                continue;
            }
            if((elevator.getDirection() == ElevatorDirection.ELEVATOR_UP
                    || elevator.getDirection() == ElevatorDirection.ELEVATOR_NONE)
                    && elevator.getCurrentFloor() < fromFloor){
                if(minUp > fromFloor - elevator.getCurrentFloor()){
                    minUp = fromFloor - elevator.getCurrentFloor();
                    minUpElevator = elevator;
                }
            }else if((elevator.getDirection() == ElevatorDirection.ELEVATOR_DOWN
                    || elevator.getDirection() == ElevatorDirection.ELEVATOR_NONE)
                    && elevator.getCurrentFloor() > fromFloor){
                if(minDown > elevator.getCurrentFloor() - fromFloor){
                    minDown = elevator.getCurrentFloor() - fromFloor;
                    minDownElevator = elevator;
                }
            }
        }
        /*
        If we found 2 elevators in both up and down direction. Assign the pickUp requests to closest elevator.
         */
        if(minDownElevator != null && minUpElevator != null){
            if(minDown < minUp){
                minDownElevator.addNewDestinatoin(fromFloor);
            }else{
                minUpElevator.addNewDestinatoin(fromFloor);
            }
        }
        /*
        If we found only 1 closest elevator in down direction. Assign the pickUp requests to it.
         */
        else if(minDownElevator != null){
            minDownElevator.addNewDestinatoin(fromFloor);
        }
        /*
        If we found only 1 closest elevator in up direction. Assign the pickUp requests to it.
         */
        else if(minUpElevator != null){
            minUpElevator.addNewDestinatoin(fromFloor);
        }
        /*
        We could not allocate the request to any elevator. All elevators must be under maintenance. Return false.
         */
        else{
            return false;
        }

        activeRequests++;
        return true;
    }

    public void step() {
        //Loop though every elevator and call move
        for (Elevator currElevator : elevators) {
            if(currElevator.moveAndCheckIfServed()){
                activeRequests--;
            }
        }
    }

    public Elevator[] getElevators(){
        return elevators;
    }

    public int getActiveRequests(){
        return activeRequests;
    }

}
