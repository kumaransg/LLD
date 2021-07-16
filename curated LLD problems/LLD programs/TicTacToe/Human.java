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
public class Human extends Player {
    public Scanner input=new Scanner(System.in);
    public Human(int player) {

        super(player);

    }



//    @Override
//    public void play(Board board) {
//        chance(board);
//        board.setPosition(attempt, player);
//        //throw new UnsupportedOperationException("Not supported yet.");
//    }

    @Override
    public void chance(Board board) {

        boolean flag=true;
        do
        {

        do
        {
            System.out.println("row");
            attempt[0]=input.nextInt();
        }while(!validate(attempt[0]));

        do
        {
            System.out.println("column ");
            attempt[1]=input.nextInt();
        }while(!validate(attempt[0]));
        attempt[0]--;
        attempt[1]--;
        flag=board.isEmpty(attempt);
        if(flag)
            board.setPosition(attempt, player);// TODO find player
        else
            System.out.println("please enter new position");


        }while(!flag);

       // throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean validate(int x)
    {
        if(x>3 || x<1)
        {
            System.out.println("invalid input ");
        return  false;
        }
        return true;
    }


}
