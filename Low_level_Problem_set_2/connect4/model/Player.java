package connect4.model;

/**
 * @author priyamvora
 * @created 15/05/2021
 */
public class Player {
    private final User user;
    private final BallType ballType;

    public Player(User user, BallType ballType) {
        this.user = user;
        this.ballType = ballType;
    }

    public User getUser() {
        return user;
    }

    public BallType getBallType() {
        return ballType;
    }

    @Override
    public String toString() {
        return "Player{" +
                "user=" + user +
                ", ballType=" + ballType +
                '}';
    }
}
