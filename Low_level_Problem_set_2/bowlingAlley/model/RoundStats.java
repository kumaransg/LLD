package bowlingAlley.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author priyamvora
 * @created 24/05/2021
 */
public class RoundStats {
    private final Integer roundNo;
    private final List<Score> scores;
    private Integer totalPoints;

    public RoundStats(Integer roundNo) {
        this.roundNo = roundNo;
        this.scores = new ArrayList<>();
        this.totalPoints = 0;
    }

    public void addScore(Score score) {
        scores.add(score);
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void addTotalPoints(Integer points) {
        this.totalPoints += points;
    }

    public Integer getRoundNo() {
        return roundNo;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public List<Score> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "RoundStats{" +
                "roundNo=" + roundNo +
                ", scores=" + scores +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
