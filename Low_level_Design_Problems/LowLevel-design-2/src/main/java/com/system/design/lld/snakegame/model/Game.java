package com.system.design.lld.snakegame.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Game {
    public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
            DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
    private Board board;
    private Snake snake;
    private int direction;
    private boolean gameFinished;
    private int score;
    public Game( String playerName , int row, int col ) {
        this.board = new Board( row, col);
        this.snake = new Snake( playerName);
        this.direction = 1;
        this.gameFinished = false;
        this.score = 0;
    }
    public int play(){
        if (!gameFinished) {
            if (direction != DIRECTION_NONE) {
                Cell nextCell = getNextCell(snake.getHeadPosition());

                if (snake.checkCrash(nextCell)) {
                    setDirection(DIRECTION_NONE);
                    gameFinished = true;
                }
                else {
                    snake.move(nextCell);
                    if (nextCell.getCellType() == CellType.FOOD) {
                        snake.grow();
                        board.generateFood();
                    }
                }
            }
            score++;
        }
        return score;
    }

    private Cell getNextCell( Cell currentPosition) {
        System.out.println("Going to find next cell");
        int row = currentPosition.getX();
        int col = currentPosition.getY();
        if (direction == DIRECTION_RIGHT) {
            col++;
        } else if (direction == DIRECTION_LEFT) {
            col--;
        } else if (direction == DIRECTION_UP) {
            row--;
        } else if (direction == DIRECTION_DOWN) {
            row++;
        }
        Cell nextCell = board.getCell()[row][col];
        return nextCell;
    }
}
