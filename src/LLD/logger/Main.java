package LLD.logger;
import LLD.logger.appender.Appender;
import LLD.logger.appender.ConsoleAppender;
import LLD.logger.appender.FileAppender;
import LLD.logger.config.LoggerConfig;
import LLD.logger.formatter.Formatter;
import LLD.logger.formatter.PlainTextFormatter;

import java.io.IOException;
import java.util.Arrays;


public class Main {
   public static void main(String[] args) throws IOException {

       Formatter formatter = new PlainTextFormatter();

       Appender consoleAppender = new ConsoleAppender();

       Appender fileAppender = new FileAppender("application.log");

       LoggerConfig config = new LoggerConfig(
                                LogLevel.INFO,
                                formatter,
                                Arrays.asList(
                                        consoleAppender,
                                        fileAppender
                                )

       );

       Logger logger = new Logger(config);

       logger.debug("debug message");
       logger.info("info message");
       logger.warn("warn message");
       logger.error("warn message");


    }
}
