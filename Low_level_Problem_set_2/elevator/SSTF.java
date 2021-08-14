package elevator;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author priyamvora
 * @created 20/04/2021
 */
public class SSTF {
    private final TreeSet<Integer> passengerRequests;
    private Integer currentFloor;

    public SSTF() {
        passengerRequests = new TreeSet<>();
        currentFloor = 0;
    }

    public Integer servePassengers() {
        Integer totalTime = 0;
        while (true) {
            if (passengerRequests.isEmpty()) {
                return totalTime;
            }
            Integer greaterThanCurrentFloor = passengerRequests.ceiling(currentFloor);
            Integer lowerThanCurrentFloor = passengerRequests.floor(currentFloor);
            if (greaterThanCurrentFloor == null && lowerThanCurrentFloor != null) {
                totalTime += currentFloor - lowerThanCurrentFloor;
                currentFloor = lowerThanCurrentFloor;
            } else if (greaterThanCurrentFloor != null && lowerThanCurrentFloor == null) {
                totalTime += greaterThanCurrentFloor - currentFloor;
                currentFloor = greaterThanCurrentFloor;
            } else if (Math.abs(greaterThanCurrentFloor - currentFloor) < Math.abs(lowerThanCurrentFloor - currentFloor)) {
                totalTime += greaterThanCurrentFloor - currentFloor;
                currentFloor = greaterThanCurrentFloor;
            } else {
                totalTime += currentFloor - lowerThanCurrentFloor;
                currentFloor = lowerThanCurrentFloor;
            }
            passengerRequests.remove(currentFloor);
        }
    }

    public void addPassengerRequests(Integer passengerRequest) {
        passengerRequests.add(passengerRequest);
    }
}
