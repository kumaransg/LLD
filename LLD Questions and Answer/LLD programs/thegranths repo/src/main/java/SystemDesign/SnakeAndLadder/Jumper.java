package SystemDesign.SnakeAndLadder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Jumper {
    int startPoint;
    int endPoint;

    public Jumper(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
