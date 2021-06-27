package HitCounter;

import java.util.List;

public class Record {

    private long epochTime;
    private int count;

    public Record(long epochTime, int count) {
        this.epochTime = epochTime;
        this.count = count;
    }
}
