package snakeLadder.model;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class Snake extends GameObjects implements Comparable<Snake> {

    public Snake(Integer start, Integer end) {
        super(start, end);
    }


    @Override
    public int compareTo(Snake o) {
        return o.getEnd() - this.getEnd();
    }
}
