
package pieces;

import cell.Cell;
import enums.PieceColor;

public class Bishop extends Piece{

    public Bishop(PieceColor pieceColor){
        super(pieceColor);
    }

    @Override
    public Boolean canMove(Cell from, Cell to) {
        System.out.println("Moving Bishop");
        return true;
    }
};