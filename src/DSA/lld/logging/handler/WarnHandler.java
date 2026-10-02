package DSA.lld.logging.handler;

import DSA.lld.logging.LogLevel;

public class WarnHandler extends LogHandler{
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.WARN;
    }
}
