package battleship.model;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
public abstract class Ship {
    private final String shipId;
    private boolean isDestroyed;
    private final int noOfHoles;

    public Ship(boolean isDestroyed, int noOfHoles) {
        this.shipId = UUID.randomUUID().toString();
        this.isDestroyed = isDestroyed;
        this.noOfHoles = noOfHoles;
    }

    public String getShipId() {
        return shipId;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public int getNoOfHoles() {
        return noOfHoles;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipId='" + shipId + '\'' +
                ", isDestroyed=" + isDestroyed +
                ", noOfHoles=" + noOfHoles +
                '}';
    }
}
