package com.system.design.lld.snakeandladder_v2.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SnakeAndLadderBoard {
    private int size; // board size
    private List<Snake> snakes; // The board also contains some snakes and ladders.
    private List<Ladder> ladders;
    private Map<String, Integer> playerPieces;

    public SnakeAndLadderBoard(int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPieces = new HashMap<>();
    }
}
