package elevator;

import java.util.TreeSet;

/**
 * @author priyamvora
 * @created 20/04/2021
 */
public class LOOK {
    private final TreeSet<Integer> passengerRequests;
    private Integer currentFloor;
    private Integer direction;
    private final Integer maxFloors;
    private final Integer minFloors;

    public LOOK() {
        this.passengerRequests = new TreeSet<>();
        this.currentFloor = 0;
        this.direction = 1;
        this.maxFloors = 100;
        this.minFloors = 0;
    }

    public void servePassengerRequests() {
        while (true) {
            Integer nextFloorAccToDirection;
            if (direction == 1) {
                nextFloorAccToDirection = passengerRequests.ceiling(currentFloor);
            } else {
                nextFloorAccToDirection = passengerRequests.floor(currentFloor);
            }
            if (nextFloorAccToDirection == null) {
                direction = 1 - direction;
            } else {
                currentFloor = nextFloorAccToDirection;
                passengerRequests.remove(currentFloor);
            }
        }
    }

    public void addPassenger(Integer floor) {
        passengerRequests.add(floor);
    }
}
