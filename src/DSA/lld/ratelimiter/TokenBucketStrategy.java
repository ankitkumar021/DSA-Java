package DSA.lld.ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketStrategy implements RateLimiterStrategy {

    private final TokenBucketConfig bconfig ;

    private final Map<String,Bucket>  buckets = new HashMap<>();

    public TokenBucketStrategy(TokenBucketConfig bconfig){
        this.bconfig = bconfig;
    }
    @Override
    public synchronized boolean allowRequest(String userId) {
        //get user bucket
        Bucket bucket = buckets.get(userId);

        //first request from this the user
        if(bucket == null){
            bucket = new Bucket(bconfig.getCapacity(),System.currentTimeMillis());
        }

        //if not null put it in the map
        buckets.put(userId,bucket);

        //refill
        refill(bucket);


        //consume 1 token
        if(bucket.tokens > 0){
            bucket.tokens--;
            return true;
        }
        //no token available
        return false;
    }
    public void refill(Bucket bucket){
        //Refill logic
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - bucket.lastRefillTime;

        //convert milli to second
        long elapsedSeconds = elapsedTime/1000;

        if(elapsedSeconds<=0){
            return;
        }

        if(elapsedSeconds > 0) {
            //refill = 2 token/sec
            //elapsedSeconds = 3
            //tokensToAdd  = 2*3 =6
            int tokensToAdd = (int) (elapsedSeconds * bconfig.getRefillRate());

            //capacity= 5
            //currentbuckettoken = 2
            //tokensToAdd = 6
            //min(5,8)//never allow bucket to exceed capacity
            bucket.tokens = Math.min(bconfig.getCapacity(), bucket.tokens + tokensToAdd);

            //move refill time forward
            bucket.lastRefillTime +=elapsedTime*1000;
        }

    }

    //bucket for each user
    static class Bucket{
        int tokens;
        long lastRefillTime;

        Bucket(int tokens,long lastRefillTime){
            this.tokens=tokens;
            this.lastRefillTime=lastRefillTime;
        }
    }
}
