package ru.geekbrains.homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW6Var2ArrayList {
    public static final int FIRST_REQUIRED_NUMBER_IN_ARRAY = 4;
    public static final int SECOND_REQUIRED_NUMBER_IN_ARRAY = 1;
    public static List<Integer> testArray = Arrays.asList(8, 4, 1, 4, 5, 6);


    public static void main(String[] args) {

        System.out.println(arrayOfNumbersAfterLastRequired(testArray).toString());
        System.out.println(isThereRequiredNumbersInArray(testArray));
    }

    public static List<Integer> arrayOfNumbersAfterLastRequired (List<Integer> array) {

        if(!array.contains(FIRST_REQUIRED_NUMBER_IN_ARRAY)) {
            throw new RuntimeException("No required number in array");
        }

        List<Integer> newArray = new ArrayList<>();

        for (int i = array.lastIndexOf(FIRST_REQUIRED_NUMBER_IN_ARRAY) + 1; i < array.size(); i++) {
            newArray.add(array.get(i));
        }

        return newArray;
    }

    public static boolean isThereRequiredNumbersInArray(List<Integer> array) {
        boolean isThereFirstRequiredNumber = false;
        boolean isThereSecondRequiredNumber = false;


        for (Integer number : array) {
            if  (number == FIRST_REQUIRED_NUMBER_IN_ARRAY) {
                isThereFirstRequiredNumber = true;

            } else if (number == SECOND_REQUIRED_NUMBER_IN_ARRAY) {
                isThereSecondRequiredNumber = true;

            } else {
                return false;
            }
        }

        return isThereFirstRequiredNumber && isThereSecondRequiredNumber;
    }
}
