package com.system.design.systemdesign.chess;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@Builder
//@NoArgsConstructor
public abstract class Piece {
    private PieceType pieceType;
    private PieceColor pieceColor;
    private boolean isKilled = false;
    public abstract boolean canMove(Board board, Cell start, Cell end);
}
