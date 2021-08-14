package com.snl.services;

import java.util.*;
import com.snl.models.NumberBox;
import com.snl.models.Player;

public class Game {
    private HashMap<Integer, NumberBox> numBoxMapping;
    private ArrayList<Player> boardPlayers;
    private boolean someoneReached100;

    // constructor
    public Game() {
        boardPlayers = new ArrayList<Player>();
        someoneReached100 = false;
    }
    
    public void initialize() {
        numBoxMapping = new HashMap<Integer, NumberBox>();
        for(int i=0; i<=100; i++) {
            numBoxMapping.put(i, new NumberBox(i));
        }
    }

    public void addSnakeEntry(int snakeHead, int snakeTail) throws Exception {
        if (snakeHead < snakeTail) {
            throw new Exception("Snake's Head can't be at a Box lesser than Snake's Tail");
        }
        NumberBox nb = numBoxMapping.get(snakeHead);
        nb.setSnake(snakeTail);
    }

    public void addLadderEntry(int ladderStart, int ladderEnd) throws Exception {
        if (ladderStart > ladderEnd) {
            throw new Exception("Ladder's Start can't be at a Box greater than Ladder's End");
        }
        NumberBox nb = numBoxMapping.get(ladderStart);
        nb.setLadder(ladderEnd);
    }

    public void addPlayerEntry(String name) {
        boardPlayers.add(new Player(name));
    }

    private int validateMove(int playerPosition, int updatedPosition) {
        if(updatedPosition > 100) {
            System.out.print(" (Crosses 100 hence no movement) ");
            return playerPosition;
        } else if (updatedPosition == 100) {
            someoneReached100 = true;
            return updatedPosition;
        } else {
            NumberBox nb = numBoxMapping.get(updatedPosition);
            if(nb.doesSnakeHeadStart()) {
                System.out.print("" + updatedPosition + " (through Snake Bite) to ");
                return validateMove(playerPosition, nb.getSnakeTail());
            } else if (nb.doesLadderStart()) {
                System.out.print("" + updatedPosition + " (through Ladder Climb) to ");
                return validateMove(playerPosition, nb.getLadderEnd());
            } else {
                return updatedPosition;
            }
        }
    }

    private void movePlayerNBoxes(Player p, int diceRoll) {
        int playerPosition = p.getCurPosition();
        System.out.print("" + playerPosition + " to ");
        playerPosition = validateMove(playerPosition, playerPosition+diceRoll);
        System.out.println("" + playerPosition);
        if(playerPosition == 100) {
            System.out.println("" + p.getName() + " wins the game");
        }
        p.setCurPosition(playerPosition);
    }

    private void playTurn(Player p) {
        int diceRoll = DiceRoll.rollDice();
        System.out.print("" + p.getName() + " rolled a " + diceRoll + " and moved from ");
        movePlayerNBoxes(p, diceRoll);
    }

    public void play() {
        System.out.println("Game Begins");
        int numRounds = 0;
        while(!someoneReached100) {
            numRounds++;
            System.out.println(" ");
            System.out.println("Round " + numRounds + " starts");
            for (int i = 0; (i < boardPlayers.size() && !someoneReached100); i++) {
                playTurn(boardPlayers.get(i));
            }
            System.out.println("Round " + numRounds + " ends");
            System.out.println(" ");
        }
        System.out.println("Game Ends");
    }
}