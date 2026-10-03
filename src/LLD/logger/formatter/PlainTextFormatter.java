package LLD.logger.formatter;

import LLD.logger.LogEvent;

public class PlainTextFormatter implements Formatter {
    @Override
    public String format(LogEvent event) {

        return String.format(
                "%d[%s][%s]%s",
                event.getTimestamp(),
                event.getThreadName(),
                event.getLevel(),
                event.getMessage()
        );

    }
}
