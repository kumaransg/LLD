package model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FloorSwitch {
    private Boolean[] state;//[UP,DOWN]
    private Integer currentFloor;

    public FloorSwitch(int floor){
        this.state= new Boolean[2];
        this.currentFloor=floor;
    }
}
