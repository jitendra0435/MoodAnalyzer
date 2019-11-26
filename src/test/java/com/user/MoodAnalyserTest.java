package com.user;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public  void for_given_Message_should_Return_SAD(){
        MoodAnalyser moodAnalyser=new MoodAnalyser();
        String mood=moodAnalyser.analyseMood("This is SAD mood");
        Assert.assertEquals("SAD",mood);

    }
    @Test
    public void in_anyMood_should_ReturnHappy(){
        MoodAnalyser moodAnalyser=new MoodAnalyser();
        String mood=moodAnalyser.analyseMood("I am in HAPPY mood");
        Assert.assertEquals("HAPPY",mood);

    }
}
