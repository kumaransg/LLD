package connect4.dao;

import connect4.model.BallType;
import connect4.model.Board;
import connect4.model.BoardHole;
import connect4.model.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author priyamvora
 * @created 15/05/2021
 * 0 0 0 0
 * Y R R 0
 * 0 Y 0 0
 * 0 Y 0 0
 * 0 R Y 0
 * 0 R 0 0
 * colToNextFreeRow = [3, 3, 3, 3] -> [2,3,3,3] -> [-1, 3, 3 ,3]
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

    private Integer makeMove(Integer col) {
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
        return nextFreeRow;
    }

    private boolean checkForWin(Integer row, Integer col) {
        return checkHorizontal(row, col) || checkVertical(row, col) || checkDiagonals();
    }

    private boolean checkHorizontal(Integer row, Integer col) {
        BallType currentBallType = board.getBoardHole(row, col).getBallType();
        if (currentBallType == null) {
            return false;
        }
        Integer currentConsecutiveBallsCount = 0;
        for (int i = Math.max(0, col - numberOfBallsInRowToWin - 1); i < Math.min(board.getNumberOfCols(), col + numberOfBallsInRowToWin); i++) {
            BoardHole boardHole = board.getBoardHole(row, i);
            if (boardHole != null && boardHole.getBallType().equals(currentBallType)) {
                currentConsecutiveBallsCount++;
            } else {
                currentConsecutiveBallsCount = 0;
            }
            if (currentConsecutiveBallsCount >= numberOfBallsInRowToWin) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVertical(Integer row, Integer col) {
        BallType currentBallType = board.getBoardHole(row, col).getBallType();
        if (currentBallType == null) {
            return false;
        }
        Integer currentConsecutiveBallsCount = 0;
        for (int i = Math.max(0, row - numberOfBallsInRowToWin + 1); i < Math.min(board.getNumberOfRows(), row + numberOfBallsInRowToWin); i++) {
            BoardHole boardHole = board.getBoardHole(i, col);
            if (boardHole != null && boardHole.getBallType().equals(currentBallType)) {
                currentConsecutiveBallsCount++;
            } else {
                currentConsecutiveBallsCount = 0;
            }
            if (currentConsecutiveBallsCount >= numberOfBallsInRowToWin) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return false;
    }
}
