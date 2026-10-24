package LLD.ratelimiting;

public interface RateLimiter {
     boolean allowRequest(String key);
}
//key could represent

//user:123
//ip:10:20:30:40
//api:/payment
//user:123/payment

//rate limiter doesn't need to know what the key represents