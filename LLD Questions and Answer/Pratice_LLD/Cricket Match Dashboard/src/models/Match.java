package models;

import UI.Dashboard;
import enums.MatchStatus;

import java.util.Scanner;

public class Match {
    String matchName;
    Dashboard dashboard;
    Team teamA;
    Team teamB;
    int numOfPlayerInTeam;
    int numOfOversInMatch;
    Team currentBattingTeam;
    Team previousBattingTeam;
    MatchStatus matchStatus;
    static final String WICKET = "W";
    static final String WIDE = "Wd";

    public Match(String matchName, Team teamA, Team teamB, int numOfPlayerInTeam, int numOfOversInMatch) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchName = matchName;
        this.numOfPlayerInTeam = numOfPlayerInTeam;
        this.numOfOversInMatch = numOfOversInMatch;
        this.dashboard = new Dashboard();
        this.currentBattingTeam = null;
        this.previousBattingTeam = null;
        this.matchStatus = MatchStatus.NOT_STARTED;
    }

    public void addPlayersToTeam(Team team, String[] listOfPlayers) {
        if (listOfPlayers.length > this.numOfPlayerInTeam) {
            System.out.println("No of players is more");
            return;
        }
        for (String name : listOfPlayers) {
            team.addPlayersToTeam(new CricketPlayer(name));
        }
    }

    public void startMatch(Team battingTeam) {
        this.matchStatus = MatchStatus.IN_PROGRESS;
        this.currentBattingTeam = battingTeam;
        startBatting();
        switchTeam(battingTeam);
        startBatting();
        displayResult();
    }

    private void startBatting() {
        System.out.println("Batting team is : " + this.currentBattingTeam.getTeamName() + " playing for overs : "
            + this.numOfOversInMatch);
        Scanner scanner = new Scanner(System.in);
        this.currentBattingTeam.initializePlayers();
        for (int i = 1; i <= this.numOfOversInMatch; i++) {
            System.out.println("Currently playing over : " + i);
            for (int j = 0; j < 6; j++) {
                String score = scanner.nextLine();
                if (!updateScore(score) || (previousBattingTeam != null
                    && this.currentBattingTeam.getTotalTeamScore() >= this.previousBattingTeam.getTotalTeamScore())) {
                    dashboard.displayScoreCard(this.currentBattingTeam);
                    return;
                }
            }
            //end of over
            this.currentBattingTeam.swapStrike();
            dashboard.displayScoreCard(this.currentBattingTeam);
        }
    }

    private boolean updateScore(String score) {
        if (score.equals(WICKET)) {
            return this.currentBattingTeam.updateWicket();
        } else if (score.equals(WIDE)) {
            this.currentBattingTeam.updateScore(0);
        } else {
            if (score.length() == 1 && Integer.valueOf(score) >= 0 && Integer.valueOf(score) <= 6) {
                int num = Integer.valueOf(score);
                this.currentBattingTeam.updateScore(num);
            }
        }
        return true;
    }

    private void switchTeam(Team currentBattingTeam) {
        if (currentBattingTeam == teamA) {
            this.currentBattingTeam = teamB;
            this.previousBattingTeam = teamA;
        } else {
            this.currentBattingTeam = teamA;
            this.previousBattingTeam = teamB;
        }
    }

    private void displayResult() {
        this.matchStatus = MatchStatus.COMPLETED;
        Team winner = null;
        if (this.currentBattingTeam.getTotalTeamScore() >= this.previousBattingTeam.getTotalTeamScore()) {
            winner = this.currentBattingTeam;
        } else {
            winner = this.previousBattingTeam;
        }
        int runs = this.currentBattingTeam.getTotalTeamScore() - this.previousBattingTeam.getTotalTeamScore();
        System.out.println("Result: " + winner.getTeamName() + " won the match by " + runs + " runs");
    }
}
