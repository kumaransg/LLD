package pieces;

import cell.Cell;
import enums.PieceColor;
public abstract class Piece {
    private Boolean isAlive = true;
    private PieceColor pieceColor;
  
	public Piece(PieceColor newPieceColor) {
        pieceColor = newPieceColor;
	}
	public abstract Boolean canMove(Cell from, Cell to);
}