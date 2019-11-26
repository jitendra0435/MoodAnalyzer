package com.user;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public  void moodTest(){
        MoodAnalyser moodAnalyser=new MoodAnalyser();
        String mood=moodAnalyser.analyseMood("This is SAD mood");
        Assert.assertEquals("SAD",mood);

    }
}
