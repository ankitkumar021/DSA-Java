package LLD.logger.formatter;

import LLD.logger.LogEvent;

public class JsonFormatter implements Formatter {
    @Override
    public String format(LogEvent event) {
        //in key-value pair
       return String.format(
                "{\"timestamp\":%d,\"thread\":\"%s\",\"level\":\"%s\",\"message\":\"%s\"}",
                event.getTimestamp(),
                event.getThreadName(),
                event.getLevel(),
                event.getMessage()
        );

    }
}
//{
// "timestamp":1727675100000
//"thread": "pool-1-thread-2"
//"level":  "INFO"
//"message":"payment successful
// }