package snakeLadder.model;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public abstract class GameObjects {
    private Integer start;
    private Integer end;

    public GameObjects(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }
}
