package com.user;

public class MoodAnalyseException extends Exception{
    enum  ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY,NOSUCH_CLASS,NO_SUCH_METHOD;
    }
    ExceptionType type;

    public MoodAnalyseException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }
    public MoodAnalyseException(ExceptionType noSuchClass)
    {
        super(noSuchClass.toString());
        this.type=noSuchClass;
    }


}
