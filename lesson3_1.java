package ru.geekbrains;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson3_1 {
    public static void main(String[] args) {

        game ();

    }

    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    static Random rand = new Random();
    static int indexOFWords = rand.nextInt(25);
    static String correctAnswer = words[indexOFWords];

    static String answer;

    public static String requestAWord () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Ваш ответ: ");
        return sc.nextLine();
    }

    public static void comparisonStrings() {
        char[] arrAnswer = answer.toCharArray();
        char[] arrCorrectAnswer = correctAnswer.toCharArray();
        char[] arrResult = new char[15];

        for (int i = 0; i < 15; i ++) {
            if (i >= correctAnswer.length() || i >= answer.length()) {
                arrResult[i] = '#';
                continue;
            }
            if (arrAnswer[i] == arrCorrectAnswer[i]) {
                arrResult[i] = arrAnswer[i];
            } else {
                arrResult[i] = '#';
            }
        }
        System.out.println("Вы не угадали. Возможно, есть совпадения по буквам " + Arrays.toString(arrResult));
    }

    public static void game () {
        System.out.println("Угадайте загаданное слово.");
        System.out.println("Возможные варианты ответа: apple, orange, lemon, banana, apricot, avocado, broccoli, carrot, cherry, garlic, grape, melon, leak, kiwi, mango, mushroom, nut, olive, pea, peanut, pear, pepper, pineapple, pumpkin, potato");
        while (true) {
            answer = requestAWord ().toLowerCase();
            if (answer.equals(correctAnswer)) {
                System.out.println("Поздравляем, Вы угадали слово!!! Правльный ответ: " + correctAnswer + ".");
                break;
            } else {
                comparisonStrings();
            }
        }
    }

}
