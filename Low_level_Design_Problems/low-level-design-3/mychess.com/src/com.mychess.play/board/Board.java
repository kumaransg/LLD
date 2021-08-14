package board;

import cell.Cell;
import enums.PieceColor;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Board {
    private Cell[][] board = null;
    Integer BOARD_SIZE = 8;

    public Board() {
        board = new Cell[BOARD_SIZE][BOARD_SIZE];
        resetBoard();
    }

    private void resetBoard(){
        Piece whitePiece = null;
        Piece blackPiece = null;
        for(Integer i = 0; i < BOARD_SIZE; i++){
            whitePiece = new Pawn(PieceColor.WHITE);
            blackPiece = new Pawn(PieceColor.BLACK);

            board[1][i] = new Cell(1, i, whitePiece);
            board[BOARD_SIZE-2][i] = new Cell(BOARD_SIZE-2, i, blackPiece);
        }
        Integer whiteCounter = 0;
        Integer blackCounter = 0;
        final Integer left = 0;
        final Integer right = BOARD_SIZE-1;

        board[left][whiteCounter] = new Cell(left, whiteCounter, new Rook(PieceColor.WHITE));
        board[left][right-whiteCounter] = new Cell(left,right-whiteCounter, new Rook(PieceColor.WHITE));

        board[right][blackCounter] = new Cell(right, blackCounter, new Rook(PieceColor.BLACK));
        board[right][right-blackCounter] = new Cell(right, right-blackCounter, new Rook(PieceColor.BLACK));

        whiteCounter++;
        board[left][whiteCounter] = new Cell(left, whiteCounter, new Knight(PieceColor.WHITE));
        board[left][right-whiteCounter] = new Cell(left, right- whiteCounter, new Knight(PieceColor.WHITE));

        blackCounter++;
        board[right][blackCounter] = new Cell(right, blackCounter,new Knight(PieceColor.BLACK));
        board[right][right-blackCounter] = new Cell(right, right-blackCounter,new Knight(PieceColor.BLACK));

        whiteCounter++;
        board[left][whiteCounter] = new Cell(left, whiteCounter, new Bishop(PieceColor.WHITE));
        board[left][right-whiteCounter] = new Cell(left, right-whiteCounter,new Bishop(PieceColor.WHITE));

        blackCounter++;
        board[right][blackCounter] = new Cell(right, blackCounter, new Bishop(PieceColor.BLACK));
        board[right][right-blackCounter] = new Cell(right, right-blackCounter, new Bishop(PieceColor.BLACK));

        whiteCounter++;
        board[left][whiteCounter] = new Cell(left, whiteCounter, new King(PieceColor.WHITE));
        board[left][right-whiteCounter] = new Cell(left, right-whiteCounter, new Queen(PieceColor.WHITE));

        blackCounter++;
        board[right][blackCounter] = new Cell(right, blackCounter, new King(PieceColor.BLACK));
        board[right][right-blackCounter] = new Cell(right, right-blackCounter, new Queen(PieceColor.BLACK));
        System.out.println("Board has been set.");
    }
}