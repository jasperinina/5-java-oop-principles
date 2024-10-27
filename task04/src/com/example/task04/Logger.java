package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private static ArrayList<MessageHandler> handlers = new ArrayList<>();
    private final String Name;
    private LoggerLevel Level;

    public Logger(String name){
        Name = name;
        Level = LoggerLevel.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, ArrayList<MessageHandler> messageHandlers) {
        this.Name = name;
        this.Level = LoggerLevel.INFO;
        handlers = messageHandlers;
        loggers.put(this.Name, this);
    }

    public Logger(String name,LoggerLevel level, ArrayList<MessageHandler> messageHandlers) {
        this.Name = name;
        this.Level = level;
        handlers = messageHandlers;
        loggers.put(this.Name, this);
    }

    public static Logger getLogger(String name){
        if(loggers.get(name) == null){
            loggers.put(name,new Logger(name));
        }
        return loggers.get(name);
    }

    public String getName(){
        return this.Name;
    }

    public LoggerLevel getLevel(){
        return this.Level;
    }

    public void setLevel(LoggerLevel level){
        Level = level;
    }

    private void log(LoggerLevel level, String message) {
        String printedMessage;
        if (Level.ordinal() <= level.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            printedMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, Name, message);
        }else {
            printedMessage = "No message";
        }
        for (MessageHandler messageHandler : handlers) {
            messageHandler.log(printedMessage);
        }
    }

    private void log(LoggerLevel level, String format, Object... args) {
        if (this.Level.ordinal() <= level.ordinal()) {
            String message = MessageFormat.format(format, args);

            for (MessageHandler messageHandler : handlers) {
                messageHandler.log(message);
            }
        }
    }

    public void debug(String message){
        this.log(LoggerLevel.DEBUG, message);
    }

    public void debug(String format, Object... objects){
        this.log(LoggerLevel.DEBUG, format, objects);
    }

    public void info(String mesage){
        this.log(LoggerLevel.INFO, mesage);
    }

    public void info(String format, Object... objects){
        this.log(LoggerLevel.INFO, format, objects);
    }

    public void warning(String message){
        this.log(LoggerLevel.WARNING, message);
    }

    public void warning(String format, Object... objects){
        this.log(LoggerLevel.WARNING, format, objects);
    }

    public void error(String message){
        this.log(LoggerLevel.ERROR, message);
    }

    public void error(String format, Object... objects){
        this.log(LoggerLevel.ERROR, format, objects);
    }
}