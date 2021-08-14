package move;

import java.util.ArrayList;

import cell.Cell;

public class Moves {
    private ArrayList<Cell> moves = null;

    public Moves(){
        moves = new ArrayList<>();
    }

    public void addMove(Cell move){
        moves.add(move);
    }

    public ArrayList<Cell> getMoves(){
       return moves;
    }

}