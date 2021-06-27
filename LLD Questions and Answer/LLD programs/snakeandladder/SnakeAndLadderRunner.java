/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package snakeandladder;

import snakeandladder.models.Ladder;
import snakeandladder.models.Player;
import snakeandladder.models.Snake;
import snakeandladder.service.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author paras.chawla
 * @version $Id: SnakeAndLadderRunner.java, v 0.1 2020-11-16 21:00 paras.chawla Exp $$

https://workat.tech/machine-coding/article/how-to-design-snake-and-ladder-machine-coding-ehskk9c40x2w
 */

// Runner class
public class SnakeAndLadderRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Create Snakes based on user input .. Snake start position is greater than snake end position
        int noOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for (int i = 0; i < noOfSnakes; i++) {
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }

        // 2. Create Ladders based on user input .. Ladder start position is less than ladder end position
        int noOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        // 3. Create number of players .. include player name and Unique Id
        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(scanner.next()));
        }

        // 4. Passing everything to Orchestrator Service
        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();

        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setLadders(ladders);

        // 5. Let the game begins
        snakeAndLadderService.startGame();
    }

}