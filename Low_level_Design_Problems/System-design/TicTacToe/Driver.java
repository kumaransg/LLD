package Game;

import java.util.*;

public class Driver {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int noOfPlayers = scanner.nextInt();
		
		List<User> pl = new ArrayList<User>();
		for(int i=1;i<=noOfPlayers;i++) {
			pl.add(new User(scanner.next(),i));
		}
		
		TicTacToeService service = new TicTacToeService(3);
		service.setPlayers(pl);
		service.startGame();
	}
}
