package com.user;

public class MoodAnalyser {
    String message;
    public  MoodAnalyser(){

    }
    public MoodAnalyser(String message) {
        this.message=message;
    }
    public String analyseMood(){
        try {
            if (message.contains(("SAD")))
                return "SAD";
            else
                return "HAPPY";

        }catch (NullPointerException e){
                return "HAPPY";
        }
    }
}

