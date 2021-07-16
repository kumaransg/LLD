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
public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(ChessBoard board, Cell start, Cell end) {
        return false;
    }

    @Override
    public String toString() {
        return "Rook{}";
    }
}