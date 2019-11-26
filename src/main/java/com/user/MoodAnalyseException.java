package com.user;

public class MoodAnalyseException extends Exception{
    enum  ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY;
    }
    ExceptionType type;

    public MoodAnalyseException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
