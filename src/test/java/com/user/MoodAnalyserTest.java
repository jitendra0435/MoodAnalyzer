package com.user;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public  void for_given_Message_should_Return_SAD(){
        String mood=null;
        MoodAnalyser moodAnalyser= null;
        try {
            moodAnalyser = new MoodAnalyser("This is SAD mood");
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
        try {
            mood=moodAnalyser.analyseMood();
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",mood);

    }
    @Test
    public void for_givenMessage_should_ReturnHappy(){
        MoodAnalyser moodAnalyser= null;
        try {
            moodAnalyser = new MoodAnalyser("I am in HAPPY mood");
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
        String mood= null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",mood);

    }
    @Test
    public void for_NullMessage_Should_Returnhappy(){
        String mood=null;
        MoodAnalyser moodAnalyser= null;
        try {
            moodAnalyser = new MoodAnalyser(null);
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
        try {
            Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenNullMoodShouldThrowException(){
        MoodAnalyser moodAnalyser= null;
        try {
            moodAnalyser = new MoodAnalyser(null);
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
        try{
            moodAnalyser.analyseMood();
        } catch(MoodAnalyseException e){
            Assert.assertEquals(MoodAnalyseException.ExceptionType.ENTERED_NULL,e.type);
            e.printStackTrace();
        }
    }

}

