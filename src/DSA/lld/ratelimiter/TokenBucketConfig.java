package DSA.lld.ratelimiter;

public class TokenBucketConfig {

    //maximum token a bucket can hold
    private final int capacity;

    //token added per second
    private final int refillRate;

    public TokenBucketConfig(int capacity,int refillRate){
        this.capacity= capacity;
        this.refillRate=refillRate;
    }

    public int getCapacity(){
        return capacity;
    }
    public int getRefillRate(){
        return refillRate;
    }


}
