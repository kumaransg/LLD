package chess.model;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public class Move {
    private final Player player;
    private final Box start;
    private final Box end;
    private final Piece pieceMoved;
    private Piece pieceKilled;
    private boolean castlingMove;

    public Move(Player player, Box start, Box end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    public Player getPlayer() {
        return player;
    }

    public Box getStart() {
        return start;
    }

    public Box getEnd() {
        return end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public boolean isCastlingMove() {
        return castlingMove;
    }

    @Override
    public String toString() {
        return "Move{" +
                "player=" + player +
                ", start=" + start +
                ", end=" + end +
                ", pieceMoved=" + pieceMoved +
                ", pieceKilled=" + pieceKilled +
                ", castlingMove=" + castlingMove +
                '}';
    }
}
