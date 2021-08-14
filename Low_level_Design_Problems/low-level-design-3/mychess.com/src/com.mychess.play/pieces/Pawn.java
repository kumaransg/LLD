package pieces;

import cell.Cell;
import enums.PieceColor;

public class Pawn extends Piece{
    public Pawn(PieceColor pieceColor){
        super(pieceColor);
    }

    @Override
    public Boolean canMove(Cell from, Cell to) {
        System.out.println("Moving Pawn");
        return true;
    }
}