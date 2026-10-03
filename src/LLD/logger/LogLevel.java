package LLD.logger;

public enum LogLevel {

    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4);

    //why priority let if the min level is INFO so level before this will ignored(not logged)
    private final int  priority;

    LogLevel(int priority){
        this.priority=priority;
    }

    public int getPriority(){
        return priority;
    }

}
