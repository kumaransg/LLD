package SystemDesign.TicTacToeNxN;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {

    char[][] board;
    int boardSize;
    Queue<Player> nextTurn;
    Scanner input;

    public GameBoard(int boardSize, Player[] players) {
        this.boardSize=boardSize;
        this.board= new char[(2*boardSize)-1] [(2*boardSize)-1];
        initializeBoard(board);
        nextTurn = new LinkedList<>();
        nextTurn.offer(players[0]);
        nextTurn.offer(players[1]);
        input = new Scanner(System.in);
    }

    private void initializeBoard(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i%2==0 && j%2!=0) board[i][j] = '|';
                if(i%2!=0 && j%2==0) board[i][j] = '-';
                if(i%2!=0 && j%2 !=0) board[i][j] = '+';
            }
        }
        /*
        *  | |
          -+-+-
           | |
          -+-+-
           | |
        * */
    }
    private void printBoard(){
        for(char[] row : board){
            for(char col:row){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public void startGame(){
        int count =0;
        while(true){
            count++;
            if(count== ((boardSize*boardSize)+1)) {
                System.out.println("Match draw");
                break;
            }
            Player p = nextTurn.poll();
            int position = getUserInput(p);
            int row = 2*((position%boardSize==0)?(position/boardSize)-1:position/boardSize);
            int col = 2*((position%boardSize==0?boardSize:position%boardSize)-1);
            board[row][col]= p.getPlayerSymbol();
            printBoard();
            System.out.println("Board after the move");
            if(count>=boardSize && checkEndGame(p,row,col)) break;
            nextTurn.offer(p);
        }
    }

    private int getUserInput(Player p){
        printBoard();
        System.out.println(p.getPlayerName() + " Please Enter a number between 1 - "+ (boardSize*boardSize));
        int val = input.nextInt();
        while (!validateInput(val)){
            printBoard();
            System.out.println("Wrong Position - " + p.getPlayerName() + " Please Enter a number between 1 - "+ (boardSize*boardSize));
            val = input.nextInt();
        }
        return val;
    }

    private boolean validateInput(int val){

        if (val<1 || val>(boardSize*boardSize)) return false;

        int row = 2*((val%boardSize==0)?(val/boardSize)-1:val/boardSize);
        int col = 2*((val%boardSize==0?boardSize:val%boardSize)-1);
        if((int)board[row][col] != 0) return false;

        return true;
    }

    private boolean checkEndGame(Player p, int row, int col){
        String winString = "";
        for(int i=0;i<boardSize;i++){
            winString += String.valueOf(p.getPlayerSymbol());
        }

        String rowString="";
        String colString="";
        String diagonalString="";
        String reverseDiagonalString="";
        for(int i=0;i<board.length;i=i+2){
            rowString += board[row][i];
            colString += board[i][col];
            if(row==col){
                diagonalString += board[i][i];
            }
            if((row+col)== board.length-1){
                reverseDiagonalString += board[board.length-1-i][i];
            }
        }

        if(winString.equals(rowString) || winString.equals(colString) || winString.equals(diagonalString) || winString.equals(reverseDiagonalString)){
            System.out.println(p.getPlayerName()+" has won the Game");
            return true;
        }

        return false;
    }


}
