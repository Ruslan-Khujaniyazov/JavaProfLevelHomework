package ru.geekbrains.homework7.testClassExecutors;

import ru.geekbrains.homework7.testClasses.TestClass;
import ru.geekbrains.homework7.testClasses.TestStartClass;

public class TestClassExecutor {
    public static void main(String[] args) {
        //Class testClass = TestClass.class;

        TestStartClass.start(TestClass.class);
    }
}
