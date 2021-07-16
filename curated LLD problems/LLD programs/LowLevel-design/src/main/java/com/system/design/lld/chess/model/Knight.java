package com.system.design.lld.chess.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Knight extends Piece {
    Knight(PieceType pieceType, PieceColor pieceColor, boolean isKilled) {
        super(pieceType, pieceColor, isKilled);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        if (end.getPiece().getPieceColor() == this.getPieceColor()) {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x * y == 2;
    }
}
