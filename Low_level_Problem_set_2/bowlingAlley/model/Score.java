package bowlingAlley.model;

import bowlingAlley.constants.ScoreType;

/**
 * @author priyamvora
 * @created 24/05/2021
 */
public class Score {
    private Integer numberOfPinsDown;
    private ScoreType scoreType;

    public Score(Integer numberOfPinsDown) {
        this.numberOfPinsDown = numberOfPinsDown;
    }

    public void setNumberOfPinsDown(Integer numberOfPinsDown) {
        this.numberOfPinsDown = numberOfPinsDown;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }

    public Integer getNumberOfPinsDown() {
        return numberOfPinsDown;
    }

    public ScoreType getScoreType() {
        return scoreType;
    }

    @Override
    public String toString() {
        return "Score{" +
                "numberOfPinsDown=" + numberOfPinsDown +
                ", scoreType=" + scoreType +
                '}';
    }
}
