package Logger;

public class DebugLoggerHandler implements LoggerHandler{
    LoggerHandler nextLoggerHandler;

    @Override
    public void handleRequest(LoggerLevel loggerLevel, String value) {
        if(loggerLevel == LoggerLevel.DEBUG){
            System.out.println("DEBUG: "+value);
        }else if(nextLoggerHandler!=null){
            nextLoggerHandler.handleRequest(loggerLevel, value);
        }
    }

    @Override
    public void setNextHandler(LoggerHandler nextLoggerHandler) {
        this.nextLoggerHandler = nextLoggerHandler;
    }
}
