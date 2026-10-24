package LLD.ratelimiting.config;

public class TokenBucketConfig {
    private final int capacity;
    private final int refillTokens;
    private final long refillIntervalMillis;

    public TokenBucketConfig(int capacity, int refillTokens, long refillIntervalMillis) {
        this.capacity = capacity;
        this.refillTokens = refillTokens;
        this.refillIntervalMillis = refillIntervalMillis;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRefillTokens() {
        return refillTokens;
    }

    public long getRefillIntervalMillis() {
        return refillIntervalMillis;
    }
}

//Bucket can hold 5 token and receives 1 token every second

//capacity = 5
//refill token = 1
//refillInterval = 1000ms(1sec)
