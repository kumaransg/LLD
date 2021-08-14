package io.abhishek.machinecoding.snakeladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SnakeLadderMain {
  private LudoBoard board;
  private List<Player> players;
  private int numOfDice;
  static Scanner sc = new Scanner(System.in);
  private static final int DICE_MIN = 1;
  private static final int DICE_MAX = 6;

  public SnakeLadderMain() throws InterruptedException {
    initializeGameBoard();
    initializePlayers();
    gameStarted();
  }

  private void gameStarted() throws InterruptedException {
    boolean winner = false;
    while(true) {
      for (Player curPlayer : players) {
        makeTurn(curPlayer);
        TimeUnit.SECONDS.sleep(2);
        winner = checkPossibleWinner(curPlayer);
        if (winner) {
          System.out.println(curPlayer.getName() + " has won the game");
          return;
        }
      }
      if (winner)
        return;
    }
  }

  private boolean checkPossibleWinner(Player curPlayer) {
    if (curPlayer.getCurPosition() == board.getBoardSize()) {
      return true;
    }
    return false;
  }

  private void makeTurn(Player curPlayer) {
    int numOfMoves = rollDice();
    int curPos = curPlayer.getCurPosition();
    int destCell = numOfMoves + curPos;
    if (destCell <= 100) {
      curPos = destCell;
      boolean isAbnormalCell = true;
      while (isAbnormalCell) {
        if (board.getSnakes().containsKey(curPos)) {
          curPos = board.getSnakes().get(curPos);
          //  System.out.println("snake has met to the " + curPlayer.getName() + " at position " + curPos);
        } else if (board.getLadders().containsKey(curPos)) {
          curPos = board.getLadders().get(curPos);
          //  System.out.println("ladder has met to the " + curPlayer.getName() + " at position " + curPos);
        } else {
          isAbnormalCell = false;
        }
      }
    }
    System.out.println(curPlayer.getName() + " rolled a " +  numOfMoves + " and moved from "
            + curPlayer.getCurPosition() +  " to " +  curPos);
    curPlayer.setCurPosition(curPos);
  }

  private int rollDice() {
    int val = (int)(Math.random() * (DICE_MAX - DICE_MIN + 1) + DICE_MIN);
  //  System.out.println("dice rolled val " + val);
    // can have more logic if required for 6
    return val;
  }

  private void initializePlayers() {
    System.out.print("Enter the num of Players for the game : ");
    int numOfPlayers = sc.nextInt();
    players = new ArrayList<>();
    for (int p = 0;p < numOfPlayers;p++) {
      System.out.print("Enter the name of " + (p + 1) + " Player for the game : ");
      String pName = sc.next();
      Player player = new Player(pName);
      players.add(player);
    }
  }

  private void initializeGameBoard() {
    System.out.print("Enter the size of the board : -");
    int boardSize = sc.nextInt();
    this.board = new LudoBoard(boardSize);
  }



  public static void main(String[] args) throws InterruptedException {
    new SnakeLadderMain();
  }
}
