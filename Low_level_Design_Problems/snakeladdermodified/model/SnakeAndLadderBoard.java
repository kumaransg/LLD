package io.abhishek.machinecoding.snakeladdermodified.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderBoard {
  private List<Snake> snakes;
  private List<Ladder> ladders;
  private Map<String, Integer> playerPieces;
  private int size;

  public SnakeAndLadderBoard(int size) {
    this.size = size;
    this.snakes = new ArrayList<>();
    this.ladders = new ArrayList<>();
    this.playerPieces = new HashMap<>();
  }

  public List<Snake> getSnakes() {
    return snakes;
  }

  public void setSnakes(List<Snake> snakes) {
    this.snakes = snakes;
  }

  public List<Ladder> getLadders() {
    return ladders;
  }

  public void setLadders(List<Ladder> ladders) {
    this.ladders = ladders;
  }

  public Map<String, Integer> getPlayerPieces() {
    return playerPieces;
  }

  public void setPlayerPieces(Map<String, Integer> playerPieces) {
    this.playerPieces = playerPieces;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
