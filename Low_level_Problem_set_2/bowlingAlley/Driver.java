package bowlingAlley;

import bowlingAlley.dao.BowlingAlleyDao;
import bowlingAlley.model.Player;

/**
 * @author priyamvora
 * @created 23/05/2021
 */
public class Driver {
    public static void main(String[] args) {
        BowlingAlleyDao bowlingAlleyDao = new BowlingAlleyDao(new StandardGameRule(5, 2, 10, 5, 2));
        bowlingAlleyDao.addPlayer(new Player("1", "Priyam"));
        bowlingAlleyDao.addPlayer(new Player("2", "Shoyeb"));
        bowlingAlleyDao.startGame();
    }
}
