/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designchess.models;

/**
 * @author paras.chawla
 * @version $Id: Move.java, v 0.1 2020-11-09 18:57 paras.chawla Exp $$ To encapsulate a chess move
 */
public class Move {

    private Cell    start;
    private Cell    end;
    private Player  playedBy;
    private Piece   pieceMoved;
    private Piece   pieceKilled;
    private boolean castlingMove = false;

    public Move(Player playedBy, Cell start, Cell end) {
        this.start = start;
        this.end = end;
        this.playedBy = playedBy;
        this.pieceMoved = start.getCurrentPiece();
    }

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }

    public Player getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(Player playedBy) {
        this.playedBy = playedBy;
    }

    public boolean isCastlingMove() {
        return this.castlingMove == true;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

}