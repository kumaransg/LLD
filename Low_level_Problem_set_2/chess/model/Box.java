package chess.model;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public class Box {
    private Piece piece;
    private Integer x, y;

    public Box(Integer x, Integer y, Piece piece) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }


    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Box{" +
                "piece=" + piece +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
