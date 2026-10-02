package DSA.systemdesign.ratelimiting;
//Token Bucket: Requests consume tokens, which regenerate at a fixed rate.
//It allows short bursts up to the bucket capacity while preventing continuous overload.

import java.time.Instant;

public class SlidingWindowCounter {
    private final long windowSizeInSecond; // Size of the sliding window in seconds
    private final long maxRequestPerWindow;// Maximum number.txt of requests allowed in the window
    private long currentWindowStart;// Start time of the current window
    private long previousWindowCount;// Number of requests in the previous window
    private long currentWindowCount;// Number of requests in the current window

    public SlidingWindowCounter(long windowSizeInSecond,long maxRequestPerWindow){
        this.windowSizeInSecond=windowSizeInSecond;
        this.maxRequestPerWindow=maxRequestPerWindow;
        this.currentWindowStart= Instant.now().getEpochSecond();
        this.currentWindowCount=0;
        this.previousWindowCount=0;
    }
    public synchronized boolean allowRequest(){
        long now = Instant.now().getEpochSecond();
        long timePassedInWindow = now-currentWindowStart;

        //check if we have moved to next window
        if(timePassedInWindow>=windowSizeInSecond){
            previousWindowCount=currentWindowCount;
            currentWindowCount=0;
            currentWindowStart=now;
            timePassedInWindow=0;
        }
        // Calculate the weighted count of requests
        double weightedCount = previousWindowCount * ((windowSizeInSecond - timePassedInWindow) / (double) windowSizeInSecond)+ currentWindowCount;
        if (weightedCount < maxRequestPerWindow) {
            currentWindowCount++;  // Increment the count for this window
            return true;           // Allow the request
        }
        return false;  // We've exceeded the limit, deny the request

    }
}

