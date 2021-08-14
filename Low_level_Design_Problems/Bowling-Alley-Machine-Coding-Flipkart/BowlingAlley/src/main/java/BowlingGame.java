import java.util.Scanner;

public class BowlingGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		System.out.println("Enter no of players");
		game.setNo_of_players(in.nextInt());
		System.out.println("Enter no of rounds");
		game.setNo_of_rounds(in.nextInt());
		ScoreKeeperUtility scoreKeeperUtility=new  ScoreKeeperUtility();
		scoreKeeperUtility.startGame(game);
	}

}
