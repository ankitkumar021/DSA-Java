package LLD.logger.config;

import LLD.logger.LogLevel;
import LLD.logger.appender.Appender;
import LLD.logger.formatter.Formatter;

import java.util.List;

public class LoggerConfig {
    private final LogLevel minimumLevel;
    private final Formatter formatter;
    private final List<Appender> appenders;

    public LoggerConfig(LogLevel minimumLevel, Formatter formatter, List<Appender> appenders) {
        this.minimumLevel = minimumLevel;
        this.formatter = formatter;
        this.appenders = appenders;
    }


    public LogLevel getMinimumLevel() {
        return minimumLevel;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public List<Appender> getAppenders() {
        return appenders;
    }
}
