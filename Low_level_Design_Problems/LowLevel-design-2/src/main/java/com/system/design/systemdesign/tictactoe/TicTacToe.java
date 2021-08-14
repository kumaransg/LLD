package com.system.design.systemdesign.tictactoe;

public class TicTacToe {
    public static void main(String[] args) {
        int n = 4;
        int[][] mat = new int[4][4];

        // played a tic tac toe
        // 1st player
        // 2nd player
        // 0 and X
        // number generator between 0-15
        int row = 1;
        int col = 1;
        int player = 1;
        boolean win = move(mat, row, col, player);
    }

    private static boolean move(int[][] mat, int row, int col, int player) {
        mat[row][col] = player;
        // check for row
        boolean win = true;
        for (int i = 0; i < mat[0].length; i++) {
            if (mat[row][i] != player) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }
        // check for column
        win = true;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] != player) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }
        // check for forward diagonals
        win = true;
        if (row == col) {
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][i] != player) {
                    win = false;
                    break;
                }
            }
        }
        if (win) {
            return true;
        }
        // check for backward diagonals
        win = true;
        for (int i = mat.length - 1, j = 0; i >= 0 && j < mat[0].length; i--, j++) {
            if (mat[i][j] != player) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }
        return false;
    }
}
