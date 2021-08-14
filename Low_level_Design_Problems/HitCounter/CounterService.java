package HitCounter;

import java.time.Instant;

public interface CounterService {

    public void hitRequest(Instant ts);

    public long requestCountInLastOneHour(Instant ts);
}
