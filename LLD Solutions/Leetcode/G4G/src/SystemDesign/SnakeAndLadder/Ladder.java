package SystemDesign.SnakeAndLadder;

public class Ladder {
    // Each ladder will have its start position at some number and end position at a larger number.
    private int start;
    private int end;

    public Ladder(int start, int end) {
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
