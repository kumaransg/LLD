package chess.model;

import chess.constants.PieceType;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public class Rook extends Piece {

    public Rook(PieceType pieceType) {
        super(pieceType);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if (end.getPiece() != null && start.getPiece().isWhitePiece() == end.getPiece().isWhitePiece())
            return false;
        return start.getX() == end.getX() || start.getY() == end.getY();
    }
}
