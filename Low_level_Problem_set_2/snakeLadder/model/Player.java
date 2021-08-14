package snakeLadder.model;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class Player {
    private final Integer id;
    private final String name;
    private Integer pawnPosition;
    private Boolean isGameOver;

    public Player(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.pawnPosition = 0;
        this.isGameOver = false;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPawnPosition() {
        return pawnPosition;
    }

    public void setPawnPosition(Integer pawnPosition) {
        this.pawnPosition = pawnPosition;
    }

    public Boolean getGameOver() {
        return isGameOver;
    }

    public void setGameOver(Boolean gameOver) {
        isGameOver = gameOver;
    }
}
