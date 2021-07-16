package com.system.design.lld.snakeandladder_v2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Snake {
    // Each snake will have its head at some number and its tail at a smaller number.
    private int start;
    private int end;

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
