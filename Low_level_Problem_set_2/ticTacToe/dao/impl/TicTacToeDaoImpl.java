package ticTacToe.dao.impl;

import ticTacToe.dao.TicTacToeDao;
import ticTacToe.model.Board;
import ticTacToe.model.Piece;


/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class TicTacToeDaoImpl implements TicTacToeDao {
    private final Board board;

    private static TicTacToeDaoImpl ticTacToeDao;

    private TicTacToeDaoImpl() {
        this.board = new Board();
    }

    public static TicTacToeDao getInstance() {
        if (ticTacToeDao == null) {
            ticTacToeDao = new TicTacToeDaoImpl();
        }
        return ticTacToeDao;
    }

    @Override
    public boolean addPiece(Piece piece, Integer row, Integer col) {
        return board.addPieceOnBoard(piece, row, col);
    }

    @Override
    public Board getBoard() {
        return board;
    }

}
