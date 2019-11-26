package com.user;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserfactory {
    public static MoodAnalyser createAnalyzer(String message) {
                try{
                Constructor<?> constructor = null;
                Class<?> moodAnalyserClass = Class.forName("com.user.MoodAnalyser");
                Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
                Object obj = moodConstructor.newInstance(message);
                return (MoodAnalyser) obj;

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
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
