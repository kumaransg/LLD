package com.system.design.lld.snakeandladder.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Game {
    private static final int ROW_LEN = 100;
    private static final int COL_LEN = 100;
    private Board board;
    private Player A;
    private Player B;
    private int turn;
    private boolean gameEnd;
    public Game() {
        board = new Board(ROW_LEN, COL_LEN);
        A = new Player("A");
        A = new Player("B");
        turn = 0;
        gameEnd = false;
    }
    private Player getPlayerTurn() {
        return turn %2 == 0 ? A : B;
    }
    public String play() {
        while (!gameEnd) {
            Player player = getPlayerTurn();
            int number = getNumber();
            if( board.move( number, player)) {
                return player.getName();
            }
            ++turn;
            turn = turn%2;
        }
        return "DRAW";
    }

    private int getNumber() {
        return (int) Math.random();
    }
}
