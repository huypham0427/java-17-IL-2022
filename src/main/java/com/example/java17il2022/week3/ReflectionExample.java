package com.example.java17il2022.week3;


import org.hibernate.engine.spi.ManagedEntity;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ReflectionStudentExample {
    private String name;

    @MyAnnotation(value = "456")
    private ReflectionStudentExample(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
//        throw new RuntimeException("..");
        return name;
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> stuClass = ReflectionStudentExample.class;
        Constructor constructor = stuClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        for(Annotation annotation: constructor.getDeclaredAnnotations()) {
            if(annotation.annotationType() == MyAnnotation.class) {
                Method m = annotation.getClass().getDeclaredMethods()[0];
                System.out.println(m.invoke(annotation));
            }
        }
        ReflectionStudentExample stu = (ReflectionStudentExample) constructor.newInstance("Tom'");
//        ReflectionStudentExample stu = new ReflectionStudentExample("Tom");
        Field field = stuClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(stu, "Jerry");
        System.out.println(stu);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
@interface MyAnnotation {
    String value() default "1234";
}

