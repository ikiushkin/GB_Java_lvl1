package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class lesson3 {

    public static void main(String[] args) {
        checkCorrectAnswer();
    }

    public static Scanner userInput1 = new Scanner(System.in);
    public static Scanner userInput2 = new Scanner(System.in);

    public static void checkCorrectAnswer () {
        int counter = 3;
        Random rand = new Random();
        int correctAnswer = rand.nextInt(10);

        System.out.println(correctAnswer);

        while (counter > 0) {
            System.out.println("Угадайте число от 0 до 9! Осталось попыток: " + counter + ".");
            int answer = userInput1.nextInt();
            if (answer < 0 || answer > 9) {
                System.out.println("Вы ввели число не из заданного диапозона. С Вас списана 1 попытка. Попробуйте снова.");
                counter --;
                continue;
            }
            if (answer == correctAnswer) {
                System.out.println("Поздравляем! Вы угадали число!!!");
                break;
            }
            if (answer > correctAnswer) {
                counter --;
                System.out.println("Вы ввели число больше.");
            }
            if (answer < correctAnswer) {
                counter --;
                System.out.println("Вы ввели число меньше.");
            }
        }
        if (counter == 0) {
            System.out.println("Вы не смогли угадать правильное число. Правильный ответ: " + correctAnswer + ".");
        }
        restartGame ();
    }

    public static void restartGame () {
        System.out.println("Сыграть ещё? Да - введите 1, Нет - 0");
        int answer2 = userInput2.nextInt();
        if (answer2 == 1) {
            checkCorrectAnswer();
        } else {
            System.out.println("Спасибо за игру!!!");
        }
        userInput1.close();
        userInput2.close();
    }

}
