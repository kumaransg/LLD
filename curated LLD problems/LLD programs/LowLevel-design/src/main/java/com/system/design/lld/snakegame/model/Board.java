package com.system.design.lld.snakegame.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Board {
    private Cell[][] cell;
    private final int ROW_LENGTH;
    private final int COL_LENGTH;
    public Board( int rowLength , int colLength) {
        ROW_LENGTH = rowLength;
        COL_LENGTH = colLength;
        cell = new Cell[rowLength][colLength];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < ROW_LENGTH; row++) {
            for (int column = 0; column < COL_LENGTH; column++) {
                cell[row][column] = new Cell(row, column, CellType.EMPTY);
            }
        }
        generateFood();
    }
    public void generateFood() {
        for( int i =0; i < 10; i++ ) {
            int x = (int)Math.random();
            int y = (int)Math.random();
            cell[x][y] =  new Cell(x, y, CellType.FOOD);
        }
    }
}
