package com.system.design.lld.snakeandladder_v2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ladder {
    // Each ladder will have its start position at some number and end position at a larger number.
    private int start;
    private int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
