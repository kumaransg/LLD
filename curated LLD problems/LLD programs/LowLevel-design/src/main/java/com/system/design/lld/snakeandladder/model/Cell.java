package com.system.design.lld.snakeandladder.model;

import lombok.Builder;
import lombok.Data;

// if pieceEnum is snake i can go from y to x
// if pieceEnum is ladder i can go from x to y
@Data
public class Cell {
    private int x;
    private int y;
    private int number;
    private CellType cellType;
    public Cell(int x , int y, CellType cellType, int number) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
        this.number = number;
    }
}
