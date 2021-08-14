package elevator;

import java.util.TreeSet;

/**
 * @author priyamvora
 * @created 20/04/2021
 */
public class SCAN {
    private final TreeSet<Integer> passengerRequests;
    private Integer currentFloor;
    private Integer currentDirection;
    private final Integer MAX_FLOORS = 100;
    private final Integer MIN_FLOORS = 0;

    public SCAN() {
        this.passengerRequests = new TreeSet<>();
        this.currentFloor = 0;
        this.currentDirection = 1;
    }

    public void servePassengerRequests() {
        while (true) {
            if (currentDirection == 1) {
                Integer nextFloor = passengerRequests.ceiling(currentFloor);
                if (nextFloor == null) {
                    currentFloor++;
                } else {
                    currentFloor = nextFloor;
                    passengerRequests.remove(nextFloor);
                }
            } else {
                Integer nextFloor = passengerRequests.floor(currentFloor);
                if (nextFloor == null) {
                    currentFloor--;
                } else {
                    currentFloor = nextFloor;
                    passengerRequests.remove(nextFloor);
                }
            }
            if (currentFloor.equals(MAX_FLOORS) || currentFloor.equals(MIN_FLOORS)) {
                currentDirection = 1 - currentDirection;
            }
        }
    }

    public void addPassengerRequest(Integer floor) {
        passengerRequests.add(floor);
    }
}
