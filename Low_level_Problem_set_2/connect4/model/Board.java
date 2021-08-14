package connect4.model;

/**
 * @author priyamvora
 * @created 15/05/2021
 */
public class Board {
    private final Integer numberOfRows;
    private final Integer numberOfCols;
    private final BoardHole[][] board;

    public Board(Integer numberOfRows, Integer numberOfCols) {
        this.numberOfRows = numberOfRows;
        this.numberOfCols = numberOfCols;
        this.board = new BoardHole[numberOfRows][numberOfCols];
    }

    public boolean setBoardHole(Integer row, Integer col, BallType ballType) {
        if (validMove(row, col)) {
            board[row][col] = new BoardHole(ballType);
            return true;
        }
        return false;

    }

    private boolean validMove(Integer row, Integer col) {
        return row >= 0 && row < numberOfRows && col >= 0 && col < numberOfCols && board[row][col] == null;
    }

    public Integer getNumberOfRows() {
        return numberOfRows;
    }

    public Integer getNumberOfCols() {
        return numberOfCols;
    }

    public BoardHole[][] getBoard() {
        return board;
    }

    public BoardHole getBoardHole(Integer row, Integer col) {
        return board[row][col];
    }
}
