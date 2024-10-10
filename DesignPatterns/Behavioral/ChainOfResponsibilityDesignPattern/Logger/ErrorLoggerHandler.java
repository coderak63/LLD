package DesignPatterns.Behavioral.ChainOfResponsibilityDesignPattern.Logger;

public class ErrorLoggerHandler implements LoggerHandler{
    LoggerHandler nextLoggerHandler;

    @Override
    public void handleRequest(LoggerLevel loggerLevel, String value) {
        if(loggerLevel == LoggerLevel.ERROR){
            System.out.println("ERROR: "+value);
        }else if(nextLoggerHandler!=null){
            nextLoggerHandler.handleRequest(loggerLevel, value);
        }
    }

    @Override
    public void setNextHandler(LoggerHandler nextLoggerHandler) {
        this.nextLoggerHandler = nextLoggerHandler;
    }
}
