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

/**
 * A king is a Piece A king can move to L/R/T/B/D 1 time if cell is free or no other Piece exist there
 * If the move is a castling, set the new position of the rook accordingly. But a king and rook can only castle if they haven't moved, so you need to keep track of that.
 * And if the king moves through a check to castle, that's disallowed, too.
 */
public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(ChessBoard board, Cell start, Cell end) {

        super.canMove(board, start, end);

        // if king direction is movement direction is L-R-T-B && box end is unoccupied
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if (x + y == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "King{}";
    }
}