package DSA.systemdesign.ratelimiting;

//Design a logger system that receives a stream of messages along with their timestamps.
// Each unique message should only be printed at most every 10 seconds
// (i.e. a message printed at timestamp t will prevent other identical messages from
// being printed until timestamp t + 10).
//All messages will come in chronological order. Several messages may arrive at the same timestamp.
//Implement the Logger class:
//
//Logger() Initializes the logger object.
//bool shouldPrintMessage(int timestamp, string message)
//Returns true if the message should be printed in the given timestamp, otherwise returns false.
//Input: [[1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]

import java.util.HashMap;

//Output: [true, true, false, false, false, true]
//Logger logger = new Logger();
//logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
//logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
//logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
//logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
//logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
//logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
public class RateLimiter {
    HashMap<String, Integer> lastTime;
    public RateLimiter() {
        lastTime = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp - lastTime.getOrDefault(message, -100) < 10)
            return false;
        lastTime.put(message, timestamp);
        return true;
    }
}

