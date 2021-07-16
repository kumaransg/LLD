package com.system.design.systemdesign.chess;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pawn extends Piece {
    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        return false;
    }
}
