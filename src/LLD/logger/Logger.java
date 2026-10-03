package LLD.logger;


import LLD.logger.appender.Appender;
import LLD.logger.config.LoggerConfig;

public class Logger {
    private final LoggerConfig config;
    //blocking q(should be bounded meaning have a fixed size)
    //because unbounded queue can grow theoretically grow indefinitely if
    //application log production rate > logging worker consumption rate
    //and queue grows than memory grows than potential OOM
    //public final BlockingQueue q = new ArrayBlockingQueue<>(1000);
    //what if queue is full-> we can either block the producer for reliability
    //or drop lower-priority logs depending on the configured policy
    //create thread workerThread pool Executors.newFixedThreadPool(4);
    //for(int i=0;i<4;i++){
    //  workerPool.submit(this::processLogs);
    // }
    //queue.put(event)->application thread
    //process log (){
    // LogEvent event = queue.take()//logger worker thread
    //  format it and send it all the appender
    //
    // }


    public Logger(LoggerConfig config){
        this.config = config;
    }

    public void debug(String message){
        log(LogLevel.DEBUG,message);

    }
    public void info(String message){
        log(LogLevel.INFO,message);

    }
    public void warn(String message){
        log(LogLevel.WARN,message);

    }
    public void error(String message){
        log(LogLevel.ERROR,message);

    }


    public  void log(LogLevel level,String message){

        //check min level if not pass discard
        if(level.getPriority() < config.getMinimumLevel().getPriority()){
            return;
        }

        //create log event
        LogEvent event = new LogEvent(
                                System.currentTimeMillis(),
                                level,
                                message,
                                Thread.currentThread().getName()
                            );

        //format
        String formattedMessage = config.getFormatter().format(event);

        //send to all appenders
        for(Appender appender : config.getAppenders()){
            appender.append(formattedMessage);
        }

    }
}
