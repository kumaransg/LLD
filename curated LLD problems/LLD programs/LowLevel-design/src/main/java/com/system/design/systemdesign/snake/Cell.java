package com.system.design.systemdesign.snake;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Cell {
    private final int x;
    private final int y;
    private CellType cellType;
    public Cell( int x , int y , CellType cellType){
        this.x = x;
        this.y = y;
        this.cellType = cellType;
    }
}
