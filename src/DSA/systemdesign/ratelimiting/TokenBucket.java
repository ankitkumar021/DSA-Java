package DSA.systemdesign.ratelimiting;

import java.time.Instant;

public class TokenBucket {
    private final long capacity;// Maximum number.txt of tokens the bucket can hold
    private final double fillRate;// Rate at which tokens are added to the bucket (tokens per second)
    private double currentTokens;// Current number.txt of tokens in the bucket
    private Instant lastFillTimestamp; // Last time we refilled the bucket
    public TokenBucket(long capacity,double fillRate){
        this.capacity=capacity;
        this.fillRate=fillRate;
        this.currentTokens=capacity;// Start with a full bucket
        this.lastFillTimestamp=Instant.now();
    }
    public synchronized boolean allowRequest(int tokens){
        refill();// First, add any new tokens based on elapsed time
        if(this.currentTokens<tokens){
            return false; // Not enough tokens, deny the request
        }
        else {
            this.currentTokens -=tokens; // Consume the tokens
            return true;//allow request
        }
    }

    private void refill() {
        Instant now = Instant.now();
        // Calculate how many tokens to add based on the time elapsed
        double tokenToAdd = (now.toEpochMilli() - lastFillTimestamp.toEpochMilli())*fillRate/1000.0;
        this.currentTokens=Math.min(capacity,this.currentTokens+tokenToAdd);// Add tokens, but don't exceed capacity
        this.lastFillTimestamp=now;
    }
}

//read difference between api throttling and rate limiting
//.Both help prevent server overload and ensure fair usage,
// but they manage requests in different ways.
//
//API Throttling controls the speed of incoming requests over time to handle
// sudden traffic spikes smoothly.
//API Rate Limiting sets a strict maximum number of requests allowed within
// a specific time period.
//
//API Throttling
//API Throttling is a technique used to control the rate of API requests processed
//within a specific time period. It helps prevent server overload,
//manage traffic spikes, and maintain system stability and performance for all users.
//
//API throttling temporarily limits how many requests a client can send in a given timeframe.
//This ensures fair resource usage and prevents excessive consumption by a single user.
//It is commonly used in distributed systems and cloud services to maintain API availability
//during high traffic. Throttling helps avoid downtime and improves overall reliability of
//the system.
//
//API Rate Limiting
//API Rate Limiting is a technique used to restrict the number of API requests a client
//can make within a fixed time period. It helps prevent abuse, protects server resources,
//and ensures fair access to the API for all users.
//
//Rate limiting sets a predefined request limit such as requests per second, minute,
//or day. Once the limit is exceeded, additional requests are blocked or delayed until
//the next time window.
//It is commonly used to prevent API abuse, DDoS attacks, and excessive resource consumption.
// This helps maintain system performance, stability, and availability