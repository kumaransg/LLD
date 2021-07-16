/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designchess.models;

import designchess.enums.Color;

/**
 * @author paras.chawla
 * @version $Id: Piece.java, v 0.1 2020-09-30 16:40 paras.chawla Exp $$
 */
public abstract class Piece {

    Color   color;
    boolean killed = false;
    boolean castlingMove = false;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean canMove(ChessBoard board, Cell start, Cell end){

        // If player exist and same player piece exist
        if (end.getCurrentPiece()!=null && end.getCurrentPiece().getColor() == this.getColor()) {
            return false;
        }
        return true;
    }

    public boolean isCastlingMove() {
        return castlingMove;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }
}