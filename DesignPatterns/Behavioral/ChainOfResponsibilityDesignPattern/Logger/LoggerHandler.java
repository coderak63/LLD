package Logger;

public interface LoggerHandler {
    public void handleRequest(LoggerLevel loggerLevel, String value);
    public void setNextHandler(LoggerHandler nextLoggerHandler);
}
