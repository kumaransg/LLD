package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Elevator {
    private Integer id;
    private State state;
    private Boolean isFanOn;
    private Boolean isLightsOn;
    private Boolean isAlarmOn;

    public Elevator(int id) {
        this.id=id;
        this.state= new State();
        this.isFanOn = false;
        this.isLightsOn = false;
        this.isAlarmOn = false;
    }
}
