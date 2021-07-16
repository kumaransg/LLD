package com.system.design.systemdesign.snake;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Game {
    private Board board;
    private static final int ROWS = 32;
    private int totalFood;

    public Game(int totalFood) {
        this.totalFood = totalFood;
        this.board = new Board(totalFood);
    }

    public void playGame(){
        boolean flag = true;
        Random random = new Random();
        int min = 0;
        int max = ROWS;
        while (flag) {
            int x = random.ints(min, (max)).findFirst().getAsInt();
            int y = random.ints(min, (max)).findFirst().getAsInt();
            Cell cell = board.getCells()[x][y];
            System.out.println(cell.getCellType() + "::"+ cell.getY() + "::"+cell.getY());
            flag = board.getSnake().move(cell);
        }
        System.out.println("game end");
    }

    public static void main(String[] args) {
        Game game = new Game(48);
        game.playGame();
    }
}
