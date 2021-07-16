package com.system.design.systemdesign.chess;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
    private Cell[][] cells;
    private Piece[][] pieces;
    public Cell getBox(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }

        return cells[x][y];
    }

    public void resetBoard()
    {
        /*Temp temp = new Temp(1,2);
        Temp temp2 = new Temp(1);
        Temp temp3 = new Temp(2);
         // initialize white pieces
        cells[0][0] = new Cell(0, 0, new Rook(true));
        cells[0][1] = new Cell(0, 1, new Knight(true));
        cells[0][2] = new Cell(0, 2, new Bishop(true));
        //...
        cells[1][0] = new Cell(1, 0, new Pawn(true));
        cells[1][1] = new Cell(1, 1, new Pawn(true));
        //...

        // initialize black pieces
        cells[7][0] = new Cell(7, 0, new Rook(false));
        cells[7][1] = new Cell(7, 1, new Knight(false));
        cells[7][2] = new Cell(7, 2, new Bishop(false));
        //...
        cells[6][0] = new Cell(6, 0, new Pawn(false));
        cells[6][1] = new Cell(6, 1, new Pawn(false));
        //...*/

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
//                cells[i][j] = new Cell(i, j, null);
            }
        }
    }
}
