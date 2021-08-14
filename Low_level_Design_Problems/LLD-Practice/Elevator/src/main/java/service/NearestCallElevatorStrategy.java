package service;

import model.Direction;
import model.Elevator;

public class NearestCallElevatorStrategy implements CallElevatorStrategy{
    @Override
    public Elevator getElevator(Elevator[] elevators, Integer currentFloor, Integer direction) {
        int minDist=Integer.MAX_VALUE,idleElevatorDistance= Integer.MAX_VALUE;
        Elevator minDistElevator=null, idleElevator=null;

        for(Elevator elevator:elevators){
            if(direction == 0){//going UP
                if(elevator.getState().getDirection() == Direction.UP && elevator.getState().getCurrentFloor() <= currentFloor){
                    if(minDistElevator==null){
                        minDistElevator=elevator;
                        minDist=Math.abs(elevator.getState().getCurrentFloor()-currentFloor);
                    }
                    else if(minDist > Math.abs(elevator.getState().getCurrentFloor()-currentFloor)){
                        minDist= Math.abs(elevator.getState().getCurrentFloor()-currentFloor);
                        minDistElevator=elevator;
                    }
                }
            }
            else{//going DOWN
                if(elevator.getState().getDirection() == Direction.DOWN && elevator.getState().getCurrentFloor() >= currentFloor){
                    if(minDistElevator==null){
                        minDistElevator=elevator;
                        minDist=Math.abs(elevator.getState().getCurrentFloor()-currentFloor);
                    }
                    else if(minDist > Math.abs(elevator.getState().getCurrentFloor()-currentFloor)){
                        minDist= Math.abs(elevator.getState().getCurrentFloor()-currentFloor);
                        minDistElevator=elevator;
                    }
                }
            }

            if(elevator.getState().getDirection() == Direction.IDLE){
                if(idleElevator == null){
                    idleElevator= elevator;
                    idleElevatorDistance= Math.abs(elevator.getState().getCurrentFloor()-currentFloor);
                }
                else if(idleElevatorDistance > Math.abs(elevator.getState().getCurrentFloor()-currentFloor)){
                    idleElevatorDistance= Math.abs(elevator.getState().getCurrentFloor()-currentFloor);
                    idleElevator=elevator;
                }
            }
        }

        if(minDist > idleElevatorDistance){
            return idleElevator;
        }
        return minDistElevator;
    }
}
