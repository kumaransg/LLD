package com.system.design.systemdesign.chess;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Knight extends Piece  {
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
