package ru.geekbrains.homework6;


import java.util.Arrays;

public class HW6Main {
    public static final int FIRST_REQUIRED_NUMBER_IN_ARRAY = 4;
    public static final int SECOND_REQUIRED_NUMBER_IN_ARRAY = 1;
    public static int[] testArray = {8, 4, 1, 4, 5, 6};


    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfNumbersAfterLastRequired(testArray)));
        System.out.println(isThereRequiredNumbersInArray(testArray));
    }

    public static int[] arrayOfNumbersAfterLastRequired (int[] array) {

        for (int i = array.length - 1; i >= 0; i--) {

            if (array[i] == FIRST_REQUIRED_NUMBER_IN_ARRAY) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }

        throw new RuntimeException("No required number in array");
    }



    public static boolean isThereRequiredNumbersInArray(int[] array) {
        boolean isThereFirstRequiredNumber = false;
        boolean isThereSecondRequiredNumber = false;


        for (int number : array) {
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
