package SystemDesign.ElevatorDesign2.ecs.impl;

import SystemDesign.ElevatorDesign2.ecs.IElevator;
import SystemDesign.ElevatorDesign2.ecs.enums.ElevatorDirection;
import SystemDesign.ElevatorDesign2.ecs.enums.ElevatorStatus;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Arun Singh on 4/3/16.
 */

/*
     Elevator service algorithm:
     ---------------------------
     -> It can happen that an elevator is on its way from floor 1 to floor 10 and while its is at floor 5, elevator got a pickUp request for floor 8.
        In this case, we should stop the elevator at floor 8 first and then proceed to floor 10. So a simple FCFS algorithm in elevator service queue will not work.

     -> Each elevator maintains 2 sets of floors to be serviced.
        -> 1 TreeSet for all pickUp requests from floors above the getCurrentFloor in ascending order.
        -> 1 TreeSet for all pickUp requests from floors below the getCurrentFloor in descending order.
        -> TreeSet also helps avoid duplicate requests.
     -> When an elevator moves:
        -> Case I       -> Elevator was in NONE state which means elevator hasn't serviced any request yet or was done servicing all previous requests in the direction of its move.
                        -> Start servicing the request in the direction which has closest requestFloor and set the direction as UP or DOWN based on target floor's location.
        -> Case II      -> Elevator is moving UP:
                        -> Continue to move in this direction until all requestFloors above current floors are serviced.
                        -> When done servicing all above floors, reset the direction to NONE.
        -> Case III     -> Elevator is moving DOWN:
                        -> Continue to move in this direction until all requestFloors below current floors are serviced.
                        -> When done servicing all below floors, reset the direction to NONE.
 */

public class Elevator implements IElevator {

    private final Integer id;
    private Integer currentFloor;
    /*
    Sorted in Asc for up movement
     */
    private TreeSet<Integer> upDestinationFloors;
    /*
    Sorted in Desc for down movement
     */
    private TreeSet<Integer> downDestinationFloors;
    private ElevatorStatus elevatorStatus;
    ElevatorDirection direction;

    public Elevator(Integer currentFloor, Integer id) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.upDestinationFloors = new TreeSet<Integer>();
        this.downDestinationFloors = new TreeSet<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        this.elevatorStatus = ElevatorStatus.ELEVATOR_FUNCTIONAL;
        direction = ElevatorDirection.ELEVATOR_NONE;
    }

    public boolean updateStatus(ElevatorStatus elevatorStatus){
        /*
        Cannot update status for an elevator which is actively serving requests
         */
        if(getTotalRequests() > 0){
            return false;
        }
        this.elevatorStatus = elevatorStatus;
        return true;
    }

    public ElevatorStatus getElevatorStatus(){
        return this.elevatorStatus;
    }

    public int getId(){
        return this.id;
    }

    public int getNextDestionationFloor(){
        if(direction == ElevatorDirection.ELEVATOR_DOWN){
            return this.downDestinationFloors.first();
        }else if(direction == ElevatorDirection.ELEVATOR_UP){
            return this.upDestinationFloors.first();
        }else{
            return 0;
        }
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    public void addNewDestinatoin(Integer destination) {
        if(destination > currentFloor){
            upDestinationFloors.add(destination);
        }else{
            downDestinationFloors.add(destination);
        }
    }

    public boolean moveAndCheckIfServed() {
        direction();
        if(direction == ElevatorDirection.ELEVATOR_UP){
            if(upDestinationFloors.first() == currentFloor){
                return popUpDestionation();
            }else {
                currentFloor++;
            }
        }else if(direction == ElevatorDirection.ELEVATOR_DOWN){
            if(downDestinationFloors.first() == currentFloor){
                return popDownDestionation();
            }else {
                currentFloor--;
            }
        }else{
            //Do Nothing. Elevator is not moving.
        }
        return false;
    }

    public ElevatorDirection getDirection(){
        return this.direction;
    }

    private void direction() {
        if(direction == ElevatorDirection.ELEVATOR_NONE){
            if(upDestinationFloors.size() > 0 && downDestinationFloors.size() > 0){
                if(Math.abs(currentFloor - upDestinationFloors.first()) < Math.abs(currentFloor - downDestinationFloors.first())){
                    direction = ElevatorDirection.ELEVATOR_UP;
                }else{
                    direction = ElevatorDirection.ELEVATOR_DOWN;
                }
            }else if(upDestinationFloors.size() > 0){
                direction = ElevatorDirection.ELEVATOR_UP;
            }else if(downDestinationFloors.size() > 0){
                direction = ElevatorDirection.ELEVATOR_DOWN;
            }
        }
    }

    private boolean popUpDestionation() {
        upDestinationFloors.remove(upDestinationFloors.first());
        if (upDestinationFloors.size() == 0) {
            direction = ElevatorDirection.ELEVATOR_NONE;
        }
        return true;
    }

    private boolean popDownDestionation() {
        downDestinationFloors.remove(downDestinationFloors.first());
        if(downDestinationFloors.size() == 0){
            direction = ElevatorDirection.ELEVATOR_NONE;
        }
        return true;
    }

    public int getTotalRequests(){
        return upDestinationFloors.size() + downDestinationFloors.size();
    }
}
