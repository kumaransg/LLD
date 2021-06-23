package models;

public class CricketPlayer extends Player {

    PlayerData playerData;
    boolean isOnStrike;
    boolean isOut;

    public CricketPlayer(String playerName) {
        super(playerName);
        this.isOnStrike = false;
        this.isOut = false;
        this.playerData = new PlayerData();
    }

    public PlayerData getPlayerData() {
        return playerData;
    }

    public void updatePlayerScore(int score){
        playerData.updatePlayerScore(score);
    }
}
