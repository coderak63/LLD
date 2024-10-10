package Logger;

public class InfoLoggerHandler implements LoggerHandler{
    LoggerHandler nextLoggerHandler;

    @Override
    public void handleRequest(LoggerLevel loggerLevel, String value) {
        if(loggerLevel == LoggerLevel.INFO){
            System.out.println("INFO: "+value);
        }else if(nextLoggerHandler!=null){
            nextLoggerHandler.handleRequest(loggerLevel, value);
        }
    }

    @Override
    public void setNextHandler(LoggerHandler nextLoggerHandler) {
        this.nextLoggerHandler = nextLoggerHandler;
    }


}
