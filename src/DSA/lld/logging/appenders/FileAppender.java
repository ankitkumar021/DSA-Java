package DSA.lld.logging.appenders;

import DSA.lld.logging.LogMessage;
import DSA.lld.logging.formater.LogFormatter;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{
    private final LogFormatter formatter;
    private final String filePath;

    public FileAppender(LogFormatter formatter,String filePath) {
        this.formatter = formatter;
        this.filePath=filePath;
    }
//blocking queue
    @Override
    public synchronized void append(LogMessage message) {
        try(FileWriter writer = new FileWriter(filePath,true)){
            writer.write(formatter.format(message));
        }
    catch (IOException e) {
        e.printStackTrace(); // Print error if file writing fails
    }

    }
}
