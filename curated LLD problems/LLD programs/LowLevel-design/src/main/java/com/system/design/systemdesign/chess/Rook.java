package com.system.design.systemdesign.chess;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Rook extends Piece {
    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        return false;
    }
}
