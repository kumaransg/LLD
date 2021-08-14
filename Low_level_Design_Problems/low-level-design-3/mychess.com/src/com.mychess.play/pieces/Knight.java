package pieces;

import cell.Cell;
import enums.PieceColor;

public class Knight extends Piece {
    public Knight(PieceColor pieceColor){
        super(pieceColor);
    }

    @Override
    public Boolean canMove(Cell from, Cell to) {
        System.out.println("Moving Knight");
        return true;
    }
}