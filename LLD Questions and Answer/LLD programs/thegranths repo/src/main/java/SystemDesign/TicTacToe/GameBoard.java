package SystemDesign.TicTacToe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {
    char[][] board ;
    Scanner input;
    Queue<Player> nextTurn;
    boolean gameOver;
    int count=0;
    public GameBoard(Player[] players) {
        board = new char[][]{
        {' ','|',' ','|',' '},
        {'-','|','-','|','-'},
        {' ','|',' ','|',' '},
        {'-','|','-','|','-'},
        {' ','|',' ','|',' '}
        };
        input = new Scanner(System.in);
        nextTurn = new LinkedList<>();
        nextTurn.offer(players[0]);
        nextTurn.offer(players[1]);
        gameOver = false;
    }

    public void start(){
        printBoard(board);
        while(!gameOver) {
            count++;
            if (count==10){
                System.out.println( "Match draw");
                break;
            }
            Player p = nextTurn.poll();
            int val = nextMove();
            board[val/10][val%10] = p.getPlayerSymbol();
            if(checkStatus(p)) {
                gameOver=true;
                System.out.println(p.getPlayerName() + " has won the game");
            }
            printBoard(board);
            nextTurn.offer(p);
        }

    }

    private void printBoard (char[][] board){
        for(char[] row : board){
            for(char col: row){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private boolean checkStatus(Player p){
        if(board[0][0]+board[0][2]+board[0][4] == p.getPlayerSymbol()+p.getPlayerSymbol()+p.getPlayerSymbol()) return true;
        if(board[2][0]+board[2][2]+board[2][4] == p.getPlayerSymbol()+p.getPlayerSymbol()+p.getPlayerSymbol()) return true;
        if(board[4][0]+board[4][2]+board[4][4] == p.getPlayerSymbol()+p.getPlayerSymbol()+p.getPlayerSymbol()) return true;
        if(board[0][0]+board[2][0]+board[4][0] == p.getPlayerSymbol()+p.getPlayerSymbol()+p.getPlayerSymbol()) return true;
        if(board[0][2]+board[2][2]+board[4][2] == p.getPlayerSymbol()+p.getPlayerSymbol()+p.getPlayerSymbol()) return true;
        if(board[0][4]+board[2][4]+board[4][4] == p.getPlayerSymbol()+p.getPlayerSymbol()+p.getPlayerSymbol()) return true;
        if(board[0][0]+board[2][2]+board[4][4] == p.getPlayerSymbol()+p.getPlayerSymbol()+p.getPlayerSymbol()) return true;
        if(board[0][4]+board[2][2]+board[4][0] == p.getPlayerSymbol()+p.getPlayerSymbol()+p.getPlayerSymbol()) return true;

        return false;
    }


    private int nextMove(){
        System.out.println("Enter a number from 1-9");
        int position = input.nextInt();
        while(!validPosition(position)){
            System.out.println("Wrong Position, try different position.Enter a number from 1-9");
            position = input.nextInt();
        }
        return getCoordinates(position);
    }

    private boolean validPosition(int pos){
        if(pos<1 || pos>9) return false;
        int val = getCoordinates(pos);
        if(board[val/10][val%10]=='X' || board[val/10][val%10]=='O') return false;
        return true;
    }

    private int getCoordinates(int pos){
        switch(pos){
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 20;
            case 5:
                return 22;
            case 6:
                return 24;
            case 7:
                return 40;
            case 8:
                return 42;
            case 9:
                return 44;
        }
        return -1;
    }
}




/*
              1  2    3
1|2|1   ->  0,0| 0,2| 0,4
-+-+-        4    5   6
1|2|2      2,0|  2,2| 2,4
-+-+-       7     8    9
1|1|1      4,0 | 4,2 | 4,4


* */
