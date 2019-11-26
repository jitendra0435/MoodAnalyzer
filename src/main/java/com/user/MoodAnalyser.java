package com.user;

public class MoodAnalyser {
    public String analyseMood(String message) {
        if (message.contains("SAD"))
            return "SAD";
        return message;
    }
}
