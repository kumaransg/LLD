package ticTacToe.service;

import ticTacToe.constants.PieceType;
import ticTacToe.dao.TicTacToeDao;
import ticTacToe.model.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class TicTacToeService {
    private final TicTacToeDao ticTacToeDao;
    private final Queue<Player> playerQueue;

    public TicTacToeService(TicTacToeDao ticTacToeDao) {
        this.ticTacToeDao = ticTacToeDao;
        this.playerQueue = new LinkedList<>();
    }

    public void addPlayer(String name, PieceType pieceType) {
        Piece piece = null;
        switch (pieceType) {
            case O:
                piece = new PieceO();
                break;
            case X:
                piece = new PieceX();
                break;
            default:
                break;
        }
        playerQueue.add(new Player(name, piece));
    }

    public boolean serveTurn(Integer row, Integer col) {
        row--;
        col--;
        boolean success = false;
        if (!playerQueue.isEmpty()) {
            Player player = playerQueue.peek();
            success = ticTacToeDao.addPiece(player.getPiece(), row, col);
            if (success) {
                playerQueue.poll();
                playerQueue.add(player);
            }
        }
        return success;
    }

    public Player getCurrentPlayer() {
        if (playerQueue.isEmpty()) {
            return null;
        }
        return playerQueue.peek();
    }

    public Boolean checkForWin(Piece playerPiece) {
        Board board = ticTacToeDao.getBoard();
        Integer size = board.getSize();
        Piece[][] piece = board.getBoard();
        return checkDiagonals(piece, playerPiece, size) || checkRow(piece, playerPiece, size) || checkCol(piece, playerPiece, size);
    }

    public void printBoard() {
        Piece[][] pieces = ticTacToeDao.getBoard().getBoard();
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces.length; j++) {
                if (pieces[i][j] == null) {
                    System.out.print("-");
                    continue;
                }
                switch (pieces[i][j].getPieceType()) {
                    case X:
                        System.out.print("x");
                        break;
                    case O:
                        System.out.print("o");
                        break;
                    default:
                        System.out.print("-");
                        break;
                }
            }
            System.out.println();
        }
    }

    private boolean checkDiagonals(Piece[][] piece, Piece playerPiece, Integer size) {
        int start = 0, end = 0;
        boolean win = true;
        while (start < size && end < size && win) {
            if (piece[start][end] == null || !piece[start][end].getPieceType().equals(playerPiece.getPieceType())) {
                win = false;
            }
            start++;
            end++;
        }
        if (win) {
            return true;
        }
        win = true;
        start = size - 1;
        end = 0;
        while (start >= 0 && end < size && win) {
            if (piece[start][end] == null || !piece[start][end].getPieceType().equals(playerPiece.getPieceType())) {
                win = false;
            }
            start--;
            end++;
        }
        return win;
    }

    private boolean checkRow(Piece[][] pieces, Piece playerPiece, Integer size) {
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size && win; j++) {
                if (pieces[i][j] == null || !pieces[i][j].getPieceType().equals(playerPiece.getPieceType())) {
                    win = false;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(Piece[][] pieces, Piece playerPiece, Integer size) {
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size && win; j++) {
                if (pieces[j][i] == null || !pieces[j][i].getPieceType().equals(playerPiece.getPieceType())) {
                    win = false;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }
}
