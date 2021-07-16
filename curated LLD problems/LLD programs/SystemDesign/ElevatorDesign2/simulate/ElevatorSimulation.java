package SystemDesign.ElevatorDesign2.simulate;

import SystemDesign.ElevatorDesign2.ecs.IElevatorControlSystem;
import SystemDesign.ElevatorDesign2.ecs.impl.Elevator;
import SystemDesign.ElevatorDesign2.ecs.impl.ElevatorControlSystem;

/**
 * Created by Arun Singh on 4/3/16.
 */
public class ElevatorSimulation {

    public static void main(String[] args) {

        IElevatorControlSystem elevatorControlSystem = (IElevatorControlSystem) new ElevatorControlSystem(16);
        for(int i = 1; i <= 18; i++){
            elevatorControlSystem.pickUpRequest(i);
        }

        System.out.println("*** Request Distribution ***");
        for(Elevator elevator : elevatorControlSystem.getElevators()){
            System.out.println("Elevator[" + elevator.getId() + "] - " + elevator.getTotalRequests());
        }

        System.out.println("------------------------");

        System.out.println("*** Stepping simulation ***");
        while(elevatorControlSystem.getActiveRequests() > 0){
            elevatorControlSystem.step();
            for(Elevator elevator : elevatorControlSystem.getElevators()){
                System.out.println("Elevator[" + elevator.getId() + "] - Current Floor " + elevator.getCurrentFloor());
            }
        }
    }
}
