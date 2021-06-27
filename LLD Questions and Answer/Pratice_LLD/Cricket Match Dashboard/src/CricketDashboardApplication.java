import models.Match;
import models.Team;

public class CricketDashboardApplication {
    public static void main(String[] args) {
        Team india = new Team("India");
        Team austriala = new Team("Austriala");
        Match match1 = new Match("Test Match", india, austriala, 5, 2);
        match1.addPlayersToTeam(india,new String[]{"P1","P2","P3","P4","P5"});
        match1.addPlayersToTeam(austriala,new String[]{"P1","P2","P3","P4","P5"});
        match1.startMatch(india);
    }
}
