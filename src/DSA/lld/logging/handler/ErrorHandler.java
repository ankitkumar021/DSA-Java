package DSA.lld.logging.handler;

import DSA.lld.logging.LogLevel;

public class ErrorHandler extends LogHandler{


    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }
}
