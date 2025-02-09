package com.example.libraryapi;

import java.lang.reflect.Field;

public class ReflectionUtil {

    public static void printObjectDetails(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(field.getName() + ": " + field.get(obj));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
