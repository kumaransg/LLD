package SystemDesign.ElevatorDesign;

import java.util.*;

public class ElevatorController implements IElevatorController, ElevatorEventListener {
    private int numElevators;
    private int numFloors;
    private Elevator [] elevators = null;
    private ArrayList<Queue<Integer>> passengers = null;

    private void  initElevators(int numElevators, int numFloors) {
        if(numElevators<0)  throw new IllegalArgumentException();
        elevators = new Elevator [numElevators];
        for (int i=0; i<numElevators;i++) {
            Elevator el = new Elevator(numFloors);
            el.setElEventListener(this);
            elevators[i] = el;
        }
    }

    private void initFloors(int numFloors) {
        if(numFloors<0)  throw new IllegalArgumentException();
        passengers = new ArrayList<Queue<Integer>> (numFloors);
        for(int i=0;i<numFloors;i++) passengers.add(i, new LinkedList<Integer>());
    }

    public ElevatorController (int numElevators, int numFloors) {
        initFloors(numFloors);
        initElevators(numElevators, numFloors);
        this.numElevators = numElevators;
        this.numFloors = numFloors;
    }

    private int calculateRoute(int afloor, int bfloor) {
        return Math.abs(afloor - bfloor);
    }

    private int calculateRoute(int xfloor, int xefloor, int tfloor) {
        return calculateRoute(xefloor, tfloor) + calculateRoute(xfloor, tfloor);
    }


    public Queue<Integer> getPassengers(int floor) {
        if((floor<0) || (floor >= numFloors )  ) throw new IllegalArgumentException();
        return passengers.get(floor);
    }

    public void setPassengers(Queue<Integer> pssgrs, int floor) {
        if(pssgrs == null) throw new NullPointerException();
        if((floor<0) || (floor >= numFloors )  ) throw new IllegalArgumentException();
        this.passengers.add(floor, pssgrs);
    }

    @Override
    public  void status() {
        int i = 0;
        for(Elevator el:elevators) {
            System.out.print( " elID =  " + i++ + " CurrentFloor = " + el.getCurrentFloor() + " Moving =  " + el.getMove()  +  " DIRECTION = " + el.getDirection() + "\n");
        }
    }

    @Override
    public Elevator getElevator(int elevatorId) {
        if((elevatorId<0) || (elevatorId >= numElevators ) ) throw new NoSuchElementException();
        return elevators[elevatorId];
    }

    @Override
    public void reset(int elevatorId, int floor) {
        if((elevatorId<0) || (elevatorId >= numElevators ) ) throw new NoSuchElementException();
        Elevator elevator = elevators[elevatorId];
        elevator.moveToFloor(floor);
    }

    @Override
    public void pickup(int floor, boolean direction) {
        if((floor<0) || (floor >= numFloors )) throw new IllegalArgumentException();
        // shufling the order of elevators in the case where most of the elevators are on the same floors and they are picked up at the same time from different floors
        // this is going to run several elevators instead of only the first !
        int [] elevatorIDs = new int[numElevators];
        for(int i=0; i<numElevators; i++) elevatorIDs[i] = i;
        //Random.shuffle(elevatorIDs);

        Elevator.DIRECTION userDirection = (direction) ? (Elevator.DIRECTION.UP):(Elevator.DIRECTION.DOWN);
        int minDistance = numFloors;
        Elevator closestElevator = null;
        int d;
        for (int elID : elevatorIDs ) {
            Elevator elevator = elevators[elID];
            if(	(elevator.getMove() == false) ||
                    ((userDirection == Elevator.DIRECTION.UP) && (elevator.getDirection() == Elevator.DIRECTION.UP) && (floor >= elevator.getCurrentFloor())) ||
                    ((userDirection == Elevator.DIRECTION.DOWN) && (elevator.getDirection() == Elevator.DIRECTION.DOWN) && (floor <= elevator.getCurrentFloor())) )
                d =	calculateRoute(floor,elevator.getCurrentFloor());
            else
                d = calculateRoute(floor, elevator.getCurrentFloor(), elevator.getGoalFloor());

            if(d<minDistance) {
                minDistance = d;
                closestElevator = elevator;
            }
        }

        closestElevator.setGoalFloor(floor);
    }

    @Override
    public void update(int elevatorId, int floor) {
        if((floor<0) || (floor >= numFloors )) throw new IllegalArgumentException();
        if((elevatorId<0) || (elevatorId >= numElevators ) ) throw new NoSuchElementException();

        Elevator el = elevators[elevatorId];
        el.setGoalFloor(floor);
    }

    @Override
    public void step() {
        for(Elevator elevator : elevators) elevator.moveNext();
    }

    @Override
    public void onStopped(Object sender) {
        /// onboarding waiting people
        Queue<Integer> psQueue = getPassengers(((Elevator)sender).getCurrentFloor());
        if(psQueue == null) return;
        if(psQueue.isEmpty()) return;
        for(Integer goalFloor : psQueue){
            ((Elevator)sender).setGoalFloor(goalFloor);
        }
    }
}