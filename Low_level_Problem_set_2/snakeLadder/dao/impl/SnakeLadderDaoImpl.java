package snakeLadder.dao.impl;

import snakeLadder.dao.SnakeLadderDao;
import snakeLadder.model.Board;
import snakeLadder.model.Ladder;
import snakeLadder.model.Player;
import snakeLadder.model.Snake;

import java.util.Random;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class SnakeLadderDaoImpl implements SnakeLadderDao {
    private final Board board;
    private final Random random;

    private static SnakeLadderDao snakeLadderDao;

    private SnakeLadderDaoImpl() {
        board = new Board();
        random = new Random();
    }

    public static SnakeLadderDao getInstance() {
        if (snakeLadderDao == null) {
            snakeLadderDao = new SnakeLadderDaoImpl();
        }
        return snakeLadderDao;
    }

    @Override
    public Integer rollDice() {
        Integer diceRollValue = 0;
        for (int i = 0; i < board.getNumberOfDiceRolls(); i++) {
            diceRollValue += random.nextInt(6) + 1;
        }
        board.setDiceRollValue(diceRollValue);
        return diceRollValue;
    }

    @Override
    public Player movePawn(Integer playerId, Integer diceRollValue) {
        Player player = board.getPlayerById(playerId);
        Integer currentPosition = player.getPawnPosition();
        Integer newPosition = currentPosition + diceRollValue;
        if (newPosition <= board.getBoardSize()) {
            player.setPawnPosition(newPosition);
            for (Snake snake : board.getSnakeList()) {
                if (snake.getEnd().equals(newPosition)) {
                    newPosition = snake.getStart();
                    player.setPawnPosition(newPosition);
                }
            }
            for (Ladder ladder : board.getLadderList()) {
                if (ladder.getStart().equals(newPosition)) {
                    newPosition = ladder.getEnd();
                    player.setPawnPosition(newPosition);
                }
            }
        }
        return player;
    }

    @Override
    public Player getNextPlayer() {
        return board.getNextPlayer();
    }

    @Override
    public void addSnake(Integer start, Integer end) {
        Snake snake = new Snake(start, end);
        board.addSnake(snake);
    }

    @Override
    public void addLadder(Integer start, Integer end) {
        Ladder ladder = new Ladder(start, end);
        board.addLadder(ladder);
    }

    @Override
    public void setNumberOfPlayers(Integer numberOfPlayers) {
        board.setNumberOfPlayers(numberOfPlayers);
    }

    @Override
    public void setNumberOfDiceRolls(Integer numberOfDiceRolls) {
        board.setNumberOfDiceRolls(numberOfDiceRolls);
    }

    @Override
    public void setBoardSize(Integer boardSize) {
        board.setBoardSize(boardSize);
    }

    @Override
    public void addPlayer(Integer id, String name) {
        board.addPlayer(id, name);
    }

    @Override
    public Player hasCurrentPlayerWon() {
        Player player = board.getPlayerById(board.getCurrentPlayer());
        return player.getPawnPosition().equals(board.getBoardSize()) ? player : null;
    }

    @Override
    public void setGameOverForPlayer(Integer id) {
        Player player = board.getPlayerById(id);
        player.setGameOver(true);
    }

    @Override
    public boolean isGameEnded() {
        Integer numberOfPlayersPlaying = 0, numberOfPlayersWon = 0;
        for (Integer id : board.getPlayerIdMap().keySet()) {
            if (!board.getPlayerById(id).getGameOver()) {
                numberOfPlayersPlaying++;
            } else {
                numberOfPlayersWon++;
            }
        }
        if (!board.getContinueGameTillLastPlayer()) {
            return numberOfPlayersWon >= 1;
        } else {
            return numberOfPlayersPlaying <= 1;
        }
    }


}
