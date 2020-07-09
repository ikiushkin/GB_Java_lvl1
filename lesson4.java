package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class lesson4 {

    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkTrue ()) {
                System.out.println("Победил человек!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if (checkTrue ()) {
                System.out.println("Победил Искуственный Интеллект!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Игра закончена!");
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1) + ".");
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y.");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Вы ввели значения не из заданного диапозона от 1 до 5");
            return false;
        }
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean checkTrue () {

        int circle = 0;
        char value = DOT_X;
        int counter;

        while (circle < 2) {

            // 1. Поиск по горизонтали (4 подряд - true)
            counter = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] != value) {
                        counter = 0;
                        continue;
                    }
                    if (map[i][j] == value) counter++;
                    if (counter == DOTS_TO_WIN) return true;
                }
            }

            // 2. Поиск по вертикали (4 подряд - true)
            counter = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][i] != value) {
                        counter = 0;
                        continue;
                    }
                    if (map[j][i] == value) counter++;
                    if (counter == DOTS_TO_WIN) return true;
                }
            }

            // 3. Поиск по диагонали (4 подряд - true)
            counter = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] != value) {
                        counter = 0;
                        continue;
                    }
                    if (map[i][j] == value) counter++;
                    if (counter == DOTS_TO_WIN) return true;
                }
            }

            // 4. Поиск по обратной диагонали (4 подряд - true)
            counter = 0;
            for (int i = SIZE-1; i >= 0; i--) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] != value) {
                        counter = 0;
                        continue;
                    }
                    if (map[i][j] == value) counter++;
                    if (counter == DOTS_TO_WIN) return true;
                }
            }

            // 5. Поиск по обратной диагонали (верхн.) (4 подряд - true)
            counter = 0;
            for (int i = SIZE-2; i >= 0; i--) {
                for (int j = 0; j < SIZE-2; j++) {
                    if (map[i][j] != value) continue;
                    if (map[i][j] == value) counter++;
                    if (counter == DOTS_TO_WIN) return true;
                }
            }

            // 6. Поиск по обратной диагонали (нижн.) (4 подряд - true)
            counter = 0;
            for (int i = SIZE-1; i > 0; i--) {
                for (int j = 1; j < SIZE; j++) {
                    if (map[i][j] != value) continue;
                    if (map[i][j] == value) counter++;
                    if (counter == DOTS_TO_WIN) return true;
                }
            }

            // 7. Поиск по диагонали (верх.) (4 подряд - true)
            counter = 0;
            for (int i = 1; i < SIZE; i++) {
                for (int j = 0; j < SIZE-2; j++) {
                    if (map[i][j] != value) continue;
                    if (map[i][j] == value) counter++;
                    if (counter == DOTS_TO_WIN) return true;
                }
            }

            // 8. Поиск диагонали (нижн.) (4 подряд - true)
            counter = 0;
            for (int i = 0; i < SIZE-2; i++) {
                for (int j = 1; j < SIZE; j++) {
                    if (map[i][j] != value) continue;
                    if (map[i][j] == value) counter++;
                    if (counter == DOTS_TO_WIN) return true;
                }
            }
            value = DOT_O;
            circle++;
        }
        return false;
    }

}