package com.system.design.lld.tictactoe.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Move {
    private int x;
    private int y;
}
