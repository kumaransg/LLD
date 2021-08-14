package snakeLadder;

import snakeLadder.dao.impl.SnakeLadderDaoImpl;
import snakeLadder.model.Player;
import snakeLadder.services.SnakeLadderService;

import java.util.Scanner;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class Driver {
    public static void main(String[] args) {
        SnakeLadderService snakeLadderService = new SnakeLadderService(SnakeLadderDaoImpl.getInstance());
        Scanner scanner = new Scanner(System.in);
        Integer numOfSnakes = scanner.nextInt();
        for (int i = 0; i < numOfSnakes; i++) {
            Integer start = scanner.nextInt();
            Integer end = scanner.nextInt();
            snakeLadderService.addSnake(end, start);
        }

        Integer numOfLadders = scanner.nextInt();
        for (int i = 0; i < numOfLadders; i++) {
            Integer start = scanner.nextInt();
            Integer end = scanner.nextInt();
            snakeLadderService.addLadder(start, end);
        }

        Integer numberOfPlayers = scanner.nextInt();
        scanner.nextLine();
        snakeLadderService.addNumberOfPlayers(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = scanner.nextLine();
            snakeLadderService.addPlayer(i, name);
        }
        int x = 10;
        while (x-- > 0) {
            Player currentPlayer = snakeLadderService.getNextPlayer();
            Integer currentPosition = currentPlayer.getPawnPosition();
            Player updatedPlayer = snakeLadderService.playTurn(currentPlayer);
            System.out.println(currentPlayer.getName() + " moved from " + currentPosition + " to " + updatedPlayer.getPawnPosition());
            if (snakeLadderService.hasCurrentPlayerWon()) {
                System.out.println(currentPlayer.getName() + " has won!!!");
                snakeLadderService.setGameOverForPlayer(updatedPlayer.getId());
                if (snakeLadderService.isGameEnded()) {
                    System.out.println("Game over!");
                    return;
                }
            }
        }
    }
}
