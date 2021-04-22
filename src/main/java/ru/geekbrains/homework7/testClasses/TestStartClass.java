package ru.geekbrains.homework7.testClasses;

import ru.geekbrains.homework7.annotations.AfterSuite;
import ru.geekbrains.homework7.annotations.BeforeSuite;
import ru.geekbrains.homework7.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestStartClass {

    private static final int MIN_PRIORITY = 1;
    private static final int MAX_PRIORITY = 10;
    private static Method beforeSuiteMethod;
    private static Method afterSuiteMethod;


    public static void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        checkBeforeAndAfterSuiteMethodsCount(methods);
        try {
            invokeMethod(beforeSuiteMethod);
            invokeTestMethods(methods);
            invokeMethod(afterSuiteMethod);

        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static void checkBeforeAndAfterSuiteMethodsCount(Method[] methods) {
        int beforeSuiteAnnotationCount = 0;
        int afterSuiteAnnotationCount = 0;

        for (Method method : methods) {
            method.setAccessible(true);

            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteAnnotationCount++;
                beforeSuiteMethod = method;
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteAnnotationCount++;
                afterSuiteMethod = method;
            }
        }

        if (beforeSuiteAnnotationCount > 1 | afterSuiteAnnotationCount > 1) {
            throw new RuntimeException("More than one BeforeSuite or AfterSuite annotated methods in TestClass!");
        }
    }

    private static void invokeMethod(Method method) throws InvocationTargetException, IllegalAccessException {
        method.invoke(null);
    }

    private static void invokeTestMethods(Method[] methods) throws InvocationTargetException, IllegalAccessException {
        for (int priorityValue = MAX_PRIORITY; priorityValue >= MIN_PRIORITY; priorityValue--) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {

                    if (method.getAnnotation(Test.class).priority() == priorityValue) {

                        method.invoke(null);
                    }

                }
            }
        }
    }
}
