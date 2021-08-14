package Game;

import java.util.*;
public class TicTacToeBoard {
	private int size;
	private Map<String,Integer> players;
	
	TicTacToeBoard(int n) {
		this.size = n;
		players = new HashMap<String,Integer>();
	}
	
	public int getSize() {
		return size;
	}
	
	public void setPlayers(Map<String,Integer> pp) {
		this.players = pp;
	}
	
	public Map<String,Integer> getPlayers() {
		return players;
	}
}
