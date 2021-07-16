/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TicTacToe;

/**
 *
 * @author admin
 */
public abstract class Player {
    protected int attempt[]=new int[2];
    protected int player;

    public Player(int player) {
        this.player = player;
    }

    public void play(Board board)
    {
        chance(board);
        board.setPosition(attempt, player);
    }
    public abstract void chance(Board board);

//    public boolean checkChance(int attempt[],Board board)
//    {
//        if(board.getPosition(attempt)==0)
//            return true;
//        else
//            return false;
//    }


}
