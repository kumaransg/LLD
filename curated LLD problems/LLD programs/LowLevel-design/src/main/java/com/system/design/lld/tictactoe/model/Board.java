package com.system.design.lld.tictactoe.model;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;

@Data
public class Board {
    private PieceEnum[][] board;
    public Board() {
        board = new PieceEnum[Constants.TOTAL_ROWS][Constants.TOTAL_COLS];
        initializeBoard();
    }
    private void initializeBoard() {
        for( PieceEnum[] rows : board) {
            Arrays.fill( rows, PieceEnum.EMPTY);;
        }
    }
    public boolean playAndCheck( int x, int y, Player player) {
        this.board[x][y] = player.getPieceEnum();
        player.getMoveList().add(Move.builder().x(x).y(y).build());
        PieceEnum candidate = player.getPieceEnum();
        int rowWin = 0;
        int colWin = 0;
        int diagWin = 0;
        int revDiagWin = 0;
        for(int i = 0; i < 3; i++) {
            // Check row
            if(this.board[x][i] == candidate) {
                rowWin++;
            }
            // Check col
            if(this.board[i][y] == candidate) {
                colWin++;
            }
            // Check diagonal
            if(this.board[i][i] == candidate) {
                diagWin++;
            }
            // Check reverse Diagonal
            if(this.board[i][Constants.TOTAL_COLS-i-1] == candidate) {
                revDiagWin++;
            }
        }

        if(rowWin == 3 || colWin == 3 || diagWin == 3 || revDiagWin == 3) {
            return true;
        }else {
            return false;
        }
    }
}
