package snakeLadder.model;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class Ladder extends GameObjects implements Comparable<Ladder> {
    public Ladder(Integer start, Integer end) {
        super(start, end);
    }


    @Override
    public int compareTo(Ladder o) {
        return this.getStart() - o.getStart();
    }
}
