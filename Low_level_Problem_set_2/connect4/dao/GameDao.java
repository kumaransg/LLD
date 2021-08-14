package connect4.dao;

import connect4.model.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author priyamvora
 * @created 15/05/2021
 */
public class GameDao {
    private final Board board;
    private final Queue<Player> players;
    private final Integer[] colToNextFreeRow;
    private final Integer numberOfBallsInRowToWin;

    public GameDao(Integer numOfRows, Integer numOfCols, Integer numberOfBallsInRowToWin) {
        this.board = new Board(numOfRows, numOfCols);
        this.players = new LinkedList<>();
        this.colToNextFreeRow = new Integer[numOfCols];
        intializeColToNextFreeRow();
        this.numberOfBallsInRowToWin = numberOfBallsInRowToWin;
    }

    private void intializeColToNextFreeRow() {
        Arrays.fill(colToNextFreeRow, board.getNumberOfRows() - 1);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Move makeMove(Integer col) {
        if (players.isEmpty()) {
            return null;
        }
        Player player = players.peek();
        Integer nextFreeRow = colToNextFreeRow[col];
        if (nextFreeRow < 0) {
            return null;
        }
        boolean result = board.setBoardHole(nextFreeRow, col, player.getBallType());
        if (result) {
            players.poll();
            players.add(player);
            colToNextFreeRow[col]--;
        }
        return new Move(nextFreeRow, col, player);
    }

    public boolean checkForWin(Integer row, Integer col) {
        return checkHorizontal(row, col) || checkVertical(row, col) || checkDiagonals(row, col, new int[][]{{-1, 1}, {1, -1}}) || checkDiagonals(row, col, new int[][]{{-1, -1}, {1, 1}});
    }

    private boolean checkHorizontal(Integer row, Integer col) {
        BallType currentBallType = board.getBoardHole(row, col).getBallType();
        if (currentBallType == null) {
            return false;
        }
        int startPointer = col - 1, endPointer = col + 1;
        while ((startPointer >= 0 || endPointer < board.getNumberOfCols())) {
            boolean foundOnEitherSide = false;
            if (startPointer >= 0) {
                BoardHole boardHole = board.getBoardHole(row, startPointer);
                if (boardHole != null && boardHole.getBallType().equals(currentBallType)) {
                    startPointer -= 1;
                    foundOnEitherSide = true;
                }
            }
            if (endPointer < board.getNumberOfCols()) {
                BoardHole boardHole = board.getBoardHole(row, endPointer);
                if (boardHole != null && boardHole.getBallType().equals(currentBallType)) {
                    endPointer += 1;
                    foundOnEitherSide = true;
                }
            }
            if (endPointer - startPointer - 1 >= numberOfBallsInRowToWin) {
                return true;
            }
            if (!foundOnEitherSide) {
                break;
            }
        }
        return endPointer - startPointer - 1 >= numberOfBallsInRowToWin;
    }

    private boolean checkVertical(Integer row, Integer col) {
        BallType currentBallType = board.getBoardHole(row, col).getBallType();
        if (currentBallType == null) {
            return false;
        }
        int startPointer = row - 1, endPointer = row + 1;
        while ((startPointer >= 0 || endPointer < board.getNumberOfRows())) {
            boolean foundOnEitherSide = false;
            if (startPointer >= 0) {
                BoardHole boardHole = board.getBoardHole(startPointer, col);
                if (boardHole != null && boardHole.getBallType().equals(currentBallType)) {
                    startPointer -= 1;
                    foundOnEitherSide = true;
                }
            }
            if (endPointer < board.getNumberOfRows()) {
                BoardHole boardHole = board.getBoardHole(endPointer, col);
                if (boardHole != null && boardHole.getBallType().equals(currentBallType)) {
                    endPointer += 1;
                    foundOnEitherSide = true;
                }
            }
            if (endPointer - startPointer - 1 >= numberOfBallsInRowToWin) {
                return true;
            }
            if (!foundOnEitherSide) {
                break;
            }
        }
        return (endPointer - startPointer - 1) >= numberOfBallsInRowToWin;
    }

    // dir - [[-1, 1], [1, -1]] - One diagonal side
    // dir - [[-1, -1], [1, 1]] - Another diagonal side
    private boolean checkDiagonals(Integer row, Integer col, int[][] dir) {
        BallType currentBallType = board.getBoardHole(row, col).getBallType();
        if (currentBallType == null) {
            return false;
        }
        int startPointerRow = row + dir[0][0], startPointerCol = col + dir[0][1];
        int endPointerRow = row + dir[1][0], endPointerCol = col + dir[1][1];
        while ((checkForRowColBounds(startPointerRow, startPointerCol)) || (checkForRowColBounds(endPointerRow, endPointerCol))) {
            boolean foundOnEitherSide = false;
            if ((checkForRowColBounds(startPointerRow, startPointerCol))) {
                BoardHole boardHole = board.getBoardHole(startPointerRow, startPointerCol);
                if (boardHole != null && boardHole.getBallType().equals(currentBallType)) {
                    startPointerRow += dir[0][0];
                    startPointerCol += dir[0][1];
                    foundOnEitherSide = true;
                }
            }

            if (checkForRowColBounds(endPointerRow, endPointerCol)) {
                BoardHole boardHole = board.getBoardHole(endPointerRow, endPointerCol);
                if (boardHole != null && boardHole.getBallType().equals(currentBallType)) {
                    endPointerRow += dir[1][0];
                    endPointerCol += dir[1][1];
                    foundOnEitherSide = true;
                }
            }
            if (endPointerRow - startPointerRow - 1 >= numberOfBallsInRowToWin) {
                return true;
            }
            if (!foundOnEitherSide) {
                break;
            }
        }
        return (endPointerRow - startPointerRow - 1) >= numberOfBallsInRowToWin;

    }

    private boolean checkForRowColBounds(Integer rowPointer, Integer colPointer) {
        return checkRowBounds(rowPointer) && checkColBounds(colPointer);
    }

    private boolean checkRowBounds(Integer row) {
        return row >= 0 && row < board.getNumberOfRows();
    }

    private boolean checkColBounds(Integer col) {
        return col >= 0 && col < board.getNumberOfCols();
    }
}
