package bowlingAlley.dao;

import bowlingAlley.IGameRules;
import bowlingAlley.constants.ScoreType;
import bowlingAlley.model.Player;
import bowlingAlley.model.RoundStats;
import bowlingAlley.model.Score;

import java.util.*;

/**
 * @author priyamvora
 * @created 24/05/2021
 */
public class BowlingAlleyDao {
    private final List<Player> playerQueue;
    private final Map<String, List<RoundStats>> playerIdToRoundStatsMap;
    private final IGameRules gameRules;

    public BowlingAlleyDao(IGameRules gameRules) {
        this.playerQueue = new ArrayList<>();
        this.playerIdToRoundStatsMap = new HashMap<>();
        this.gameRules = gameRules;
    }

    public void addPlayer(Player player) {
        playerQueue.add(player);
    }

    public void startGame() {
        for (int round = 1; round <= gameRules.getTotalNumberOfRounds(); round++) {
            for (Player player : playerQueue) {
                RoundStats roundStats = new RoundStats(round);
                Integer totalScore = 0;
                Boolean gotStrike = false;
                Boolean isEligibleForBonus = false;
                for (int chance = 1; chance <= gameRules.getNumberOfChancesInEachRound(); chance++) {
                    System.out.print("Player: " + player.getName() + "Round: " + round + " - Enter your number of hits: ");
                    Scanner scanner = new Scanner(System.in);
                    Integer score = scanner.nextInt();
                    totalScore += score;
                    Score chanceScore = new Score(score);
                    if (isStrike(chance, score)) {
                        gotStrike = true;
                        chanceScore.setScoreType(ScoreType.STRIKE);
                        roundStats.addTotalPoints(gameRules.getNumberOfBonusPointsForStrike());
                    } else if (!gotStrike && isSpare(totalScore)) {
                        chanceScore.setScoreType(ScoreType.SPARE);
                        roundStats.addTotalPoints(gameRules.getNumberOfBonusPointsForStrike());
                    }
                    roundStats.addTotalPoints(score);
                    roundStats.addScore(chanceScore);
                    if (isEligibleForBonusBalls(round, chanceScore.getScoreType())) {
                        isEligibleForBonus = true;
                    }
                }

                if (isEligibleForBonus) {
                    totalScore = 0;
                    gotStrike = false;
                    for (int extraBalls = 1; extraBalls <= gameRules.getNumberOfBonusBallsOnStrikeOrSpareInLastRound(); extraBalls++) {
                        System.out.print("Round: " + round + " - Enter your number of hits: ");
                        Scanner scanner = new Scanner(System.in);
                        Integer score = scanner.nextInt();
                        totalScore += score;
                        Score chanceScore = new Score(score);
                        if (isStrike(extraBalls, score)) {
                            gotStrike = true;
                            chanceScore.setScoreType(ScoreType.STRIKE);
                            roundStats.addTotalPoints(gameRules.getNumberOfBonusPointsForStrike());
                        } else if (!gotStrike && isSpare(totalScore)) {
                            chanceScore.setScoreType(ScoreType.SPARE);
                            roundStats.addTotalPoints(gameRules.getNumberOfBonusPointsForStrike());
                        }
                        roundStats.addTotalPoints(score);
                        roundStats.addScore(chanceScore);
                    }
                }
                List<RoundStats> roundStatsList = playerIdToRoundStatsMap.getOrDefault(player.getPlayerId(), new ArrayList<>());
                roundStatsList.add(roundStats);
                playerIdToRoundStatsMap.put(player.getPlayerId(), roundStatsList);
                System.out.println("RoundStats:  " + roundStats + " for player: " + player);
            }
        }
    }

    public void showFinalBoard() {
        TreeMap<Integer, List<Player>> finalPointsToPlayerMap = new TreeMap<>(Collections.reverseOrder());
        for (String playerId : playerIdToRoundStatsMap.keySet()) {
            Integer totalPoints = playerIdToRoundStatsMap.get(playerId).stream().mapToInt(RoundStats::getTotalPoints).sum();
            List<Player> players = finalPointsToPlayerMap.getOrDefault(totalPoints, new ArrayList<>());
            Optional<Player> player = playerQueue.stream().filter(player1 -> player1.getPlayerId().equals(playerId)).findFirst();
            if (player.isPresent()) {
                players.add(player.get());
            }
            finalPointsToPlayerMap.put(totalPoints, players);
        }
        System.out.println(finalPointsToPlayerMap);
    }

    private boolean isStrike(int chance, int currentScore) {
        return chance == 1 && currentScore == 10;
    }

    private boolean isSpare(int totalScore) {
        return totalScore == 10;
    }

    private boolean isEligibleForBonusBalls(Integer round, ScoreType scoreType) {
        return gameRules.isEligibleForBonusBalls(round, scoreType);
    }

}
