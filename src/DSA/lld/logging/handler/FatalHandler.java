package DSA.lld.logging.handler;

import DSA.lld.logging.LogLevel;

public class FatalHandler extends LogHandler{
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.FATAL;
    }
}
