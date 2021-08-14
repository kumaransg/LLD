package com.system.design.lld.chess.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class King extends Piece {
    private boolean castlingDone = false;

    King(PieceType pieceType, PieceColor pieceColor, boolean isKilled) {
        super(pieceType, pieceColor, isKilled);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        // we can't move the piece to a Spot that
        // has a piece of the same color
        if (end.getPiece().getPieceColor() == this.getPieceColor()) {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1) {
            // check if this move will not result in the king
            // being attacked if so return true
            return true;
        }

        return this.isValidCastling(board, start, end);
    }
    private boolean isValidCastling(Board board, Cell start, Cell end)
    {
//        if (this.isCastlingDone()) {
//            return false;
//        }
        // TODO
        // Logic for returning true or false
        return true;
    }

    // TODO
    public boolean isCastlingMove(Cell start, Cell end)
    {
        // check if the starting and
        // ending position are correct
        return true;
    }
}
