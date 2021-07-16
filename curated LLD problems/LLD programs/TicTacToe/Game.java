/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TicTacToe;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    public int turn =1;
    int r,c;
    public Scanner input1=new Scanner(System.in);


    public Game() {


        System.out.println("Please enter the row of the board ");
        this.r=input1.nextInt();
        System.out.println("PLease enter the column of the board ");
        this.c=input1.nextInt();

        if(validate(r,c))
        {
        board=new Board(r,c);
        startPlayers();
        while(play());
        System.out.println("Game is over !!!!!");

        }
        else
        {
            System.out.println("exiting,Please try again");
        }

    }

    public boolean validate(int r,int c)
    {
        if(r<0 || c<0)
        {
            System.out.println("enter valid rows and column");
            return false;
        }
        return true;
    }

    public void startPlayers()
    {
        //int opt=0;
        System.out.println("enter player 1");


        if(chooseOption()==1)
        {
            this.player1=new Human(1);
        }
        else
        {
            this.player1=new Computer(1);
        }
        System.out.println("----------------");
        System.out.println("enter player 2 ");

        if(chooseOption()==1)
        {
            this.player2=new Human(2);
        }
        else
        {
            this.player2=new Computer(2);
        }

    }

    public int chooseOption()
    {
        int opt=0;
        do
        {
        System.out.println("1: Human ");
        System.out.println("2: Computer ");
        opt=input1.nextInt();
        if(opt!=1 && opt!=2)
                System.out.println("invalid input for player 1,Try again!");
        }while(opt!=1 && opt!=2);

        return opt;
    }

    public int won()
    {
        if(board.checkRows()==-1 || board.checkColumn()==-1 || board.checkDiagonal()==-1 )
        {
            //System.out.println("Inside -1 ");
            return -1;
        }
       
        else if(board.checkColumn()==1 || board.checkRows()==1 || board.checkDiagonal()==1)
        {
           // System.out.println("inside +1 ");
            return 1;
        }
       
        return 0;
    }

    public boolean play()
    {
        //board.showBoard();
        if(won()==0)
        {
            if(whoseTurn()==1)
                player1.play(board);
            else
                player2.play(board);
            turn++;
            int pappu = won();

            board.showBoard();
           // System.out.println("pappu " +pappu);
            if(pappu == -1)
            {
                System.out.println("player 1 won");
                return false;
            }
            else if(pappu == 1){
              System.out.println("player 2 won");
               return false;
            }

            if(board.fullBoard())
            {
                //board.showBoard();
                System.out.println("Game is draw");

                return false;
            }

            return true;

        }
//        else
//        {
//            if(won()==-1)
//            {
//                System.out.println("Player1 has won");
//
//            }
//            else
//            {
//                System.out.println("Player2 has won ");
//
//            }
//            return false;
//        }
      return false;
    }

    public int whoseTurn()
    {
        if(turn%2==1)
        {
            System.out.println("player 1 turn");
            return player1.player;
        }
        else
        {
            System.out.println("player 2 turn");
           return player2.player;
        }
            
    }



}
