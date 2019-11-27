package com.user;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
public class MoodAnalyserReflector {
    public static Constructor<?> getConstrcutor(Class<?>... param) throws MoodAnalyseException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.user.MoodAnalyser");
            try {
                return moodAnalyserClass.getConstructor((param));
            } catch (NoSuchMethodException e) {
                throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD);
            }
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NOSUCH_CLASS);
        }
    }

    public static Object createMoodAnalyser(Constructor<?> constructor, Object... message) throws MoodAnalyseException {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.OBJECT_ORIENTATION_ISSUE);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_ACCESS);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

}

