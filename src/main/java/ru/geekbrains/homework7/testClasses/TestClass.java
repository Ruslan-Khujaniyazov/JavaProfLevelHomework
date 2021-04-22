package ru.geekbrains.homework7.testClasses;

import ru.geekbrains.homework7.annotations.AfterSuite;
import ru.geekbrains.homework7.annotations.BeforeSuite;
import ru.geekbrains.homework7.annotations.Test;

public class TestClass {

    @BeforeSuite
    private static void beforeSuite() {
        System.out.println(">>> BeforeSuite method running");
    }

    //for testing Exception "RuntimeException: More than one BeforeSuite or AfterSuite annotated methods in TestClass!"
    /*@BeforeSuite
    private static void beforeSuite1() {
        System.out.println(">>> BeforeSuite method running");
    }*/

    @Test(priority = 3)
    private static void test1() {
        System.out.println("> Test1 running");
    }

    @Test(priority = 2)
    private static void test2() {
        System.out.println("> Test2 running");
    }

    @Test()
    private static void test3() {
        System.out.println("> Test3 running");
    }

    @AfterSuite
    private static void afterSuite() {
        System.out.println(">>> AfterSuite method running");
    }
}
