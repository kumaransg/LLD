package SaL;

import java.util.*;

public class SnakeAndLadderBoard {
	private int size;
	private List<Snake> snakes;
	private List<Ladder> ladders;
	private Map<String, Integer> playerPieces;
	
	public SnakeAndLadderBoard(int s) {
		this.size = s;
		this.snakes = new ArrayList<Snake>();
		this.ladders = new ArrayList<Ladder>();
		this.playerPieces = new HashMap<String, Integer>();
	}
	
	public int getSize() { 
		return size;
	}
	
	public List<Snake> getSnakes() {
		return snakes;
	}
	
	public void setSnake(List<Snake> s) {
		this.snakes = s;
	}
	
	public List<Ladder> getLadders() {
		return ladders;
	}
	
	public void setLadders(List<Ladder> l) {
		this.ladders = l;
	}
	
	public Map<String,Integer> getPlayerPieces() {
		return playerPieces;
	}
	
	public void setPlayerPieces(Map<String,Integer> pp) {
		this.playerPieces = pp;
	}
}
