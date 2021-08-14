package OthelloGame;//package OthelloGame;
//
//
//enum Direction
//{
//    left,right,up,down;
//}
//
//enum Color
//{
//    Black,White;
//}
//
//class Piece
//{
//    private  Color color;
//    public Piece(Color c){
//        color=c;
//    }
//    
//    public void flip()
//    {
//        if(color==Color.Black)
//            color=Color.White;
//        else
//            color=Color.Black;
//    }
//    
//     public Color getColor(){ return color;}
//}
//
//class Player
//{
//    private Color color;
//    
//    public Player(Color c)
//    {
//        color=c;
//    }
//    
//    public int getscore(){
//    
//        //
//    }
//    
//    public boolean playPiece(int r,int c)
//    {
//        return Game.getInstance().getBorad().placeColor(r,c,color);
//    }
//
//    public Color getColor(){ return color;}
//}
//
//
//
// class Board
//{
//    private int BlackCount=0;
//    private int WhiteCount=0;
//    private Piece[][] board;
//    
//    public Board(int rows,int columns)
//    {
//        board=new Piece[rows][columns];
//    }
//    
//    public void initialize(){
//        // initilaze center black and white pieces
//    }
//    
//    // Attempt to place a piece of color at (row,column)
//    // Return true if successful
//    public boolean placecolor(int row,int column,Color color)
//    {
//        board[row][column]=new Piece(color);    //color.White;
//        return true;
//    }
//    
//}
//
//class Game
//{
//    private 
//}
//
//public class Design1 {
//    
//}
