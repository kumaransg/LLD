package com.system.design.systemdesign.snake;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Board {
    private Cell[][] cells;
    private Snake snake;
    private static final int ROWS = 32;
    private static final int COLUMNS = 32;

    public Board( int food ) {
        // initialize the box
        cells = new Cell[ROWS][COLUMNS];
        // set the empty in cell
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                cells[i][j] = new Cell(i, j, CellType.EMPTY);
            }
        }
        // set the food in cells
        initializeFood(food);
        // initialize the snake
        Cell cell = new Cell(0, 0, CellType.EMPTY);
        snake = new Snake(cell);

//        for (int i = 0; i < ROWS; i++) {
//            for (int j = 0; j < COLUMNS; j++) {
//                System.out.println(cells[i][j].getCellType());
//            }
//        }
    }

    public void initializeFood(int food) {
        int totalFood = food;
        Random random = new Random();
        int min = 0;
        int max = ROWS;
        for (int i = 0; i < totalFood; i++) {
            int x = random.ints(min, (max )).findFirst().getAsInt();
            int y = random.ints(min, (max)).findFirst().getAsInt();
            cells[x][y] = new Cell(x, y, CellType.FOOD);
        }
    }
}
