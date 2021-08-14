package elevator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class FCFS {
    private final Queue<Integer> passengerRequests;
    private Integer currentFloor;
    private final Integer maxFloors;

    public FCFS(Integer maxFloors) {
        passengerRequests = new LinkedList<>();
        currentFloor = 0;
        this.maxFloors = maxFloors;
    }

    public Integer servePassengers() {
        Integer totalCosts = 0;
        while (!passengerRequests.isEmpty()) {
            Integer floorToReach = passengerRequests.poll();
            totalCosts += Math.abs(currentFloor - floorToReach);
            currentFloor = floorToReach;
        }
        return totalCosts;
    }

    public void addPassengerRequest(Integer floorNumber) {
        passengerRequests.add(floorNumber);
    }
}
