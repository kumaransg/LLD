package io.abhishek.machinecoding.snakeladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LudoBoard {
  int[] cells;
  private int boardSize;
  private int numOfSnakes;
  private int numOfLadders;
  private Map<Integer, Integer> snakes;
  private Map<Integer, Integer> ladders;

  public LudoBoard(int boardSize) {
    cells = new int[boardSize + 1];
    this.boardSize = boardSize;
    buildSnakes();
    buildLadder();
  }

  private void buildSnakes() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the numOfSnakes on the board : ");
    this.numOfSnakes = sc.nextInt();
    this.snakes = new HashMap<>();
    System.out.println("Enter the head and tail of each " + numOfSnakes + "snakes");
    for(int snake = 0;snake < numOfSnakes;snake++) {
     int head = sc.nextInt();
     int tail = sc.nextInt();
     snakes.put(head, tail);
    }
  }

  private void buildLadder() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the numOfLadders on the board : ");
    this.numOfLadders = sc.nextInt();
    System.out.println("Enter the start and end of each " + numOfLadders + "ladders");
    this.ladders = new HashMap<>();
    for(int ladder = 0;ladder < numOfLadders;ladder++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      ladders.put(start, end);
    }
  }

  public int getBoardSize() {
    return boardSize;
  }

  public int[] getCells() {
    return cells;
  }

  public void setCells(int[] cells) {
    this.cells = cells;
  }

  public int getNumOfSnakes() {
    return numOfSnakes;
  }

  public void setNumOfSnakes(int numOfSnakes) {
    this.numOfSnakes = numOfSnakes;
  }

  public int getNumOfLadders() {
    return numOfLadders;
  }

  public void setNumOfLadders(int numOfLadders) {
    this.numOfLadders = numOfLadders;
  }

  public Map<Integer, Integer> getSnakes() {
    return snakes;
  }

  public void setSnakes(Map<Integer, Integer> snakes) {
    this.snakes = snakes;
  }

  public Map<Integer, Integer> getLadders() {
    return ladders;
  }

  public void setLadders(Map<Integer, Integer> ladders) {
    this.ladders = ladders;
  }
}
