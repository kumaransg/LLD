package models;

abstract public class Player {
    String playerName;
    int age;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
