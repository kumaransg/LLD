/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designchess.models.pieceimpl;

import designchess.enums.Color;
import designchess.models.Cell;
import designchess.models.ChessBoard;
import designchess.models.Piece;

/**
 * @author paras.chawla
 * @version $Id: King.java, v 0.1 2020-09-30 16:47 paras.chawla Exp $$
 */
public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(ChessBoard board, Cell start, Cell end) {

        // If same player piece already exist
        if (end.getCurrentPiece().getColor() == this.getColor()) {
            return false;
        }

        // if king direction is movement direction is L-R-T-B && box end is unoccupied
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if (x == y) {
            // if no pieces between start and end location
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bishop{}";
    }
}