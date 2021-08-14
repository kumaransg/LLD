package connect4.model;

/**
 * @author priyamvora
 * @created 15/05/2021
 */
public class BoardHole {
    private BallType ballType;

    public BoardHole(BallType ballType) {
        this.ballType = ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public BallType getBallType() {
        return ballType;
    }

    @Override
    public String toString() {
        return "BoardHole{" +
                "ballType=" + ballType +
                '}';
    }
}
