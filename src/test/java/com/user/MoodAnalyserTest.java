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
        try {
             MoodAnalyser moodAnalyser = new MoodAnalyser("I am in HAPPY mood");
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);

    }

    @Test
    public void for_NullMessage_Should_Returnhappy() {

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
    public void if_mood_is_Empty() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            moodAnalyser.analyseMood();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.ENTERED_EMPTY, e.type);
        }

    }
}

