package DSA.lld.logging.appenders;

import DSA.lld.logging.LogMessage;
import DSA.lld.logging.formater.LogFormatter;

public class ConsoleAppender implements LogAppender{
    private final LogFormatter formatter;

    public ConsoleAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LogMessage message) {
        System.out.println(formatter.format(message));

    }
}
