package connect4.model;

/**
 * @author priyamvora
 * @created 16/05/2021
 */
public class Move {
    private Integer row;
    private Integer col;
    private Player player;

    public Move(Integer row, Integer col, Player player) {
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "Move{" +
                "row=" + row +
                ", col=" + col +
                ", player=" + player +
                '}';
    }
}
