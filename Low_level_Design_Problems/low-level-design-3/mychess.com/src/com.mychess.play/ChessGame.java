import board.Board;
import enums.GameStatus;
import player.Player;

public class ChessGame {

    Player whitePlayer;
    Player blackPlayer;
    Board gameBoard;
    GameStatus gameStatus;

    private ChessGame(Player p1wPlayer, Player p2bPlayer) {
        whitePlayer = p1wPlayer;
        blackPlayer = p2bPlayer;
        gameBoard = new Board();
        gameStatus = GameStatus.UNDECIDED;
    }

	private void initGame() throws InterruptedException {
        System.out.println("White Player start the game...");
        while(gameStatus == GameStatus.UNDECIDED){
            
            Thread.sleep(1000*6);
            System.out.println("Game is in progress...");
        }
    }

    public GameStatus getGameStatus(){
        return gameStatus;
    }

    public static void startGame(Player p1, Player p2) throws InterruptedException {
        ChessGame game = new ChessGame(p1, p2);
        game.initGame();
    }
}