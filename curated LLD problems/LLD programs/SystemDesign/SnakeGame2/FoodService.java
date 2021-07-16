package SystemDesign.SnakeGame2;

public class FoodService implements FoodInterface {
    @Override
    public Cell generateFood(int ROW, int COL) {
        int r = (int) (Math.random() * ROW);
        int c = (int) (Math.random() * COL);
        return new Cell(r,c);
    }
}
