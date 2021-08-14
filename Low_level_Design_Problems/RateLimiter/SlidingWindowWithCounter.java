package RateLimiter;

public class SlidingWindowWithCounter {
    public static void main(String[] args) {
        SlidingWindowWithCounter ob = new SlidingWindowWithCounter();
        int rateLimitPerMinute = 5; // hits allowed in 60 secs
        RedisService redisService = new RedisService(5);
        new SimpleThread("User 1", redisService).start();
        new SimpleThread("User 1", redisService).start();
    }
}


