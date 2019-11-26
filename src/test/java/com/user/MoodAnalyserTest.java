package com.user;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public  void for_given_Message_should_Return_SAD(){
        String mood;
        MoodAnalyser moodAnalyser=new MoodAnalyser("This is SAD mood");
        mood=moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",mood);

    }


}
