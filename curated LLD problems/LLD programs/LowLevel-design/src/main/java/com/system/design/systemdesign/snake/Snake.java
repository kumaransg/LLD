package com.system.design.systemdesign.snake;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Snake {
    private Cell head;
    private Queue<Cell> listOfMoves;

    public Snake(Cell cell) {
        this.head = cell;
        listOfMoves = new LinkedList<>();
        listOfMoves.add(cell);
    }
    public boolean move(Cell nextCell){
        if( checkCrash(nextCell)){
            return false;
        }else{
            nextCell.setCellType(CellType.SNAKE_NODE);
            listOfMoves.add(nextCell);
        }
        return true;
    }
    public boolean checkCrash( Cell nextCell){
        Iterator<Cell> cellIterator = listOfMoves.iterator();
        while (cellIterator.hasNext()){
            Cell cell = cellIterator.next();
            if( cell.getX() == nextCell.getX() && cell.getY() == nextCell.getY()){
                return true;
            }
        }
        return false;
    }
}
