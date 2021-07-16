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
public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(ChessBoard board, Cell start, Cell end) {

        super.canMove(board,start,end);

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        return x * y == 2;

    }

    @Override
    public String toString() {
        return "Knight{}";
    }
}