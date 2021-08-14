package snakeLadder.dao;

import snakeLadder.model.Player;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public interface SnakeLadderDao {
    Integer rollDice();

    Player movePawn(Integer playerId, Integer diceRollValue);

    Player getNextPlayer();

    void addSnake(Integer start, Integer end);

    void addLadder(Integer start, Integer end);

    void setNumberOfPlayers(Integer numberOfPlayers);

    void setNumberOfDiceRolls(Integer numberOfDiceRolls);

    void setBoardSize(Integer boardSize);

    void addPlayer(Integer id, String name);

    Player hasCurrentPlayerWon();

    void setGameOverForPlayer(Integer id);

    boolean isGameEnded();



}
