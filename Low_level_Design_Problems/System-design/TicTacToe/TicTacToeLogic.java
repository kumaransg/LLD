package Game;

public class TicTacToeLogic {
	
	private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    
    /** Initialize your data structure here. */
    public TicTacToeLogic(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }
        if (row + col == rows.length + 1) {
            antiDiagonal += toAdd;
        }
        int size = rows.length;
        if (Math.abs(rows[row]) == size || 
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size ||
            Math.abs(antiDiagonal) == size) {
                return player;
            }
        return 0;
    }
}
