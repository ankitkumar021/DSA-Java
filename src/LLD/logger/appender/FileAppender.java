package LLD.logger.appender;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//for concurrency,multiple thread could try writing to the file simultaneously
//so we need to make file writing thread safe
public class FileAppender implements Appender {

   private final BufferedWriter bufferedWriter;

    public FileAppender(String fileName) throws IOException {
        this.bufferedWriter = new BufferedWriter(new FileWriter(fileName,true));
    }
    @Override
    public synchronized void append(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.newLine();;
            bufferedWriter.flush();//why?

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
