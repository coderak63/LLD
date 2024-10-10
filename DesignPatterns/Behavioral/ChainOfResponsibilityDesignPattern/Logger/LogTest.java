package DesignPatterns.Behavioral.ChainOfResponsibilityDesignPattern.Logger;

public class LogTest {
    public static void main(String[] args) {
        // This is based on "Chain of Responsibility" design pattern
        // Same we can do for ATM Machine, Vending Machine, L1->L2->L3 Support

        // ATM Machine ->
        // 2000 rupee note handler
        // 500 rupee note handler
        // 100 rupee note handler

        // We can create one more class "Logger" based on Singleton Design Pattern, such that only one logger object will be created
        
        LoggerHandler loggerHandler = new InfoLoggerHandler();
        LoggerHandler debugLoggerHandler = new DebugLoggerHandler();
        LoggerHandler errorLoggerHandler = new ErrorLoggerHandler();
        loggerHandler.setNextHandler(debugLoggerHandler);
        debugLoggerHandler.setNextHandler(errorLoggerHandler);

        loggerHandler.handleRequest(LoggerLevel.INFO, "This is info log.");
        loggerHandler.handleRequest(LoggerLevel.DEBUG, "This is debug log.");
        loggerHandler.handleRequest(LoggerLevel.ERROR, "This is error log.");

    }
}
