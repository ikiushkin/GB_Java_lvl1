package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class lesson4 {

    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
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
            if (checkWin()) {
                System.out.println("Победил человек!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin()) {
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

    private static boolean checkWin() {

        int circle = 0;
        char value = DOT_X;
        int counter, mapX, mapY;

        while (circle < 2) {

            // 1. Поиск по горизонтали (4 подряд - true)
            for (int i = 0; i < SIZE; i++) {
                counter = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] != value) {
                        counter = 0;
                        continue;
                    }
                    if (map[i][j] == value) {
                        counter++;
                    }
                    if (counter == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }

            // 2. Поиск по вертикали (4 подряд - true)
            for (int i = 0; i < SIZE; i++) {
                counter = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][i] != value) {
                        counter = 0;
                        continue;
                    }
                    if (map[j][i] == value) {
                        counter++;
                    }
                    if (counter == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }

            // 3. Поиск по диагонали (4 подряд - true)
            counter = 0;
            mapX = 0;
            mapY = 0;
            while (mapX < 5) {
                if (map[mapX][mapY] == value) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 4) {
                    return true;
                }
                mapX++;
                mapY++;
            }

            // 4. Поиск по обратной диагонали (4 подряд - true)
            counter = 0;
            mapX = 4;
            mapY = 0;
            while (mapX >= 0) {
                if (map[mapX][mapY] == value) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 4) {
                    return true;
                }
                mapY++;
                mapX--;
            }

            // 5. Поиск по обратной диагонали (верхн.) (4 подряд - true)
            counter = 0;
            mapX = 3;
            mapY = 0;
            while (mapX >= 0) {
                if (map[mapX][mapY] == value) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 4) {
                    return true;
                }
                mapX--;
                mapY++;
            }


            // 6. Поиск по обратной диагонали (нижн.) (4 подряд - true)
            counter = 0;
            mapX = 4;
            mapY = 1;
            while (mapX >= 1) {
                if (map[mapX][mapY] == value) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 4) {
                    return true;
                }
                mapX--;
                mapY++;
            }

            // 7. Поиск по диагонали (верх.) (4 подряд - true)
            counter = 0;
            mapX = 1;
            mapY = 0;
            while (mapX < 5) {
                if (map[mapX][mapY] == value) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 4) {
                    return true;
                }
                mapX++;
                mapY++;
            }


            // 8. Поиск диагонали (нижн.) (4 подряд - true)
            counter = 0;
            mapX = 0;
            mapY = 1;
            while (mapX < 4) {
                if (map[mapX][mapY] == value) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 4) {
                    return true;
                }
                mapX++;
                mapY++;
            }

            value = DOT_O;
            circle++;
        }
        return false;
    }
}
