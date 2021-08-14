package com.system.design.oops.chessv1;

public class King extends Piece {
    private boolean castlingDone = false;

    public King(boolean white) {
        super(white);
    }

    public boolean isCastlingDone() {
        return this.castlingDone == true;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        // we can't move the piece to a box that has a piece of the same color
        if(end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if(x + y == 1) {
            // check if this move will not result in king being attacked, if so return true
            return true;
        }

        return this.isValidCastling(board, start, end);
    }

    private boolean isValidCastling(Board board, Box start, Box end) {

        if(this.isCastlingDone()) {
            return false;
        }

        // check for the white king castling
        if(this.isWhite()
                && start.getX() == 0 && start.getY() == 4 && end.getY() == 0) {
            // confirm if white king moved to the correct ending box
            if (Math.abs(end.getY() - start.getY()) == 2) {
                // check if there the Rook is in the correct position
                // check if there is no piece between Rook and the King
                // check if the King or the Rook has not moved before
                // check if this move will not result in king being attacked
                //...
                this.setCastlingDone(true);
                return true;
            }
        } else {
            // check for the black king castling
            this.setCastlingDone(true);
            return true;
        }

        return false;
    }

    public boolean isCastlingMove(Box start, Box end) {
        // check if the starting and ending position are correct
        return true;
    }
}
