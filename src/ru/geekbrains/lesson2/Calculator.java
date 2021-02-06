package ru.geekbrains.lesson2;

public class Calculator {

    public static void arrCheckSizeCondition(String[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers.length != 4 || numbers[i].length != 4) {
                throw new MyArraySizeException("Array should be 4x4!");
            }
        }

    }

    public static void arrPrint(String[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (j < numbers.length - 1) {
                    System.out.print(numbers[i][j] + " - ");
                } else {
                    System.out.print(numbers[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void arrFill(String[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                numbers[i][j] = String.valueOf((int) (Math.random() * 10));
            }
        }
    }


    public static int stringToIntCalc(String[][] strings) {
        int counter = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                try {
                    counter += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(
                            String.format("Check the value at [%s][%s]. It should be a number."
                                    , i, j)
                            );
                }

            }
        }
        return counter;
    }

    public static int stringToIntCalcSafe(String[][] strings) {
        arrCheckSizeCondition(strings);
        arrFill(strings);
        arrPrint(strings);
        return stringToIntCalc(strings);


    }


}
