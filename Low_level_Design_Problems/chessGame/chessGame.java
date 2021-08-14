package chessGame;

import java.util.List;

public class chessGame {
    ChessBoard chessBoard;
    Player[] players;
    List<Move> moves;
    Player winner;
    Player currentPlayer;
    GameStatus status;
    public Player getWinner() {return null;}
    public void playerMove(CellPosition from, CellPosition to, Piece piece) {}
    public void reset() {}
    public void endGame() {}
    private void changeTurn() {}
}
