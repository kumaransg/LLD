package chessGame;

import java.util.List;

public abstract class Piece {
    Color color;
    String name;
    public void move(CellPosition from , CellPosition to) {}
    public abstract List<CellPosition> possibleMoves(CellPosition pos);
    public abstract boolean isValidMove(CellPosition from, CellPosition to);
}
