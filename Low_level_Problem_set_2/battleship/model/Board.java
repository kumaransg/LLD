package battleship.model;

import java.util.Arrays;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
public class Board {
    private static final Integer BOARD_SIZE = 10;
    private static final Integer NUMBER_OF_PLAYERS = 2;
    private final BoardEntity[][][] board;

    public Board() {
        this.board = new BoardEntity[NUMBER_OF_PLAYERS][BOARD_SIZE][BOARD_SIZE];
    }

    public void addShip(Integer playerNum, Ship ship, Coordinate start, Coordinate end) {
        if (!start.getX().equals(end.getX()) && !start.getY().equals(end.getY())) {
            return;
        }
        if (start.getX().equals(end.getX())) {
            for (int i = start.getY(); i <= end.getY(); i++) {
                BoardEntity boardEntity = new BoardEntity(ship, false);
                board[playerNum][start.getX()][i] = boardEntity;
            }
        } else {
            for (int i = start.getX(); i <= end.getX(); i++) {
                BoardEntity boardEntity = new BoardEntity(ship, false);
                board[playerNum][i][start.getY()] = boardEntity;
            }
        }
    }

    public Ship hitShip(Integer hitBy, Integer playerToHit, Coordinate coordinate) {
        if (board[playerToHit][coordinate.getX()][coordinate.getY()] != null) {
            board[playerToHit][coordinate.getX()][coordinate.getY()].setHit(true);
            board[hitBy][coordinate.getX()][coordinate.getY()].setHitAttemptedAndSuccessful(1);
            return board[playerToHit][coordinate.getX()][coordinate.getY()].getShip();
        }
        board[hitBy][coordinate.getX()][coordinate.getY()].setHitAttemptedAndSuccessful(0);
        return null;
    }

    public boolean isShipDestroyed(Integer playerToHit, Coordinate start, Coordinate end) {
        boolean isDestroyed = true;
        if (start.getX().equals(end.getX())) {
            for (int i = start.getY(); i <= end.getY() && isDestroyed; i++) {
                if (!board[playerToHit][start.getX()][i].isHit()) {
                    isDestroyed = false;
                }
            }
        } else {
            for (int i = start.getX(); i <= end.getX(); i++) {
                if (board[playerToHit][i][start.getY()].isHit()) {
                    isDestroyed = false;
                }
            }
        }
        if (isDestroyed) {
            board[playerToHit][start.getX()][start.getY()].getShip().setDestroyed(true);
        }
        return isDestroyed;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board, player1=" + Arrays.deepToString(board[0]) +
                "\n player2=" + Arrays.deepToString(board[1]) +
                '}';
    }
}
