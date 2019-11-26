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
    @Test
    public void for_givenMessage_should_ReturnHappy(){
        MoodAnalyser moodAnalyser=new MoodAnalyser("I am in HAPPY mood");
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);

    }
    @Test
    public void for_NullMessage_Should_Returnhappy(){
        String mood=null;
        MoodAnalyser moodAnalyser=new MoodAnalyser(null);
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }

}

