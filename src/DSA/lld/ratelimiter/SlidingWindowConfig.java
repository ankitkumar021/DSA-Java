package DSA.lld.ratelimiter;

public class SlidingWindowConfig {
    int maxRequests;
    long windowSizeMillis;

    public SlidingWindowConfig(int maxRequests,long windowSizeMillis){
        this.maxRequests=maxRequests;
        this.windowSizeMillis=windowSizeMillis;
    }

    public int getMaxRequests(){
        return maxRequests;
    }
    public long getWindowSizeMillis(){
        return windowSizeMillis;
    }
}
