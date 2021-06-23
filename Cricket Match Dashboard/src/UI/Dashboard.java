package UI;

import models.CricketPlayer;
import models.PlayerData;
import models.Team;

import java.util.UUID;

public class Dashboard {
    String id;
    private static final String PLAYER_NAME_COL = "Player Name";
    private static final String SCORE = "Score";
    private static final String NO_OF_4 = "4's";
    private static final String NO_OF_6 = "6's";
    private static final String BALLS = "Balls";

    public Dashboard() {
        this.id = UUID.randomUUID().toString();
    }

    public void displayScoreCard(Team currentTeam) {
        displayHeader(currentTeam);
        displayTeamStats(currentTeam);
        displayTeamFinalScore(currentTeam);
    }

    private void displayTeamFinalScore(Team currentTeam) {
        System.out.println("Total : " + currentTeam.getTotalTeamScore() + "/" + currentTeam.getTotalWickets());
    }

    private void displayTeamStats(Team currentTeam) {
        for (CricketPlayer player : currentTeam.getPlayers()) {
            PlayerData data = player.getPlayerData();
            System.out.println(
                player.getPlayerName() + "          | " + data.getScore() + " | " + data.getNumberOfFour() + " | "
                    + data
                    .getNumberOfSix() + " | " + data.getNumberOfBallsFaced());
        }
    }

    private void displayHeader(Team team) {
        System.out.println("Scorecard for Team  " + team.getTeamName());
        System.out.println(PLAYER_NAME_COL + " | " + SCORE + " | " + NO_OF_4 + " | " + NO_OF_6 + " | " + BALLS);
    }
}
