package DSA.lld.logging;

public class LogMessage {
    private final LogLevel level;
    private final String message;
    private final long timestamp;

    public LogMessage(LogLevel level, String message, long timestamp) {
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Returns the log level of the message
    public LogLevel getLevel() {
        return level;
    }

    // Returns the log message content
    public String getMessage() {
        return message;
    }

    // Returns the timestamp of the log creation
    public long getTimestamp() {
        return timestamp;
    }
}
