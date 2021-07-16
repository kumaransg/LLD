package com.system.design.lld.chess.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {
    private Piece piece;
    private int x;
    private int y;
}
