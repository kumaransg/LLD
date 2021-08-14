/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designchess.controller;

import designchess.enums.GameStatus;
import designchess.models.ChessBoard;
import designchess.models.Move;
import designchess.models.Piece;
import designchess.models.Player;
import designchess.models.pieceimpl.King;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author paras.chawla
 * @version $Id: Game.java, v 0.1 2020-11-09 22:07 paras.chawla Exp $$ This class controls the flow of a game. It keeps track of all the
 * game moves, which player has the current turn, and the final result of the game.
 *
 * https://massivetechinterview.blogspot.com/2015/07/design-chess-game-using-oo-principles.html
 * https://www.educative.io/courses/grokking-the-object-oriented-design-interview/JP7BXYkj3DK
 */
public class Game {
    private Player[]   players;
    private ChessBoard board;
    private GameStatus status;
    private List<Move> movesPlayed;

    // Main method which is starting the game
    public void startGame() {

        // Initialize both players
        players[0] = new Player("Paras", true);
        players[1] = new Player("Computer", false);

        // Initialize ChessBoard
        board = new ChessBoard(8);
        movesPlayed = new ArrayList<>();

        // Keep playing game until GameStatus is BLACK_WIN or WHITE_WIN
        while (true) {

            processTurn(players[0]);
            if (this.status == GameStatus.WHITE_WIN) {
                System.out.println("P1 win!");
                break;
            }

            processTurn(players[1]);
            if (this.status == GameStatus.BLACK_WIN) {
                System.out.println("P2 win!");
                break;
            }
        }

    }

    // Move played by Player - keep in Loop till valid move happens
    public void processTurn(Player player) {
        Move move;
        do {
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter current position of Piece you want to move");
            // Positions entered by player
            int startX = scan.nextInt();
            int startY = scan.nextInt();

            System.out.println("Enter position where you want to put Piece");
            int endX = scan.nextInt();
            int endY = scan.nextInt();

            // Move created based on position entered by player 1
            move = new Move(player, board.getCellAtLocation(startX, startY), board.getCellAtLocation(endX, endY));
        } while (!makeMove(move));
    }

    // Actual Command executed by this method
    private boolean makeMove(Move move) {

        // Moving piece from Cell
        Piece sourcePiece = move.getStart().getCurrentPiece();

        // Valid Move? Calling Piece actual implementation
        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            System.out.println("Invalid Move, sourcePiece is " + sourcePiece);
        }

        // Killed other player Piece?
        Piece destPiece = move.getEnd().getCurrentPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        // castling?
        if (sourcePiece instanceof King
                && sourcePiece.isCastlingMove()) {
            move.setCastlingMove(true);
        }

        // Store the Move
        movesPlayed.add(move);

        // If move is VALID, set piece=null at start cell and new piece at dest cell
        move.getEnd().setCurrentPiece(sourcePiece);
        move.getStart().setCurrentPiece(null);

        // Game Win or not
        if (destPiece instanceof King) {
            if (move.getPlayedBy().isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }

        }

        return true;
    }

    private void setStatus(GameStatus status) {
        this.status = status;
    }
}