package com.system.design.lld.snakegame.model;

import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;

@Data
public class Snake {
    private String name;
    private LinkedList<Cell> moves;
    private int maxScore;
    private Cell headPosition;
    public Snake(String name ) {
        this.name = name;
        moves = new LinkedList<>();
        headPosition = new Cell(0,0, CellType.SNAKE_NODE);
        moves.add(headPosition);
    }
    public void grow() {
        moves.add(headPosition);
    }
    // behaviour of snake class
    public void move( Cell nextCell){
        System.out.println("Snake is moving to " +
                nextCell.getX()+ " " + nextCell.getY());
        Cell tail = moves.removeLast();
        tail.setCellType(CellType.EMPTY);

        headPosition = nextCell;
        moves.addFirst(headPosition);
    }
    public boolean checkCrash( Cell nextMove) {
        for( Cell cell : moves ){
            if( cell == nextMove){
                return true;
            }
        }
        return false;
    }
}
