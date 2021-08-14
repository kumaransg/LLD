package com.system.design.lld.snakeandladder.model;

import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Player {
    private String name;
    private Cell currentPosition;
    private int number;
    private List<Cell> moves;
    public Player( String name) {
        this.name = name;
        this.currentPosition = new Cell(0,0,CellType.EMPTY,0);
        this.moves = new LinkedList<>();
        this.number =0;
    }
}
