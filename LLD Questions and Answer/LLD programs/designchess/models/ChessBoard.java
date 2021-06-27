/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designchess.models;

/**
 * @author paras.chawla
 * @version $Id: ChessBoard.java, v 0.1 2020-09-30 13:56 paras.chawla Exp $$
 */

import designchess.enums.Color;
import designchess.models.pieceimpl.Bishop;
import designchess.models.pieceimpl.King;
import designchess.models.pieceimpl.Knight;
import designchess.models.pieceimpl.Pawn;
import designchess.models.pieceimpl.Queen;
import designchess.models.pieceimpl.Rook;

/**
 * A chessBoard having cells and boardSize(It can be generic)
 */
public class ChessBoard {

    Cell[][] cells;
    int      boardSize;

    // Initialize Chess Board
    public ChessBoard(int boardSize) {
        this.cells = new Cell[boardSize][boardSize];
        this.boardSize = boardSize;
        this.resetBoard();
    }

    private void resetBoard() {

        // initialize white pieces row 1
        cells[0][0] = new Cell(0, 0, new Rook(Color.WHITE));
        cells[0][1] = new Cell(0, 1, new Knight(Color.WHITE));
        cells[0][2] = new Cell(0, 2, new Bishop(Color.WHITE));
        cells[0][3] = new Cell(0, 3, new Queen(Color.WHITE));
        cells[0][4] = new Cell(0, 4, new King(Color.WHITE));
        cells[0][5] = new Cell(0, 5, new Bishop(Color.WHITE));
        cells[0][6] = new Cell(0, 6, new Knight(Color.WHITE));
        cells[0][7] = new Cell(0, 7, new Rook(Color.WHITE));

        // initialize white pieces row 2 - PAWN
        for (int i = 0; i < 8; i++) {
            cells[1][i] = new Cell(1, i, new Pawn(Color.WHITE));
        }

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(i, j, null);
            }
        }

        // initialize white pieces row 6 - PAWN
        for (int i = 0; i < 8; i++) {
            cells[6][i] = new Cell(6, i, new Pawn(Color.BLACK));
        }

        // initialize black pieces
        cells[7][0] = new Cell(7, 0, new Rook(Color.BLACK));
        cells[7][1] = new Cell(7, 1, new Knight(Color.BLACK));
        cells[7][2] = new Cell(7, 2, new Bishop(Color.BLACK));
        cells[7][3] = new Cell(7, 3, new Queen(Color.BLACK));
        cells[7][4] = new Cell(7, 4, new King(Color.BLACK));
        cells[7][5] = new Cell(7, 5, new Bishop(Color.BLACK));
        cells[7][6] = new Cell(7, 6, new Knight(Color.BLACK));
        cells[7][7] = new Cell(7, 7, new Rook(Color.BLACK));

    }

    // 1. Get location of cell based on x,y cordinates
    public Cell getCellAtLocation(int x, int y) {

        // boundary condition where there is no cell
        if (x >= boardSize || x < 0 || y >= boardSize || y < 0) {
            return null;
        }

        return cells[x][y];
    }

    // 2. Get cell left location
    public Cell getLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX() - 1, cell.getY());
    }

    // 3. Get cell right location
    public Cell getRightCell(Cell cell) {
        return getCellAtLocation(cell.getX() + 1, cell.getY());
    }

    // 4. Get cell up location
    public Cell getUpCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() + 1);
    }

    // 5. Get cell down location
    public Cell getDownCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() - 1);
    }

}