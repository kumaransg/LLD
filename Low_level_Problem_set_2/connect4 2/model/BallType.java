package connect4.model;

import connect4.constants.BallColor;

/**
 * @author priyamvora
 * @created 15/05/2021
 */
public abstract class BallType {
    private BallColor ballColor;

    public BallType(BallColor ballColor) {
        this.ballColor = ballColor;
    }

    @Override
    public String toString() {
        return "BallType{" +
                "ballColor=" + ballColor +
                '}';
    }
}
