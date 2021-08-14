package chess.model;

import chess.constants.PieceType;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public abstract class Piece {
    private PieceType pieceType;
    private Boolean killed;

    public Piece(PieceType pieceType) {
        this.pieceType = pieceType;
        this.killed = false;
    }

    public boolean isWhitePiece() {
        return getPieceType().equals(PieceType.WHITE);
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public Boolean getKilled() {
        return killed;
    }

    public void setKilled(Boolean killed) {
        this.killed = killed;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceType=" + pieceType +
                ", killed=" + killed +
                '}';
    }

    public abstract boolean canMove(Board board, Box start, Box end);
}
