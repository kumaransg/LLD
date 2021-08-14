package com.system.design.lld.ratelimiter;
// rate limiiter algo
public class TokenBucket {
    private long maxBucketSize;
    private double currentBucketSize;
    private long lastRefillTimeStamp;
    private int refillRate;
    public TokenBucket( long maxBucketSize, int refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        this.currentBucketSize = maxBucketSize;
        lastRefillTimeStamp = System.nanoTime();
    }
    public synchronized boolean allowRequest( int tokens) {
        refill();
        if( tokens > currentBucketSize )
            return false;
        currentBucketSize -= tokens;
        return true;
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTimeStamp) * refillRate / 1e9;
        currentBucketSize = Math.max( maxBucketSize, tokensToAdd+ currentBucketSize);
    }
}
