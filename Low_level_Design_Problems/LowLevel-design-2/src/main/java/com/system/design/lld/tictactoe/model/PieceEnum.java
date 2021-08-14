package com.system.design.lld.tictactoe.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum PieceEnum {
    CIRCLE ("0"),
    CROSS ("X"),
    EMPTY ("-");
    private String symbol;
    PieceEnum(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }
}
