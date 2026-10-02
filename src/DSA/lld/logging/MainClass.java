package DSA.lld.logging;

import DSA.lld.logging.appenders.ConsoleAppender;
import DSA.lld.logging.appenders.FileAppender;
import DSA.lld.logging.formater.PlainTextFormatter;

public class MainClass {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.INFO,
                new ConsoleAppender(new PlainTextFormatter())
        );

        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.ERROR,
                new ConsoleAppender(new PlainTextFormatter())
        );

        LogHandlerConfiguration.addAppenderForLevel(
                LogLevel.ERROR,
                new FileAppender(new PlainTextFormatter(), "logs.txt")
        );

        // Usage
        logger.info("This is some key information"); // CONSOLE
        logger.error("Oh no! there's an error"); // CONSOLE + FILE
    }
}

