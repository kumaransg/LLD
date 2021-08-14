package pieces;

import cell.Cell;
import enums.PieceColor;

public class King extends Piece {
    private Boolean isCastled;

    public King(PieceColor pieceColor){
        super(pieceColor);
        isCastled = false;
    }

    @Override
    public Boolean canMove(Cell from, Cell to){
        System.out.println("Moving King");
        return true;
    }

    public Boolean getIsCastled(){
        return isCastled;
    }

    public void setIsCastled() {
        isCastled = true;
    }
}