package DSA.lld.ratelimiter;

public interface RateLimiterStrategy {
    boolean allowRequest(String userId);

}
