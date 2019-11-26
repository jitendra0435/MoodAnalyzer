package com.user;

public class MoodAnalyser {
    String message;
    public  MoodAnalyser() throws MoodAnalyseException {

    }
    public String analyseMood(String message) throws MoodAnalyseException {
       this.message=message;
        return analyseMood();
    }

    public MoodAnalyser(String message) throws MoodAnalyseException {
        this.message=message;
    }
    public String analyseMood() throws MoodAnalyseException{
        try {
            if(message.length()==0)
                throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.ENTERED_EMPTY,"message should not empty");
            if (message.contains(("SAD")))
                return "SAD";
            else
                return "HAPPY";

        }catch (NullPointerException e){
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.ENTERED_NULL,"Please enter proper mood" );
        }
    }
    public boolean equals(Object another){
       if(this.message.equals(((MoodAnalyser)another).message))
            return true;
        return false;
    }

}
