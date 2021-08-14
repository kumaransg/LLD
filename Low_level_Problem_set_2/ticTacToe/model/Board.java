package ticTacToe.model;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class Board {
    private Integer size;
    private final Piece[][] board;

    public Board() {
        this.size = 3; // add in constants
        this.board = new Piece[size][size];
    }

    public Integer getSize() {
        return size;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean addPieceOnBoard(Piece piece, Integer row, Integer col) {
        if (board[row][col] != null) {
            return false;
        }
        board[row][col] = piece;
        return true;
    }
}
