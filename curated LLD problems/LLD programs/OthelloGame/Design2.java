
package OthelloGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Design2 {
    
  public static void main(String[] args) 
  {
    Othello game_inst = new Othello();
    game_inst.startGame();
  }	
  
}

class Othello 
{
    private final int empty = 0;
    private final int white = 1;
    private final int black = 2;
    private int[][] board;
    private int size;
   // private int numOfMoves;
    private int black_count;
    private int white_count;
    private HashMap<String, ArrayList<String>> validMoves;

Othello() 
{
    this.size = 3;
   // this.numOfMoves = 0;
    this.board = new int[this.size][this.size];
    
    for (int i = 0; i < this.size; ++i)
    {
        Arrays.fill(this.board[i], empty);	
    }
    // Init board with 4 pieces placed in the middle of board.
    this.board[1][1] = this.white;  //= this.board[1][2] 
    this.board[2][1] = this.black;   // = this.board[2][2]
    this.black_count = this.white_count = 1;
    this.validMoves = new HashMap();
}

// The whole workflow of Othello game.
public void startGame() 
{
    System.out.println("Starting game...");
    printBoard();
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    boolean noValidMovesForBlack = false;
    boolean noValidMovesForWhite = false;
    int[] coordinate;
    while (this.black_count != 0 && this.white_count != 0) 
    {
        // black goes first.
        noValidMovesForBlack = hasMoreValidMoves(this.black);
        
        if (!noValidMovesForBlack)
        {
            System.out.println("There is no possible alid moves for black player.");
        }
        else
        {
            coordinate = getCoordinate(this.black);
            this.board[coordinate[0]][coordinate[1]] = this.black;
            flip("" + coordinate[0] + coordinate[1]);
            printBoard();
        }
        
        // white goes second.
        noValidMovesForWhite = hasMoreValidMoves(this.white);
        
        if (!noValidMovesForWhite) 
        {
            System.out.println("There is no possible alid moves for black player.");	
        } 
        else 
        {
            coordinate = getCoordinate(this.white);
            this.board[coordinate[0]][coordinate[1]] = this.white;
            flip("" + coordinate[0] + coordinate[1]);
            printBoard();
        }
        
        // Check if there are no valid moves for both of the player.
        if (!noValidMovesForWhite && !noValidMovesForBlack) 
        {
            break;	
        }
    }
    System.out.println("No more valid moves for both players...");
    win();
    System.out.println("Ending game...");
}

private int[] getCoordinate(int color)
{
    if (color == this.black) 
    {
        System.out.println("Black player's move...");
    }
    else 
    {
        System.out.println("White player's move...");
    }
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean valid = false;
    
    int x = -1, y = -1, raw_int;
    
    String raw_string;
    
    while (!valid) 
    {
    try 
    {
        System.out.print("Enter the coordinate you'd place the piece: ");
        raw_string = br.readLine();
        raw_int = Integer.parseInt(raw_string);
        x = raw_int / 10;
        y = raw_int % 10;
        valid = x >= 0 && x < this.size && y >= 0 && y < this.size;
        if (!valid)
        {
            System.out.println("Enter a valid coordinate falls on the board.");
             continue;
        }
        valid = this.validMoves.containsKey(raw_string);
        if (!valid) 
        {
            System.out.println("Enter a valid move.");	
        }
    } 
    catch (Exception e) 
    {
        System.out.println("Enter a valid coordinate.");
    }
    }
    return new int[] {x, y};
}

// Helper function to print the board.
public void printBoard() {
System.out.println("Printing board...");
int i, j;
// Print column indexes.
System.out.print(" ");
for (i = 0; i < this.size; ++i) {
System.out.print("" + i + " ");	
}
System.out.println();
// Print row indexes.
for (i = 0; i < this.size; ++i) {
System.out.print("" + i + " ");
for (j = 0; j < this.size; ++j) {
if (this.board[i][j] == this.empty) {
System.out.print(". ");	
} else if (this.board[i][j] == this.black) {
System.out.print("X ");	
} else {
System.out.print("O ");	
}
}
System.out.println();
}
System.out.println("Done printing board...");
}

// flip the surrounded piece.
private void flip(String key) {
ArrayList<String> value = this.validMoves.get(key);
int raw_int, x, y;
if (value == null) {
System.out.println("Something is wrong here");
return;
}
for (String raw : value) {
raw_int = Integer.parseInt(raw);
x = raw_int / 10;
y = raw_int % 10;
if (this.board[x][y] == this.white) {
this.board[x][y] = this.black;
} else if (this.board[x][y] == this.black) {
this.board[x][y] = this.white;	
}
}
}

// Check if there is any more valid moves and cache all valid moves.
private boolean hasMoreValidMoves(int color) {
// clear cache.
this.validMoves.clear();

int i, j;
for (i = 0; i < this.size; ++i) {
for (j = 0; j < this.size; ++j) {
isValidMove(i, j, color);
}	
}
return !this.validMoves.isEmpty();
}

// Check if placing a piece at (x, y) with certain color is a valid move.
private void isValidMove(int x, int y, int color) {
int opposite = (color == this.black) ? this.white : this.black;
String key = "" + x + y;
ArrayList<String> value = new ArrayList<String>();
// Check upper.
if (x >= 2) {
if (this.board[x - 1][y] == opposite && this.board[x - 2][y] == color) {
value.add("" + (x - 1) + y);
}
}
// Check lower.
if (x <= this.size - 3) {
if (this.board[x + 1][y] == opposite && this.board[x + 2][y] == color) {
value.add("" + (x + 1) + y);
}
}
// Check left.
if (y >= 2) {
if (this.board[x][y - 1] == opposite && this.board[x][y - 2] == color) {
value.add("" + x + (y - 1));
}
}
// Check right.
if (y <= this.size - 3) {
if (this.board[x][y + 1] == opposite && this.board[x][y + 2] == color) {
value.add("" + x + (y + 1));
}
}
if (!value.isEmpty()) {
this.validMoves.put(key, value);
}
}

// Count the pieces with different colors and anounce the winner.
private void win() {
if (this.black_count > this.white_count) {
System.out.println("Black player won the game!");
} else if (this.black_count < this.white_count) {
System.out.println("White player won the game!");	
} else {
System.out.println("It's a draw game!");
}
}
}
