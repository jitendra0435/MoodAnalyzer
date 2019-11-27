package com.user;

public class MoodAnalyseException extends Exception{
    enum  ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY,NOSUCH_CLASS,NO_SUCH_METHOD, METHODE_INVOCATION_ISSUE,NO_SUCH_FIELD,NO_ACCESS,
        OBJECT_ORIENTATION_ISSUE;
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
