package DSA.lld.logging.appenders;

import DSA.lld.logging.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}
