package pieces;

import cell.Cell;
import enums.PieceColor;

public class Queen extends Piece{
    public Queen(PieceColor pieceColor){
        super(pieceColor);
    }

    @Override
    public Boolean canMove(Cell from, Cell to) {
        System.out.println("Moving Queen");
        return true;
    }
};