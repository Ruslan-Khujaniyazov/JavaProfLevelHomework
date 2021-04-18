package ru.geekbrains.homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


class HW6MainTest {
    //private final HW6Main hw6Main  = new HW6Main();

    @ParameterizedTest
    @MethodSource("dataForTestArrayOfNumbersAfterLastRequired")
    void testArrayOfNumbersAfterLastRequired(int[] initialArray, int[] expectedArray) {
        int[] actualArray = HW6Main.arrayOfNumbersAfterLastRequired(initialArray);

        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    private static Stream<Arguments> dataForTestArrayOfNumbersAfterLastRequired() {
        List<Arguments> arguments = new ArrayList<>() {{
            add(Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}));
            add(Arguments.arguments(new int[]{2, 4, 5}, new int[]{5}));
            add(Arguments.arguments(new int[]{4, 5, 3, 2, 4, 7, 8}, new int[]{7, 8}));
            add(Arguments.arguments(new int[]{1, 4, 9, 0, 8}, new int[]{9, 0, 8}));
        }};

        return arguments.stream();
    }

    @Test
    void arrayOfNumbersAfterLastRequiredExceptionTest() {
        int[] array = new int[]{1, 3, 2, 5};

        Assertions.assertThrows(RuntimeException.class, () -> HW6Main.arrayOfNumbersAfterLastRequired(array));
    }


    @Test
    void arrayOfNumbersAfterLastRequiredExceptionTestEmptyArrayCase() {
        int[] emptyArray = new int[]{};

        Assertions.assertThrows(RuntimeException.class, () -> HW6Main.arrayOfNumbersAfterLastRequired(emptyArray));
    }


    @ParameterizedTest
    @MethodSource("dataForTestIsThereRequiredNumbersInArray")
    void testIsThereRequiredNumbersInArray(int[] array, boolean expectedResult) {
        boolean actualResult = HW6Main.isThereRequiredNumbersInArray(array);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> dataForTestIsThereRequiredNumbersInArray() {
       List<Arguments> arguments = new ArrayList<>() {{
           add(Arguments.arguments(new int[]{1, 1, 4, 4}, true));
           add(Arguments.arguments(new int[]{1, 1, 4, 3}, false));
           add(Arguments.arguments(new int[]{1, 1, 1, 1, 1}, false));
           add(Arguments.arguments(new int[]{4, 4, 4, 4, 4, 4}, false));
        }};
       return arguments.stream();
    }
}