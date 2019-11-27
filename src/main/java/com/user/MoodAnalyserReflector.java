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

    public static Object invokeMethode(Object moodAnalyserObject,String methodName) throws MoodAnalyseException {
        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_ACCESS,"May be issue with Data entered");
        } catch (InvocationTargetException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.METHODE_INVOCATION_ISSUE,
                    "May be issue with Data entered");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_METHOD, "DEfine proper Method");
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalyseException {
        try {
            Field field= myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_SUCH_FIELD, "No Such field");
        }catch (IllegalAccessException e) {
            throw new MoodAnalyseException(MoodAnalyseException.ExceptionType.NO_ACCESS,"No Access");
        }
    }


}
