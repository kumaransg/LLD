/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TicTacToe;

/**
 *
 * @author admin
 */
public class Board {
  //  private static final int n=3;
    int n;
    int m;
    private int board[][];

    public Board(int n,int m) {
        this.n=n;
        this.m=m;
        board=new int[n][m];
        clearBoard(n,m);
    }

    public void clearBoard(int n,int m)
    {
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<m;col++)
            {
                board[row][col]=0;
            }
        }
    }
    
    public void showBoard()
    {
        System.out.println();
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<m;col++)
            {
                if(board[row][col]==1)
                    System.out.print("X ");
                if(board[row][col]==-1)
                    System.out.print("O ");
                if(board[row][col]==0)
                    System.out.print(" ");
                if(col==0 || col==1)
                    System.out.print(" | ");
                
                
            }
            System.out.println();
        }
    }
    
    public int checkRows()
    {
        int c;
        for(int i=0;i<n;i++)
        {
            c=0;
            for(int j=0;j<m;j++)
            {
                c=c+board[i][j];
                if(c==-3)
                   return -1;
                else if(c==3)
                   return 1;
                
            }
        }
        return 0;
    }
    
    public int checkColumn()
    {
        int c;
        for(int i=0;i<n;i++)
        {
            c=0;
            for(int j=0;j<m;j++)
            {
                c=c+board[j][i];
                if(c==-3)
                   return -1;
                else if(c==3)
                   return 1;
            }
        }
        return 0;
    }
    
    public int checkDiagonal()
    {
        int c=0,t=0;
        int x=n-1;
        for(int i=0;i<n;i++)
        {
            c=c+board[i][i];
             if(c==-3)
                return -1;
             else if(c==3)
                return 1;
        }
        
        for (int j=0;j<n;j++)
        {
            
            t=t+board[j][x];
            x--;
            if(t==-3)
                return -1;
            else if(t==3)
                return 1;
        }
        return 0;
    }
    
    public boolean fullBoard()
    {
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<m;col++)
            {
                if(board[row][col]==0)
                    return false;
            }
        }
        return true;
    }
    
    public int getPosition(int attempt[])
    {
       int row=attempt[0];
       int col=attempt[1];
       
       if(board[row][col]==-1)
           return -1;
       if(board[row][col]==1)
           return 1;
       
       return 0;
       
    }
    
    public boolean isEmpty(int attempt[])
    {
        if(board[attempt[0]][attempt[1]]==0)
            return true;
        else 
            return false;
    }
    
    public void setPosition(int attempt[],int player)
    {
        if(player==1)// human chance
            board[attempt[0]][attempt[1]]=-1;
        else// computer chance
            board[attempt[0]][attempt[1]]=1;
        
        
    }


}
