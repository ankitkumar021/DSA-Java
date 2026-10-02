package DSA.lld.logging.handler;

import DSA.lld.logging.LogLevel;
import DSA.lld.logging.LogMessage;
import DSA.lld.logging.appenders.LogAppender;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LogHandler {

    protected LogHandler next;
    protected final List<LogAppender> appenders = new CopyOnWriteArrayList<>();

    // Set the next logger in the chain
    public void setNext(LogHandler next){
        this.next=next;
    }

    public void subscribe(LogAppender observer){
        appenders.add(observer);
    }
    public void notifyObservers(LogMessage message){
        for(LogAppender appender: appenders){
            appender.append(message);
        }
    }
    //if logging level in the chain handle and notify the appender else move to next level
    public void handle(LogMessage message) {
        if (canHandle(message.getLevel())) {
            notifyObservers(message);
        }
        else if (next != null) {
            next.handle(message);
        }
    }
    protected abstract boolean canHandle(LogLevel level);








}
