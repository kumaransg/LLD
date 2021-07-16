package com.system.design.lld.snakegame.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cell {
    private int x;
    private int y;
    private CellType cellType;
    public Cell( int x, int y, CellType cellType ) {
        this.x = x;
        this.y = y;
        cellType =cellType;
    }
}
