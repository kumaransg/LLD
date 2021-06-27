package HitCounter;

import java.time.Instant;

public class CounterServiceImpl implements CounterService {

    private RedisService redisService;

    public CounterServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void hitRequest(Instant ts) {
        redisService.request(ts);
    }

    @Override
    public long requestCountInLastOneHour(Instant ts) {
        return redisService.getCount(ts);
    }
}
