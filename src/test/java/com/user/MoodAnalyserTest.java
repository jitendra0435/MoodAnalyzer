package com.user;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void for_given_Message_should_Return_SAD() {
        String mood = null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("This is SAD mood");
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
            Assert.assertEquals("SAD", mood);
        }
    }
    @Test
    public void for_givenMessage_should_ReturnHappy() {
        String mood=null;
        try{
             MoodAnalyser moodAnalyser = new MoodAnalyser("I am in HAPPY mood");
             moodAnalyser.analyseMood();
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
            Assert.assertEquals("HAPPY", mood);
        }
    }

    @Test
    public void for_Null_Message_Should_Returnhappy() {

        try {
             MoodAnalyser moodAnalyser = new MoodAnalyser(null);
             moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void given_Null_MoodShould_ThrowException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyseMood();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void if_passes_MoodValues_as_Empty_throwsException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            moodAnalyser.analyseMood();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void given_moodAnalyserFor_comparing_Objects() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserfactory.createAnalyzer("I am in Happy mood");
            Assert.assertEquals(new MoodAnalyser("I am in Happy mood"), moodAnalyser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void when_pass_The_WrongClass_Name_throws_The_Exception(){
        try{
            MoodAnalyser moodAnalyser = MoodAnalyserfactory.createAnalyzer();
        } catch (MoodAnalyseException e){
            Assert.assertEquals(MoodAnalyseException.ExceptionType.NOSUCH_CLASS,e.type);

        }
    }
}

