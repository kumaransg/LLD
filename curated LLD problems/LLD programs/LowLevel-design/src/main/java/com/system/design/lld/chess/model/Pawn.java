package com.system.design.lld.chess.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Pawn extends Piece {
    Pawn(PieceType pieceType, PieceColor pieceColor, boolean isKilled) {
        super(pieceType, pieceColor, isKilled);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        return false;
    }
}
