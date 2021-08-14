package chess.model;

import chess.constants.PieceType;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public class Bishop extends Piece {
    public Bishop(PieceType pieceType) {
        super(pieceType);
    }


    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if (end.getPiece() != null && start.getPiece().isWhitePiece() == end.getPiece().isWhitePiece())
            return false;
        Integer xDiff = Math.abs(start.getX() - end.getX());
        Integer yDiff = Math.abs(start.getY() - end.getY());
        return xDiff.equals(yDiff);
    }
}
