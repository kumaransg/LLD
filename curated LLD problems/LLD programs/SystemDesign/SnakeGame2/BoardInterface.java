package SystemDesign.SnakeGame2;

public interface BoardInterface {

    void generateFood(Cell cell);
    public Cell[][] getBoard();
    public void setBoard(Cell[][] board);
}
