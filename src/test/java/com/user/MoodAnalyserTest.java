package com.user;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    @Test
    public void for_given_Message_should_Return_SAD() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("This is SAD mood");
            Assert.assertEquals("SAD", moodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();

        }
    }
    @Test
    public void for_givenMessage_should_ReturnHappy() {
        try{
             MoodAnalyser moodAnalyser = new MoodAnalyser("I am in HAPPY mood");
            Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void for_Null_Message_Should_Returnhappy() {
        try {
             MoodAnalyser moodAnalyser = new MoodAnalyser();
            Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given_Null_Mood_Should_ThrowMoodAnalyseException() throws MoodAnalyseException {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood(null);
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void if_passes_MoodValues_as_Empty_throwsException() throws MoodAnalyseException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void given_moodAnalyserFor_comparing_Objects() {
        try {
            Constructor<?>constructor=MoodAnalyserReflector.getConstrcutor();
            Object moodAnalyser1 = MoodAnalyserReflector.createMoodAnalyser(constructor,"I am in Happy mood");
           Assert.assertEquals(new MoodAnalyser("I am in Happy mood"),moodAnalyser1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenImproper_class_Name_throws_The_Exception(){
        try{
            Constructor<?>constructor=MoodAnalyserReflector.getConstrcutor(String.class);
            MoodAnalyserReflector.createMoodAnalyser(constructor,"I am in Happy mood");
        } catch (MoodAnalyseException e){
            Assert.assertEquals(MoodAnalyseException.ExceptionType.NOSUCH_CLASS,e.type);

        }
    }
    @Test
    public void givenClassName_whenImproperConstructor_shouldThrowException() throws MoodAnalyseException {
        try {
            Constructor<?>constructor=MoodAnalyserReflector.getConstrcutor(String.class);
            MoodAnalyserReflector.createMoodAnalyser(constructor,"I am in Happy mood");
        } catch (MoodAnalyseException e) {
            Assert.assertEquals(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenHappymessage_with_Reflection_Should_Return_Happy(){
        try {
            Constructor<?>constructor=MoodAnalyserReflector.getConstrcutor();
            Object myObject =MoodAnalyserReflector.createMoodAnalyser(constructor);
            Object mood=MoodAnalyserReflector.invokeMethode(myObject,"analyseMood");
            MoodAnalyserReflector.invokeMethode(myObject,"analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMoodAnalyser_onChanged_Should_Return_Happy(){
        try {
            MoodAnalyser moodAnalyser=new MoodAnalyser();
            Constructor<?>constructor=MoodAnalyserReflector.getConstrcutor();
            Object myObject=MoodAnalyserReflector.createMoodAnalyser(constructor);
            MoodAnalyserReflector.setFieldValue(myObject,"message","I am in HAPPY Mood");
            Object mood=moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyseException e) {
            e.printStackTrace();
        }
    }
}

