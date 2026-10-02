package DSA.lld.ratelimiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowStrategy implements RateLimiterStrategy {

    private final SlidingWindowConfig sconfig;

    //each user has a queue of request timestamps
    //user1 ->[1000,2000,3000]
    //user2 ->[1500,2500]
    private final Map<String, Queue<Long>> requests = new HashMap<>();

    public SlidingWindowStrategy(SlidingWindowConfig sconfig){
        this.sconfig =sconfig;
    }

    @Override
    public synchronized boolean allowRequest(String userId) {

        long currentTime = System.currentTimeMillis();

        Queue<Long> timestamps = requests.get(userId);

        //first time user
        if(timestamps == null){
            timestamps = new LinkedList<>();
            requests.put(userId,timestamps);
        }

        //remove expired requests
        long windowStart = currentTime - sconfig.getWindowSizeMillis();

        while(!timestamps.isEmpty() && timestamps.peek()<= windowStart){
            timestamps.poll();
        }

        //check limit
        if(timestamps.size()>=sconfig.getMaxRequests()){
            return false;
        }

        //add current request
        timestamps.offer(currentTime);

        return true;
    }
}
