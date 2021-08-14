package battleship.model;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
public class BoardEntity {
    private final Ship ship;
    private boolean isHit;
    private Integer hitAttemptedAndSuccessful;

    public BoardEntity(Ship ship, boolean isHit) {
        this.ship = ship;
        this.isHit = isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public Ship getShip() {
        return ship;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHitAttemptedAndSuccessful(Integer hitAttemptedAndSuccessful) {
        this.hitAttemptedAndSuccessful = hitAttemptedAndSuccessful;
    }

    public Integer getHitAttemptedAndSuccessful() {
        return hitAttemptedAndSuccessful;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "ship=" + ship +
                ", isHit=" + isHit +
                ", hitAttemptedAndSuccessful=" + hitAttemptedAndSuccessful +
                '}';
    }
}
