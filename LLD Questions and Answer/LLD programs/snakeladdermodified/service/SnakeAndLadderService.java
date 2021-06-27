package io.abhishek.machinecoding.snakeladdermodified.service;

import io.abhishek.machinecoding.snakeladdermodified.model.Ladder;
import io.abhishek.machinecoding.snakeladdermodified.model.Player;
import io.abhishek.machinecoding.snakeladdermodified.model.Snake;
import io.abhishek.machinecoding.snakeladdermodified.model.SnakeAndLadderBoard;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadderService {

  private SnakeAndLadderBoard snakeAndLadderBoard;
  private Queue<Player> players;  // player will be removed if they won
  private int noOfDices;
  private int initialNoOfPlayers;
  private boolean isGameCompleted;
  private boolean shouldGameContinueTillLastPlayer;
  private boolean shouldAllowMultipleDiceRollOnSix; // for multiple roll on 6
  private static final int DEFAULT_DICE = 1;
  private static final int DEFAULT_BOARD_SIZE = 100;

  public SnakeAndLadderService(int boardSize) {
    this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
    this.players = new LinkedList<>();
  }

  public SnakeAndLadderService() {
    this(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
  }

  public void setSnakesOnBoard(List<Snake> snakes) {
    snakeAndLadderBoard.setSnakes(snakes);
  }

  public void setLaddersOnBoard(List<Ladder> ladders) {
    snakeAndLadderBoard.setLadders(ladders);
  }

  public void setPlayers(List<Player> playerList) {
    this.initialNoOfPlayers = playerList.size();
    Map<String, Integer> playerPieceMapping = new HashMap<>();
    for(Player player : playerList) {
      players.add(player);
      playerPieceMapping.put(player.getName(), 0);
    }
    snakeAndLadderBoard.setPlayerPieces(playerPieceMapping);
  }

  /**
   * game starts here
   */
  public void startTheGame() {
    while(!isGameCompleted()) {
        int diceVal = totalValAfterRunningDice();
        Player curPlayer = players.poll();
        movePlayer(curPlayer, diceVal);
        if (hasWon(curPlayer)) {
          System.out.println(curPlayer.getName() + " has won");
          snakeAndLadderBoard.getPlayerPieces().remove(curPlayer.getName());
        } else {
          players.add(curPlayer);
        }
    }
  }

  /**
   * player makes a move
   * @param curPlayer
   * @param diceVal
   */
  private void movePlayer(Player curPlayer, int diceVal) {
    int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(curPlayer.getName());
    int curPosition = oldPosition + diceVal;

    if (curPosition > snakeAndLadderBoard.getSize()) {
      curPosition = oldPosition;
    } else {
      curPosition = getCurPositionAfterGoingThroughSnakeAndLadders(curPosition);
    }
    snakeAndLadderBoard.getPlayerPieces().put(curPlayer.getName(), curPosition);
    System.out.println(curPlayer.getName() + " rolled a " +  diceVal + " and moved from "
        + oldPosition +  " to " +  curPosition);
  }

  private int getCurPositionAfterGoingThroughSnakeAndLadders(int curPosition) {
    int prevPosition;
    do {
      prevPosition = curPosition;
      for(Snake snake : snakeAndLadderBoard.getSnakes()) {
        if (snake.getHead() == curPosition) {
          curPosition = snake.getTail();
        }
      }

      for(Ladder ladder : snakeAndLadderBoard.getLadders()) {
        if (ladder.getStart() == curPosition) {
          curPosition = ladder.getEnd();
        }
      }
    } while(curPosition != prevPosition);

    return curPosition;
  }

  private boolean hasWon(Player curPlayer) {
    if (snakeAndLadderBoard.getPlayerPieces().containsKey(curPlayer.getName())) {
      int cellNo = snakeAndLadderBoard.getPlayerPieces().get(curPlayer.getName());
      if (cellNo == snakeAndLadderBoard.getSize())
        return true;
    }
    return false;
  }

  private int totalValAfterRunningDice() {
    return DiceService.roll();
  }

  private boolean isGameCompleted() {
    if (players.size() != initialNoOfPlayers)
      return true;
    return false;
  }

  public Queue<Player> getPlayers() {
    return players;
  }
}
