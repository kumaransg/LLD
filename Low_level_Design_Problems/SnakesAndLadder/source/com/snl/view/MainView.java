package com.snl.view;

import java.util.*;
import com.snl.services.Game;

public class MainView {
    
    public static void main(String[] args) {
        try {
            Game g = new Game();
            g.initialize();

            Scanner scanner = new Scanner(System.in);

            // set snakes on Number Boxes
            int noOfSnakes = scanner.nextInt();
            for (int i = 0; i < noOfSnakes; i++) {
                g.addSnakeEntry(scanner.nextInt(), scanner.nextInt());
            }

            // set ladders on Number Boxes
            int noOfLadders = scanner.nextInt();
            for (int i = 0; i < noOfLadders; i++) {
                g.addLadderEntry(scanner.nextInt(), scanner.nextInt());
            }

            // set players into the game
            int noOfPlayers = scanner.nextInt();
            for (int i = 0; i < noOfPlayers; i++) {
                g.addPlayerEntry(scanner.next());
            }

            g.play();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}