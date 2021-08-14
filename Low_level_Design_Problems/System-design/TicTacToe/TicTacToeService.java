package Game;

import java.util.*;
public class TicTacToeService {
	private int size;
	private TicTacToeBoard tictacboard;
	private TicTacToeLogic tictactoelogic;
	private Queue<User> user;
	
	TicTacToeService(int n) {
		this.size = n;
		this.tictacboard = new TicTacToeBoard(n);
		this.user = new LinkedList<User>();
	}
	
	public void setPlayers(List<User> pl) {
		int i = 1;
		Map<String, Integer> playerPieces = new HashMap<String,Integer>();
		for(User u : pl) {
			this.user.add(u);
			playerPieces.put(u.getName(),i);
			i++;
		}
		tictacboard.setPlayers(playerPieces);
	}
	
	public void startGame() {
		tictactoelogic = new TicTacToeLogic(size);
		Scanner scanner = new Scanner(System.in);
		User winner = null;
		int tc = 0;
		while(tc < 9) {
			User currentuser = user.poll();
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			System.out.println("Ask user : " + currentuser.getName() + " with id : " + currentuser.getID() + " to tell row : " + row + " and column : " + col);
			int result = tictactoelogic.move(row, col, currentuser.getID());
			System.out.println("Result of move : " + result);
			if(result == 1 || result == 2) {
				winner = currentuser;
				break;
			}
			user.add(currentuser);
			tc++;
		}
		System.out.println("Winner of the game : " + winner.getName());
		
	}
}
