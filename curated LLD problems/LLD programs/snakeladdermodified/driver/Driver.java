package io.abhishek.machinecoding.snakeladdermodified.driver;

import io.abhishek.machinecoding.snakeladdermodified.model.Ladder;
import io.abhishek.machinecoding.snakeladdermodified.model.Player;
import io.abhishek.machinecoding.snakeladdermodified.model.Snake;
import io.abhishek.machinecoding.snakeladdermodified.service.SnakeAndLadderService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.print("Enter the board size :- ");
    int boardSize = sc.nextInt();

    System.out.println("Enter the snake count :- ");
    int cntOfSnakes = sc.nextInt();
    List<Snake> snakes = new ArrayList<>();
    for(int i = 0;i < cntOfSnakes;i++) {
      snakes.add(new Snake(sc.nextInt(), sc.nextInt()));
    }
    System.out.println("Enter the Ladder count :- ");
    int cntOfLadders = sc.nextInt();
    List<Ladder> ladders = new ArrayList<>();
    for(int i = 0;i < cntOfLadders;i++) {
      ladders.add(new Ladder(sc.nextInt(), sc.nextInt()));
    }
    System.out.println("Enter the no. of Players :- ");
    int noOfPlayers = sc.nextInt();
    List<Player> players = new ArrayList<>();
    for(int i = 0;i < noOfPlayers;i++) {
      players.add(new Player(sc.next()));
    }

    SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService(boardSize);
    snakeAndLadderService.setSnakesOnBoard(snakes);
    snakeAndLadderService.setLaddersOnBoard(ladders);
    snakeAndLadderService.setPlayers(players);
    snakeAndLadderService.startTheGame();


  }
}
