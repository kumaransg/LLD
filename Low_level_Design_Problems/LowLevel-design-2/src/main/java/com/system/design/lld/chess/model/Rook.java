package com.system.design.lld.chess.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Rook extends Piece {
    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        return false;
    }
}
