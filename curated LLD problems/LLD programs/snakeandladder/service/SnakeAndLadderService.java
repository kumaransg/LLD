/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package snakeandladder.service;

import snakeandladder.models.Ladder;
import snakeandladder.models.Player;
import snakeandladder.models.Snake;
import snakeandladder.models.SnakeAndLadderBoard;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author paras.chawla
 * @version $Id: SnakeAndLadderService.java, v 0.1 2020-11-16 21:07 paras.chawla Exp $$
 */
public class SnakeAndLadderService {

    private              SnakeAndLadderBoard snakeAndLadderBoard;
    private              int                 initialNumberOfPlayers;
    private              Queue<Player>       players;
    private              boolean             isGameCompleted;
    private              int                 noOfDices;
    private static final int                 DEFAULT_BOARD_SIZE  = 100; //The board will have 100 cells numbered from 1 to 100.
    private static final int                 DEFAULT_NO_OF_DICES = 1;

    public SnakeAndLadderService() {
        this(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
    }

    public SnakeAndLadderService(int boardSize) {
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
        this.players = new LinkedList<>();
        this.noOfDices = SnakeAndLadderService.DEFAULT_NO_OF_DICES;
    }

    /**
     * ==================Initialize board==================
     */
    public void setPlayers(List<Player> players) {
        this.initialNumberOfPlayers = players.size();
        Map<String, Integer> playerPosition = this.snakeAndLadderBoard.getPlayerPosition();

        //Set Initial position of all players is 0
        for (Player player : players) {
            this.players.add(player);
            playerPosition.put(player.getId(), 0);
        }
        this.snakeAndLadderBoard.setPlayerPosition(playerPosition);
    }

    public void setSnakes(List<Snake> snakes) {
        snakeAndLadderBoard.setSnakes(snakes); // Add snakes to board
    }

    public void setLadders(List<Ladder> ladders) {
        snakeAndLadderBoard.setLadders(ladders); // Add ladders to board
    }

    /**
     * ==================Start GAME==================
     */

    public void startGame() {

        while (!isGameCompleted) {

            // 1. Roll Dice
            int totalDiceValue = getTotalValueAfterDiceRolls();

            // 2. Move current player to dice value + current player position
            Player currentPlayer = players.poll();

            // 3. Move player
            movePlayer(currentPlayer, totalDiceValue);

            // 4. check if Game Won by current player
            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game");
                snakeAndLadderBoard.getPlayerPosition().remove(currentPlayer.getId());
                this.isGameCompleted = true;
            } else {
                players.add(currentPlayer);
            }
        }

    }

    private void movePlayer(Player player, int totalDiceValue) {

        int oldPosition = this.snakeAndLadderBoard.getPlayerPosition().get(player.getId());
        int newPosition = oldPosition + totalDiceValue;
        System.out.println(player.getName() + "Old Position " + oldPosition + "- New Position " + newPosition);
        newPosition = newPosition > snakeAndLadderBoard.getSize() ? oldPosition : getNewPositionAfterGoingThroughSnakeAndLadders(
                newPosition);
        this.snakeAndLadderBoard.getPlayerPosition().put(player.getId(), newPosition);

        System.out.println(
                player.getName() + " Rolled a dice and gets " + totalDiceValue + "and moved from " + oldPosition + " to " + newPosition);
    }

    // Include snake and ladder logic
    private int getNewPositionAfterGoingThroughSnakeAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : snakeAndLadderBoard.getSnakes()) {
                if (snake.getStart() == newPosition) {
                    System.out.println("Meet Snake, Slip From " + snake.getStart() + " To " + snake.getEnd());
                    newPosition = snake
                            .getEnd(); // Whenever a piece ends up at a position with the head of the snake, the piece should go down to
                    // the position of the tail of that snake.
                }
            }

            for (Ladder ladder : snakeAndLadderBoard.getLadders()) {
                if (ladder.getStart() == newPosition) {
                    System.out.println("Meet Ladder, Up From " + ladder.getStart() + " To " + ladder.getEnd());
                    newPosition = ladder
                            .getEnd(); // Whenever a piece ends up at a position with the start of the ladder, the piece should go up to
                    // the position of the end of that ladder.
                }
            }
        } while (newPosition != previousPosition);
        return newPosition;
    }

    private int getTotalValueAfterDiceRolls() {
        // Can use noOfDices and setShouldAllowMultipleDiceRollOnSix here to get total value (Optional requirements)
        return DiceService.roll();
    }

    private boolean hasPlayerWon(Player player) {
        // Can change the logic a bit to handle special cases when there are more than one dice (Optional requirements)
        int playerPosition = snakeAndLadderBoard.getPlayerPosition().get(player.getId());
        int winningPosition = snakeAndLadderBoard.getSize();
        return playerPosition == winningPosition; // A player wins if it exactly reaches the position 100 and the game ends there.
    }

}