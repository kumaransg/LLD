package battleship.model;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
public class Player {
    private Integer playerId;
    private String name;

    public Player(Integer playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                '}';
    }
}
