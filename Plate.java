package ru.geekbrains;

public class Plate {
    private int food;

    public void info() {
        System.out.println("Еды на тарелке " + food  + " еды");
    }

    public void decreaseFood(int appetite) {
        if (appetite > food) {
            food  = 0;
        } else {
            food -= appetite;
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
