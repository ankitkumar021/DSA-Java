package LLD.logger.formatter;

import LLD.logger.LogEvent;
//strategy
public interface Formatter {
    String format(LogEvent event);
}
