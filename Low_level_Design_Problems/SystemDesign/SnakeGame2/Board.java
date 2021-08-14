package SystemDesign.SnakeGame2;

public class Board implements BoardInterface {
    final int ROW_COUNT, COL_COUNT;
    Cell[][] board;
    //FoodInterface foodInterface;

    public Board(int row, int col) {
        ROW_COUNT=row;
        COL_COUNT=col;
        this.board = new Cell[ROW_COUNT][COL_COUNT];
        //foodInterface = new FoodService();

        for(int i=0;i<ROW_COUNT;i++){
            for(int j=0;j<COL_COUNT;j++){
                board[i][j]=new Cell(i,j);
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }
    public void generateFood(Cell cell){
        //Cell cell = foodInterface.generateFood(ROW_COUNT,COL_COUNT);
        board[cell.getRow()][cell.getCol()].setCellType(CellType.Food);
    }

}
