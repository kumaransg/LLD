package bowlingAlley;

import bowlingAlley.constants.ScoreType;

/**
 * @author priyamvora
 * @created 24/05/2021
 */
public interface IGameRules {
    Integer getTotalNumberOfRounds();

    Integer getNumberOfChancesInEachRound();

    Integer getNumberOfBonusPointsForStrike();

    Integer getNumberOfBonusPointsForSpare();

    Integer getNumberOfBonusBallsOnStrikeOrSpareInLastRound();

    Boolean isEligibleForBonusBalls(Integer roundNumber, ScoreType scoreType);
}
