package ru.geekbrains.lesson1;

public class MainClass {
    public static void main(String[] args) {

        /*
        Задание 2
        Скопировал из методички, поменял именена переменных
         */
        byte b = 127;
        short s = 12442;
        int i = 1000;
        long l = 200000L;
        float f = 12.23f;
        double d = -123.123;
        char c = 'A';
        boolean bool = false;

        System.out.println(arithmetic (2, 5, 10, 5));;
        checkNumber(2, 14);
        positiveOrNegative (55);
        System.out.println(retTrue (-90));
        printHello ("Игорь");
        leapYear (2000);
    }

    // Задание 3
    public static int arithmetic (int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    // Задание 4
    public static void checkNumber (int a, int b) {
        int c = a + b;
        if (c <= 20 && c >= 10) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    // Задание 5
    public static void positiveOrNegative (int a) {
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    // Задание 6
    public static String retTrue (int a) {
        if (a < 0) {
            return "true";
        }
        return null;
    }

    // Задание 7
    public static void printHello (String a) {
        System.out.println("Привет, " + a + "!");
    }

    // Задание 8
    public static void leapYear (int a) {
        if (a % 400 == 0) {
            System.out.println(a + " год является високосным");
        } else if (a % 4 == 0 && a % 100 != 0) {
            System.out.println(a + " год является високосным");
        } else {
            System.out.println(a + " год не високосный");
        }
    }
}
