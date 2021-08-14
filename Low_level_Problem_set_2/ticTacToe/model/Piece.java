package ticTacToe.model;

import ticTacToe.constants.PieceType;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public abstract class Piece {
    private PieceType pieceType;

    public Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceType=" + pieceType +
                '}';
    }
}
