package com.system.design.lld.tictactoe.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Game {
    private Board board;
    private Player playerA;
    private Player playerB;
    private int moveCount;
    private int turn;

    public Game() {
        this.board = new Board();
        playerA = new Player("A", PieceEnum.CIRCLE);
        playerA = new Player("B", PieceEnum.CROSS);
        this.moveCount = 0;
        this.turn = 0;
    }
    private Player playerChances() {
        return turn % 2 ==0 ? playerA : playerB;
    }
    public String play() {
        while ( moveCount <= Constants.TOTAL_COLS * Constants.TOTAL_ROWS) {
            Player player = playerChances();
            int[] nextMove = getNextMoves();
            boolean result = board.playAndCheck(nextMove[0], nextMove[1], player);
            if( result)
                return player.getName();
            turn = ++turn%2;
            moveCount++;
        }
        return "DRAW";
    }
    private int[] getNextMoves(){
        int x = (int)Math.random();
        int y = (int)Math.random();
        if( board.getBoard()[x][y] == PieceEnum.EMPTY) {
            return new int[]{x,y};
        }
        return getNextMoves();
    }
}
