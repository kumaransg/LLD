package chess.dao;

import chess.constants.GameStatus;
import chess.model.Board;
import chess.model.Box;
import chess.model.Move;
import chess.model.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public class ChessDao {
    private final Queue<Player> playerQueue;
    private final Board board;
    private final GameStatus gameStatus;
    private final List<Move> moveList;

    public ChessDao() {
        this.playerQueue = new LinkedList<>();
        this.board = new Board();
        this.gameStatus = GameStatus.START;
        this.moveList = new ArrayList<>();
    }

    public void intializePlayers(Player p1, Player p2) {
        if (p1.isWhiteSide()) {
            playerQueue.add(p1);
            playerQueue.add(p2);
        } else {
            playerQueue.add(p2);
            playerQueue.add(p1);
        }
    }

    public boolean movePiece(Integer startX, Integer startY, Integer endX, Integer endY) throws Exception {
        Player currentPlayer = playerQueue.poll();
        Box startBox = board.getBox(startX, startY);
        Box endBox = board.getBox(endX, endY);
        Move move = new Move(currentPlayer, startBox, endBox);
        return makeMove(currentPlayer, move);
    }

    private boolean makeMove(Player currentPlayer, Move move) {
        Box startBox = move.getStart();
        Box endBox = move.getEnd();
        if (startBox == null || (currentPlayer.isWhiteSide() != startBox.getPiece().isWhitePiece())) {
            return false;
        }
        if (!startBox.getPiece().canMove(board, startBox, endBox)) {
            return false;
        }
        if (endBox != null) {
            endBox.getPiece().setKilled(true);
            move.setPieceKilled(endBox.getPiece());
        }
        // store the move
        moveList.add(move);

        // move piece from the stat box to end box
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);
        return true;
    }


}
