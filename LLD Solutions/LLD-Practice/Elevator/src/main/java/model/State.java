package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class State {
    private Direction direction;
    private Integer currentFloor;
    private Set<Integer> isPressed;

    public State() {
        this.direction= Direction.IDLE;
        this.currentFloor = 0;
        this.isPressed = new HashSet<>();
    }

    public void addFloor(Integer floor){
        isPressed.add(floor);
    }
}
