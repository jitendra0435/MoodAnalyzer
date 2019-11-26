package com.user;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserfactory {
    public static MoodAnalyser createAnalyzer(String message1)throws MoodAnalyseException{
                try{
                Constructor<?> constructor = null;
                Class<?> moodAnalyserClass = Class.forName("com.user.MoodAnalyser");
                Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
                Object obj = moodConstructor.newInstance(message1,message1);
                return (MoodAnalyser) obj;

                } catch (NoSuchMethodException e) {
                    throw  new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD);
                } catch (ClassNotFoundException e) {
                    throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NOSUCH_CLASS);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e){
                    throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD);

            }
                return null;
        }

    public static MoodAnalyser createAnalyzer()throws MoodAnalyseException{
        try{
            Constructor<?> constructor = null;
            Class<?> moodAnalyserClass = Class.forName("com.user.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            Object obj = moodConstructor.newInstance();
            return (MoodAnalyser) obj;

        } catch (NoSuchMethodException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NOSUCH_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
