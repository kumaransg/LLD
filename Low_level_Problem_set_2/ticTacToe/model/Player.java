package ticTacToe.model;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class Player {
    private final String name;
    private final Piece piece;

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }
}
