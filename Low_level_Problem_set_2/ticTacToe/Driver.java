package ticTacToe;

import ticTacToe.constants.PieceType;
import ticTacToe.dao.impl.TicTacToeDaoImpl;
import ticTacToe.model.Player;
import ticTacToe.service.TicTacToeService;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class Driver {
    public static void main(String[] args) {
        TicTacToeService ticTacToeService = new TicTacToeService(TicTacToeDaoImpl.getInstance());
        ticTacToeService.addPlayer("Gaurav", PieceType.X);
        ticTacToeService.addPlayer("Sagar", PieceType.O);

        Player player = ticTacToeService.getCurrentPlayer();
        boolean success = ticTacToeService.serveTurn(2, 2);
        if (!success) {
            System.out.println("INVALID MOVE");
        }
        ticTacToeService.printBoard();
        boolean win = ticTacToeService.checkForWin(player.getPiece());
        if (win) {
            System.out.println(player.getName() + " has won");
            return;
        }

        player = ticTacToeService.getCurrentPlayer();
         success = ticTacToeService.serveTurn(1, 3);
        if (!success) {
            System.out.println("INVALID MOVE");
        }
        ticTacToeService.printBoard();
         win = ticTacToeService.checkForWin(player.getPiece());
        if (win) {
            System.out.println(player.getName() + " has won");
            return;
        }

        player = ticTacToeService.getCurrentPlayer();
        success = ticTacToeService.serveTurn(1, 1);
        if (!success) {
            System.out.println("INVALID MOVE");
        }
        ticTacToeService.printBoard();
        win = ticTacToeService.checkForWin(player.getPiece());
        if (win) {
            System.out.println(player.getName() + " has won");
            return;
        }
        player = ticTacToeService.getCurrentPlayer();
        success = ticTacToeService.serveTurn(1, 2);
        if (!success) {
            System.out.println("INVALID MOVE");
        }
        ticTacToeService.printBoard();
        win = ticTacToeService.checkForWin(player.getPiece());
        if (win) {
            System.out.println(player.getName() + " has won");
            return;
        }
        player = ticTacToeService.getCurrentPlayer();
        success = ticTacToeService.serveTurn(2, 2);
        if (!success) {
            System.out.println("INVALID MOVE");
        }
        ticTacToeService.printBoard();
        win = ticTacToeService.checkForWin(player.getPiece());
        if (win) {
            System.out.println(player.getName() + " has won");
            return;
        }
        player = ticTacToeService.getCurrentPlayer();
        success = ticTacToeService.serveTurn(3, 3);
        if (!success) {
            System.out.println("INVALID MOVE");
        }
        ticTacToeService.printBoard();
        win = ticTacToeService.checkForWin(player.getPiece());
        if (win) {
            System.out.println(player.getName() + " has won");
            return;
        }

    }
}
