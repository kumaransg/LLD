package com.system.design.lld.snakeandladder.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Snake {
    private int x;
    private int y;
    public Snake( int x , int y ) {
        this.x = x;
        this.y = y;
    }
}
