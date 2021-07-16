package io.abhishek.machinecoding.snakeladder;

public class Player {
  private int id;
  private String name;
  private int curPosition;

  public Player(String name) {
    this.name = name;
    this.curPosition = 0;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCurPosition() {
    return curPosition;
  }

  public void setCurPosition(int curPosition) {
    this.curPosition = curPosition;
  }
}
