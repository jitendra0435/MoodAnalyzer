package com.user;

public class MoodAnalyser {
    String message;
    public  MoodAnalyser(){

    }
    public MoodAnalyser(String message) {
        this.message=message;
    }
    public String analyseMood(){
        if(message.contains(("SAD")))
            return "SAD";
        else
            return "HAPPY";
    }
}
