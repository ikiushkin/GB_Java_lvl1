package ru.geekbrains;

public class Lesson2 {
    public static void main(String[] args) {
    }

    // Задание 1

    public static void replacingValue () {

        int[] arrTask1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arrTask1.length; i ++) {
            if (arrTask1[i] == 0) {
                arrTask1[i] = 1;
            } else {
                arrTask1[i] = 0;
            }
        }
    }

    // Задание 2

    public static void addNumbInArray () {

        int[] arrTask2 = new int[8];
        int arrValue = 0;

        for (int i = 0; i < arrTask2.length; i ++) {
            arrTask2[i] = arrValue;
            arrValue += 3;
        }
    }

    // Задание 3

    public static void multiplyByTwo () {

        int[] arrTask3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arrTask3.length; i ++) {
            if (arrTask3[i] < 6) {
                arrTask3[i] *= 2;
            }
        }
    }

    // Задание 4

    public static void fillTheArrayWithOne () {

        int[][] arrTask4 = new int[5][5];

        for (int i = 0; i < arrTask4.length; i++) {
            for (int j = 0; j < arrTask4[i].length; j++) {
                arrTask4[i][j] = 1;
            }
        }
    }

    // Задание 5

    public static void findMinMax () {

        int[] arrTask5 = {4, 5, 0, 3, 2, 11, -12, 4, 5, 2, 4, 8, 9, 15, 1, -16};
        int minNumb = arrTask5[0];
        int maxNumb = arrTask5[0];

        for (int i = 0; i < arrTask5.length; i++) {
            if (i == arrTask5.length-1) {
                break;
            }

            if (arrTask5[i] < arrTask5[i+1] && maxNumb < arrTask5[i+1]) {
                maxNumb = arrTask5[i+1];
            }

            if (arrTask5[i] > arrTask5[i+1] && minNumb > arrTask5[i+1]) {
                minNumb = arrTask5[i+1];
            }
        }
    }

    // Задание 6

    public static void checkBalance (int[] arrTask6) {

        int summLeft = 0;
        int summRight = 0;
        int arrTotalSumm = 0;

        for (int i = 0; i < arrTask6.length; i++) {
            arrTotalSumm = arrTotalSumm + arrTask6[i];
        }

        for (int j = 0; j < arrTask6.length; j ++) {
            summLeft = summLeft + arrTask6[j];
            summRight = arrTotalSumm - summLeft;

            if (summLeft == summRight) {
                System.out.println("true");
                break;
            }
        }
    }

    // Задание 7

    public static int[] createArrayWithShift (int[] arrTask7, int shiftValue) {

        int currentIndex, newIndex, buffer;

        for (int i = 0; i < calcGCD (shiftValue, arrTask7.length); i ++) {
            buffer = arrTask7[i];

            currentIndex = i;

            if (shiftValue > 0) {
                while (true) {
                    newIndex = currentIndex + shiftValue;
                    if (newIndex >= arrTask7.length) {
                        newIndex = newIndex - arrTask7.length;
                    }
                    if (newIndex == i) {
                        break;
                    }
                    arrTask7[currentIndex] = arrTask7[newIndex];
                    currentIndex = newIndex;
                }
            } else if (shiftValue < 0) {
                while (true) {
                    newIndex = currentIndex + shiftValue;
                    if (newIndex < 0) {
                        newIndex =  arrTask7.length + newIndex;
                    }
                    if (newIndex == i) {
                        break;
                    }
                    arrTask7[currentIndex] = arrTask7[newIndex];
                    currentIndex = newIndex;
                }
            }
            arrTask7[currentIndex] = buffer;
        }
        return arrTask7;
    }

    public static int calcGCD (int x, int y) {
        if (y == 0)
            return x;
        else
            return calcGCD (y, x % y);
    }
}
