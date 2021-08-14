package snakeLadder.services;

import snakeLadder.dao.SnakeLadderDao;
import snakeLadder.model.Player;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class SnakeLadderService {
    private final SnakeLadderDao snakeLadderDao;

    public SnakeLadderService(SnakeLadderDao snakeLadderDao) {
        this.snakeLadderDao = snakeLadderDao;
    }

    public Player playTurn(Player currentPlayer) {
        Integer rollDice = snakeLadderDao.rollDice();
        return snakeLadderDao.movePawn(currentPlayer.getId(), rollDice);
    }

    public Player getNextPlayer() {
        return snakeLadderDao.getNextPlayer();
    }

    public void addSnake(Integer start, Integer end) {
        snakeLadderDao.addSnake(start, end);
    }

    public void addLadder(Integer start, Integer end) {
        snakeLadderDao.addLadder(start, end);
    }

    public void addNumberOfPlayers(Integer numberOfPlayers) {
        snakeLadderDao.setNumberOfPlayers(numberOfPlayers);
    }

    public void addPlayer(Integer id, String name) {
        snakeLadderDao.addPlayer(id, name);
    }

    public Boolean hasCurrentPlayerWon() {
        Player player = snakeLadderDao.hasCurrentPlayerWon();
        return player != null;
    }

    public Boolean isGameEnded() {
        return snakeLadderDao.isGameEnded();
    }

    public void setGameOverForPlayer(Integer id) {
        snakeLadderDao.setGameOverForPlayer(id);
    }

    public void setNumberOfDiceRolls(Integer numberOfDiceRolls) {
        snakeLadderDao.setNumberOfDiceRolls(numberOfDiceRolls);
    }

    public void setBoardSize(Integer boardSize) {
        snakeLadderDao.setBoardSize(boardSize);
    }
}
