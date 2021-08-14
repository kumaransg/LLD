package chess.model;

import chess.constants.PieceType;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public class Board {
    private Box[][] boxes;
    private final Integer boardSize;

    public Board() {
        this.boardSize = 8;
        this.resetBoard();
    }

    private void resetBoard() {
        this.boxes = new Box[boardSize][boardSize];
        boxes[0][0] = new Box(0, 0, new Rook(PieceType.WHITE));
        boxes[0][1] = new Box(0, 1, new Knight(PieceType.WHITE));
        boxes[0][2] = new Box(0, 2, new Bishop(PieceType.WHITE));
        boxes[0][3] = new Box(0, 3, new Queen(PieceType.WHITE));
        boxes[0][4] = new Box(0, 4, new King(PieceType.WHITE));
        boxes[0][5] = new Box(0, 5, new Bishop(PieceType.WHITE));
        boxes[0][6] = new Box(0, 6, new Knight(PieceType.WHITE));
        boxes[0][7] = new Box(0, 7, new Rook(PieceType.WHITE));

        for (int i = 0; i < this.boardSize; i++) {
            boxes[1][i] = new Box(1, i, new Pawn(PieceType.WHITE));
        }


        boxes[7][0] = new Box(7, 0, new Rook(PieceType.BLACK));
        boxes[7][1] = new Box(7, 1, new Knight(PieceType.BLACK));
        boxes[7][2] = new Box(7, 2, new Bishop(PieceType.BLACK));
        boxes[7][3] = new Box(7, 3, new Queen(PieceType.BLACK));
        boxes[7][4] = new Box(7, 4, new King(PieceType.BLACK));
        boxes[7][5] = new Box(7, 5, new Bishop(PieceType.BLACK));
        boxes[7][6] = new Box(7, 6, new Knight(PieceType.BLACK));
        boxes[7][7] = new Box(7, 7, new Rook(PieceType.BLACK));

        for (int i = 0; i < this.boardSize; i++) {
            boxes[6][i] = new Box(6, i, new Pawn(PieceType.BLACK));
        }
    }

    private void addPieceToBox(Box box, Integer x, Integer y) {
        boxes[x][y] = box;
    }

    private void removePieceFromBox(Integer x, Integer y) {
        boxes[x][y] = null;
    }

    public Box getBox(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }

        return boxes[x][y];
    }
}
