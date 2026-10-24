package LLD.ratelimiting.ratelimiter;

import LLD.ratelimiting.RateLimiter;
import LLD.ratelimiting.config.TokenBucketConfig;

import java.util.concurrent.ConcurrentHashMap;

/*public class TokenBucketRateLimiter implements RateLimiter {

    private final TokenBucketConfig config;
    private final ConcurrentHashMap<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(TokenBucketConfig config) {
        this.config = config;
    }

    @Override
    public boolean allowRequest(String key) {

        TokenBucket bucket = buckets.computeIfAbsent(
                key,
                k->new TokenBucket(
                        config.getCapacity(),
                        config.getRefillTokens(),
                        config.getRefillIntervalMillis()
                )
        );

        return bucket.tryConsume();

    }*/


