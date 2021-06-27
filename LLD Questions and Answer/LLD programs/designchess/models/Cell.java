/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designchess.models;

/**
 * @author paras.chawla
 * @version $Id: Cell.java, v 0.1 2020-09-30 13:57 paras.chawla Exp $$
 */
public class Cell {

    private int x;
    private int y;
    Piece currentPiece;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(int x, int y, Piece currentPiece) {
        this.x = x;
        this.y = y;
        this.currentPiece = currentPiece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public boolean isFree() {
        return currentPiece == null;
    }
}