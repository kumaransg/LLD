package ticTacToe.dao;

import ticTacToe.model.Board;
import ticTacToe.model.Piece;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public interface TicTacToeDao {
    boolean addPiece(Piece piece, Integer row, Integer col);

    Board getBoard();
}
