package SystemDesign.SnakeAndLadder;

public class Snake {
    // Each snake will have its head at some number and its tail at a smaller number.
    private int start;
    private int end;

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}