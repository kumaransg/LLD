package SaL;

import java.util.*;

public class SnakeAndLadderService {
	
	private static final int DEFAULT_BOARD_SIZE = 100;
	private static final int DEFAULT_NO_OF_DICES = 1;
	
	private int noOfDices;
	private SnakeAndLadderBoard snakeAndLadderBoard;
	private int initialNumberofPlayers;
	private boolean isGameCompleted;
	private Queue<Player> players;
	
	public SnakeAndLadderService(int size) {
		this.snakeAndLadderBoard = new SnakeAndLadderBoard(size);
		this.players = new LinkedList<Player>();
		this.noOfDices = SnakeAndLadderService.DEFAULT_NO_OF_DICES;
	}
	
	public SnakeAndLadderService() {
		this(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
	}
	
	// Initialize the board
	
	public void setPlayer(List<Player> players) {
		this.players = new LinkedList<Player>();
		this.initialNumberofPlayers = players.size();
		
		Map<String, Integer> playerPieces = new HashMap<String,Integer>();
		for(Player p : players) {
			this.players.add(p);
			playerPieces.put(p.getId(),0); 
		}
		snakeAndLadderBoard.setPlayerPieces(playerPieces);
	}
	
	public void setSnakes(List<Snake> snakes) {
		snakeAndLadderBoard.setSnake(snakes);
	}
	
	public void setLadders(List<Ladder> ladders) {
		snakeAndLadderBoard.setLadders(ladders);
	}
	
	// Core Business Logic of the Game 
	
	public void startGame() {
		while(!isGameCompleted()) {
			int totalDiceValue = getTotalValueAfterDiceRolls();
			Player currentPlayer = players.poll();
			moveCurrentPlayer(currentPlayer,totalDiceValue);
			if(hasWonGame(currentPlayer)) {
				snakeAndLadderBoard.getPlayerPieces().remove(currentPlayer.getId());
			} else {
				players.add(currentPlayer);
			}
		}
	}

	private boolean hasWonGame(Player currentPlayer) {
		// TODO Auto-generated method stub
		int playerposition = snakeAndLadderBoard.getPlayerPieces().get(currentPlayer.getId());
		int winningposition = snakeAndLadderBoard.getSize();
		return playerposition == winningposition;
	}

	private void moveCurrentPlayer(Player currentPlayer, int totalDiceValue) {
		// TODO Auto-generated method stub
		int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(currentPlayer.getId());
		int newPosition = oldPosition + totalDiceValue;
		
		int boardsize = snakeAndLadderBoard.getSize();
		
		if(newPosition > boardsize) {
			newPosition = oldPosition;
		} else {
			newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
		}
	
		snakeAndLadderBoard.getPlayerPieces().put(currentPlayer.getId(), newPosition);
        System.out.println(currentPlayer.getName() + " rolled a " + totalDiceValue + " and moved from " + oldPosition +" to " + newPosition);
	}

	private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
		// TODO Auto-generated method stub
		int previousPosition;
		do {
			previousPosition = newPosition;
			for(Snake s : snakeAndLadderBoard.getSnakes()) {
				if(s.getStartPoint() == newPosition) {
					newPosition = s.getEndPoint();
				}
			}
			for(Ladder l : snakeAndLadderBoard.getLadders()) {
				if(l.getStart() == newPosition) {
					newPosition = l.getEnd();
				}
			}
		} while(previousPosition != newPosition);
		return newPosition;
	}

	private boolean isGameCompleted() {
		// TODO Auto-generated method stub
		int currentNumberofPlayers = players.size();
		return currentNumberofPlayers < initialNumberofPlayers;
	}

	private int getTotalValueAfterDiceRolls() {
		// TODO Auto-generated method stub
		return DiceService.roll();
	}
}
