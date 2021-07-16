package com.system.design.lld.snakeandladder.model;

import lombok.Builder;
import lombok.Data;

// row = 10
// col = 10
// 2, 5
// 2 * 10 + 5
// (i) * col_len + col
// 25%10 5
// 25 / 10 2
@Data
public class Board {
    private int destination;
    private Cell[][] cells;
    public Board( int row, int col) {
        cells = new Cell[row][col];
        this.destination = cells.length * cells[0].length -1;
        initializeBoard();
    }

    private void initializeBoard() {
        for( int i =0; i < cells.length; i++ ) {
            for( int j =0; j < cells[0].length; j++ ) {
                int number = i * cells[0].length +  j;
                cells[i][j] = new Cell(i,j,CellType.EMPTY,number);
            }
        }
        generateSnake();
        generateLadder();
    }

    private void generateSnake() {
        for( int i =0; i < 5; i++ ) {
            int x = (int) Math.random();
            int y = (int) Math.random();
            if(y > x) {
                cells[x][y].setCellType( CellType.SNAKE);
            }else {
                cells[y][x].setCellType( CellType.SNAKE);
            }
        }
    }
    private void generateLadder() {
        for( int i =0; i < 5; i++ ) {
            int x = (int) Math.random();
            int y = (int) Math.random();
            if(y > x) {
                cells[x][y].setCellType( CellType.LADDER);
            }else {
                cells[y][x].setCellType( CellType.LADDER);
            }
        }
    }

    public boolean move(int number, Player player) {
        int finalPosition = number + player.getNumber();
        if( finalPosition == destination )
            return true;

        // convert number to row and column
        int row = number / cells[0].length;
        int col = number % cells[0].length;
        Cell cell = cells[row][col];
        if( cell.getCellType().equals( CellType.LADDER)) {
            finalPosition = cell.getY();
        }else if( cell.getCellType().equals( CellType.SNAKE)) {
            finalPosition = cell.getX();
        }
        player.setNumber(finalPosition);
        player.setNumber( finalPosition);
        player.setCurrentPosition(cell);
        return false;
    }
}
