package models;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Team {

    List<CricketPlayer> players;
    Deque<CricketPlayer> availablePlayers;
    int totalTeamScore;
    int totalWickets;

    public int getTotalTeamScore() {
        return totalTeamScore;
    }

    CricketPlayer currentBatsman;
    CricketPlayer strikeBatsman;
    String teamName;

    public Team(String teamName) {
        this.players = new ArrayList<>();
        this.availablePlayers = new LinkedList<>();
        this.totalTeamScore = 0;
        this.currentBatsman = null;
        this.strikeBatsman = null;
        this.teamName = teamName;
        this.totalWickets = 0;
    }

    public void addPlayersToTeam(CricketPlayer player) {
        if (this.players.contains(player)) {
            System.out.println("Player Already in the team");
        } else {
            this.players.add(player);
            availablePlayers.addLast(player);
        }
    }

    public void initializePlayers() {
        if (availablePlayers.size() >= 2) {
            this.currentBatsman = availablePlayers.poll();
            this.strikeBatsman = availablePlayers.poll();
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public List<CricketPlayer> getPlayers() {
        return new ArrayList<>(players);
    }

    public boolean isNextBatsmanAvailable() {
        if (availablePlayers.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public Player wicketFallen() {
        CricketPlayer player = availablePlayers.poll();
        this.currentBatsman = player;
        return player;
    }

    public void swapStrike() {
        CricketPlayer temp = this.currentBatsman;
        this.currentBatsman = this.strikeBatsman;
        this.strikeBatsman = temp;
    }

    public boolean updateScore(int score) {
        currentBatsman.updatePlayerScore(score);
        updateStrikeBatsman(score);
        this.totalTeamScore += score;
        return true;
    }

    private void updateStrikeBatsman(int score) {
        if (score != 0 && score % 2 != 0) {
            swapStrike();
        }
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public boolean updateWicket() {
        this.totalWickets +=1;
        if (isNextBatsmanAvailable()) {
            updateScore(0);
            wicketFallen();
            return true;
        } else {
            System.out.println("no batsman to play");
            return false;
        }
    }
}
