package com.system.design.lld.tictactoe.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private String name;
    private PieceEnum pieceEnum;
    private List<Move> moveList;

    public Player(String a, PieceEnum circle) {
        this.name = a;
        pieceEnum = circle;
        moveList = new ArrayList<>();
    }
}
